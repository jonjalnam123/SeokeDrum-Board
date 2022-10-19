package dao.face;

import java.sql.Connection;

import dto.SeokMember;

public interface SeokMemberDao {

	public int insert(Connection conn, SeokMember seokmember);

	public int selectCntSeokMemberByUseridUserpw(Connection connection, SeokMember seokmember);

	public SeokMember selectSeokMemberByUserid(Connection connection, SeokMember seokmember);

	public int selectCntByUserId(Connection connection, SeokMember sMember);



	
	
}

