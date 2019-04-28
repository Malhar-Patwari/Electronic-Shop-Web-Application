import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Likeproduct extends HttpServlet
{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ArrayList <Bestrating> hm2 = new ArrayList <Bestrating>();
		MongoDbDataStoreUtility mydata = new MongoDbDataStoreUtility();
		hm2= mydata.LikedProducts();			
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Utilities util= new Utilities(request, out);
		util.printHtml("HeaderLogout.html");
		out.println("<section id=\"content\">");
	 	out.println("<h2 align=\"center\" margin-top=\"60px\">Most Liked Products based on Ratings</h2>");	
		
		out.println("<table cellspacing=\"0\" class=\"shopping-cart\"  style=\"Height:50px\"> ");
		out.println("<thead>");
		out.println("<tr class=\"headings\">");

		out.println("<th class=\"\">Product name</td>");

		out.println("<th class=\"\">Rating</td>");

		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for(Bestrating product : hm2)
		{
		  	//out.println("<section id=\"content\">");		
			out.println("<tr>"); 
			out.println("<td class=\"productName\">");
			out.println(product.getProductname());
			out.println("</td>");
			out.println("<td class=\"productName\">");
			out.println(product.getRating());
			out.println("</td>");

			out.println("</tr>");
		}
	        	 				
		out.println("</tbody>");
        out.println("</table>");
        out.println("</section>");

		util.printHtml("Sidebar.html");
		util.printHtml("Footer.html");

	}
}