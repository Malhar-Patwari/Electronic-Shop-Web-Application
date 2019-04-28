import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class productadd extends HttpServlet {
	//Utilities utility;
	PrintWriter pw;
	//List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{		  
		pw= response.getWriter();

		//String OrderID = request.getParameter("oid");
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("HeaderAdd.html");
		// pw.println("<section id=\"content\">");

		pw.println("<section id=\"content\">");	                				
		pw.println("<h2 style=\"color:red\"> Product added successfully. </h2>"); 
		//pw.println("<h2 style=\"color:blue\"> Your order num # is A44.  </h2>"); 
		pw.println("</section>");

		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");	
	}
}