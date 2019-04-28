import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Cancelorder extends HttpServlet {

	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

		PrintWriter pw= response.getWriter();
		String username = request.getParameter("username");		
		String OrderId = request.getParameter("id");		
		Utilities utility = new Utilities(request,pw);
		utility.printHtml("HeaderLogout.html");
		
		//==================Handle the Back Session==================/
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
	
		
		pw.println("<section id=\"content\">");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); 
		c.add(Calendar.DATE, 14); 
		String deliverydate =   sdf.format(c.getTime());
		pw.println("<h2 style=\"color:blue\">Your delivery date is: </h2>");
		//pw.println(deliverydate);
		pw.println("<input  type = 'text' name = 'deliverydate' value = '"+deliverydate+"' readonly>");
		//pw.println("<h2 style=\"color:blue\">Your Current date is: </h2>");	
		Date date = new Date();
		String CurrentDate = sdf.format(date);
		//pw.println(CurrentDate);
		pw.println("<br>");
		
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		HttpSession session=request.getSession(false); 
		
		//String username = session.getAttribute("username");
		mydata.CancelOrder(OrderId);
			
		if(CurrentDate.compareTo(deliverydate) < 0)
		{
			pw.println("<h2 style=\"color:blue\">Your order is cancelled successfully.</h2>");
		}		
		else if(CurrentDate.compareTo(deliverydate) >0)
		{
			pw.println("Order Cancel is not possible");
		}
		else if(CurrentDate.compareTo(deliverydate) == 0)
		{
			pw.println("order Cancel is not possible");
		}
		else
		{
			pw.println("Malhar");
		}			
		//pw.println("<input  type = 'hidden' name = 'deliverydate' value = '"+deliverydate+"'>");
		pw.println("</section>");	
		utility.printHtml("Sidebar.html");	
		utility.printHtml("Footer.html");

	}
}
