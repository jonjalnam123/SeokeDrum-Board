package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardFile;
import dto.qa;

public interface SeokQaService {

	public List <qa> getList();

	public void write(HttpServletRequest req);

	public qa getBoardno(HttpServletRequest req);

	public qa view(qa boardno);

	public String getWriteNick(qa viewBoard);

	public BoardFile viewFile(qa viewBoard);

	public void delete(qa qa);

	

}
