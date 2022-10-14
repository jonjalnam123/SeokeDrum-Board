package service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import dao.face.SeokMemberDao;
import dao.impl.SeokMemberDaoImpl;
import dto.SeokMember;
import service.face.SeokMemberService;

public class SeokMemberServiceImpl implements SeokMemberService {

	
	//DAO 객체
	private SeokMemberDao seokmemberDao = new SeokMemberDaoImpl();
	
	
	@Override
	public SeokMember getJoinMember(HttpServletRequest req) {
		
		
		SeokMember seokmember = new SeokMember();

		seokmember.setUserid( req.getParameter("userid") );
		seokmember.setUserpw( req.getParameter("userpw") );		
		seokmember.setUsernick( req.getParameter("usernick") );
		
		return seokmember;
	}


	@Override
	public void join(SeokMember seokmember) {
		Connection conn = JDBCTemplate.getConnection();
		
		if( seokmemberDao.insert(conn, seokmember) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}


	@Override
	public SeokMember getLoginMember(HttpServletRequest req) {
		
		SeokMember seokmember = new SeokMember();

		seokmember.setUserid( req.getParameter("userid") );
		seokmember.setUserpw( req.getParameter("userpw") );
		
		return seokmember;
	}


	@Override
	public boolean login(SeokMember seokmember) {
		
		//로그인 인증 성공
		if( seokmemberDao.selectCntSeokMemberByUseridUserpw(JDBCTemplate.getConnection(), seokmember) > 0 ) {
			return true;
		}
		
		//로그인 인증 실패
		return false;
	}


	@Override
	public SeokMember info(SeokMember seokmember) {
		
		return seokmemberDao.selectSeokMemberByUserid(JDBCTemplate.getConnection(), seokmember);
	}
	
}
