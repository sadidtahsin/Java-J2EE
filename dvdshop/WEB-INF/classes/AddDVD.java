// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Extend HttpServlet class

public class AddDVD extends HttpServlet {
 
    public String createUpdateForm(String title ,int length, String description,String act, String id,String catagory_name, String actors,String date ){
        
        return "<form method='POST' action='add_dvd'><table align='center'>"+
        "<tr>"+
        "<td>DVD Title</td>"+
        " <td><input type='text' name='dvd_title' value='"+title+"'/></td>"+
        "</tr>"+
        "<tr>"+
        "<td>Length</td>"+
        " <td><input type='number' name='length' value='"+length+"' /></td>"+
        "</tr>"+
        "<tr>"+
        "<td>Previous Catagory</td>"+
        "<td>"+ catagory_name+
        "</td>"+
        "</tr>"+
        "<tr>"+
        "<td>Catagory</td>"+
        "<td>"+
        "<select name='search_by'>"+getAllCatagory()+"</select></td>"+
        "</tr>"+
        "<tr>"+
        "<td>Release Date</td>"+
        " <td><input type='date' name='release_date' value='"+date+"'/></td>"+
        "</tr>"+
        "<tr>"+
        "<td>Actors</td>"+
        "<td><textarea rows='5' cols='30' name='actors'>"+actors+"</textarea></td>"+
        "</tr>"+
        "<tr>"+
        "<td>DVD Description</td>"+
        " <td><textarea rows='10' cols='60' name='description'>"+description+"</textarea></td>"+
        "</tr>"+
        "<tr>"+
        "<td><input type='hidden' name='action' value='"+act+"'/> <input type='hidden' name='dvd_id' value='"+id+"'/></td>"+
        " <td><input type='submit' style='float:right;'/></td>"+
        "</tr>"+
        "</table></form>";
        
    }
    
    public String getAllCatagory(){
        String list="";
        DataAccess da= new DataAccess();
        ResultSet rs= da.getResultSet("select catagory_name from catagory");
        try{
            while(rs.next()){
                list +="<option>"+rs.getString("catagory_name")+"</option>\n";
            }
            return list;
        }catch(SQLException e){
            return list;
        }
        
    }

	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
        String id="",act="add";
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");
        String type = (String)session.getAttribute("type");
        if(name==null || !type.equals("manager")){
          response.sendRedirect(request.getContextPath() + "/login");
        }
      
      
         
        
        id=request.getParameter("dvd_id");
        if(id==null || id==""){
            id="";
            
            
        }else{
            act="update";
        }
      
                
        String menu="<h5 align='center'><a href='admin'>HOME</a> &nbsp  &nbsp<a href='add_dvd'>ADD DVD</a> &nbsp  &nbsp <a href='catagories'>DVD CATAGORIES</a> &nbsp  &nbsp <a href='customers'>VIEW CUSTOMERS</a>  &nbsp  &nbsp <a href='request'> CUSTOMER REQUESTS</a> &nbsp  &nbsp<a href='logout' >LOGOUT</a> &nbsp  &nbsp <a href='chngpass'> CHANGE PASSWORD</a></h5>\n";
                

        String table= "<form method='POST' action='add_dvd'><table align='center'>"+
            "<tr>"+
                "<td>DVD Title</td>"+
               " <td><input type='text' name='dvd_title'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>Length</td>"+
               " <td><input type='number' name='length'/></td>"+
            "</tr>"+
             "<tr>"+
                "<td>Catagory</td>"+
                "<td>"+ 
                "<select name='search_by'>"+getAllCatagory()+"</select></td>"+
            "</tr>"+
            "<tr>"+
            "<td>Release Date</td>"+
            " <td><input type='date' name='release_date'/></td>"+
            "</tr>"+
            "<tr>"+
            "<td>Actors</td>"+
            "<td><textarea rows='5' cols='30' name='actors'></textarea></td>"+
            "</tr>"+

