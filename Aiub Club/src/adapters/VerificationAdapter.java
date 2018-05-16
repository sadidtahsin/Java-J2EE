package adapters;

import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class VerificationAdapter {

	public User  verify(String username, String password) {
		User user= new User();
		DataAccess da= new DataAccess();
		ResultSet rs=da.getResultSet("select * from users where user_name='"+username+"' and password='"+password+"'");
		
		try {
			while(rs.next()) {
				user.setName(rs.getString("name"));
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("user_name"));
				user.setUserStaus(rs.getString("user_status"));
				user.setUserType(rs.getString("user_type"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
