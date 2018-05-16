package models;

import java.sql.Date;
import java.util.ArrayList;

public class Event {

	private int eventId;
	private String eventTitle;
	private java.sql.Date eventCreationDate;
	private java.sql.Date eventDate;
	private String details;
	
	private ArrayList<UserHolder> userList;
	private ArrayList<Comments> commentsList;
	
	public class Comments{
		
		private String comments;
		private int user_id;
		private String username;
		private Date date;
		public Comments(int user_id, String username,String comments, Date date) {
		
			this.comments = comments;
			this.user_id = user_id;
			this.username = username;
			this.date=date;
		}

		
		
		
		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public String getComments() {
			return comments;
		}

		public int getUser_id() {
			return user_id;
		}
		
		

		public String getUsername() {
			return username;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public void setUsername(String username) {
			this.username = username;
		}
		
		
		
		
	}
	
	public class UserHolder{
		private int  userId;
		private String name;
		private String taskDetal;
		public UserHolder(int  userId, String name, String taskDetal) {
			this.userId=userId;
			this.name= name;
			this.taskDetal= taskDetal;
		}
		public int getUserId() {
			return userId;
		}
		public String getName() {
			return name;
		}
		public String getTaskDetal() {
			return taskDetal;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public void setName(String name) {
			this.name = name;
		}
		public void setTaskDetal(String taskDetal) {
			this.taskDetal = taskDetal;
		}
		
		
	}
	
	
	
	public ArrayList<UserHolder> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<UserHolder> userList) {
		this.userList = userList;
	}
	
	
	
	public ArrayList<Comments> getCommentsList() {
		return commentsList;
	}
	public void setCommentsList(ArrayList<Comments> commentsList) {
		this.commentsList = commentsList;
	}
	public int getEventId() {
		return eventId;
	}
	
	public String getEventTitle() {
		return eventTitle;
	}
	public java.sql.Date getEventCreationDate() {
		return eventCreationDate;
	}
	public java.sql.Date getEventDate() {
		return eventDate;
	}
	public String getDetails() {
		return details;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public void setEventTitle(String eventName) {
		this.eventTitle = eventName;
	}
	public void setEventCreationDate(java.sql.Date eventCreationDate) {
		this.eventCreationDate = eventCreationDate;
	}
	public void setEventDate(java.sql.Date eventDate) {
		this.eventDate = eventDate;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	

	
}
