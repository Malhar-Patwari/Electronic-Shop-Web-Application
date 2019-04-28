import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewBuy extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Buy> arraylist;
	HttpSession session;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		session = request.getSession(false);
		if(session == null)  
		{
			response.sendRedirect("./Login");
			return;
		} 
		
		out= response.getWriter();
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");
		arraylist = (ArrayList<Buy>)session.getAttribute("buyitem");  
		String check = request.getParameter("input");
		
		if(session != null)
		{
			out.println("<section id=\"content\">");
			out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
			out.println("<thead>");
			out.println("<tr class=\"headings\">");
			out.println("<th class=\"link\">&nbsp;</th>");
			out.println("<th class=\"link\">&nbsp;</th>   ");  
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tr>");
			
			for(Buy buy : arraylist)
			{
				out.println("<article>");
				out.println("<a  href=\"#\">");
				out.println("<img src=\"Html\\images\\" + buy.getImage() +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
				out.println("</a>");
				out.println("<ul>");
				out.println("<li class=\"desc\">Name : " + buy.getName() +"</li>");
				out.println("<li>Price: $" + buy.getPrice() + "</li>");
				out.println("<li>Discount: $" + buy.getDiscount() + "</li>");
				out.println("<li>Warranty: $" + buy.getWarranty() + "</li>");
				out.println("<li>Quantity=1 </li>");
				out.println("</ul>");
				out.println("</article>");
			}
			out.println("<button ><a href=\"Checkout\" class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</a></button>");
			
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("</section>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
		}
		else
		{
			utility.printHtml("Header.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}