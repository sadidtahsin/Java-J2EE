package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.EventAdapter;
import adapters.UserAdapter;
import models.Event;
import models.User;

/**
 * Servlet implementation class EventController
 */
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out= response.getWriter();
		EventAdapter ea= new EventAdapter();
		String path=request.getServletPath();
		
		if(path.equals("/home/detail"))  {
			String id = request.getParameter("id");
			Event event = ea.getEventInfo(Integer.parseInt(id));
			
			
//				out.println(event.getEventId());
//				out.println(event.getEventTitle());
//				out.println(event.getDetails());
//				out.println(event.getEventCreationDate());
//				out.println(event.getEventDate());
			
			request.setAttribute("event", event);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/details.jsp");
			disp.forward(request, response);
			
			
		}else if(path.equals("/home")) {
		
			
			ArrayList<Event> eventList= ea.getAllEvents();
			request.setAttribute("eventllist", eventList);
			RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			disp.forward(request, response);
			
			
//			Event a=ea.getTaskAssignedEventUserList(1);
//			ArrayList<Event.UserHolder> list= a.getUserList();
//			response.getWriter().println(list.get(0).getName()+" "+list.get(0).getUserId());
//			response.getWriter().println(list.get(1).getName()+" "+list.get(1).getUserId());
//			response.getWriter().println(list.get(2).getName()+" "+list.get(2).getUserId());
//			UserAdapter ua= new UserAdapter();
//			User a=ua.getAssignedEventList(2)
//			ArrayList<User.UserTask> list= a.getTaskList();
			//response.getWriter().println(list.get(0).getEventName()+" "+list.get(0).getEventId());
//			response.getWriter().println(list.get(1).getName()+" "+list.get(1).getUserId());
//			response.getWriter().println(list.get(2).getName()+" "+list.get(2).getUserId());
			
//			Event e=new Event();
//			e.setDetails("sadasd");
//			e.setEventId(1);
//			e.setEventDate(Date.valueOf("2016-09-02"));
//			e.setEventCreationDate(Date.valueOf("2016-09-01"));
//			e.setEventTitle("Cricket Donaca");
//			
//			ea.updateEvent(e);
//			
//			ua.activeUser(4);
//			ua.inactiveUser(3);
			
//			User u= new User();
//			u.setName("sdsa");
//			u.setAddress("sdasdasdas");
//			u.setEmail("dasdsd");
//			u.setPassword("dasdsadas");
//			u.setPhoneNo(1112121);
//			u.setUserName("sdasdasdasda");
//			ua.addNewUser(u);
			
			//ea.addNewEvent(e);
			
			
			
			
//			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		EventAdapter ea= new EventAdapter();
		String search=request.getParameter("search");
		ArrayList<Event> eventList= ea.getAllEventsBySearch(search);
		request.setAttribute("eventllist", eventList);
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
		disp.forward(request, response);
	}

}
