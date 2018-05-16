import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.*;

// Extend HttpServlet class
public class UserHome extends HttpServlet {
    
    

    public String makeTable(String data1,int data2,String data3,int data4, String data5,String data6,String data7){
        
        return "<tr><td>"+data1+"</td><td>"+data7+"</td><td>"+data2+"</td>"+"</td><td>"+data3+"</td><td>"+data5+"</td><td>"+data6+"</td>"+"<td><a href='user?dvd_id="+data4+"'>review</a></td></tr>";
    }
    
    String menu="<h5 align='center'><a href='user'>HOME</a> &nbsp &nbsp &nbsp <a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a> </h5>\n";
    
    String dvdRequest="<br><h4 align='center'>Request For a DVD</h4><table align='center'><form action='user' method='POST'> <tr><td>DVD Name </td> <td><input type='text' name='dvd_name'/> &nbsp<td> <td>&nbsp<input type='submit'/></td></tr> <input type='hidden' value='request' name='action'> </form> </table>";
    
    String search="<h5 align='center'><form action='user' method='POST'><input type='search' name='dvd_search'/>  <select name='search_by'><option value='dvd_title'>Title</option><option value='actors'>Actor/Actress</option><option value='catagory_name'>Catagory</option></select>  <input type='submit'> <input type='hidden' value='search' name='action'></form></h5>";
    
    
    
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
      if(name==null || !type.equals("customer")){
          response.sendRedirect(request.getContextPath() + "/login");
      }
      
                
      boolean reviewFlag=false;
      String dvd_id="";
      
      if(request.getParameter("dvd_id") != null){
          reviewFlag=true;
          dvd_id = request.getParameter("dvd_id");
          
      }else{
          dvd_id="";
          
      }
      
      String review="<br><br><form align='center' action='user' method='POST'> <textarea name='review'rows='6' cols='50'></textarea> <input type='submit'/> <input type='hidden' name ='dvd_id' value='"+dvd_id+"'/> <input type='hidden' value='review' name='action'> </form></body></html>";
         
      response.setContentType("text/html");

      
      DataAccess da = new DataAccess();
      ResultSet rs= da.getResultSet("select d.*, c.catagory_name FROM dvd_info d,catagory c where d.catagory_id=c.catagory_id");
    
      
	  String title = "Login";
      String docType ="<!doctype >";
      
      
      
      
      if(reviewFlag){
          out.println(docType +
                      "<html>\n" +
                      "<head><title>" + title + "</title></head>\n" +
                      "<body bgcolor=\"#f0f0f0\">\n" +
                      "<h1 align=\"center\"> Welcome USER </h1>"+menu+review);
      }else{
          out.println(docType +
                      "<html>\n" +
                      "<head><title>" + title + "</title></head>\n" +
                      "<body bgcolor=\"#f0f0f0\">\n" +
                      "<h1 align=\"center\">" + "Welcome USER" + "</h1>\n\n"+menu+search+
                      "<table align='center' border=1><tr><th>Title</th><th>Catagory</th><th>Length</th><th>Description</th><th>Actor/Actress</th><th>Release Date</th><th>Action</th></tr>");
          try{
              while(rs.next()){
                  out.println(makeTable(rs.getString("dvd_title"),rs.getInt("length"),rs.getString("description"),rs.getInt("dvd_id"),rs.getString("actors"),rs.getDate("release_date").toString(),rs.getString("catagory_name")));
              }
          }catch(SQLException e){
              
          }
          
          
          
          out.println("</table>"+dvdRequest);
      }
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");
        if(name==null){
            response.sendRedirect(request.getContextPath() + "/login");
        }

        String res;
        response.setContentType("text/html");
        String action= request.getParameter("action");
        PrintWriter out = response.getWriter();
        
        if(action.equals("search")){
            
            String sr=request.getParameter("dvd_search");
            String op=request.getParameter("search_by");
        
            
            DataAccess da= new DataAccess();
            ResultSet rs = da.getResultSet("select d.*, c.catagory_name FROM dvd_info d,catagory c where d.catagory_id=c.catagory_id and  "+op+ " like '%"+sr+"%'" );
        
            
            String title = "Login";
            String docType ="<!doctype >";
            out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "Welcome USER" + "</h1>\n\n" + menu+
                    "<br><table align='center' border=1><tr><th>Title</th><th>Catagory</th><th>Length</th><th>Description</th><th>Actor/Actress</th><th>Release Date</th><th>Action</th></tr>");
            try{
                while(rs.next()){
                out.println(makeTable(rs.getString("dvd_title"),rs.getInt("length"),rs.getString("description"),rs.getInt("dvd_id"),rs.getString("actors"),rs.getDate("release_date").toString(),rs.getString("catagory_name")));
            }
            }catch(SQLException e){
            
            }
            
            out.println("</table></body></html>");
        
        }else if(action.equals("review")){
            
            String dvdReview=request.getParameter("review");
            String dvd_id=request.getParameter("dvd_id");
            if(dvdReview==""){
                out.println("Do no Fill DVD name Field");
                doGet(request,response);
                
            }else{
                DataAccess da= new DataAccess();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                boolean x=da.executeQuery("insert into review values(null,'"+dvdReview+"','"+name+"','"+dateFormat.format(date)+"',"+dvd_id+") ");
                if(x){
                    res="Review Successfully Submitted";
                }else{
                    res="Failed";
                }
                out.println(res);
                doGet(request,response);
            }
            
        }else if(action.equals("request")){
            String dvdName=request.getParameter("dvd_name");
            
            if(dvdName==""){
                out.println("Do no Fill DVD name Field");
                doGet(request,response);
                
            }else{
                DataAccess da= new DataAccess();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                boolean x=da.executeQuery("insert into customer_requests values(null,'"+dvdName+"','"+name+"','"+dateFormat.format(date)+"') ");
                if(x){
                    res="Request Successfully Submitted";
                }else{
                    res="Failed";
                }
                out.println(res);
                doGet(request,response);
            }
            
            
        }

	}

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
