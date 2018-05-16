package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.EventAdapter;
import adapters.TaskAdapter;
import adapters.UserAdapter;
import models.Event;
import models.User;

/**
 * Servlet implementation class AdminController
 */
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session= request.getSession();
		//session.removeAttribute("user");
		User usersession=(User) session.getAttribute("user") ;
		if(usersession != null && usersession.getUserType().equals("admin")) {
			
		
			String path= request.getServletPath();
			RequestDispatcher disp=null;
			
			
			if(path.equals("/admin/add")) {
				UserAdapter ua = new UserAdapter();
				ArrayList<User> userList=ua.unassignedUserOfEvent(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("userList", userList);
				request.setAttribute("id",request.getParameter("id"));
				//response.getWriter().println(request.getParameter("id"));
				disp=request.getRequestDispatcher("/WEB-INF/views/addUser.jsp");
				disp.forward(request, response);
				
				
			}else if(path.equals("/admin/edit")) {
				int eventId=Integer.parseInt(request.getParameter("id"));
				EventAdapter ea= new EventAdapter();
				request.setAttribute("event", ea.getEventInfo(eventId));
				disp=request.getRequestDispatcher("/WEB-INF/views/event_edit.jsp");
				disp.forward(request, response);
				
			}else if(path.equals("/admin/delete")) {
				int eventId=Integer.parseInt(request.getParameter("id"));
				EventAdapter ea = new EventAdapter();
				ea.deleteEvent(eventId);
				response.sendRedirect(request.getContextPath()+"/admin");
				
			}else if(path.equals("/admin/create_event")){
				disp=request.getRequestDispatcher("/WEB-INF/views/add_Event.jsp");
				disp.forward(request, response);
			}else if(path.equals("/admin/comments")){
				
				EventAdapter ea= new EventAdapter();
				int eventId=Integer.parseInt(request.getParameter("id"));
				Event event= ea.getCommnetByEvent(eventId);
				request.setAttribute("commentList",event.getCommentsList());
				disp=request.getRequestDispatcher("/WEB-INF/views/view_comments.jsp");
				disp.forward(request, response);
				
			}else if(path.equals("/admin/user_active")){
				int userId=Integer.parseInt(request.getParameter("id"));
				UserAdapter ua= new UserAdapter();
				ua.activeUser(userId);
				
				response.sendRedirect(request.getContextPath()+"/admin/user_request");
				
			}else if(path.equals("/admin/user_inactive")){
				int userId=Integer.parseInt(request.getParameter("id"));
				UserAdapter ua= new UserAdapter();
				ua.inactiveUser(userId);
				
				response.sendRedirect(request.getContextPath()+"/admin/all_user");
				
			}else if(path.equals("/admin/all_user")){
				UserAdapter ua= new UserAdapter();
				request.setAttribute("userList", ua.getAllActiveUserList());
				request.setAttribute("action", "inactive");
				disp=request.getRequestDispatcher("/WEB-INF/views/all_user.jsp");
				disp.forward(request, response);
			}else if(path.equals("/admin/user_request")){
				UserAdapter ua= new UserAdapter();
				request.setAttribute("action", "active");
				request.setAttribute("userList", ua.getAllInactiveUserList());
				disp=request.getRequestDispatcher("/WEB-INF/views/all_user.jsp");
				disp.forward(request, response);
			}else if(path.equals("/admin/assigned_user")){
				EventAdapter ea= new EventAdapter();
				int eventId=Integer.parseInt(request.getParameter("id"));
				request.setAttribute("userList", ea.getTaskAssignedEventUserList(eventId).getUserList());
				disp=request.getRequestDispatcher("/WEB-INF/views/assigned_user.jsp");
				disp.forward(request, response);
			}else {
				
				EventAdapter ea = new EventAdapter();
				request.setAttribute("eventList", ea.getAllEvents());
				disp=request.getRequestDispatcher("/WEB-INF/views/admin.jsp");
				disp.forward(request, response);
			}
		}else {
			response.sendRedirect("/Aiub_Club/login");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		HttpSession session= request.getSession();
		//session.removeAttribute("user");
		User usersession=(User) session.getAttribute("user") ;
		if(usersession != null && usersession.getUserType().equals("admin")) {
			
			RequestDispatcher disp=null;
			
			String formType=request.getParameter("form_type");
			
			if(formType.equals("add_user")) {
				TaskAdapter ta = new TaskAdapter();
				int event_id= Integer.parseInt(request.getParameter("event_id"));
				String [] checkBox= request.getParameterValues("userlist_checkbox");
				if(checkBox !=null) {
					for(int i=0;i<checkBox.length;i++) {
						ta.addUserToAnEvent(event_id, Integer.parseInt(checkBox[i]), request.getParameter("task"+checkBox[i]));
					}
					response.sendRedirect("/Aiub_Club/admin");
				}
				
			}else if(formType.equals("add_event")) {
				
				String err=""; 
				Event event= new Event();
				String title= request.getParameter("event_title");
				String details= request.getParameter("event_detal");
				Date date=null;
				java.sql.Date cdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				
				if(title.equals("")) {
					err +=" Title ";
				}
				if(details.equals("")) {
					err +=" Details ";
				}
				
				if(request.getParameter("event_date").equals("")) {
					err +=" Date ";
				}else {
					date=Date.valueOf(request.getParameter("event_date"));
				}
				if(err.equals("")) {
					EventAdapter ea= new EventAdapter();
					event.setEventTitle(title);
					event.setDetails(details);
					event.setEventDate(date);
					event.setEventCreationDate(cdate);
					
					ea.addNewEvent(event);
					request.setAttribute("msg", "Successfull");
					disp=request.getRequestDispatcher("/WEB-INF/views/add_Event.jsp");
					disp.forward(request, response);
				}else {
					
					request.setAttribute("msg", err+" are Empty!!!");
					disp=request.getRequestDispatcher("/WEB-INF/views/add_Event.jsp");
					disp.forward(request, response);
				}
				
				
			}else if(formType.equals("event_edit")) {
				
				String err=""; 
				Event event= new Event();
				String title= request.getParameter("event_title");
				String details= request.getParameter("event_detal");
				int eventId=Integer.parseInt(request.getParameter("event_id"));
				Date date=null;
				java.sql.Date cdate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				
				if(title.equals("")) {
					err +=" Title ";
				}
				if(details.equals("")) {
					err +=" Details ";
				}
				
				if(request.getParameter("event_date").equals("")) {
					err +=" Date ";
				}else {
					date=Date.valueOf(request.getParameter("event_date"));
				}
				if(err.equals("")) {
					EventAdapter ea= new EventAdapter();
					event.setEventId(eventId);
					event.setEventTitle(title);
					event.setDetails(details);
					event.setEventDate(date);
					event.setEventCreationDate(cdate);
					
					ea.updateEvent(event);
					
					response.sendRedirect(request.getContextPath()+"/admin");
				}else {
					
					request.setAttribute("msg", err+" are Empty!!!");
					disp=request.getRequestDispatcher("/WEB-INF/views/event_edit.jsp");
					disp.forward(request, response);
				}
				
			}else if(formType.equals("srch")) {
				
				EventAdapter ea= new EventAdapter();
				String search=request.getParameter("search");
				ArrayList<Event> eventList= ea.getAllEventsBySearch(search);
				request.setAttribute("eventList", eventList);
				disp = request.getRequestDispatcher("/WEB-INF/views/admin.jsp");
				disp.forward(request, response);
				
			}
			
		}else {
			response.sendRedirect("/Aiub_Club/login");
		}
	}

}
