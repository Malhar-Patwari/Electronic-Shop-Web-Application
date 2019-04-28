import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class updateproduct extends HttpServlet {
	Product productup;
	PrintWriter out;
	HashMap<String,Product> productupdate = null;
	 	
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
  	{
		HttpSession session=request.getSession();  
		out= response.getWriter();
		String product_id = request.getParameter("id");
		String product_category = request.getParameter("category");
		String product_name = request.getParameter("name");
		String product_itemcondition = request.getParameter("Itemcondition");
		String product_price = request.getParameter("Price");
		String product_manufacturer = request.getParameter("manufacturer");
		String product_imagepath = request.getParameter("Imagepath");
		String product_quantity = request.getParameter("quantity");
		String product_onsale = request.getParameter("Onsale");
		String product_rebate = request.getParameter("rebate");


		Utilities utility = new Utilities(request,out);

		productup= new Product();

		productup.setId(product_id);
		productup.setName(product_name);
		productup.setCategory(product_category);
		productup.setCondition(product_itemcondition);
		productup.setPrice(Integer.parseInt(product_price));
		productup.setImage(product_imagepath);
		//productup.setManufacturer(product_manufacturer);
		productup.setOnsale(product_onsale);
		productup.setRebate(product_rebate);
		productup.setQuantity(Integer.parseInt(product_quantity));



		if(session.getAttribute("ProductMap")!= null)
		{	
			productupdate = (HashMap<String,Product>)session.getAttribute("ProductMap");
			productupdate.put(product_name,productup); // update product in hashmap
			session.setAttribute("ProductMap",productupdate);
		}

		utility.printHtml("HeaderAdd.html");
		//utility.printHtml("updateproduct.html");

		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		int hm2;
		//update product in database after updating it in hashmap
		hm2 = mydata.updateproduct(product_id,product_category,product_name,product_itemcondition,product_price,product_imagepath,product_quantity,product_onsale,product_rebate);

		out.println("<section id=\"content\">");
	                
		out.println("<h2 style=\"color:red\"> Your product is succesfully updated </h2>"); 
		out.println("</section>"); 
			 
		utility.printHtml("Sidebar.html");

		utility.printHtml("Footer.html");
  	}
}







