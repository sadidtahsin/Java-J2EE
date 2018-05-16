package adapters;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Event;
import models.User;

public class EventAdapter {

	
	
	public Event getCommnetByEvent(int eventId) {
		ArrayList<Event.Comments> list= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("SELECT c.user_id,u.name, c.u_comments,c.date FROM comments c ,users u where c.event_id="+eventId+" and u.user_id=c.user_id");
		Event event = new Event();
		try {
			while(rs.next()) {

				Event.Comments comments= event.new Comments(rs.getInt("user_id"), rs.getString("name"), rs.getString("u_comments"),rs.getDate("date"));
				//System.out.println(rs.getInt("user_id")+" "+ rs.getString("name")+" "+ rs.getString("u_comments")+" "+rs.getDate("date"));
				list.add(comments);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		event.setCommentsList(list);
		return event;
		
	}


	public void  addNewEvent(Event event) {

		DataAccess da= new DataAccess();
		da.executeQuery("insert into event values(NULL,'"+event.getEventTitle()+"','"+event.getDetails()+"','"+event.getEventCreationDate()+"','"+event.getEventDate()+"')");

	}


	public void updateEvent(Event event) {
		DataAccess da= new DataAccess();
		da.executeQuery("update event set event_title='"+ event.getEventTitle() +"', details= '"+event.getDetails()+"', event_date= '"+event.getEventDate()+"', event_creation_date= '"+event.getEventCreationDate()+"' where event_id="+event.getEventId());

	}


	public void deleteEvent(int eventId) {
		DataAccess da= new DataAccess();
		da.executeQuery("delete from event where event_id="+eventId);
	}

	public Event getTaskAssignedEventUserList(int eventId){

		DataAccess da= new DataAccess();
		ArrayList<Event.UserHolder> list = new ArrayList<>();
		ResultSet rs= da.getResultSet("SELECT t.user_id,u.name, t.task_detail FROM task t,users u where t.event_id="+eventId +" and u.user_id=t.user_id");
		Event event = new Event();
		try {
			while(rs.next()) {

				Event.UserHolder user= event.new UserHolder(rs.getInt("user_id"), rs.getString("name"), rs.getString("task_detail"));
				System.out.println(rs.getInt("user_id")+" "+ rs.getString("name")+" "+ rs.getString("task_detail"));
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		event.setUserList(list);
		return event;
	}

	public ArrayList<Event> getAllEvents() {
		ArrayList<Event> eventList= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("SELECT * FROM event");


		try {
			while(rs.next()) {
				Event event= new Event();
				event.setEventId(rs.getInt("event_id"));
				event.setEventTitle(rs.getString("event_title"));
				event.setEventCreationDate(rs.getDate("event_creation_date"));
				event.setEventDate(rs.getDate("event_date"));
				event.setDetails(rs.getString("details"));
				eventList.add(event);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;
	}
	
	public ArrayList<Event> getAllEventsBySearch(String search) {
		ArrayList<Event> eventList= new ArrayList<>();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("SELECT * FROM event where event_title like '%"+search+"%'");


		try {
			while(rs.next()) {
				Event event= new Event();
				event.setEventId(rs.getInt("event_id"));
				event.setEventTitle(rs.getString("event_title"));
				event.setEventCreationDate(rs.getDate("event_creation_date"));
				event.setEventDate(rs.getDate("event_date"));
				event.setDetails(rs.getString("details"));
				eventList.add(event);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;
	}

	public Event getEventInfo(int id) {
		Event event = new Event();
		DataAccess da= new DataAccess();
		ResultSet rs= da.getResultSet("SELECT * FROM event where event_id="+ id);

		try {
			while(rs.next()) {

				event.setEventId(rs.getInt("event_id"));
				event.setEventTitle(rs.getString("event_title"));
				event.setEventCreationDate(rs.getDate("event_creation_date"));
				event.setEventDate(rs.getDate("event_date"));
				event.setDetails(rs.getString("details"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}
}
