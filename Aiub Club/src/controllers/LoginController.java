package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import adapters.VerificationAdapter;
import models.User;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		 RequestDispatcher disp=null;
		System.out.println("WELCOME");
		String err="";
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		
		if(username.equals("")) {
			err+="username";
		}
		if(password.equals("")) {
			err+="password";
		}
		
		
		if(err.equals("")) {
			VerificationAdapter va= new VerificationAdapter();
			
			User user = va.verify(username, password);
			try {
				if(user !=null ){
					if(user.getUserType().equals("admin")) {
						session.setAttribute("user", user);
						response.sendRedirect("/Aiub_Club/admin");
					}else if(user.getUserType().equals("member")) {
						if(user.getUserStaus().equals("active")) {
							
							session.setAttribute("user", user);
							response.sendRedirect("/Aiub_Club/user");
							
						}else {
							//System.out.println("INACTIVE USER");
							response.sendRedirect("/Aiub_Club/login");
						}
					}else {
						response.sendRedirect("/Aiub_Club/login");
					}
				}else {
					
					response.sendRedirect("/Aiub_Club/login");
					
				}
			}catch( Exception e) {
				request.setAttribute("msgs", "Failed");
				disp=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
				disp.forward(request, response); 
			}
		}else {
			request.setAttribute("msgs", err);
			disp=request.getRequestDispatcher("/WEB-INF/views/login.jsp");
			disp.forward(request, response); 
		}
		
	}

}
