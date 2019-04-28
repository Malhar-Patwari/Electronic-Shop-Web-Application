import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewCart extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	HttpSession session;

	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		int total = 0;
		int val;
		int war;
		int dis;
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		Carousel carousel = new Carousel();
		
		session = request.getSession(false);
		
		if(session == null)  
		{
			response.sendRedirect("./Login");
			return;
		}

		out= response.getWriter();
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");

		arraylist = (ArrayList<Cart>)session.getAttribute("cartitem");  
		String check = request.getParameter("input");
		System.out.println(session);
		
		//=-==================Change this condition=============//
		if(arraylist != null)
		{
			System.out.println("==========INSIDE==============");
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
			for(Cart cart : arraylist)
			{
				val = Integer.parseInt(cart.getPrice());
				dis = Integer.parseInt(cart.getDiscount());
				war = Integer.parseInt(cart.getWarranty());
				
				total += val + war - dis;
				System.out.println("===============================================vdfbnbvndbnfdbvf=====");
				System.out.println();
				out.println("<article>");
				out.println("<a  href=\"#\">");
				out.println("<img src=\"Html\\images\\" + cart.getImage() +"\" class=\"img-responsive\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
				out.println("</a>");
				out.println("<ul>");
				out.println("<li class=\"desc\">Name : " + cart.getName() +"</li>");
				out.println("<li class=\"desc\">Discount : " + cart.getDiscount() +"</li>");
				out.println("<li class=\"desc\">Warranty : " + cart.getWarranty() +"</li>");
				out.println("<li>Price: $" + cart.getPrice() + "</li>");
				out.println("<li>Quantity=1 </li>");
				out.println("<a href=\"RemoveCart?id="+cart.getId()+"&&name=" +cart.getName()+"&&price=" +cart.getPrice()+"&&image=" +cart.getImage()+"&&discount=" +cart.getDiscount()+"&&warranty=" +cart.getWarranty()+ "\" class=\"btn btn-primary\" role=\"button\">Remove from Cart</a> "
							);
				out.println("</ul>");
				out.println("</article>");
			}
			if(arraylist.size()>0)
			{
				out.println("<label><b>Total Amount: "+total+"</b></label>");
				out.println("</br>");
				out.println("<button ><a href=\"Checkout\" class=\"lbutton\" type=\"submit\" value=\"login\">Checkout</a></button>");
			}
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			System.out.println("=========================bndvbvnbdvnvb===================");
			/* This code is calling Carousel.java code to implement carousel feature*/
			out.print(carousel.carouselfeature(utility,session));
			out.println("</section>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
		}
		else
		{
			//utility.printHtml("HeaderLogout.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}