import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewItem extends HttpServlet
{
	public PrintWriter out;
	Utilities utility;
	

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		String flag = null;
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		out= response.getWriter();
		//==============Change path to relative path=========//
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");
		HashMap<String, Product> hm2 = handler.getProducts();		
		String category= request.getParameter("category");
		String id= request.getParameter("id");
		if(id == null)
		{
			utility.printHtml("HeaderLogout.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");			
		}
		utility = new Utilities(request,out);
		
		HttpSession session=request.getSession(false); 
		
		//Users user = (Users) session.getAttribute("userDetails");
		//Users user = (Users)session.getAttribute("userDetails");
		if(session != null)  
		{
			
			Users user = (Users) session.getAttribute("userDetails");
			
			String n=(String)session.getAttribute("uname");
			String usertype = (String)session.getAttribute("usertype");
			if(usertype.equals("StoreManager")){
				flag = "StoreManager";
			}
			else if(usertype.equals("Customer")){
				flag = "Customer";
			}
			utility.printHtml("HeaderLogout.html");
		}
		else
		{
			flag = null;
			System.out.println("===========Not Logged IN============");
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
		out.println("<div class=\"row\">");
		for(Map.Entry<String,Product> entry : hm2.entrySet())
		{
		    Product product=(Product)entry.getValue();
			String accessories= product.getAccesory();
			if( product.getId().equals(id) && product.getCategory().equals(category))
			{	
				if(flag == null)
				{
					System.out.println("===============" + product.getName()  +  "--------------------" );
					out.println("  <div class=\"col-sm-12 col-md-6\">" +
						"    <div class=\"thumbnail\">" +
						"      <img src=\"Html\\images\\" + product.getImage() +"\" class=\"img-responsive\" alt=\"...\" style = \" height:300px;\">" +
						"      <div class=\"caption text-center\">" +
						"        <h3>" + product.getName() + "</h3>" +
						"        <p>Price: $" + product.getPrice() + "</p>" +
						"        <p>Discount: $" + product.getDiscount() + "</p>" +
						"        <p>Warranty: $" + product.getWarranty() + "</p>" +
						"      </div>" +
						"    </div>" +
						"	</div>");
				}
					
				else if(flag.equals("StoreManager"))
				{	
					
					out.println("  <div class=\"col-sm-12 col-md-6\">" +
								"    <div class=\"thumbnail\">" +
								"      <img src=\"Html\\images\\" + product.getImage() +"\" class=\"img-responsive\" alt=\"...\" style = \" height:300px;\">" +
								"      <div class=\"caption text-center\">" +
								"        <h3>" + product.getName() + "</h3>" +
								"        <p>Price: $" + product.getPrice() + "</p>" +
								"        <p>Discount: $" + product.getDiscount() + "</p>" +
								"        <p>Warranty: $" + product.getWarranty() + "</p>" +
							//	"        <p><a href=\"AddCart?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-primary\" role=\"button\">Add To Cart</a> " +
							//	"        <a href=\"AddBuy?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-success\" role=\"button\">Buy Now</a></p>" +
								"        <a href=\"ViewItem?id="+"&&name="+"&&price="+"&&image="+"&&discount="+"&&warranty="+"\" class=\"btn btn-success\" role=\"button\">Delete</a></p>" +
								"        <a href=\"StoreUpdate?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-success\" role=\"button\">Update</a></p>" +
								"      </div>" +
								"    </div>" +
								"	</div>");
				}
				else if(flag.equals("Customer"))
				{
					out.println("  <div class=\"col-sm-12 col-md-6\">" +
					"    <div class=\"thumbnail\">" +
					"      <img src=\"Html\\images\\" + product.getImage() +"\" class=\"img-responsive\" alt=\"...\" style = \" height:300px;\">" +
					"      <div class=\"caption text-center\">" +
					"        <h3>" + product.getName() + "</h3>" +
					"        <p>Price: $" + product.getPrice() + "</p>" +
					"        <p>Discount: $" + product.getDiscount() + "</p>" +
					"        <p>Warranty: $" + product.getWarranty() + "</p>" +
					" 		<a href=\"Review?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "&&category="+product.getCategory()+"\" class=\"btn btn-success\" role=\"button\">Write Review</a></p>" +
					"		 <a href=\"ViewReview?name=" +product.getName()+"\" class=\"btn btn-success\" role=\"button\">View Review</a></p>" +
					"        <p><a href=\"AddCart?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-primary\" role=\"button\">Add To Cart</a> " +
					"        <a href=\"AddCart?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-success\" role=\"button\">Buy Now</a></p>" +
				//request.getRequestDispatcher("/ViewReview?name="+ProductModelName).forward(request, response);
					"      </div>" +
					"    </div>" +
					"	</div>");
				}
					
				System.out.println(product.getDiscount());
				System.out.println(product.getWarranty());
				out.println("</div>");
				out.println("</tr>");
				out.println("</tbody>");
				out.println("</table>");
				out.println("</article>");
				
				out.println("<div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">");
				out.println("<!-- Indicators -->");
				out.println("<ol class=\"carousel-indicators\">");
				out.println("<li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>");
				out.println("<li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>");
				out.println("<li data-target=\"#myCarousel\" data-slide-to=\"2\"></li>");
				out.println("</ol>");

				out.println("<!-- Wrapper for slides -->");
				out.println("<div class=\"carousel-inner\">");
				out.println("<div class=\"item active\">");
				out.println("<img src=\"Html\\images\\" + product.getImage() +"\" alt=\"jokes2\" >");
				out.println("</div>");
				out.println("<div class=\"item\">");
				out.println("<img src=\"Html\\images\\" + product.getAccesory() +"\" alt=\"jokes2\" >");
				out.println("</div>");


				out.println("</div>");

				// Left and right controls -->
				out.println("<a class=\"left carousel-control\" href=\"#myCarousel\" data-slide=\"prev\">");
				out.println("<span class=\"glyphicon glyphicon-chevron-left\"></span>");
				out.println("<span class=\"sr-only\">Previous</span>");
				out.println("</a>");
				out.println("<a class=\"right carousel-control\" href=\"#myCarousel\" data-slide=\"next\">");
				out.println("<span class=\"glyphicon glyphicon-chevron-right\"></span>");
				out.println("<span class=\"sr-only\">Next</span>");
				out.println("</a>");
				out.println("</div>");
				out.println("</div>");
			}
		}
		out.println("</section>");
		utility.printHtml("Sidebar.html");
		utility.printHtml("Footer.html");				
	}
}