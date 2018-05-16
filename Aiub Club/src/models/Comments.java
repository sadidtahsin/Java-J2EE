package models;

import java.sql.Date;

public class Comments {

	private int commentId;
	private int userId;
	private int eventId;
	public int getCommentId() {
		return commentId;
	}
	public int getUserId() {
		return userId;
	}
	public int getEventId() {
		return eventId;
	}
	public String getComment() {
		return comment;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	private String comment;
	private Date commentDate;
}
