package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.qa;

public interface SeokQaDao {

	List <qa> selectAll(Connection connection);

}
