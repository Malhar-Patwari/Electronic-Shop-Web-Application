import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Order extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
  	
  	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
  	{
		  	
		out= response.getWriter();
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		String cn =request.getParameter("CardHolderName");
		String Zip =request.getParameter("ZipCode");
		String address =request.getParameter("address");
		String state =request.getParameter("state");
		System.out.println("Zip is :"+Zip);
			
		String Orderid = "";
		String Price = "";
		String productid = "";
		//String state = "";
		

		HttpSession session=request.getSession();
		Utilities utility = new Utilities(request,out);
		if(session.getAttribute("username")!= null)
		{
			utility.printHtml("HeaderLogout.html");
			//pw.println(address);
			Random rand = new Random();
			String username =(String)session.getAttribute("username");
			ArrayList<Cart> list =(ArrayList<Cart>)session.getAttribute("cartitem");			
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			
			for(Cart cart : list)
			{
				int  n = rand.nextInt(500) + 1;
				
				//String OrderId = (String)cart.getId();
				productid = (String)cart.getProductId();
				Price = (String)cart.getPrice();
				System.out.println("price is :"+Price);
				System.out.println("productid is :"+productid);
				//ran = "123" + n;
				Orderid = "123" + n;
				mydata.insertOrder(Orderid,username,Price,address,productid,sqlDate,Zip,state,list);

			}
						
			out.println("<form action=\"Form\" method=\"get\">");
			out.println("<div class=\"container username\">");
			out.println("<div class=\"username\">");
			out.println("<label name =\"Order\"><b>OrderId-</b></label>");
			//out.println(Price);
			
			out.println("<input type=\"text\" class=\"uname\" value = "+ productid+"  name=\"username\" >");
			//out.println("<input type=\"text\" class=\"uname\" value = "+ total+"  name=\"username\" >");
			out.println("</div>");
			out.println("<div class=\"username\">");
			out.println("<label><b>UserName</b></label>");
			out.println(username);
			out.println("</div>");
			out.println("<div class=\"username\">");
			out.println("<label><b>Shipping Address</b></label>");
			out.println(address);
			out.println("</div>");
			out.println("<div class=\"username\">");
			out.println("<label><b>Shipping Address</b></label>");
			out.println(Zip);
			out.println("</div>");
			out.println("<div class=\"username\">");
			out.println("<label><b>Order Date</b></label>");
			out.println("</div>");
			out.println("<div class=\"username1\">");
			
			out.println("<a href=\"Form\" class=\"lbutton\"><button type=\"submit\">SubmitOrder</button></a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</form>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");	
			request.getRequestDispatcher("/Form").forward(request, response);
			//pw.println("lastname" + user.getlastname());
		}
		else
		{
			out.println("Not e to Order Anything");
		}
	}

}