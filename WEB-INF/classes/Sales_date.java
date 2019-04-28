import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Sales_date extends HttpServlet {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();

		HttpSession session=request.getSession();  
		ArrayList<OrderP> Orders;
		String username = request.getParameter("username");
		

		Utilities utility = new Utilities(request,out);

		if(session.getAttribute("usertype").equals("StoreManager")) 
		{
			
			Orders=ms.checkSalesdate();
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");

			out.println("<section id=\"content\">");
			out.println("<h2 align=\"center\" margin-top=\"60px\">Products Sales Report</h2>");
				
			out.println("<table cellspacing=\"0\" class=\"shopping-cart\"  style=\"Height:50px\"> ");
			out.println("<thead>");
			out.println("<tr class=\"headings\">");


			out.println("<th class=\"\">No.</td>");
			out.println("<th class=\"\">Date</td>");
			out.println("<th class=\"\">Total Sale in USD:$</td>");
		               
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
		
		    int i= 1;
		    for(OrderP order : Orders)
			{
				out.println("<tr>"); 
				out.println("<td class=\"productName\">");
				out.println(i++);
				out.println("</td>");
				out.println("<td class=\"productName\">");
				out.println(order.getDate());
				out.println("</td>");
				
				 out.println("<td class=\"productName\">");
				out.println("$ " +order.getprice());
				out.println("</td>");
				
				
				out.println("</tr>");
		
		 	}
				out.println("</tbody>");
                out.println("</table>");
                out.println("</section>");
				utility.printHtml("side_sales.html");
				utility.printHtml("Footer.html");
		}		 
		else
		{
			/*pw.println("Hello else");*/
			
			utility.printHtml("Header.html");
			   
			utility.printHtml("product.html");
			utility.printHtml("Sidebar.html");

			utility.printHtml("Footer.html");
		}
			
	}
}