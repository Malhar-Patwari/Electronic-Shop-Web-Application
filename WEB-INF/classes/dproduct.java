import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class dproduct extends HttpServlet {
	Product productup;
	PrintWriter out;
	HashMap<String,Product> productdelete = null;
	 
	//List<Cart> arraylist;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		  		  
		HttpSession session=request.getSession();  
 		out= response.getWriter();
		String product_id = request.getParameter("id");
		String product_category = request.getParameter("category");
		String product_name = request.getParameter("name");
		String product_itemcondition = request.getParameter("Itemcondition");
		String product_price = request.getParameter("Price");
		String product_imagepath = request.getParameter("Imagepath");
		//String product_manufacturer = request.getParameter("manufacturer");
		String product_quantity = request.getParameter("quantity");
		String product_onsale = request.getParameter("Onsale");
		String product_rebate = request.getParameter("rebate");
		Utilities utility = new Utilities(request,out);

		productup = new Product();
		productup.setId(product_id);
		productup.setName(product_name);
		productup.setCategory(product_category);
		productup.setCondition(product_itemcondition);
		productup.setPrice(Integer.parseInt(product_price));
		productup.setImage(product_imagepath);
		//productup.setImage(product_manufacturer);
		productup.setOnsale(product_onsale);
		productup.setRebate(product_rebate);
		productup.setQuantity(Integer.parseInt(product_quantity));
		
	
		if(session.getAttribute("ProductMap")!= null)
		{	

			productdelete = (HashMap<String,Product>)session.getAttribute("ProductMap");
			if(productdelete.containsKey(product_name))
			{
				productdelete.remove(product_name);
			}	// Remove product from hashmap
			session.setAttribute("ProductMap",productdelete);
		}
	
		utility.printHtml("HeaderAdd.html");
		//utility.printHtml("updateproduct.html");

		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		int hm2;
		//remove product from database after deleting  it from hashmap
		hm2 = mydata.deleteproduct(product_id,product_category);

		out.println("<section id=\"content\">");
		                    
		out.println("<h2 style=\"color:red\"> Your product is succesfully Deleted </h2>"); 
		//out.println("<h2 style=\"color:blue\"> Your order num # is "+ OrderID +"  </h2>");
		//pw.println(OrderID); 
		//out.println(product.getCategory()); 
		out.println("</section>"); 
		//utility.printHtml("Addproduct.html");
		
		utility.printHtml("Sidebar.html");

		utility.printHtml("Footer.html");
	}
	
}





