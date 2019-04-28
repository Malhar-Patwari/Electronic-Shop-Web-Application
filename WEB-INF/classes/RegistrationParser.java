import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.sql.*;

public class RegistrationParser extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String usertype = request.getParameter("usertype");
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		
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
		if(mydata.checkuser(username,password))

		{
			request.setAttribute("Er","Username Already exists");
			request.getRequestDispatcher("/Registration").forward(request, response);
			
		}
		else
		{
			Users user = new Users(firstname,lastname,username,password,usertype); 
			hm.put(username, user);

			FileOutputStream fileOutputStream = new FileOutputStream("C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\UserDetails.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream); 
			objectOutputStream.writeObject(hm);
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.close();	
		
			mydata.insert(firstname,lastname,username,password,usertype);
			//insertuser(username,password,firstname,lastname);
			// out.println(" username and password added to xml file" );
			request.getRequestDispatcher("/Home").forward(request, response);
		}	
				
	}
	
}