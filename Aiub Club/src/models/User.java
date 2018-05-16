package models;

import java.util.ArrayList;

public class User {

	private int userId;
	private String userName;
	private String name;
	private String email;
	private String password;
	private String userType;
	private String userStaus;
	private int phoneNo;
	private String address;
	
	
	private ArrayList<UserTask> taskList;
	
	
	public class UserTask{
		
		private int eventId;
		private String eventName;
		private String taskDetail;
		
		public UserTask(int eventId ,String eventName,String taskDetail) {;
			this.eventId= eventId;
			this.eventName=eventName;
			this.taskDetail=taskDetail;
		}

		public int getEventId() {
			return eventId;
		}

		public String getEventName() {
			return eventName;
		}

		public String getTaskDetail() {
			return taskDetail;
		}

		public void setEventId(int eventId) {
			this.eventId = eventId;
		}

		public void setEventName(String eventName) {
			this.eventName = eventName;
		}

		public void setTaskDetail(String taskDetail) {
			this.taskDetail = taskDetail;
		}
		
		
		
	}
	
	
	
	
	

	public ArrayList<UserTask> getTaskList() {
		return taskList;
	}

	public void setTaskList(ArrayList<UserTask> taskList) {
		this.taskList = taskList;
	}

	public String getEmail() {
		return email;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getUserType() {
		return userType;
	}
	public String getUserStaus() {
		return userStaus;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public String getAddress() {
		return address;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public void setUserStaus(String userStaus) {
		this.userStaus = userStaus;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	

	
	
	
}
