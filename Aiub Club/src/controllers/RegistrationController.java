package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import adapters.UserAdapter;
import models.User;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msg="";
		UserAdapter ua = new UserAdapter();
		User user= new User();
		String name= request.getParameter("name");
		String userName= request.getParameter("username");
		String password= request.getParameter("password");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		int phone;
		if(name.equals("")) {
			msg +="name ";
		}
		if(userName.equals("")){
			msg +=" username ";
		}
		if(password.equals("")) {
			msg +=" password ";
		}
		if(address.equals("")) {
			msg +=" address ";
		}
		if(email.equals("")) {
			msg +=" email ";
		}
		if(request.getParameter("phone").equals("")) {
			msg +=" phone ";
			phone=0;
		}else {
			phone=Integer.parseInt(request.getParameter("phone"));
		}
		
		if(msg.equals("")) {
			user.setName(name);
			user.setUserName(userName);
			user.setPassword(password);
			user.setAddress(address);
			user.setEmail(email);
			user.setPhoneNo(phone);
			ua.addNewUser(user);
		
			request.setAttribute("msg", "Registration Successfull");
			
		}else {
			request.setAttribute("msg", msg);
		}
		RequestDispatcher disp = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		//response.sendRedirect("login");
		disp.forward(request, response);
	}

}
