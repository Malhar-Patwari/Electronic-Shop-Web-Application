import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class StateSold extends HttpServlet{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	
	public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException
	{   
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		// Product product = new Product();
		HttpSession session=request.getSession();  
		ArrayList<Product> products;
		//Users user = (Users)session.getAttribute("username");
		//String usert = user.usertype;
		Utilities utility = new Utilities(request,out);
		if(session.getAttribute("username")!= null )  
		{
			products = ms.checkInventory();
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");
			out.println("<section id=\"content\">");
			out.println("<article>");
			out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
			out.println("<thead>");
			out.println("<tr class=\"headings\">");
			out.println("<th class=\"link\">&nbsp;</th>");
			out.println("<th class=\"link\">&nbsp;</th>   ");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tr>");
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("</article>");
			out.println("</section>");
			utility.printHtml("SideData.html");
			utility.printHtml("Footer.html");
		}
		else
		{
			utility.printHtml("Header.html");
			utility.printHtml("product.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}