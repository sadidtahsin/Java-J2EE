// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class AdminHome extends HttpServlet {
 

    public String makeTable(String data1,int data2,String data3,int data4, String data5,String data6,String data7){
        
        return "<tr><td>"+data1+"</td><td>"+data7+"</td><td>"+data2+"</td>"+"</td><td>"+data3+"</td><td>"+data5+"</td><td>"+data6+"</td>"+"<td><a href='review?dvd_id="+data4+"'>view review</a></td>"+"<td><a href='add_dvd?dvd_id="+data4+"'>edit</a></td>"+"<td><a href='delete?dvd_id="+data4+"'>delete</a></td></tr>";
    }
    
    String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";

    String search="<h5 align='center'><form action='admin' method='POST'><input type='search' name='dvd_search'/>  <select name='search_by'><option value='dvd_title'>Title</option><option value='actors'>Actor/Actress</option><option value='catagory_name'>Catagory</option></select>  <input type='submit'></form></h5>";
    
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
      ResultSet rs= da.getResultSet("select d.*, c.catagory_name FROM dvd_info d,catagory c where d.catagory_id=c.catagory_id");
         
      response.setContentType("text/html");

	  String title = "Login";
      String docType ="<!doctype >";
      out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + "Welcome ADMIN" + "</h1>\n\n" +
                menu+search+"<br><table align='center' border=1><tr><th>Title</th><th>Catagory</th><th>Length</th><th>Description</th><th>Actor/Actress</th><th>Release Date</th><th>Action</th><th>Action</th><th>Action</th></tr>");
                try{
                    while(rs.next()){
                        out.println(makeTable(rs.getString("dvd_title"),rs.getInt("length"),rs.getString("description"),rs.getInt("dvd_id"),rs.getString("actors"),rs.getDate("release_date").toString(),rs.getString("catagory_name")));
                    }
                }catch(SQLException e){
                    
                }
                out.println("</table></body></html>");
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        

        
        String sr=request.getParameter("dvd_search");
        String op=request.getParameter("search_by");
        
        String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
        DataAccess da= new DataAccess();
        String sql= "select * from dvd_info where "+op+" like '%"+sr+"%'";
        ResultSet rs = da.getResultSet("select d.*, c.catagory_name FROM dvd_info d,catagory c where d.catagory_id=c.catagory_id and  "+op+ " like '%"+sr+"%'" );

        
        String title = "Login";
        String docType ="<!doctype >";
        out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "Welcome Manager" + "</h1>\n\n" +
                    menu+"<br><table align='center' border=1><tr><th>Title</th><th>Catagory</th><th>Length</th><th>Description</th><th>Actor/Actress</th><th>Release Date</th><th>Action</th><th>Action</th><th>Action</th></tr>");
        try{
            while(rs.next()){
                out.println(makeTable(rs.getString("dvd_title"),rs.getInt("length"),rs.getString("description"),rs.getInt("dvd_id"),rs.getString("actors"),rs.getDate("release_date").toString(),rs.getString("catagory_name")));
            }
        }catch(SQLException e){
            
        }
        out.println("</table></body></html>");
        
    }

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
