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
 * Servlet implementation class SeokViewController
 */
@WebServlet("/seok/view")
public class SeokViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private SeokQaService seokqaService = new  SeokQaServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		System.out.println("BoardViewController doGet() - 전달파라미터 boardno : " + req.getParameter("boardno"));
		
		//전달파라미터 저장 객체 얻기
		qa boardno = seokqaService.getBoardno(req);
		
		System.out.println("BoardViewController doGet() - 전달파라미터 객체 : " + boardno);
		
		
		
		//상세보기 결과 조회
		qa viewBoard = seokqaService.view(boardno);
		System.out.println("BoardViewController doGet() - 상세보기 객체 : " + viewBoard);
		
		//조회결과 MODEL값 전달
		req.setAttribute("viewBoard", viewBoard);
		
		
		
		//작성자 닉네임 전달
		req.setAttribute("writerNick", seokqaService.getWriteNick(viewBoard));
		
		
		
		//첨부파일 정보 조회
		BoardFile boardFile = seokqaService.viewFile(viewBoard);
		
		//첨부파일 정보를 MODEL값 전달
		req.setAttribute("boardFile", boardFile);
		
		
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/views/view.jsp").forward(req, resp);
		
	}
}