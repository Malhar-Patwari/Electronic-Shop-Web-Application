import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class AddBuy extends HttpServlet {

	PrintWriter out;
	List<Buy> arraylist;
	HttpSession session;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		session=request.getSession(false);
		//========Pass the parameter using session...and come back to this page once user logged in 
		//========from login page
		if(session == null)  
		{
			response.sendRedirect("./Login");
			return;
		}

		Users user = (Users) session.getAttribute("userDetails");
		System.out.println("===========" + user.getlastname() + "============");
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		out= response.getWriter();
		
		Utilities utility = new Utilities(request,out);
		utility.printHtml("HeaderLogout.html");
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");

		//======passs cart details in list object of cart class object
		String makers= request.getParameter("id");
		String name= request.getParameter("name");
		String price= request.getParameter("price");
		String image = request.getParameter("image");
		String discount = request.getParameter("discount");
		String warranty = request.getParameter("warranty");
		
		//HttpSession session=request.getSession(false);  
		//    String n=(String)session.getAttribute("uname");  
		//   HashMap<String, Product> hm3 =.getProducts();
		arraylist = new ArrayList<Buy>();
		addToBuy(name,price,image,discount,warranty,request);
		//out.println("hi");
		request.getRequestDispatcher("/ViewBuy").forward(request, response);
	}
	
	public void addToBuy(String name, String price, String image,String discount, String warranty, HttpServletRequest request){
		int id=0;
		HttpSession session = request.getSession();
		out.println("addcart method");
		//out.println(cart.getName());
		//out.println(cart.getPrice());
		//out.println(cart.getImage());
		//out.println(cart.getId());
		List<Buy> list = (ArrayList) session.getAttribute("buyitem");
		//out.println(list);
		if(list == null){
			id = id +1;
			// out.println(id);
			Buy buy = new Buy(name,price,image,id,discount,warranty);
			arraylist.add(buy);
			session.setAttribute("buyitem", arraylist);
			out.println("hi-if");
		}
		else{
			id = list.size() + 1;
			//out.println(id);
			Buy buy = new Buy(name,price,image,id,discount,warranty);
			arraylist = list;
			//out.println(arrayList);
			arraylist.add(buy);
			session.setAttribute("buyitem", arraylist);
			out.println("hi-else");
		}
	}
}