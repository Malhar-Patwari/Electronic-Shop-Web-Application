import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Checkout extends HttpServlet {
	
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		out= response.getWriter();
		
		//String Orderid = request.getParameter("id");
		//String price = request.getParameter("price");
		//String username = request.getParameter("username");
		//String username = request.getParameter("username");
		//String username = request.getParameter("username");
		Utilities utility = new Utilities(request,out);
		HttpSession session=request.getSession();
		
		arraylist = (ArrayList<Cart>)session.getAttribute("cartitem");  
		String check = request.getParameter("input");
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	
		if(arraylist!=null)
		{
			utility.printHtml("HeaderLogout.html");
			//out.println("if");
			out.println("<section id=\"content\">");
			//out.println("<h2 align=\"center\" margin-top=\"60px\">Login Form</h2>");
			out.println("<form action=\"Order\" method=\"get\">");
			out.println("<div class=\"container username\">");
			out.println("<div class=\"username\">");
			out.println("<label><b>Card Holder Name</b></label>");
			out.println("<input type=\"text\" class=\"uname\" placeholder=\"Enter Card Holder Name\" name=\"CardHolderName\" required>");
			out.println("</div>");
			
			out.println("<div class=\"username\">");
			out.println("<label><b>Card Number</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"number\" class=\"uname\" placeholder=\"Enter Card Number\" name=\"CardNumber\" required>");
			out.println("</div>");

			out.println("<div class=\"username\">");
			out.println("<label><b>Enter Address</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"text\" name=\"address\" class=\"uname\" placeholder=\"Enter Address\"  required>");
			out.println("</div>");
			
			out.println("<div class=\"username\">");
			out.println("<label><b>State</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"text\" name=\"state\" class=\"uname\" placeholder=\"Enter State\"  required>");
			out.println("</div>");
			
			out.println("<div class=\"username\">");
			out.println("<label><b>ZipCode</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"number\" name=\"ZipCode\" class=\"uname\" placeholder=\"Enter ZipCode \"  required>");
			out.println("</div>");
			
			out.println("<button class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</button>");
			out.println("</div>");
			out.println("</form>");

			// out.println("<button ><a href=\"Form\" class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</a></button>");
			//out.println("<li><a href=\"Form\" class=\"btnreview\">Checkout</a></li>"); 

			out.println("</section>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
		}
		else if(arraylist==null)
		{
			
			utility.printHtml("HeaderLogout.html");
			//out.println("if");
			out.println("<section id=\"content\">");
			//out.println("<h2 align=\"center\" margin-top=\"60px\">Login Form</h2>");
			out.println("<form action=\"Order\" method=\"get\">");
			out.println("<div class=\"container username\">");
			out.println("<div class=\"username\">");
			out.println("<label><b>Card Holder Name</b></label>");
			out.println("<input type=\"text\" class=\"uname\" placeholder=\"Enter Card Holder Name\" name=\"username\" required>");
			out.println("</div>");
			
			out.println("<div class=\"username\">");
			out.println("<label><b>Card Number</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"number\" class=\"uname\" placeholder=\"Enter Card Number\" name=\"password\" required>");
			out.println("</div>");

			out.println("<div class=\"username\">");
			out.println("<label><b>Enter Address</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"text\" class=\"address\" placeholder=\"Enter Address\" name=\"address\" required>");
			out.println("</div>");

			out.println("<div class=\"username\">");
			out.println("<label><b>ZipCode</b></label>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("<input type=\"number\" class=\"ZipCode\" placeholder=\"Enter ZipCode \" name=\"ZipCode\" required>");
			out.println("</div>");

			out.println("<button class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</button>");
			out.println("</div>");
			out.println("</form>");

			// out.println("<button ><a href=\"Form\" class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</a></button>");
			//out.println("<li><a href=\"Form\" class=\"btnreview\">Checkout</a></li>"); 

			out.println("</section>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
			
		}
		else
		{
			utility.printHtml("HeaderLogout.html");
			//out.println("else");n
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}