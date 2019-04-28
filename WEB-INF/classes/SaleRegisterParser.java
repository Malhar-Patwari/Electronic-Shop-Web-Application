import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class SaleRegisterParser extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
	
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String usertype = request.getParameter("usertype");
		
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);

		HashMap<String,Users>hm=new HashMap<String,Users>();

		try
		{
			FileInputStream fileInputStream = new FileInputStream(new File("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\UserDetails.txt")); 
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			//out.println(username);
			hm= (HashMap)objectInputStream.readObject();
			//out.println("hm ");
		}
		catch(Exception ex)
		{
			ex.getMessage();
		}
		if(hm.containsKey(username))
		{
			
			Users user=(Users)hm.get(username);			
			if(usertype.equals(user.getusertype()))
			{
				
				Utilities utility = new Utilities(request,out);
				utility.printHtml("Header.html");

				out.println("<section id=\"content\">");
		                    
				out.println("<h2 style=\"color:red\">User Already Exist! </h2>"); 
				out.println("<h2 style=\"color:blue\"> Click Here for Register : <a href=\"Registration\" color=\"red\">Register</a> </h2>"); 
		              
		        out.println("</section>");

				utility.printHtml("Sidebar.html");
			
				utility.printHtml("Footer.html");
			}
			else
			{
				Utilities utility = new Utilities(request,out);
				utility.printHtml("Header.html");
				out.println("<section id=\"content\">");		                    
				out.println("<h2 style=\"color:red\">You can not register for differnt usertype  with same username </h2>"); 
				out.println("<h2 style=\"color:blue\"> Click Here for Register : <a href=\"Registration\" color=\"red\">Register</a> </h2>"); 
				out.println("</section>");

				utility.printHtml("Sidebar.html");
				
				utility.printHtml("Footer.html");												
			}	

		}

		else		
		{
				
			Users user = new Users(username,password,firstname,lastname,usertype); 
			hm.put(username, user);

			FileOutputStream fileOutputStream = new FileOutputStream("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\UserDetails.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
			objectOutputStream.writeObject(hm);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();	
						
			Utilities utility = new Utilities(request,out);

			utility.printHtml("Header.html");
			out.println("<section id=\"content\">");
	                    
			out.println("<h2 style=\"color:red\"> Registration Successful </h2>"); 
			out.println("<h2 style=\"color:blue\"> Click Here to go Login Page : <a href=\"Login\" color=\"red\">Login</a> </h2>"); 	
	        out.println("</section>");

			utility.printHtml("Sidebar.html");
		
			utility.printHtml("Footer.html");
		}
	
	}
 
}