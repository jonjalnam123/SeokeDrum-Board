package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import dao.face.SeokQaDao;
import dto.BoardFile;
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
				Q.setUserid(rs.getString("USERID"));  
				Q.setHit(rs.getInt("HIT"));
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

	@Override
	public int insert(Connection conn, qa qa) {
		
		String sql = "";
		sql += "INSERT INTO seokeboard ( boardno, title, userid, content, hit )";
		sql += " VALUES ( ?, ?, ?, ?, 0 )";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, qa.getBoardno());
			ps.setString(2, qa.getTitle());
			ps.setString(3, qa.getUserid());
			ps.setString(4, qa.getContent());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;


	}
	
	@Override
	public int selectCntAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM seokeboard";
		
		//총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

	@Override
	public int selectNextBoardno(Connection conn) {
		String sql = "";
		sql += "SELECT seokeboard_seq.nextval FROM dual";
		
		int nextBoardno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextBoardno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextBoardno;
	}

	@Override
	public int insertFile(Connection conn, BoardFile boardFile) {
		String sql = "";
		sql += "INSERT INTO boardfile( fileno, boardno, originname, storedname, filesize )";
		sql += " VALUES( boardfile_seq.nextval, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, boardFile.getBoardno());
			ps.setString(2, boardFile.getOriginname());
			ps.setString(3, boardFile.getStoredname());
			ps.setInt(4, boardFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int updateHit(Connection conn, qa boardno) {
		String sql = "";
		sql += "UPDATE seokeboard";
		sql += "	SET hit = hit + 1";
		sql += " WHERE boardno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public qa selectBoardByBoard(Connection conn, qa boardno) {
		String sql = "";
		sql += "SELECT";
		sql += "	boardno, title, userid";
		sql += "	, content, hit, write_date";
		sql += " FROM seokeboard";
		sql += " WHERE boardno = ?";

		qa board = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardno.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				board = new qa();
				
				board.setBoardno( rs.getInt("boardno") );
				board.setTitle( rs.getString("title") );
				board.setUserid( rs.getString("userid") );
				board.setContent( rs.getString("content") );
				board.setHit( rs.getInt("hit") );
				board.setWritedate(rs.getDate("write_date"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return board;
	}

	@Override
	public String selectNickByBoard(Connection connection, qa viewBoard) {
		String sql = "";
		sql += "SELECT usernick FROM seokmember";
		sql += " WHERE userid = ?";
		
		//결과 저장할 변수
		String usernick = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, viewBoard.getUserid());

			rs = ps.executeQuery();
			
			while( rs.next() ) {
				usernick = rs.getString("usernick");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return usernick;
	}

	@Override
	public BoardFile selectFile(Connection connection, qa viewBoard) {
		String sql = "";
		sql += "SELECT";
		sql += "	fileno, boardno, originname, storedname, filesize, write_date";
		sql += " FROM boardfile";
		sql += " WHERE boardno = ?";
		sql += " ORDER BY fileno";
		
		//조회 결과 객체
		BoardFile boardFile = null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, viewBoard.getBoardno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				boardFile = new BoardFile();
				
				boardFile.setFileno( rs.getInt("fileno") );
				boardFile.setBoardno( rs.getInt("boardno") );
				boardFile.setOriginname( rs.getString("originname") );
				boardFile.setStoredname( rs.getString("storedname") );
				boardFile.setFilesize( rs.getInt("filesize") );
				boardFile.setWrite_date( rs.getDate("write_date") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return boardFile;
	}

	@Override
	public int deleteFile(Connection conn, qa qa) {
		String sql = "";
		sql += "DELETE boardfile ";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qa.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int delete(Connection conn, qa qa) {
		String sql = "";
		sql += "DELETE seokeboard";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, qa.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}

	@Override
	public int update(Connection conn, qa board) {
		String sql = "";
		sql += "UPDATE seokeboard ";
		sql += " SET";
		sql += "	title = ?";
		sql += "	, content = ?";
		sql += " WHERE boardno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, board.getTitle());
			ps.setString(2, board.getContent());
			ps.setInt(3, board.getBoardno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;

	}
}
	

