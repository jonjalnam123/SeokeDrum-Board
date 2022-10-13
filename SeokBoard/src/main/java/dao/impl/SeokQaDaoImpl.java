package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.SeokQaDao;
import dto.qa;

public class SeokQaDaoImpl implements SeokQaDao {
	
	
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public List<qa> selectAll(Connection connection) {
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM seokeboard";
		sql += " ORDER BY boardno DESC";
		
		//결과 저장할 List
		List<qa> qaList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			//조회 결과 처리
			while(rs.next()) {
				qa Q = new qa(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				Q.setBoardno(rs.getInt("boardno"));
				Q.setTitle(rs.getString("title"));
				Q.setContent(rs.getString("content"));
				Q.setWritedate(rs.getDate("write_date"));
				
				//리스트에 결과값 저장
				qaList.add(Q);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return qaList;
	}
	
}
