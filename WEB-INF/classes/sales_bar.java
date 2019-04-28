import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class sales_bar extends HttpServlet {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
  
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();

		String username = request.getParameter("username");
		// Product product = new Product();
		 HttpSession session=request.getSession();  

		Utilities utility = new Utilities(request,out);

		if(session.getAttribute("usertype").equals("StoreManager")) 
		{			
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");
			out.println("<section id=\"content\">");
			out.println("<h2 align=\"center\" margin-top=\"60px\">Sales BarChart</h2>");
					
			out.println("<div id=\"piechart_sales\" ></div>" );
            out.println("</section>");

			utility.printHtml("side_sales.html");

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