package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.SeokMember;
import service.face.SeokMemberService;
import service.impl.SeokMemberServiceImpl;

/**
 * Servlet implementation class SeokMemberController
 */
@WebServlet("/seok/join")
public class SeokMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private SeokMemberService seokmemberService = new SeokMemberServiceImpl();
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			req.getRequestDispatcher("/views/join.jsp").forward(req, resp);
		}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8"); 
		//회원가입 전달파라미터 추출하기
		SeokMember seokmember = seokmemberService.getJoinMember(req);
		
		seokmemberService.join(seokmember);	
		System.out.println(seokmember);
		
		resp.sendRedirect("/seok/login");
		
		
	}
}
