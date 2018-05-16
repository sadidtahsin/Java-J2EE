package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.CommentAdapter;
import adapters.EventAdapter;
import adapters.TaskAdapter;
import adapters.UserAdapter;
import models.Event;
import models.User;

/**
 * Servlet implementation class LoginController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
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
		if(usersession != null && usersession.getUserType().equals("member")) {
			RequestDispatcher disp=null;
			
			String path= request.getServletPath();
			if(path.equals("/user/my_events")) {
				UserAdapter ua= new UserAdapter();
				
				request.setAttribute("eventList", ua.getAssignedEventList(usersession.getUserId()).getTaskList());
				disp=request.getRequestDispatcher("/WEB-INF/views/user_events.jsp");
				disp.forward(request, response);
			}else if(path.equals("/user/comment")){
				
				EventAdapter ea= new EventAdapter();
				int eventId=Integer.parseInt(request.getParameter("id"));
				Event event= ea.getCommnetByEvent(eventId);
				request.setAttribute("commentList",event.getCommentsList());
				request.setAttribute("eventId",eventId);
				disp=request.getRequestDispatcher("/WEB-INF/views/user_comments.jsp");
				disp.forward(request, response);
				
			}else {
				EventAdapter ea = new EventAdapter();
				request.setAttribute("eventList",ea.getAllEvents());
				disp=request.getRequestDispatcher("/WEB-INF/views/user.jsp");
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
		//doGet(request, response);
		
		RequestDispatcher disp=null;
		
		HttpSession session= request.getSession();
		//session.removeAttribute("user");
		User usersession=(User) session.getAttribute("user") ;
		if(usersession != null && usersession.getUserType().equals("member")) {
			String formType=request.getParameter("form_type");
			if(formType.equals("srch")) {
				
				EventAdapter ea= new EventAdapter();
				String search=request.getParameter("search");
				ArrayList<Event> eventList= ea.getAllEventsBySearch(search);
				request.setAttribute("eventList", eventList);
				disp = request.getRequestDispatcher("/WEB-INF/views/user.jsp");
				disp.forward(request, response);
				
			}else if(formType.equals("comment_form")) {
				int eventId=Integer.parseInt(request.getParameter("eventId")); 
				int userId=usersession.getUserId();
				String comment= request.getParameter("user_comment");
				CommentAdapter ca= new CommentAdapter();
				ca.addComment(eventId, userId, comment);
				response.sendRedirect(request.getContextPath()+"/user/comment?id="+eventId);
			}
			
			
		}else {
			response.sendRedirect("/Aiub_Club/login");
		}
		
		
		
	}

}
