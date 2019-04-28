import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import org.json.JSONObject;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;


public class StateSold_bar extends HttpServlet
{
	MySqlDataStoreUtilities ms = new MySqlDataStoreUtilities();
	DataExploration ms1 = new DataExploration();

	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_HEADER = "price,state";


	public void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException
	{
		PrintWriter out= response.getWriter();
		String username = request.getParameter("username");
		HttpSession session=request.getSession();  
		//Users user = (Users)session.getAttribute("username");
		Utilities utility = new Utilities(request,out);
		ArrayList<OrderP> orders;
		if(session.getAttribute("username")!= null )  
		{
			utility.printHtml("HeaderAdd.html");
			out.println("<div id=\"body\">");
			out.println("<section id=\"content\">");
			out.println("<article>");
			out.println("<div id=\"graph\">");
			out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
			out.println("<thead>");
			out.println("<tr class=\"headings\">");
			out.println("<th class=\"link\">&nbsp;</th>");
			out.println("<th class=\"link\">&nbsp;</th>   ");
			out.println("</tr>");
			out.println("</thead>");
			out.println("<tbody>");
			out.println("<tr>");
			out.println("</tr>");
			out.println("</tbody>");
			out.println("</table>");
			out.println("</article>");
			out.println("</section>");
			utility.printHtml("SideData.html");
			utility.printHtml("Footer.html");
			orders=ms1.checkStateSold();
			Gson gson=new Gson();
			String jsonString =gson.toJson(orders);
			System.out.println(jsonString + "\n\n\n");
			FileWriter fileWriter = null;
			try 
			{
	            JSONArray docs = new JSONArray(jsonString);
				String fileName = "C:\\tomcat-7.0.34\\apache-tomcat-7.0.34\\webapps\\Assignment\\stateslived.csv";
				fileWriter = new FileWriter(fileName);
	            fileWriter.append(FILE_HEADER.toString());
	            fileWriter.append(NEW_LINE_SEPARATOR);

				for(int i = 0; i < docs.length(); i++)
				{
					JSONObject line = docs.getJSONObject(i);
					fileWriter.append(String.valueOf(line.get("price")));
					fileWriter.append(COMMA_DELIMITER);
					fileWriter.append(line.getString("state"));
					fileWriter.append(NEW_LINE_SEPARATOR);			
				}
			}
			catch (JSONException e) 
			{
				e.printStackTrace();
			}
 			catch(IOException e)
			{
            // TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				try 
				{
					fileWriter.flush();
					fileWriter.close();
				} 
				catch (IOException e) 
				{
					System.out.println("Error while flushing/closing fileWriter !!!");
					e.printStackTrace();
				}
			}
	
			utility.printHtml("graph.html");
		}
		else
		{
			utility.printHtml("Header.html");
			utility.printHtml("product.html");
			utility.printHtml("Sidebar.html");
			utility.printHtml("Footer.html");
		}
	} 
}