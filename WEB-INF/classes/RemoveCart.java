import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class RemoveCart extends HttpServlet {
	
	PrintWriter out;
	List<Cart> arraylist;
	HttpSession session;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		session = request.getSession();
		//========Pass the parameter using session...and come back to this page once user logged in 
		//========from login page
		if(session == null)  
		{
			response.sendRedirect("./Login");
			return;
		} 
		
		out= response.getWriter();
		Saxpaser handler = new Saxpaser("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\WEB-INF\\classes\\ProductCatalog.xml");
		String makers= request.getParameter("id");
		String name= request.getParameter("name");
		String price= request.getParameter("price");
		String image = request.getParameter("image");
		String discount = request.getParameter("discount");
		String warranty = request.getParameter("warranty");
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		
		arraylist = new ArrayList<Cart>();
		RemovetoCart(makers,name,price,image,discount,warranty,request);
		//out.println("hi");
		request.getRequestDispatcher("/ViewCart").forward(request, response);
	}
	
	public void RemovetoCart(String makers, String name, String price, String image, String discount, String warranty ,HttpServletRequest request)
	{
		int id=0;
		int removeid = 0;
		int index = 0;
		boolean flag;
		out.println("Removecart method");
		List<Cart> list = (ArrayList) session.getAttribute("cartitem");
		try
		{
			if(list == null){
			}
			else
			{
				removeid = 0;
				flag  = false;
				for (Cart object: list) 
				{	
					removeid ++;
					System.out.println(object.getName());
					System.out.println(name);
					System.out.println(object.getPrice());
					System.out.println(price);
					if(object.getName().equals(name) && object.getPrice().equals(price))
					{
						flag = true;
						index = removeid;
					}
					else{
						System.out.println("Something wrong!");
					}
					
				}
				if(flag)
				{
					list.remove(index-1);
				}
				
				id = list.size() - 1;
				arraylist = list;
				session.setAttribute("cartitem", arraylist);
				out.println("hi-else");
			}
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
	}
}