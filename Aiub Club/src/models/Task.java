package models;

public class Task {
	
	private int taskId;
	private int eventId;
	private int userId;
	private String taksDetail;
	
	
	public int getTaskId() {
		return taskId;
	}
	public int getEventId() {
		return eventId;
	}
	public int getUserId() {
		return userId;
	}
	public String getTaksDetail() {
		return taksDetail;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setTaksDetail(String taksDetail) {
		this.taksDetail = taksDetail;
	}
	
	
}
