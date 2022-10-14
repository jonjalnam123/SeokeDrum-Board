package dto;

public class SeokMember {

	private String userid;
	private String userpw;
	private String usernick;

	public SeokMember() {
		// TODO Auto-generated constructor stub
	}

	public SeokMember(String userid, String userpw, String usernick) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.usernick = usernick;
	}

	@Override
	public String toString() {
		return "SeokMember [userid=" + userid + ", userpw=" + userpw + ", usernick=" + usernick + "]";
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsernick() {
		return usernick;
	}

	public void setUsernick(String usernick) {
		this.usernick = usernick;
	}

}
