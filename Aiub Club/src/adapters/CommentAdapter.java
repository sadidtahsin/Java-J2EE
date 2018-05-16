package adapters;

import java.util.Calendar;

public class CommentAdapter {

	public void addComment(int eventId, int userId, String comment) {
		DataAccess da = new DataAccess();
		java.sql.Date cdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		da.executeQuery("insert into comments values(NULL,'"+userId+"','"+eventId+"','"+cdate+"','"+comment+"')");
	}
	
}
