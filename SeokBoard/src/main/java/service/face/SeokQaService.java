package service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.qa;

public interface SeokQaService {

	List <qa> getList();

	public void write(HttpServletRequest req);

	

}
