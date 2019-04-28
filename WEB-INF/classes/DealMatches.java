import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class DealMatches extends HttpServlet {
	
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
	HashMap<String,Product> selectproduct = null;
	HashMap<String,Product> products = null;
	ArrayList<String> tweets;
	
	public ArrayList<String> getTweets()
	{
		return tweets;
	}
	
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		out= response.getWriter();
		Utilities utility = new Utilities(request,out);
	}
  	  	
	public HashMap<String,Product> getProductData()
	{
		
		MySqlDataStoreUtilities mydata = new MySqlDataStoreUtilities();
		products = mydata.getProductData();
	
		String TOMCAT = System.getenv("CATALINA_HOME");
		selectproduct = new HashMap<String,Product>();
		tweets = new ArrayList<String>();

		try
		{
			String line = null;
			for(Map.Entry<String,Product> entry : products.entrySet())
			{
				if(selectproduct.size() < 2 && !(selectproduct.containsKey(entry.getKey())))
				{
					BufferedReader br = new BufferedReader(new FileReader(new File(TOMCAT + "\\webapps\\Assignment\\Html\\DealMatches.txt")));
					line = br.readLine();

					if(line ==null)
					{
					  return null;
					}
					else
					{
						do
						{
							if(line.contains(entry.getKey()))
							{
								tweets.add(line);
								selectproduct.put(entry.getKey(),entry.getValue());
								break;
							}								
						} while((line = br.readLine()) != null);
					}
				}				
			}			
		}
		
		catch(Exception e)
		{
				e.printStackTrace();
				return null;
		}	
		
		return selectproduct;
	}
}