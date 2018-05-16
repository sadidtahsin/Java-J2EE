// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
// Extend HttpServlet class
public class ChangePassword extends HttpServlet {
 

	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    
            HttpSession session = request.getSession();
            String name = (String)session.getAttribute("username");
            String type = (String)session.getAttribute("type");
            if(name==null){
              response.sendRedirect(request.getContextPath() + "/login");
            }
                
            String menu_admin="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
                
            String menu_user="<h5 align='center'><a href='user'>HOME</a> &nbsp &nbsp &nbsp <a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a> </h5>\n";
                
            String table= "<form method='POST' action='chngpass'><table align='center'>"+
            "<tr>"+
                "<td>Old Password</td>"+
               " <td><input type='password' name='old_password'/></td>"+
            "</tr>"+
             "<tr>"+
                "<td>New Password</td>"+
               " <td><input type='password' name='new_password'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>Confirm Password</td>"+
               " <td><input type='password' name='confirm_password'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td></td>"+
               " <td><input type='submit' style='float:right;'/></td>"+
            "</tr>"+
            "</table></form>";         
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

      
	       String title = "Change password";
           String docType = "<!doctype >";
           if(type.equals("manager")){
               
           
               out.println(docType +
                            "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor=\"#f0f0f0\">\n" +
                            "<h1 align=\"center\">" + "Change password" + menu_admin+"<br>"+table +
                            "</body></html>");
           }else if(type.equals("customer")){
               out.println(docType +
                            "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor=\"#f0f0f0\">\n" +
                            "<h1 align=\"center\">" + "Change password" + menu_user+"<br>"+table +
                            "</body></html>");
           }

          
        
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");

        PrintWriter out = response.getWriter();
        String pass="",newPass="",cPass="",databasePass="";
        pass=request.getParameter("old_password");
        newPass=request.getParameter("new_password");
        cPass=request.getParameter("confirm_password");
        
        if(pass=="" || newPass=="" || cPass==""){
            out.println("Error!! Any Fields Cannot be Empty");
            doGet(request,response);
        }else{
            if(newPass.equals(cPass)){
                String res="";
                DataAccess da = new DataAccess();
                ResultSet rs= da.getResultSet("select * from users where user_name='"+name+"' and password='"+pass+"'");
                try{
                    if(!rs.isBeforeFirst()){
                        out.println("Error!!! Wrong Old Password");
                        doGet(request,response);
                    }else{
                        
                        boolean x=da.executeQuery("update users set password='"+newPass+"' where user_name='"+name+"'");
                        if(x){
                            res="Password Successfully Changed";
                        }else{
                            res="Failed";
                        }
                        out.println(res);
                        doGet(request,response);


                    }
                }catch(SQLException e){
                    databasePass="";
                }
                
                

                }else{
                out.println("New Password Not Matched");
                doGet(request,response);
                }

        }
    }
    
        //doGet(request,response);
	

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
