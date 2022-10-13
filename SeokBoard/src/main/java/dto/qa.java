package dto;

import java.util.Date;

public class qa {

	private int boardno;
	private String title;
	private String content;
	private Date writedate;

	public qa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "qa [boardno=" + boardno + ", title=" + title + ", content=" + content + ", writedate=" + writedate
				+ "]";
	}

	public qa(int boardno, String title, String content, Date writedate) {
		super();
		this.boardno = boardno;
		this.title = title;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

}
