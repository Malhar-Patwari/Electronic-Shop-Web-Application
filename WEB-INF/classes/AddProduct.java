import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class AddProduct extends HttpServlet {
	
	PrintWriter out;
	//List<Cart> arraylist;
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
 		
 		out= response.getWriter();

		Utilities utility = new Utilities(request,out);
			
		utility.printHtml("HeaderAdd.html");

		utility.printHtml("Addproduct.html");

		utility.printHtml("Sidebar.html");

		utility.printHtml("Footer.html");
	  
	}
}