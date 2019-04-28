import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class AjaxAutoCompleteServlet extends HttpServlet {
	 
	AjaxUtilities au = new AjaxUtilities();
   	String searchKeyword;
   	String action;
  	HashMap<String, Product> products ;
  	
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		StringBuffer sb = new StringBuffer();
		boolean prod  = false;
		PrintWriter out= response.getWriter();
		Utilities utility = new Utilities(request,out);
		products = au.getProduct();
		action = request.getParameter("action");
		searchKeyword = request.getParameter("id");	  
	  
	  
	// System.out.println(searchKeyword);
	  	if(searchKeyword!= "" || !searchKeyword.equals(""))
	  	{
			  
			if(action.equals("complete"))
		  	{
				searchKeyword = searchKeyword.trim().toLowerCase();  
				
				for(Map.Entry<String,Product> entry : products.entrySet())
					
				{
					Product product=(Product)entry.getValue();
					
					if(product.getName().toLowerCase().startsWith(searchKeyword))
					{
						sb.append("<product>");
						sb.append("<id>" + product.getId() + "</id>");
						sb.append("<name>" + product.getName() + "</name>");
						sb.append("</product>");
						prod = true;
					}
				}

				if(prod)
				{
					response.setContentType("text/xml");
					response.setHeader("Cache-Control","no-cache");
					out.write("<products>" + sb.toString() +"</products>");
				}
				else
				{
					response.setStatus(HttpServletResponse.SC_NO_CONTENT);
				}
		  	}
			
			if(action.equals("lookup"))
			{
				request.setAttribute("Product_obj",products.get(searchKeyword));
				request.getRequestDispatcher("/Searchproductview").forward(request, response);
			}
	  }
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
/*
String username = request.getParameter("username");
// Product product = new Product();
 HttpSession session=request.getSession();  
ArrayList<OrderP> Orders;

Users user = (Users)session.getAttribute("user");
//String usert = user.usertype;



if(session.getAttribute("user")!= null )  
{
	//
//String n=(String)session.getAttribute("uname");  
	
	//users= (Users)session.getAttribute("user");
	
Orders=ms.checkSalesdate();
utility.printHtml("HeaderAdd.html");

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
				//Product product=(Product)entry.getValue();
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
	/*pw.println("Hello else");
	
utility.printHtml("Header.html");
   
utility.printHtml("product.html");
utility.printHtml("Sidebar.html");

utility.printHtml("Footer.html");
}*/

	
	  }
}