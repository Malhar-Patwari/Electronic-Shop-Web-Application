import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Review extends HttpServlet {
	
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		out= response.getWriter();
		
		//String ProductModelName =  request.getParameter("ProductName");
		String ProductCategory = request.getParameter("Category");
		String ProductPrice  =  request.getParameter("Price"); 
				
		MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
		java.sql.Date ReviewDate =  new java.sql.Date(System.currentTimeMillis());
		
		String RetailerName = "SmartPortables";
		String RetailerZip = "60616";
		String RetailerCity = "Chicago";
		String RetailerState = "IL";
		String ProductOnSale = "Yes";
		String ManufacturerName = request.getParameter("name");
		String ManufacturerRebate = "Yes";
		//String UserId = "190" + n ;

		String Name = request.getParameter("name");
		String Price = request.getParameter("price");
		String image =  request.getParameter("image");
		String Category =  request.getParameter("category");
		//MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
		
		HttpSession session=request.getSession();  

		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");
		String username = (String)session.getAttribute("uname");
		out.println("<ul>");
		
		out.println("<li class=\"desc\">Product Model Name : " +  Name+"</li>");
		out.println("<li class=\"desc\">Product Category : " +  Category+"</li>");
		out.println("<li class=\"desc\">Product Price : " +  Price+"</li>");
		out.println("<li class=\"desc\">Retailer Name : " +  RetailerName+"</li>");
		out.println("<li class=\"desc\">Retailer Zip : " +  RetailerZip+"</li>");
		out.println("<li class=\"desc\">Retailer City : " +  RetailerCity+"</li>");
		out.println("<li class=\"desc\">Retailer State : " +  RetailerState+"</li>");
		out.println("<li class=\"desc\">Product On Sale : " +  ProductOnSale+"</li>");
		out.println("<li class=\"desc\">Manufacturer Name : " +  ManufacturerName+"</li>");
		out.println("<li class=\"desc\">Manufacturer Rebate : " +  ManufacturerRebate+"</li>");
		//out.println("<li class=\"desc\">User Id : " +  Name+"</li>");
		out.println("<li class=\"desc\">Review Date : " +  ReviewDate+"</li>");
		
		//	out.println("<li>Price: $" + Price + "</li>");	

		out.println("</ul>");
		out.println("<a  href=\"#\">");

		out.println("<img src=\"Html\\images\\" + image +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
		out.println("</a>");
		out.println("<form action =\"ShowReview\"  method=\"get\">");
		//pw.println("<div class=\"container\">");
			
		out.println("<div class=\"container username\">");
		out.println("<div class=\"row col-md-offset-1 col-md-5\">");
		out.println("<div>");
		out.println("<label><b>Write Review Below:</b></label>");
		out.println("<textarea rows=\"4\" cols=\"50\" name =\"TextReview\" required>");
		out.println("</textarea>");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Gender:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" name=\"Gender\" required >");
		//out.println("</textarea>");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Occupation:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" name=\"Occupation\" required >");
		//out.println("</textarea>");
		out.println("</div>");
		out.println("<div class=\"form-group\">");
		out.println("<label><b>Your Age:</b></label>");
		out.println("<input type=\"text\" class=\"form-control\" name=\"Age\" required >");
		//out.println("</textarea>");
		out.println("</div>");

		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Card Holder Name\" value= \""+ Name +"\" name=\"ProductName\" >");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Card Holder Name\" value= "+ Price +" name=\"Price\" >");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Card Holder Name\" value= "+ username +" name=\"Username\" >");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Card Holder Name\" value= "+ Category +" name=\"Category\" >");


		//out.println("<img type=\"hidden\" src=\"Html\\images\\" + image +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
		out.println("<div>");
		out.println("<label><b>Rating</b></label>");
		out.println(" <select  name = \"usertype\">");
		out.println(" <option value= \"1\" >1</option>");
		out.println(" <option value = \"2\" >2</option>");
		out.println(" <option value = \"3\" >3</option>");
		out.println(" <option value = \"4\" >4</option>");
		out.println(" <option value = \"5\" >5</option>");
		out.println(" </select>");
		out.println("</div>");
		out.println("<div class=\"username1\">");
		out.println("<a class=\"lbutton\"  ><button type=\"submit\">Submit Review</button></a>");
	
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
	
	}

			
}