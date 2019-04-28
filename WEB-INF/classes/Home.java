import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class Home extends HttpServlet {
	
	MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
	PrintWriter pw=null;
	HashMap<String,Product> productMap = null;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter pw= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session = request.getSession(false); 
	
		mydata.truncateTable();
		init();
		
		Utilities utility = new Utilities(request,pw);
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		
		//===============Normal Session handle===============
		if(session != null)  
		{
			//Users user = (Users) session.getAttribute("userDetails");
			//System.out.println("===========" + user.getlastname() + "============");
			//pw.println("Hello "+  n);
			
			String usertype = (String)session.getAttribute("usertype");
			session.setAttribute("ProductMap",productMap);
			System.out.println("usertype is:"+usertype);
			if(usertype.equals("StoreManager"))
			{
				//pw.println("hi");
				utility.printHtml("HeaderAdd.html");
				//utility.printHtml("product.html");
				//utility.printHtml("Sidebar.html");

				//utility.printHtml("Footer.html");
			}
			else
			{
				String n=(String)session.getAttribute("uname");
				utility.printHtml("HeaderLogout.html");						
			}	

			//Change
			pw.println("<section id = \"content\">");
			pw.println("<h2 align=\"center\" style=\"color:red;\">Welcome to SmartPortables</h2>");


			pw.println("<article style=\"background-color:lightgrey\">");

			pw.println("<h2 style=\"color:red;\">We beat our Competitor in all aspects</h2>");
			pw.println("<h2 style=\"color:red;\">Price Match is Guaranteed!!!</h2>");

			DealMatches dl = new DealMatches();
			HashMap<String, Product> selectproduct = dl.getProductData();
			ArrayList<String> tweets = dl.getTweets();
			Collections.reverse(tweets);

			if(tweets.isEmpty())
			{
				pw.println("<h2>No Deals Found in Smartportable!!</h2>");
				
			}
			else
			{
				for( String tw : tweets)
				{
					pw.println("<h3 style=\"color:blue\">"+tw+"</h2>");
				}
			}

			pw.println("</article>");
			pw.println("<h2 align=\"center\">Products of Smartportables</h2>");
			pw.println("<article style=\"background-color:lightgrey\">");
			pw.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
			pw.println("<thead>");
			pw.println("<tr class=\"headings\">");
			pw.println("<th class=\"link\">&nbsp;</th>");
			
			pw.println("</tr>");
			pw.println("</thead>");
			
			if(selectproduct == null || selectproduct.size() == 0)
			{	
				pw.println("<h2>No products found  in Smartportable!!</h2>");	
			}
			else
			{
				for(Map.Entry<String,Product> entry : selectproduct.entrySet())
					
				{
					Product product = (Product)entry.getValue();
					
					pw.println("<tbody>");
					// Product product=(Product)entry.getValue();
	                pw.println("<a  href=\"#\">");
					pw.println("<img src=\"Html\\images\\" + product.getImage() +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
	                pw.println("</a>");
	                         
					pw.println("<ul>");
					pw.println("<li class=\"desc\">Name : " + product.getName() +"</li>");
	                pw.println("<li>Price: $" + product.getPrice() + "</li>");
					pw.println("<li>Quantity  " + product.getQuantity() + "</li>");
								 
					pw.println("<li><a href=\"Review?name="+product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"\">WriteReview</a></li>" );
	                             
	                pw.println("<li><a href=\"ViewReview?name="+product.getName()+"\" class=\"btnreview\">View Review</a></li>");
	                pw.println("<li><a href=\"ViewItem?id="+product.getId()+"&&category=" +product.getCategory()+"&&qty=" +product.getQuantity()+"\" class=\"btnreview\">View Item</a></li>");
					//out.println("<li><a href=\"AddCart\" class=\"btnreview\">Add to Cart</a></li>");
					pw.println("</ul>");

					pw.println("</tbody>");
				}
			}


			pw.println("</table>");
			pw.println("</article>");

			pw.println("</section >");

			utility.printHtml("Sidebar.html");

			utility.printHtml("Footer.html");
							
		}
		else
		{			
			utility.printHtml("Header.html");
			   
			pw.println("<section id = \"content\">");
			pw.println("<h2 align=\"center\" style=\"color:red;\">Welcome to SmartPortables</h2>");
			pw.println("<article style=\"background-color:lightgrey\">");
			pw.println("<h2 style=\"color:red;\">We beat our Competitor in all aspects</h2>");
			pw.println("<h2 style=\"color:red;\">Price Match is Guaranteed!!!</h2>");

			DealMatches dl = new DealMatches();
			HashMap<String, Product> selectproduct = dl.getProductData();
			ArrayList<String> tweets = dl.getTweets();
			Collections.reverse(tweets);
			
			if(tweets.isEmpty())
			{
				pw.println("<h2>No Deals Found in Smartportable!!</h2>");
				
			}
			else
			{
				for( String tw : tweets)
				{
					pw.println("<h3 style=\"color:blue\">"+tw+"</h2>");
				}
			}
			pw.println("</article>");
			pw.println("<h2 align=\"center\">Products of Smartportables</h2>");
			pw.println("<article style=\"background-color:lightgrey\">");
			pw.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
			pw.println("<thead>");
			pw.println("<tr class=\"headings\">");
			pw.println("<th class=\"link\">&nbsp;</th>");			
			pw.println("</tr>");
			pw.println("</thead>");

			if(selectproduct == null || selectproduct.size() == 0)
			{
				
				pw.println("<h2>No products found  in Smartportable!!</h2>");
				
			}
			else
			{
				for(Map.Entry<String,Product> entry : selectproduct.entrySet())					
				{
					Product product = (Product)entry.getValue();
					pw.println("<tbody>");
					// Product product=(Product)entry.getValue();						 
	                pw.println("<a  href=\"#\">");
					pw.println("<img src=\"Html\\images\\" + product.getImage() +"\" alt=\"Trolltunga Norway\" width=\"300\" height=\"200\">");
	                pw.println("</a>");
	                         
					pw.println("<ul>");
					pw.println("<li class=\"desc\">Name : " + product.getName() +"</li>");
	                pw.println("<li>Price: $" + product.getPrice() + "</li>");
					pw.println("<li>Quantity  " + product.getQuantity() + "</li>");
								 
					pw.println("<li><a href=\"Review?name="+product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"\">WriteReview</a></li>" );	                           
	                pw.println("<li><a href=\"ViewReview?name="+product.getName()+"\" class=\"btnreview\">View Review</a></li>");
	                pw.println("<li><a href=\"ViewItem?id="+product.getId()+"&&category=" +product.getCategory()+"&&qty=" +product.getQuantity()+"\" class=\"btnreview\">View Item</a></li>");
					//out.println("<li><a href=\"AddCart\" class=\"btnreview\">Add to Cart</a></li>");
					pw.println("</ul>");
	       					
					pw.println("</tbody>");
				}
			}


			pw.println("</table>");
			pw.println("</article>");

			pw.println("</section >");
			utility.printHtml("Sidebar.html");

			utility.printHtml("Footer.html");
		}
	}	
	
	
	public void init()
	{
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");
		HashMap<String, Product> hm2 = handler.getProducts();
		productMap = hm2;
	  	for(Map.Entry<String,Product> entry : hm2.entrySet())
		   {
				Product product=(Product)entry.getValue();
				mydata.insertProduct(product.getName(),product.getCategory(),product.getCondition(),product.getPrice(),product.getImage(),product.getId(),product.getManufacturer(), product.getQuantity(), product.getRebate(), product.getOnsale());
				// mydata.insertProduct(product.getName(),product.getCategory(),product.getCondition(),product.getPrice(),product.getImage(),product.getId(), product.getQuantity(), product.getRebate(), product.getOnsale());
				// pw.println(product.getName());
		   }
	}
}