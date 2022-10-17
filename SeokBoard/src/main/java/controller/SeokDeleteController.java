package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qa;
import service.face.SeokQaService;
import service.impl.SeokQaServiceImpl;


@WebServlet("/seok/delete")
public class SeokDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private SeokQaService seokQaService = new SeokQaServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		qa Qa = seokQaService.getBoardno(req);
		
		seokQaService.delete(Qa);
		
		
		resp.sendRedirect("/qa");
		
	}
	

}
