

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;



public class Searchproductview extends HttpServlet {
	AjaxUtilities au = new AjaxUtilities();
 	HttpSession session ;
	
	public 	PrintWriter out;
	Utilities utility;
 	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
						
		HttpSession session=request.getSession();  
		PrintWriter out= response.getWriter();
		MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
		
		Product product = (Product)request.getAttribute("Product_obj");
		
		utility = new Utilities(request,out);

		Users users  = new Users();
		users= (Users)session.getAttribute("user");
	
		if(session.getAttribute("user")!= null)	
		{
			utility.printHtml("HeaderLogout.html");
		 
		}
		else
		{
			utility.printHtml("Header.html");
		}
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

		// Product product=(Product)entry.getValue();
		 
		out.println("<a  href=\"#\">");
		out.println("<img src=\"Html\\images\\" + product.getImage() +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
		out.println("</a>");
		         
		out.println("<ul>");
		out.println("<li class=\"desc\">Name : " + product.getName() +"</li>");
		out.println("<li>Price: $" + product.getPrice() + "</li>");
		out.println("<li>Quantity  " + product.getQuantity() + "</li>");
					 
		out.println("<li><a href=\"Review?name="+product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"\">WriteReview</a></li>" );
		             
		out.println("<li><a href=\"ViewReview?name="+product.getName()+"\" class=\"btnreview\">View Review</a></li>");
		out.println("<li><a href=\"ViewItem?id="+product.getId()+"&&category=" +product.getCategory()+"&&qty=" +product.getQuantity()+"\" class=\"btnreview\">View Item</a></li>");
		//out.println("<li><a href=\"AddCart\" class=\"btnreview\">Add to Cart</a></li>");
		out.println("</ul>");

		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");

		out.println("</article>");
		//  out.println("</div>");
		out.println("</section>");
		//  out.println("<div class=\"clear\"></div>");

		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
	}
}
    
 