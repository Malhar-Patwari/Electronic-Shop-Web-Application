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

public class Myhandler extends HttpServlet {
	
	public PrintWriter out;
	Utilities utility;

	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

		PrintWriter out= response.getWriter();
		//MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		//==============Change path to relative path=========//
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");
		HashMap<String, Product> hm2 = handler.getProducts();		
		String makers= request.getParameter("category");
		//HashMap<String, Product> hm2 = mydata.checkproduct(makers);
		utility = new Utilities(request,out);
		
		HttpSession session=request.getSession(false);
		//Users user = (Users)session.getAttribute("userDetails");

		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		if(session == null)  
		{
			//System.out.println("===========NOT Logged IN============");
			utility.printHtml("Header.html");
		}
		else
		{
			//System.out.println("===========Logged IN============");
			utility.printHtml("HeaderLogout.html");
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
		out.println("<div class=\"row\">");
				
	   for(Map.Entry<String,Product> entry : hm2.entrySet())
	   {
			Product product=(Product)entry.getValue();
		
			if( product.getCategory().equals(makers) )
			{
				System.out.println("===============" + product.getCategory()  +  "--------------------" );
				out.println("  <div class=\"col-sm-12 col-md-6\">" +
							"    <div class=\"thumbnail\">" +
							"      <img src=\"Html\\images\\" + product.getImage() +"\" class=\"img-responsive\" alt=\"...\" style = \" height:300px;\">" +
							"      <div class=\"caption text-center\">" +
							"        <h3>" + product.getName() + "</h3>" +
							"        <p>Price: $" + product.getPrice() + "</p>" +
							"        <p><a href=\"ViewItem?id=" + product.getId() + "&&category=" + product.getCategory() + "\" class=\"btn btn-primary\" role=\"button\">View Item</a></p>" +	
						//	"        <p><a href=\"ViewItem?id=" + product.getId() + "&&category=" + product.getCategory() + "\" class=\"btn btn-primary\" role=\"button\">Remove</a></p>" +
						//	"        <p><a href=\"ViewItem?id=" + product.getId() + "&&category=" + product.getCategory() + "\" class=\"btn btn-primary\" role=\"button\">Update</a></p>" +												
							"      </div>" +
							"    </div>" +
							"	</div>");			
			}				
		}
	
		out.println("</div>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</article>");
		out.println("</section>");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");
	}
}

