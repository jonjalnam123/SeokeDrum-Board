package service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.SeokQaDao;
import dao.impl.SeokQaDaoImpl;
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
		
		//--- 첨부파일없이 게시글 작성 처리하기 ---
		
		qa board = new qa();
			
		//제목 처리
		board.setTitle( req.getParameter("title") );
		
		//본문 처리
		board.setContent( req.getParameter("content") );
		
		//작성자 ID 처리
		board.setUserid( (String) req.getSession().getAttribute("userid") );
		
		Connection conn = JDBCTemplate.getConnection();
		if( seokQaDao.insert(conn, board) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}
	
}
