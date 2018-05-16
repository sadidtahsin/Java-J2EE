// Import required java libraries
import java.io.*;
import java.sql.ResultSet;
import java.sql.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
// Extend HttpServlet class
public class Logout extends HttpServlet {
 

	@Override
	public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
    
      
            PrintWriter out = response.getWriter();
            HttpSession session = request.getSession();
            session.invalidate();
            response.sendRedirect(request.getContextPath() + "/login");
          
        
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
