package service.impl;

import java.util.List;

import common.JDBCTemplate;
import dao.face.SeokQaDao;
import dao.impl.SeokQaDaoImpl;
import dto.qa;
import service.face.SeokQaService;

public class SeokQaServiceImpl implements SeokQaService {
	
	//DAO 객체
	private SeokQaDao seokQaDao = new SeokQaDaoImpl();

	@Override
	public List<qa> getList() {
		return seokQaDao.selectAll(JDBCTemplate.getConnection());
	}

}
