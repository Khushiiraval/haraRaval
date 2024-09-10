package gls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		try
		{
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con= DriverManager.getConnection("jdbc:mysql://128.66.203.247:3306/exam1","exam1","sumo@123");
   
  
   PreparedStatement pst=  con.prepareStatement("Select * from cars");
   ResultSet rs=  pst.executeQuery();
   while(rs.next())
   		{
	   
	   String cbrand = rs.getNString(0);
	String cname1 = rs.getNString(1);
	String cprice2 = rs.getNString(2);
	String linkUrl = "Details?cname=" + cname1 + "&price=" + cprice2+ "&cbrand=" + cbrand;
       out.println("<html>");
       out.println("<body>");
       out.println("<a href='" + linkUrl + "'>" + cname1 + "</a>");
       out.println("</body>");
       out.println("</html>");
      }
   out.close();
		}
    	catch(Exception e)
    	{
    		System.out.println(e);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
