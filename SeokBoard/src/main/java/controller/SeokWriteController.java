package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.face.SeokQaService;
import service.impl.SeokQaServiceImpl;


@WebServlet("/seok/write")
public class SeokWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private SeokQaService seokqaService = new SeokQaServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//작성글 삽입
		seokqaService.write(req);
		
		System.out.println(req);

		
		resp.sendRedirect("/qa");
		
	}
}
