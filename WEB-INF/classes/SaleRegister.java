import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class SaleRegister extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter pw= response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String usertype = request.getParameter("usertype");
	 	// HttpSession session=request.getSession(false);  
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
      
 		Utilities utility = new Utilities(request,pw);
	
		utility.printHtml("Header.html");

		pw.println("<!doctypes html>");

		pw.println("<html>");
		pw.println("<head>");

		pw.println("</head>");
		pw.println("<body>");
		pw.println("<section id=\"content\">");
		pw.println("<h2 align=\"center\" margin-top=\"60px\">Registration Form For User</h2>");
		pw.println("<form action=\"SaleRegisterParser\" method=\"get\">");
		pw.println("<div class=\"container username\">");

		pw.println("<div class=\"username1\">");
		pw.println("<label><b>First Name</b></label>");
		pw.println("<input type=\"text\" class=\"uname1\" placeholder=\"Enter First Name\" name=\"firstname\" required>");
		pw.println("</div>");

		pw.println("<br>");

		pw.println("<div class=\"username1\">");
		pw.println("<label><b>Last Name</b></label>");
		pw.println("<input type=\"text\" class=\"uname1\" placeholder=\"Enter Last Name\" name=\"lastname\" required>");
		pw.println("</div>");

		pw.println("<br>");

		pw.println("<div class=\"username1\">");
		pw.println("<label><b>Username</b></label>");
		pw.println("&nbsp;");
		pw.println("<input type=\"text\" class=\"uname1\" placeholder=\"Enter Username\" name=\"username\" required>");
		pw.println("</div>");

		pw.println("<br>");

		pw.println("<div class=\"username1\">");
		pw.println("<label><b>Password</b></label>");
		pw.println("&nbsp;");
		pw.println("<input type=\"password\" class=\"uname1\" placeholder=\"Enter Password\" name=\"password\" required>");
		pw.println("</div>");

		pw.println("<br>");

		pw.println("<div class=\"username1\">");
		pw.println("<label><b>UserType</b></label>");
		pw.println("&nbsp;");
		// pw.println("<input type=\"dropdown\" class=\"uname1\" placeholder=\"Choose one\" name=\"usertype\" required>");
		pw.println("<form>");
		pw.println("<select name=\"usertype\">");
		pw.println("<option value=\"Customer\">Customer</option>");
		//pw.println("<option value=\"StoreManager\">StoreManager</option>");
		//pw.println("<option value=\"SalesMan\">SalesMan</option>");
		pw.println("</select>");
		pw.println("</form>");
		pw.println("</div>");

		pw.println("<br>");





		pw.println("<div class=\"username1\">");
		pw.println("<button class=\"lbutton\" type=\"submit\" value=\"Register\">Register</button>");

		pw.println("</div>");

		pw.println("</div>");
		pw.println("</form>");

		pw.println("</section>");		
		pw.println("</body>");
		pw.println("</html>");

		utility.printHtml("Sidebar.html");

		utility.printHtml("Footer.html");

	}

    
}