package dto;

import java.util.Date;

public class qa {

	private int boardno;
	private String title;
	private String userid;
	private String content;
	private int hit;
	private Date writedate;

	public qa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "qa [boardno=" + boardno + ", title=" + title + ", userid=" + userid + ", content=" + content + ", hit="
				+ hit + ", writedate=" + writedate + "]";
	}

	public qa(int boardno, String title, String userid, String content, int hit, Date writedate) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.userid = userid;
		this.content = content;
		this.hit = hit;
		this.writedate = writedate;
	}

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

}
