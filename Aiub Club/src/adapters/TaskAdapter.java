package adapters;

import java.sql.ResultSet;
import java.util.ArrayList;

public class TaskAdapter {
	
	public void addUserToAnEvent(int eventId, int userId, String task) {
		DataAccess da = new DataAccess();
		da.executeQuery("insert into task values(NULL,'"+userId+"','"+eventId+"','"+task+"')");
	}
}
