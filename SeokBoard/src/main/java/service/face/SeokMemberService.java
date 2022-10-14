package service.face;

import javax.servlet.http.HttpServletRequest;

import dto.SeokMember;

public interface SeokMemberService {

	public SeokMember getJoinMember(HttpServletRequest req);

	public void join(SeokMember seokmember);

	public SeokMember getLoginMember(HttpServletRequest req);

	public boolean login(SeokMember seokmember);

	public SeokMember info(SeokMember seokmember);

}
