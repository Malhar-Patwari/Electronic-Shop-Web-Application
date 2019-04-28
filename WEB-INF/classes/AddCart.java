import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class AddCart extends HttpServlet {
	
	PrintWriter out;
	List<Cart> arraylist;
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
 		
 		out= response.getWriter();
		String username = request.getParameter("username");
		String productid= request.getParameter("id");
		String name= request.getParameter("name");
		String price= request.getParameter("price");
		String image = request.getParameter("image");
		String discount = request.getParameter("discount");
		String warranty = request.getParameter("warranty");
		String zip = request.getParameter("zip");
		arraylist = new ArrayList<Cart>();

		addToCart(name,productid,price,image,discount,warranty,request);
		//out.println("hi");
		request.getRequestDispatcher("/ViewCart").forward(request, response);

		
	}

	public void addToCart(String name,String productid ,String price, String image,String discount,String warranty,HttpServletRequest request){
       
        int id=0;
        HttpSession session = request.getSession();
		out.println("addcart method");       
        
        //out.println(cart.getName());
        //out.println(cart.getPrice());
        //out.println(cart.getImage());
        //out.println(cart.getId());
        List<Cart> list = (ArrayList) session.getAttribute("cartitem");
        //out.println(list);
		MySqlDataStoreUtilities mySqlDataStoreUtilities = new MySqlDataStoreUtilities();
        
        if(list == null)
        {
            id = id +1;
           // out.println(id);
            Cart cart = new Cart(name,productid,price,image,id,discount,warranty);
            arraylist.add(cart);
            session.setAttribute("cartitem", arraylist);
			out.println("hi-if");

        }
        
        else
        {
            id = list.size() + 1;
            //out.println(id);
            Cart cart = new Cart(name,productid,price,image,id,discount,warranty);
            arraylist = list;
            //out.println(arrayList);
            arraylist.add(cart);
            session.setAttribute("cartitem", arraylist);
			out.println("hi-else");
        }
		
		if(mySqlDataStoreUtilities.getConnection())
		{			
			mySqlDataStoreUtilities.insertcart(name,productid,price,image,discount,warranty);
		}

    }
}

