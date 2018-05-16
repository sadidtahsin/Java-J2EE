// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class
public class AllCatagories extends HttpServlet {
 

    public String makeTable(String data1){
        
        return "<tr><td>"+data1+"</td></tr>";
    }
    
    String ct="<br><h4 align='center'>Add New Catagory</h4><table align='center'><form action='catagories' method='POST'> <tr><td>Category Name </td> <td><input type='text' name='category'/> &nbsp<td> <td>&nbsp<input type='submit'/></form> </table>";

    
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
      
      

          DataAccess da= new DataAccess();
          ResultSet rs=da.getResultSet("select * from catagory");
          String action="default";
          String cmp="add_new_catagory";
                
          String title = "Login";
          String docType ="<!doctype >";
          
          String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
                
          response.setContentType("text/html");

          try{
              
             if(request.getParameter("action")== "" || request.getParameter("action")== null){
                 action="";
             }else{
                 action=request.getParameter("action");
             }
            
              
          }catch(Exception e){
              
          }
          
          if(action.equals(cmp)){
             out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "add new Catagory" + "</h1>\n\n" +menu+"<br><br>"+ct);
              
                    out.println("</body></html>");
          }else{
               
               
               out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "Catagoriews" + "</h1>\n\n" +menu+"<br><br>"+
                    "<h3 align='center'><a href='catagories?action=add_new_catagory'>add catagories</a></h3>\n"+"<table align='center' border=1>");
                    try{
                        while(rs.next()){ 
                            out.println(makeTable(rs.getString("catagory_name")));
                        }
                    }catch(SQLException e){
                        
                        
                    }
                    out.println("</table></body></html>");
          }

         
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        String category= request.getParameter("category");
        String res="";
        PrintWriter out = response.getWriter();
        if(category==""){
            out.println("Fields Cannot be Empty");
            doGet(request,response);

        }else{
            DataAccess da = new DataAccess();
            boolean x=da.executeQuery("insert into catagory values(null,'"+category+"') ");
            if(x){
                res="Successfully Added";
            }else{
                res="Adding Failed";
            }
            out.println(res);
            doGet(request,response);
        }
    }

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
