/* This code is used to implement carousel feature in Website. Carousels are used to implement slide show feature. This  code is used to display 
all the accessories related to a particular product. This java code is getting called from cart.java. The product which is added to cart, all the 
accessories realated to product will get displayed in the carousel.*/
  

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;	
			
			
public class Carousel{
			
	public String  carouselfeature(Utilities utility,HttpSession session){
			
		ProductRecommenderUtility prodRecUtility = new ProductRecommenderUtility();
		
		HashMap<String, Console> hm = new HashMap<String, Console>();
		StringBuilder sb = new StringBuilder();
		String myCarousel = null;		
		String name = null;
		String CategoryName = null;		
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
		prodRecmMap = prodRecUtility.readOutputFile();		
		int l =0;

		for(String user: prodRecmMap.keySet())
		{
			String x = utility.username(session);
			if(user.equals(x))
			{
				String products = prodRecmMap.get(user);
				products=products.replace("[","");
				products=products.replace("]","");
				products=products.replace("\"", " ");
				ArrayList<String> productsList = new ArrayList<String>(Arrays.asList(products.split(",")));

		        myCarousel = "myCarousel"+l;
					
				sb.append("<div class='post'><h2 class='title meta'>");
				sb.append("<a style='font-size: 24px;'>"+""+" Recommended Products</a>");
				
				sb.append("</h2>");

				sb.append("<div class='container'>");
				/* Carousels require the use of an id (in this case id="myCarousel") for carousel controls to function properly.
				The .slide class adds a CSS transition and animation effect, which makes the items slide when showing a new item.
				Omit this class if you do not want this effect. 
				The data-ride="carousel" attribute tells Bootstrap to begin animating the carousel immediately when the page loads. 
		 
				*/
				sb.append("<div class='carousel slide' id='"+myCarousel+"' data-ride='carousel' style='width:600px'>");
				
				/*The slides are specified in a <div> with class .carousel-inner.
				The content of each slide is defined in a <div> with class .item. This can be text or images.
				The .active class needs to be added to one of the slides. Otherwise, the carousel will not be visible.
				*/
				sb.append("<div class='carousel-inner'>");
						
				int k = 0;
				System.out.println("arraylist:"+productsList);
				
				for(String prod : productsList)
				{
					prod= prod.replace("'", "");
					Product prodObj = new Product();
					System.out.println(prod.trim());
					prodObj = ProductRecommenderUtility.getProduct(prod.trim());
					
					if (k==0 )
					{						
						sb.append("<div class='item active'><div class='col-md-6' >");
					}
					else
					{
						sb.append("<div class='item'><div class='col-md-6' >");
					}

					sb.append("<div id='shop_item'>");
					sb.append("<h3 align='center'>"+prodObj.getName()+"</h3>");
					sb.append("<h4 align='center'>"+"Price:"+prodObj.getPrice()+"$"+"</h4><ul>");
					sb.append("<li id='item'><img src='Html\\images\\"+prodObj.getImage()+"' style='width:400px;height:300px;' align='center' alt='' /></li>");
					sb.append("<a href=\"AddCart?id="+prodObj.getId()+"&&name="+prodObj.getName()+"&&price="+prodObj.getPrice()+"&&image="+prodObj.getImage()+"&&discount="+prodObj.getDiscount()+"&&warranty="+prodObj.getWarranty()+ "\" class=\"btn btn-success\" role=\"button\">Buy Now</a>");
						//"      <a href=\"AddCart?id="+product.getId()+"&&name=" +product.getName()+"&&price=" +product.getPrice()+"&&image=" +product.getImage()+"&&discount=" +product.getDiscount()+"&&warranty=" +product.getWarranty()+ "\" class=\"btn btn-success\" role=\"button\">Buy Now</a></p>"	
					sb.append("</ul></div></div>");
					sb.append("</div>");				
					k++;					
				}
				
			
				sb.append("</div>");
				/*		The "Left and right controls" part:
					This code adds "left" and "right" buttons that allows the user to go back and forth between the slides manually.
				The data-slide attribute accepts the keywords "prev" or "next", which alters the slide position relative to its current position.
				*/
				sb.append("<a class='left carousel-control' href='#"+myCarousel+"' data-slide='prev' style = 'width : 0% ;background-color:#D7e4ef; opacity :1'>"+
						"<span class='glyphicon glyphicon-chevron-left' style = 'color :red'></span>"+
						"<span class='sr-only'>Previous</span>"+
						"</a>");
				sb.append("<a class='right carousel-control' href='#"+myCarousel+"' data-slide='next' style = 'width : 0% ;background-color:#D7e4ef; opacity :1'>"+
						"<span class='glyphicon glyphicon-chevron-right' style = 'color :red'></span>"+

							"<span class='sr-only'>Next</span>"+
							"</a>");

			
				sb.append("</div>");
			
				sb.append("</div></div>");
				//sb.append("</div>");
				l++;			
			}
		}
			return sb.toString();
	}
}
	