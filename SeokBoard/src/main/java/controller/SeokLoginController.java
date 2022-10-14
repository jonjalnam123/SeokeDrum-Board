package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.SeokMember;
import service.face.SeokMemberService;
import service.impl.SeokMemberServiceImpl;


@WebServlet("/seok/login")
public class SeokLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	private SeokMemberService seokmemberService = new SeokMemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 로그인 정보 얻어오기
		SeokMember seokmember = seokmemberService.getLoginMember(req);
		
		//로그인 인증
		boolean isLogin = seokmemberService.login(seokmember);
		
		//로그인 인증 성공
		if( isLogin ) {
			
			//로그인 사용자 정보 조회
			seokmember = seokmemberService.info(seokmember);
			
			//세션정보 객체
			HttpSession session = req.getSession();
			
			session.setAttribute("login", isLogin);
			session.setAttribute("userid", seokmember.getUserid());
			session.setAttribute("usernick", seokmember.getUsernick());
			
			//메인페이지로 리다이렉트
			resp.sendRedirect("/views/domainsucces.jsp");
			
		}else {
			System.out.println("LoginController doPost() - 로그인 실패");
			
			//포워드URL 지정
			resp.sendRedirect("/views/domainloginfail.jsp");
		}
	}
}