            "<tr>"+
                "<td>DVD Description</td>"+
               " <td><textarea rows='10' cols='60' name='description' ></textarea></td>"+
            "</tr>"+
            "<tr>"+
                "<td><input type='hidden' name='action' value='"+act+"'/></td>"+
               " <td><input type='submit' style='float:right;'/></td>"+
            "</tr>"+
            "</table></form>";         
      response.setContentType("text/html");

      
	  String title = "Add New DVD";
      String docType =
      "<!doctype >";
      if(id.equals("")){
          out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "Add DVD to the DVD SHOP" + menu +table+
                    "</body></html>");
      }else{
          
          DataAccess da= new DataAccess();
          ResultSet rs;
          int len=0;
          String dvd_title="",dvd_description="",catagory_name="",actors="",date="";
          rs=da.getResultSet("select d.*, c.catagory_name FROM dvd_info d,catagory c where d.catagory_id=c.catagory_id and dvd_id="+id);
          
          try{
              
              while(rs.next()){
                  dvd_title=rs.getString("dvd_title");
                  len=rs.getInt("length");
                  dvd_description=rs.getString("description");
                  catagory_name=rs.getString("catagory_name");
                  actors= rs.getString("actors");
                  date= rs.getDate("release_date").toString();
                  
              }
              
          }catch(SQLException e){
              
          }
          
          

          out.println(docType +
                    "<html>\n" +
                    "<head><title>" + title + "</title></head>\n" +
                    "<body bgcolor=\"#f0f0f0\">\n" +
                    "<h1 align=\"center\">" + "Update" + menu + createUpdateForm(dvd_title,len,dvd_description,act,id,catagory_name,actors,date)+
                    "</body></html>");
      }
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String res;
        
        HttpSession session = request.getSession();
        String name = (String)session.getAttribute("username");
        if(name==null){
          response.sendRedirect(request.getContextPath() + "/login");
        }
        
        String title,description,catagory,length,ac,actors,date;
        int catagory_id=0;
        
        DataAccess da= new DataAccess();
        ResultSet rs;
        ac=request.getParameter("action");
        title=request.getParameter("dvd_title");
        description=request.getParameter("description");
        length=request.getParameter("length");
        catagory=request.getParameter("search_by");
        actors=request.getParameter("actors");
        date=request.getParameter("release_date");
        
        if(title==""){
            out.println("Error!! Title not Provided");
            doGet(request,response);
        }else if(length==""){
            out.println("Error!! Length not Provided");
            doGet(request,response);
        }else if(date==""){
            out.println("Error!! Release date not Provided");
            doGet(request,response);
        }else if(actors==""){
            out.println("Error!! Actors not Provided");
            doGet(request,response);

        }else if(description==""){
            out.println("Error!! Description not Provided");
            doGet(request,response);
        }else{
        
        rs=da.getResultSet("select catagory_id from catagory where catagory_name='"+catagory+"'");
        
        try{
            
            while(rs.next()){
                catagory_id=rs.getInt("catagory_id");
                
            }
            
        }catch(SQLException e){
            
        }
        if(ac.equals("add")){
        boolean x=da.executeQuery("insert into dvd_info(dvd_title,length,catagory_id,description,actors,release_date) values ('"+title+"',"+length+","+catagory_id+",'"+description+"','"+actors+"','"+date+"')");

            if(x){
                res="Successfully Added";
            }else{
                res="Adding Failed";
            }
        out.println(res);
        doGet(request,response);
        }
        else if (ac.equals("update")){
            
            String dvd_id=request.getParameter("dvd_id");
            boolean x=da.executeQuery("update dvd_info set dvd_title='"+title+"',length="+length+",catagory_id='"+catagory_id+"',description='"+description+"',actors='"+actors+"',release_date='"+date+"' where dvd_id="+dvd_id);
            response.sendRedirect(request.getContextPath() + "/admin");


        }
        }
	}

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
