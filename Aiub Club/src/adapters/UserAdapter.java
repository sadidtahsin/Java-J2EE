package adapters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Event;
import models.User;
import models.Event.UserHolder;

public class UserAdapter {
	
	public ArrayList<User> unassignedUserOfEvent(int event_id){
		ArrayList<User> list= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("select user_id,name from users where user_id NOT IN(select user_id from task WHERE event_id="+event_id+") and user_type='member' and user_status='active'");
		
		try {
			while(rs.next()) {
				User user= new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	public void  addNewUser(User user) {
		
		DataAccess da= new DataAccess();
		da.executeQuery("insert into users values(NULL,'"+user.getName()+"','"+user.getUserName()+"','"+user.getPassword()+"','"+user.getPhoneNo()+"','"+user.getAddress()+"','member','inactive','"+user.getEmail()+"')");
		
	}
	
	
	
	public void  activeUser(int useId) {
		DataAccess da= new DataAccess();
		da.executeQuery("UPDATE users set user_status='active' where user_id="+useId);
	}
	
	public void  inactiveUser(int useId) {
		DataAccess da= new DataAccess();
		da.executeQuery("UPDATE users set user_status='inactive' where user_id="+useId);
	}
	
	public User getAssignedEventList(int userId){
		
		DataAccess da= new DataAccess();
		ArrayList<User.UserTask> list = new ArrayList<>();
		ResultSet rs= da.getResultSet("SELECT t.event_id,e.event_title, t.task_detail FROM task t,event e where t.user_id="+userId +" and e.event_id=t.event_id");
		User user = new User();
		try {
			while(rs.next()) {
				
				User.UserTask task= user.new UserTask(rs.getInt("event_id"), rs.getString("event_title"), rs.getString("task_detail"));
				System.out.println(rs.getInt("event_id")+" "+ rs.getString("event_title")+" "+ rs.getString("task_detail"));
				list.add(task);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setTaskList(list);
		return user;
	}

	public User getActiveUser(int userId) {
		DataAccess da= new DataAccess();
		User user= new User();
		ResultSet rs= da.getResultSet("select * from users where user_id="+userId +" and user_status='active' and user_type='member'");

		try {
			while(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setUserName("user_name");
				user.setPhoneNo(rs.getInt("phone"));
				user.setUserType(rs.getString("user_type"));
				user.setUserStaus(rs.getString("user_status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public User getInctiveUser(int userId) {
		DataAccess da= new DataAccess();
		User user= new User();
		ResultSet rs= da.getResultSet("select * from users where user_id="+userId +" and user_status='inactive'and user_type='member'");

		try {
			while(rs.next()) {
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setUserName("user_name");
				user.setPhoneNo(rs.getInt("phone"));
				user.setUserType(rs.getString("user_type"));
				user.setUserStaus(rs.getString("user_status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	public ArrayList<User> getAllActiveUserList(){

		ArrayList<User> userList= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("select user_id, user_name, name,email,phone,address from users where user_status='active' and user_type='member'");
		try {
			while(rs.next()) {
				User user= new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPhoneNo(rs.getInt("phone"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

	public ArrayList<User> getAllInactiveUserList(){

		ArrayList<User> userList= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("select user_id, user_name, name,email,phone,address from users where user_status='inactive' and user_type='member'");
		try {
			while(rs.next()) {
				User user= new User();
				user.setUserId(rs.getInt("user_id"));
				user.setName(rs.getString("name"));
				user.setUserName(rs.getString("user_name"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				user.setPhoneNo(rs.getInt("phone"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
}
