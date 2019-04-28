import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Login extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		PrintWriter pw= response.getWriter();
		Utilities utility = new Utilities(request,pw);
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		utility.printHtml("Header.html");

		pw.println("<section id=\"content\" class=\"\">");
		pw.println("<h2 align=\"center\" margin-top=\"60px\">Login Form</h2>");
		
		pw.println("<form action=\"LoginParser\" method=\"POST\">");
		pw.println("<div class=\"container\">");
		pw.println("<div class=\"row col-md-offset-1 col-md-5\">");
		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">Username:</label>");
		pw.println("<input type=\"text\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter username\" name=\"username\" required >");
		pw.println("</div>");

		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"exampleInputEmail1\">Password:</label>");
		pw.println("<input type=\"password\" class=\"form-control\" id=\"exampleInputEmail1\" placeholder=\"Enter username\" name=\"password\" required >");
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
		pw.println("<button type=\"submit\" class=\"btn btn-primary btn-block\" value=\"login\">Login</button>");
		pw.println("</div>");
		pw.println("</div>");
		pw.println("</div>");

		pw.println("</form>");
		pw.println("</section>");
		
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
	}		

}