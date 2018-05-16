// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
// Extend HttpServlet class
public class Login extends HttpServlet {
 

	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      
                PrintWriter out = response.getWriter();
          
      

        String table= "<form method='POST' action='login'><table align='center'>"+
            "<tr>"+
                "<td>Login</td>"+
               " <td><input type='text' name='username'/></td>"+
            "</tr>"+
             "<tr>"+
                "<td>Password</td>"+
               " <td><input type='password' name='password'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td></td>"+
               " <td><input type='submit' style='float:right;'/></td>"+
            "</tr>"+
            "<tr>"+
            "<td></td>"+
            " <td><a href='register' style='float:right;'>Register</a></td>"+
            "</tr>"+
            "</table></form>";
      response.setContentType("text/html");

      
	  String title = "Login";
      String docType =
      "<!doctype >";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "Welcome to DVD SHOP" + "</h1>\n" +table+
                "</body></html>");
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        PrintWriter out = response.getWriter();
        
        
        
        ArrayList<String> user_info= new ArrayList();
        String name,password;
        name=request.getParameter("username");
        password=request.getParameter("password");
        
        if(name==""){
            out.println("*Empty Username Field");
            doGet(request,response);
        }else if(password==""){
            out.println("*Empty Password Field");
            doGet(request,response);
        }else{
    
            DataAccess da= new DataAccess();
            ResultSet rs= da.getResultSet("select  user_name,password, type from users where user_name='"+name+"' and password='"+password+"'");
        
           
               
            
                try{
                    if(!rs.isBeforeFirst()){
                        out.println("username or password error");
                        doGet(request,response);
                    }else{
                        while(rs.next()){
                            user_info.add(rs.getString("user_name"));
                            user_info.add(rs.getString("type"));
                
                    
                        }
                    }
                }catch(SQLException e){
                    
                }
                
                    session.setAttribute("username",user_info.get(0));
                    session.setAttribute("type",user_info.get(1));
                    if(user_info.get(1).equals("manager")){
                        
                        response.sendRedirect(request.getContextPath() + "/admin");
                        
                    }else if(user_info.get(1).equals("customer")){
                        
                        response.sendRedirect(request.getContextPath() + "/user");
                    }
                
            
            
        }
    
    
        
       
        
        //doGet(request,response);
	}


	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
