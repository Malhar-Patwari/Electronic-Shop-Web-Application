import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;


public class productparser extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();

		String pid = request.getParameter("pid");

        String pname = request.getParameter("pname");

        String pcategory = request.getParameter("Category");

		String Itemcondition = request.getParameter("Itemcondition");

		int Price=Integer.parseInt(request.getParameter("Price"));
		String manufacturer = request.getParameter("manufacturer");
	
		String Imagepath=request.getParameter("Imagepath");
		String onsale = request.getParameter("Onsale");
		String rebate = request.getParameter("rebate");
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();

		mydata.insertProduct1(pname,pcategory,Itemcondition,Price,Imagepath,pid,manufacturer,rebate,onsale,quantity);

		request.getRequestDispatcher("/productadd").forward(request, response);
	}
	//.insertProduct1(name,category,itemcondition,price,image,id,manufacturer,rebate,quantity,onsale);
	
}

 
