import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Inventory_rebate extends HttpServlet {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
  	
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		// Product product = new Product();
 		HttpSession session=request.getSession();  
		ArrayList<Product> products;
		String usertype = (String)session.getAttribute("usertype");
		//Users user = (Users)session.getAttribute("user");
		//String usert = user.usertype;

		Utilities utility = new Utilities(request,out);

		if(session.getAttribute("usertype").equals("StoreManager"))  
		{	
			products=ms.checkInventoryrebate();
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");
  			out.println("<section id=\"content\">");
 			out.println("<h2 align=\"center\" margin-top=\"60px\">Products Manufacture rebate Report</h2>");		
	  		out.println("<table cellspacing=\"0\" class=\"shopping-cart\"  style=\"Height:50px\"> ");
			out.println("<thead>");
			out.println("<tr class=\"headings\">");

			out.println("<th class=\"\">No.</td>");
			out.println("<th class=\"\">Product Name</td>");
			out.println("<th class=\"\">Price</td>");
			out.println("<th class=\"\">Quantity</td>");
			out.println("<th class=\"\">category</td>");
			out.println("<th class=\"\">Manufacture Rebate</td>");

			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");

			int i= 1;
			for(Product product : products)
			{				
				out.println("<tr>"); 
				out.println("<td class=\"productName\">");
				out.println(i++);
				out.println("</td>");
				out.println("<td class=\"productName\">");
				out.println(product.getName());
				out.println("</td>");

				out.println("<td class=\"productName\">");
				out.println(product.getPrice());
				out.println("</td>"); 

				out.println("<td class=\"productName\">");
				out.println(product.getQuantity());
				out.println("</td>");

				out.println("<td class=\"productName\">");
				out.println(product.getCategory());
				out.println("</td>");

				out.println("<td class=\"productName\">");
				out.println(product.getRebate());
				out.println("</td>");
				out.println("</tr>");				
			 }
			out.println("</tbody>");
            out.println("</table>");
            out.println("</section>");

			utility.printHtml("Side_manager.html");
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