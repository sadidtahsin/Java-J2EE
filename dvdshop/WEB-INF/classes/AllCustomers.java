// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class

public class AllCustomers extends HttpServlet {
 
   

    public String makeTable(String data1,String data2,int data3, String data4,String data5){
        
        return "<tr><td>"+data1+"</td><td>"+data2+"</td><td>"+data3+"</td><td>"+data4+"</td><td>"+data5+"</td></tr>";
    }
    
     String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
    
     String search= "<h5 align='center'><form action='customers' method='POST'> <input type='search' name='search_customer'/> <input type='submit' /></form></h5>";
    
	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
      PrintWriter out = response.getWriter();
      HttpSession session = request.getSession();
      String name = (String)session.getAttribute("username");
      String type = (String)session.getAttribute("type");
      if(name==null || !type.equals("manager")){
          response.sendRedirect(request.getContextPath() + "/login");
      }
                
      DataAccess da = new DataAccess();
      ResultSet rs = da.getResultSet("select name, user_name, phone,email, address from users where type='customer'");
      
         
      response.setContentType("text/html");

	  String title = "Login";
      String docType =
      "<!doctype >";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "All Customers" + "</h1>\n\n" +menu+"<br>"+search+
                "<br><table align='center' border=1><tr><th>Name</th><th>User name</th><th>Phone</th><th>email</th><th>address</th></tr>");
                try{
                    while(rs.next()){
                        out.println(makeTable(rs.getString("name"),rs.getString("user_name"),rs.getInt("phone"),rs.getString("email"),rs.getString("address")));
                    }
                }catch(SQLException e){
                    
                }
                    
                out.println("</table></body></html>");
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        
        String menu="<h4 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a></h4>";
        
        PrintWriter out = response.getWriter();
        
        response.setContentType("text/html");
        String sr=request.getParameter("search_customer");
        
        DataAccess da= new DataAccess();
        ResultSet rs = da.getResultSet("select name, user_name, phone,email, address from users where type='customer' and name like '%"+sr+"%'");
        
        String title = "Login";
        String docType =
        "<!doctype >";
        out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "All Customers" + "</h1>\n\n" +menu+
                    "<br><table align='center' border=1><tr><th>Name</th><th>User name</th><th>Phone</th><th>email</th><th>address</th></tr>");
        try{
            while(rs.next()){
                out.println(makeTable(rs.getString("name"),rs.getString("user_name"),rs.getInt("phone"),rs.getString("email"),rs.getString("address")));
            }
        }catch(SQLException e){
            
        }
        
        out.println("</table></body></html>");
            //doGet(request,response);
	}

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
