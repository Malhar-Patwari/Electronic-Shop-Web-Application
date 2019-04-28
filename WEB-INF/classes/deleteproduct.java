import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class deleteproduct extends HttpServlet {
	Product product;
	PrintWriter out;
	//List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
	out= response.getWriter();
	String product_id = request.getParameter("pid");
	String product_category = request.getParameter("category");
	Utilities utility = new Utilities(request,out);
		
	utility.printHtml("HeaderAdd.html");
	//utility.printHtml("updateproduct.html");

	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
	HashMap<String, Product> hm2;

	hm2 = mydata.selectproduct(product_id,product_category);
	product = new Product();
	System.out.println(product.getName());

	for(Map.Entry<String,Product> entry : hm2.entrySet())
	{
		Product product=(Product)entry.getValue();
		
		//	System.out.println(product.getName());
		//	System.out.println(product.getCategory());
			
	
		//out.println("else");
		out.println("<section id=\"content\">");
		out.println("<h2 align=\"center\" margin-top=\"60px\">Add product details below</h2>");
		out.println("<form action =\"dproduct\"  method=\"get\">");
		out.println("<div class=\"container username\">");
		out.println("<div class=\"username\">");
		out.println("<label><b>Product id</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Itemcondition\" value= '"+product.getId() +"' name=\"id\" required>");
		out.println(product.getId());
		
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Name</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Itemcondition\" value= '"+product.getName() +"' name=\"name\" required>");
		out.println(product.getName());
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Product Category</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Itemcondition\" value= '"+product.getCategory() +"' name=\"category\" required>");
		out.println(product.getCategory());
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Itemcondition</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Itemcondition\" value= '"+product.getCondition() +"' name=\"Itemcondition\" required>");
		out.println(product.getCondition());
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Price$$ for 1 Quantity</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Price\" name=\"Price\" value= '"+product.getPrice() +"' required>");
		out.println(product.getPrice());
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Product Image Name</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter image name only\" name=\"Imagepath\" value= '"+product.getImage() +"' required>");
		out.println(product.getImage());
		out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Product Quantity</b></label>");
		out.println("<input type=\"hidden\" class=\"uname\" placeholder=\"Enter Quantity\" name=\"quantity\" value= '"+product.getQuantity() +"' required>");
		out.println(product.getQuantity());
		out.println("</div>");
		//out.println("</div>");
		out.println("<div class=\"username\">");
		out.println("<label><b>Product Onsale</b></label>");
		out.println("<select  name = \"Onsale\">");
		//out.println("<option value = '\"product.getOnsale()\"' >"+product.getOnsale()+"</option>");
		out.println("<option value=\"Yes\"  >Yes</option>");
		//out.println("<option value= \"\" >Yes</option>");
		out.println("<option value = \"No\"  >No</option>");
		out.println(" </select>");
		out.println("</div>");
		out.println("<div  class=\"username\">");
		out.println("<label><b>Product Rebate</b></label>");
		out.println("<select  name = \"rebate\">");
	//	out.println("<option value = '\"product.getRebate()\"' >"+product.getRebate()+"</option>");
		out.println("<option value = \"Yes\" >Yes</option>");
		//out.println("<option value = '\"product.getOnsale()\"' selected >Yes</option>");
		//out.println("<option value = '\"product.getOnsale()\"' selected ></option>");
		out.println("<option value = \"No\" >No</option>");
		out.println("</select>");
		out.println("</div>");
		out.println("<div class=\"username1\">");			
		out.println("<button class=\"lbutton\" type=\"submit\" value=\"login\">Delete Product</button>");	
		
		out.println("</div>");
		out.println("</div>");
		out.println("</form>");
				
		out.println("</section>");
			
		 
	}
	//utility.printHtml("Addproduct.html");

	utility.printHtml("Sidebar.html");
	utility.printHtml("Footer.html");
	
  	}
}