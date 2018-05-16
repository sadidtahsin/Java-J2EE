// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
// Extend HttpServlet class
public class Register extends HttpServlet {
 

	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    
            
                
           
                
            String table= "<form method='POST' autocomplete='false' action='register'><table align='center'>"+
            "<tr>"+
                "<td>Full Name</td>"+
               " <td><input type='text' name='name'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>User Name</td>"+
               " <td><input type='text' name='username' autocomplete='false'/></td>"+
            "</tr>"+
             "<tr>"+
                "<td>Password</td>"+
               " <td><input type='password' name='password' autocomplete='false'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>Email</td>"+
               " <td><input type='email' name='email'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>Phone No</td>"+
               " <td><input type='number' name='phone'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td>Address</td>"+
               " <td><textarea name='address'></textarea></td>"+
            "</tr>"+
            "<tr>"+
                "<td></td>"+
               " <td><input type='submit' style='float:right;'/></td>"+
            "</tr>"+
            "<tr>"+
                "<td></td>"+
               " <td><h5 style='float:right;'><a href='login'>Go to login</a></h5></td>"+
            "</tr>"+
            "</table></form>";         
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");

      
	       String title = "Change password";
           String docType = "<!doctype >";
        
           
               out.println(docType +
                            "<html>\n" +
                            "<head><title>" + title + "</title></head>\n" +
                            "<body bgcolor=\"#f0f0f0\">\n" +
                            "<h1 align=\"center\">" + "REGISTER" +"<br><br>"+table +
                            "</body></html>");
          
        
  }

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        //HttpSession session = request.getSession();
        //String name = (String)session.getAttribute("username");
        String res;
        PrintWriter out = response.getWriter();
        String name="",username="",pass="",address="",phone="",email="";
        name=request.getParameter("name");
        username=request.getParameter("username");
        pass=request.getParameter("password");
        address=request.getParameter("address");
        phone=request.getParameter("phone");
        email=request.getParameter("email");
        if(name==""||username==""||pass==""|| address=="" || phone=="" || email=="" ){
            out.println("Error!!! Any Field Cannot be Empty ");
            doGet(request,response);
        }else{
            
            DataAccess da= new DataAccess();
            boolean x = da.executeQuery("insert into users values(null,'"+username+"','"+name+"','"+phone+"','"+address+"','"+email+"','customer','"+pass+"')");
            if(x){
                res="Successfully Registerd";
            }else{
                res="Failed!!";
            }
            out.println(res);
            doGet(request,response);
            
        }
        
        
        
        

        
    }
    
        //doGet(request,response);
	

	@Override
	public void destroy() {
		// resource release
		super.destroy();
	}
}
