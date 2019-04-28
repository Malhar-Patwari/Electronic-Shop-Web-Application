import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ShowReview extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;

  	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
  	{
		out= response.getWriter();
		Random rand = new Random();
		int  n = rand.nextInt(500) + 1;

		String ProductModelName =  request.getParameter("ProductName");
		System.out.println(ProductModelName);
		String ProductCategory = request.getParameter("Category");
		String ProductPrice  =  request.getParameter("Price");
		
		String RetailerName = "SmartPortables";
		String RetailerZip = "60616";
		String RetailerCity = "Chicago";
		String RetailerState = "IL";
		String ProductOnSale = "Yes";
		String ManufacturerName = request.getParameter("ProductName");
		String ManufacturerRebate = "Yes";
		String UserId = "190" + n ;
		String UserAge = request.getParameter("Age");
		String UserGender = request.getParameter("Gender");
		String UserOccupation = request.getParameter("Occupation");
	
	
		String ReviewRating = request.getParameter("usertype");
		java.sql.Date ReviewDate =  new java.sql.Date(System.currentTimeMillis());
		String ReviewText = request.getParameter("TextReview");
		
		
		String Uname =  request.getParameter("Username");
			
		MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
		mg.insertReview(Uname,ProductModelName,ProductCategory,ProductPrice,RetailerName,RetailerZip,RetailerCity,RetailerState,ProductOnSale,ManufacturerName,ManufacturerRebate,UserId,UserAge,UserGender,UserOccupation,ReviewRating,ReviewDate,ReviewText);
		request.getRequestDispatcher("/ViewReview?name="+ProductModelName).forward(request, response);
	}
}