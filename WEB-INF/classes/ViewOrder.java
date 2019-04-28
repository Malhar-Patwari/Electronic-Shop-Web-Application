import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewOrder extends HttpServlet 
{
  
  public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
  {
		PrintWriter out= response.getWriter();		

		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");
		HashMap<String, Product> hm3 = handler.getProducts();
		 
		HttpSession session=request.getSession();
		String username =(String)session.getAttribute("username");
		System.out.println("User is :"+username);
		
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		
		HashMap<String, List<OrderP>> or = mydata.orderView(username);
		
		System.out.println(or.keySet());
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");
		
		out.println("<section id=\"content\">");
		out.println("<h1>Customer Orders</h1>");


		out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
		out.println("<thead>");
		out.println("<tr class=\"headings\">");
		
		out.println("<th class=\"\">Uname</td>");
	    out.println("<th class=\"\">OrderId</td>");
	    out.println("<th class=\"\">Price</td>");
	    out.println("<th class=\"\">Address</td>");
		out.println("<th class=\"\">ZipCode</td>");
		out.println("<th class=\"\">Cancel Order</td>");	
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");

		for(Map.Entry<String,List<OrderP>> entry : or.entrySet())
		{
		   List<OrderP> productlist= (List<OrderP>) entry.getValue();
		   for(OrderP product : productlist)
		   {
		     
			    out.println("<tr>"); 
			    out.println("<td class=\"productName\">");
			    out.println(product.getUsername());
			    out.println("</td>");
			    out.println("<td class=\"productName\">");
			    out.println(product.getOrderId());
			    out.println("</td>");
			    out.println("<td class=\"productName\">");
			    out.println(product.getprice());
			    out.println("</td>");
				out.println("<td class=\"productName\">");
			    out.println(product.getAddress());
			    out.println("</td>");
			    out.println("<td class=\"productName\">");
			    out.println(product.getZip());
			    out.println("</td>");
				out.println("<td class=\"productName\">");
			    out.println("<a href=\"Cancelorder?id="+product.getOrderId()+"\" class=\"btn btn-success\" role=\"button\">Cancel Order</a></p>");
			    out.println("</td>");
			    
			    out.println("</tr>");

			}
        }	 
		
        out.println("</tbody>");
        out.println("</table>");
        out.println("</section>");
		utility.printHtml("Sidebar.html");
		
		utility.printHtml("Footer.html");
	}		

}