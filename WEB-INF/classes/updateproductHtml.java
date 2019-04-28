import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class updateproductHtml extends HttpServlet {	
	Product product;
	PrintWriter out;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		out= response.getWriter();
		String product_id = request.getParameter("pid");

		Utilities utility = new Utilities(request,out);

		utility.printHtml("HeaderAdd.html");
		utility.printHtml("udproduct.html");
		utility.printHtml("Sidebar.html");

		utility.printHtml("Footer.html");
	}
}
