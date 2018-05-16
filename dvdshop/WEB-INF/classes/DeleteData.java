import java.io.IOException;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Extend HttpServlet class
public class DeleteData extends HttpServlet {
 

    public String makeTable(String data1,int data2,String data3,int data4){
        
        return "<tr><td>"+data1+"</td><td>"+data2+"</td>"+"<td>"+data3+"</td><td><a href='login?name="+data4+"'>review</a></td></tr>";
    }
    
    
    String id="";
	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      // Set response content type
                
    DataAccess da= new DataAccess();
    
    try{  
      id=request.getParameter("dvd_id");
    }catch(Exception e){
        
    }
    
    
        da.executeQuery("delete from dvd_info where dvd_id="+id);
   
    
    response.sendRedirect(request.getContextPath() + "/admin");
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
