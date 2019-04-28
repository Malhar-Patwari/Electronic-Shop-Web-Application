import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.sql.*;

public class LoginParser extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{}

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
		
		PrintWriter pw  = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		
		HttpSession session=request.getSession();  
		session.setAttribute("uname",username);   
		HashMap<String,Users> hm = new HashMap<String,Users>();
			
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		try
		{
			//========Change the path to relative path==============//
			FileInputStream fileInputStream = new FileInputStream(new File("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\UserDetails.txt")); 
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			hm = (HashMap<String,Users>)objectInputStream.readObject();
		} 
		catch(Exception ex){
			ex.getMessage();
		}
		
		if(mydata.checkuser(username,password))
		{
			//Users user=(Users)hm.get(username);
			//System.out.println("all hashmap keys : "+hm.keySet());
			//System.out.println("User is :" + user);
			session.setAttribute("username",username);
			
			//System.out.println("============User found. User Type is "+user.getusertype());
				
			if(mydata.checkusertypeonly(usertype))
			{						
				Mydata mydata1 = new Mydata(usertype);
				System.out.println("====================usertype "+usertype.equals(mydata1.getusertype()));
				//System.out.println("User is :" + user);
				if(usertype.equals("SalesMan"))
				{
					// System.out.println("====================SalesMan is here==============");
					session.setAttribute("usertype",usertype);

					Utilities utility = new Utilities(request,pw);
					utility.printHtml("HeaderLogout.html");
					response.sendRedirect("./SaleRegister");
					//System.out.println("after send redirect");
				}
				else if(usertype.equals("StoreManager"))
				{
					//System.out.println("====================StoreManager is here==============");
					session.setAttribute("usertype",usertype);
					Utilities utility = new Utilities(request,pw);
					utility.printHtml("HeaderLogout.html");
					response.sendRedirect("./Home");
					

				}
				else
				{
					//System.out.println("====================Customer is here==============");
					session.setAttribute("usertype",usertype);
					Utilities utility = new Utilities(request,pw);
					utility.printHtml("HeaderLogout.html");
					response.sendRedirect("./Home");
					//System.out.println("after send redirect");
					 
				}	

			}			
		}
		else
		{
			Utilities utility = new Utilities(request,pw);
			utility.printHtml("Header.html");
			//pw.println("Invalid username and password");
			// pw.println("<section id=\"content\">");
			pw.println("<section id=\"content\">");
			pw.println("<h2 style=\"color:red\"> Login Failed. Please try again. </h2>"); 
			pw.println("<h2 style=\"color:blue\"> Click Here for Login : <a href=\"Login\" color=\"red\">Login</a> </h2>"); 
			pw.println("</section>");
			//<h2 align="center" margin-top="60px">Login Form</h2>
			//pw.println("</div>");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	}
}
