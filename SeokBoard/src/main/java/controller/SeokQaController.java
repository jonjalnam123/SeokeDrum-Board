package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qa;
import service.face.SeokQaService;
import service.impl.SeokQaServiceImpl;


@WebServlet("/qa")
public class SeokQaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//Sevice객체 생성
	private SeokQaService seokQaService = new SeokQaServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		System.out.println("qa [Get]");
		
		//게시글 전체 조회
		List<qa> qaList = seokQaService.getList();
		
		//조회결과 MODEL값 전달
		req.setAttribute("qaList", qaList);
		System.out.println(qaList);
		
		
		//View 지정 및 응답
		req.getRequestDispatcher("/views/qa.jsp").forward(req, resp);
		
	}
}
