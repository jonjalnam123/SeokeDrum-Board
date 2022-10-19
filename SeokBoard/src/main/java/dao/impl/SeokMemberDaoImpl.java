package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import dao.face.SeokMemberDao;
import dto.SeokMember;

public class SeokMemberDaoImpl implements SeokMemberDao {
	
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public int insert(Connection conn, SeokMember seokmember) {
		String sql = "";
		sql += "INSERT INTO seokmember ( userid, userpw, usernick )";
		sql += " VALUES ( ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, seokmember.getUserid());
			ps.setString(2, seokmember.getUserpw());
			ps.setString(3, seokmember.getUsernick());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	

	@Override
	public int selectCntSeokMemberByUseridUserpw(Connection connection, SeokMember seokmember) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM seokmember";
		sql += " WHERE userid = ?";
		sql += "	AND userpw = ?";
		
		int cnt = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, seokmember.getUserid());
			ps.setString(2, seokmember.getUserpw());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return cnt;
	}

	@Override
	public SeokMember selectSeokMemberByUserid(Connection connection, SeokMember seokmember) {
		String sql = "";
		sql += "SELECT userid, userpw, usernick FROM seokmember";
		sql += " WHERE userid = ?";
		
		SeokMember result = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, seokmember.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				result = new SeokMember();
				
				result.setUserid( rs.getString("userid") );
				result.setUserpw( rs.getString("userpw") );
				result.setUsernick( rs.getString("usernick") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return result;
	}




	@Override
	public int selectCntByUserId(Connection connection, SeokMember sMember) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM seokmember";
		sql += " WHERE userid = ?";
		
		int cnt = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, sMember.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return cnt;
	}










}


