import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.json.JSONObject;
import com.google.gson.Gson;

public class inventorybarController extends HttpServlet {
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
  
  	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();

		String username = request.getParameter("username");
		// Product product = new Product();
		HttpSession session=request.getSession();  
		ArrayList<Product> products;

		//Users user = (Users)session.getAttribute("user");
		String usertype = (String)session.getAttribute("usertype");
		//String usert = user.usertype;
		System.out.println(usertype);
		Utilities utility = new Utilities(request,out);

		if(usertype.equals("StoreManager")) 
		{
			products=ms.checkInventory();
			Gson gson=new Gson();
			String jsonString=gson.toJson(products);
			out.println(jsonString);
			//System.out.println("amsdhgas"+jsonString);
		}
	}
}
