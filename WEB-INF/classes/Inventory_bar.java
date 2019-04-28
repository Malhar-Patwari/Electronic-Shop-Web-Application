import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Inventory_bar extends HttpServlet {

	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
  	
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		// Product product = new Product();
		HttpSession session=request.getSession();  
		String usertype = (String) session.getAttribute("usertype");
		//ArrayList<Product> products;
		//Users user = (Users)session.getAttribute("user");
		//String usert = user.usertype;

		Utilities utility = new Utilities(request,out);

		if(session.getAttribute("usertype").equals("StoreManager"))  
		{
			//String n=(String)session.getAttribute("uname");  
			//users= (Users)session.getAttribute("user");
			//products=ms.checkInventory();
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");
			//utility.printHtml("Side_manager.html");
			out.println("<section id=\"content\">");
			out.println("<article>");
							
			out.println("<div id=\"piechart\" style=\"width: 6500px; height: 1700px;\" ></div>" );
			out.println("</article>");
			out.println("</section>");
			utility.printHtml("Side_manager.html");
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