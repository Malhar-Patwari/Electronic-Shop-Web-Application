import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.Random;


public class Form extends HttpServlet {
	
	Utilities utility;
	PrintWriter pw;
	List<Cart> arraylist;
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		pw= response.getWriter();
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("HeaderLogout.html");
		// pw.println("<section id=\"content\">");
		pw.println("<section id=\"content\">");
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		pw.println("<h2 style=\"color:red\"> Your Order is Placed successfully. </h2>");
		Random rand = new Random();
	    int  ordernumber = rand.nextInt(50) + 1;
		pw.println("<h2 style=\"color:blue\">Order Number is:" + ordernumber + "</h2>" );	
		pw.println("<h2 style=\"color:blue\"> Click Here for Cancel Order : <a href=\"Cancelorder\" color=\"red\">Cancel Order</a> </h2>");
		pw.println("</section>");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");	
	}

}
