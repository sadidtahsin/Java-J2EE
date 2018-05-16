// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



// Extend HttpServlet class
public class ViewRequest extends HttpServlet {
 

    public String makeTable(String data1,String data2,String data3,String data4){
        
        return "<tr><td>"+data1+"</td><td>"+data2+"</td><td>"+data3+"</td><td>"+data4+"</td></tr>";
    }
    
     String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
    
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
      ResultSet rs = da.getResultSet("select cr.request,us.name,us.user_name,cr.date from customer_requests cr , users us where us.user_name=cr.user_name ");
         
      response.setContentType("text/html");

      
	  String title = "Login";
      String docType =
      "<!doctype >";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "All Requests" + "</h1>\n\n" +menu+
                "<br><br><table align='center' border=1><tr><th>DVD Name</th><th>Customer Name</th><th>Username</th><th>Request Date</th></tr>");
                try{
                    while(rs.next()){
                        out.println(makeTable(rs.getString("request"),rs.getString("name"),rs.getString("user_name"),rs.getDate("date").toString()));
                    }
                }catch(SQLException e){
                    
                }
                out.println("</table></body></html>");
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
	}

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
