package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardFile;
import dto.qa;
import service.face.SeokQaService;
import service.impl.SeokQaServiceImpl;

/**
 * Servlet implementation class SeokUpdateController
 */
@WebServlet("/seok/update")
public class SeokUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private SeokQaService seokQaService = new SeokQaServiceImpl();
	
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("BoardUpdateController doGet() - 전달파라미터 boardno : " + req.getParameter("boardno"));
		
		//전달파라미터 저장 객체 얻기
		qa boardno = seokQaService.getBoardno(req);
		System.out.println("BoardUpdateController doGet() - 전달파라미터 객체 : " + boardno);
		
		
		
		//상세보기 결과 조회
		qa updateBoard = seokQaService.view(boardno);
		System.out.println("BoardUpdateController doGet() - 상세보기 객체 : " + updateBoard);
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateBoard", updateBoard);

		
		
		//작성자 닉네임 전달
		req.setAttribute("writerNick", seokQaService.getWriteNick(updateBoard));
		
		
		
		//첨부파일 정보 조회
		BoardFile boardFile = seokQaService.viewFile(updateBoard);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("boardFile", boardFile);
		
		
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/views/update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		seokQaService.update(req);
		
		resp.sendRedirect("/qa");
	}
		
}

