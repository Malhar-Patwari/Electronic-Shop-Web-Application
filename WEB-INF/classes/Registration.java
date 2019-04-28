import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Registration extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException
	{
		PrintWriter pw= response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//String firstname = request.getParameter("firstname");
		//String lastname = request.getParameter("lastname");
			 
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
		pw.println("<h2 align=\"center\" margin-top=\"60px\">Registration Form</h2>");
		pw.println("<form action=\"RegistrationParser\" method=\"get\">");

		pw.println("<div class=\"container\">");
		pw.println("<div class=\"row col-md-offset-1 col-md-5\">");
		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">First Name:</label>");
		pw.println("<input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter First Name\" name=\"firstname\" required >");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">Last Name:</label>");
		pw.println("<input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter Last Name\" name=\"lastname\" required >");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">User Name:</label>");
		pw.println("<input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter User Name\" name=\"username\" required >");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">Password:</label>");
		pw.println("<input type=\"password\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter Password\" name=\"password\" required >");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">UserType:</label><br/>");
		pw.println("<select name=\"usertype\">");
		pw.println("<option value=\"Customer\">Customer</option>");
		pw.println("<option value=\"StoreManager\">StoreManager</option>");
		pw.println("<option value=\"SalesMan\">SalesMan</option>");
		pw.println("</select>");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<button type=\"submit\" class=\"btn btn-primary btn-block\" value=\"Signup\">Sign Up</button>");
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