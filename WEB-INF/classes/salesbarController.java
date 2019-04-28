import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.json.JSONObject;
import com.google.gson.Gson;


public class salesbarController extends HttpServlet {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out= response.getWriter();

		HttpSession session=request.getSession();  
		ArrayList<Product> products;
		String username = request.getParameter("username");
		//Users user = (Users)session.getAttribute("user");
		//String usert = user.usertype;

		Utilities utility = new Utilities(request,out);

		if(session.getAttribute("usertype").equals("StoreManager"))  
		{
			
			products=ms.checkSales();

			Gson gson=new Gson();
		 	String jsonString=gson.toJson(products);
			out.println(jsonString);
			//System.out.println(jsonString);
		}

	}
}
