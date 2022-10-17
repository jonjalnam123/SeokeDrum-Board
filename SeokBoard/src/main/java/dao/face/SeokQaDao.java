package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.BoardFile;
import dto.qa;

public interface SeokQaDao {

	List <qa> selectAll(Connection connection);

	public int insert(Connection conn, qa qa);

	public int selectCntAll(Connection conn);

	public int selectNextBoardno(Connection conn);

	public int insertFile(Connection conn, BoardFile boardFile);

	public int updateHit(Connection conn, qa boardno);

	public qa selectBoardByBoard(Connection conn, qa boardno);

	public String selectNickByBoard(Connection connection, qa viewBoard);

	public BoardFile selectFile(Connection connection, qa viewBoard);

	public int deleteFile(Connection conn, qa qa);

	public int delete(Connection conn, qa qa);

	

	
	}


