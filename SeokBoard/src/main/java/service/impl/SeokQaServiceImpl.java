package service.impl;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import dao.face.SeokQaDao;
import dao.impl.SeokQaDaoImpl;
import dto.BoardFile;
import dto.qa;
import service.face.SeokQaService;

public class SeokQaServiceImpl implements SeokQaService {

	// DAO 객체
	private SeokQaDao seokQaDao = new SeokQaDaoImpl();

	@Override
	public List<qa> getList() {
		return seokQaDao.selectAll(JDBCTemplate.getConnection());
	}

	@Override
	public void write(HttpServletRequest req) {
		
		//--- 첨부파일 추가하여 게시글 작성 처리하기 ---
		
		//multipart/form-data 인코딩 확인
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//multipar형식이 아닐 경우 처리 중단
		if( !isMultipart ) {
			System.out.println("[ERROR] 파일 업로드 형식 데이터가 아님");
			return;
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//메모리 처리 사이즈 설정
		int maxMem = 1 * 1024 * 1024;	// 1 MB == 1048576 B
		factory.setSizeThreshold(maxMem);

		//서블릿 컨텍스트 객체
		ServletContext context = req.getServletContext();
		
		//임시 파일 저장 폴더
		String path = context.getRealPath("tmp");
		File tmpRepository = new File(path);
		tmpRepository.mkdir();
		factory.setRepository(tmpRepository);

		//파일 업로드 수행 객체
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//파일 업로드 용량 제한
		int maxFile = 10 * 1024 * 1024; // 10MB
		upload.setFileSizeMax(maxFile);

		//파일 업로드된 데이터 파싱
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		//게시글 정보 DTO객체
		qa board = new qa();
		
		//게시글 첨부파일 정보 DTO객체
		BoardFile boardFile = new BoardFile();
	
		//파일아이템의 반복자
		Iterator<FileItem> iter = items.iterator();

		while( iter.hasNext() ) {
			FileItem item = iter.next();
			
			//--- 1) 빈 파일에 대한 처리 ---
			if( item.getSize() <= 0 ) { //전달 데이터의 크기
				//빈 파일은 무시하고 다음 FileItem처리로 넘어간다
				continue;
			}
			
			//--- 2) 폼 필드에 대한 처리 ---
			if( item.isFormField() ) {
				
				//키(key) 추출하기
				String key = item.getFieldName();
				
				//값(value) 추출하기
				String value = null;
				try {
					value = item.getString("UTF-8"); //한글 인코딩 지정
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				
				//key에 맞게 value를 DTO에 삽입하기
				if( "title".equals(key) ) {
					board.setTitle(value);
				}
				if( "content".equals(key) ) {
					board.setContent(value);
				}
				
			} // if( item.isFormField() ) end
			
			
			
			//--- 3) 파일에 대한 처리 ---
			if( !item.isFormField() ) {
				
				//저장 파일명 처리
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date()); //현재시간
				
				//파일 업로드 폴더
				File uploadFolder = new File( context.getRealPath("upload") );
				uploadFolder.mkdir();
				
				//업로드할 파일 객체 생성하기
				File up = new File(uploadFolder, rename);
				try {
					item.write(up);	//임시파일을 실제 업로드 파일로 출력한다
					item.delete(); //임시파일 제거
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				//업로드된 파일의 정보를 DTO객체에 저장하기
				boardFile.setOriginname(item.getName());
				boardFile.setStoredname(rename);
				boardFile.setFilesize((int)item.getSize());
				
			} // if( !item.isFormField() ) end
			
		} // while( iter.hasNext() ) end

		
		//DB연결 객체
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 번호 생성
		int boardno = seokQaDao.selectNextBoardno(conn);
		
		
		//게시글 번호 삽입
		board.setBoardno(boardno);

		//작성자 ID 처리
		board.setUserid( (String) req.getSession().getAttribute("userid") );
		
		if( seokQaDao.insert(conn, board) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		
		//첨부파일 정보 삽입
		if( boardFile.getFilesize() != 0 ) { //첨부 파일이 존재할 때에만 동작
			
			//게시글 번호 삽입 (FK)
			boardFile.setBoardno(boardno);
			
			if( seokQaDao.insertFile(conn, boardFile) > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
			
		}

	}

	@Override
	public qa getBoardno(HttpServletRequest req) {
		//전달파라미터를 저장할 객체 생성
		qa board = new qa();
		
		String param = req.getParameter("boardno");
		if( param != null && !"".equals(param) ) {
			board.setBoardno( Integer.parseInt(param) );
		} else {
			System.out.println("[WARN] BoardService getBoardno() - boardno값이 null이거나 비어있음");
		}
		
		return board;
	}

	@Override
	public qa view(qa boardno) {
		Connection conn = JDBCTemplate.getConnection();
		
		//조회수 증가
		if( seokQaDao.updateHit(conn, boardno) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		qa board = seokQaDao.selectBoardByBoard(conn, boardno);
		
		//조회된 게시글 리턴
		return board;
	}

	@Override
	public String getWriteNick(qa viewBoard) {
		return seokQaDao.selectNickByBoard(JDBCTemplate.getConnection(), viewBoard);
		
	}

	@Override
	public BoardFile viewFile(qa viewBoard) {
		return seokQaDao.selectFile(JDBCTemplate.getConnection(), viewBoard);
	}
	
}
