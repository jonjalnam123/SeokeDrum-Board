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


@WebServlet("/check")
public class SeokIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	//서비스 객체
	private SeokMemberService sMemberService = new SeokMemberServiceImpl();
	
	
	
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String usereid = req.getParameter("usereid");
		
		SeokMember sMember = new SeokMember(); 
		
		sMember.setUserid(usereid);
		
		int res = sMemberService.existsId(sMember); 
		
 		resp.getWriter().print((res > 0) ? 1 : 0);
}

		
	
	
}
