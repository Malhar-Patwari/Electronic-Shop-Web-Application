import java.io.*; 
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class ViewReview extends HttpServlet {
	Utilities utility;
	PrintWriter out;
	List<Cart> arraylist;
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
    {
        out= response.getWriter();
      
        String name =  request.getParameter("name") ;

        MongoDbDataStoreUtility mg = new MongoDbDataStoreUtility();
        //	mg.insertReview(rating,name,Textreview,Uname);
        Utilities utility = new Utilities(request,out);
        utility.printHtml("HeaderLogout.html");

        HashMap<String, ArrayList<ReviewP>> reviewHashmap =mg.selectReview();


    	if(reviewHashmap.containsKey(name))
    	{
            ArrayList<ReviewP> reviews = reviewHashmap.get(name);
            out.println("<section id=\"content\">");

            out.println("<h1>Customer Reviews</h1>");


            out.println("<table cellspacing=\"0\" class=\"shopping-cart\">");
            out.println("<thead>");
            out.println("<tr class=\"headings\">");

            out.println("<th class=\"\">User name</td>");
            out.println("<th class=\"\">Product name</td>");
            out.println("<th class=\"\">Category</td>");
            out.println("<th class=\"\">Rating</td>");
            out.println("<th class=\"\">Review</td>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            for(ReviewP pojo : reviews)
            {
            	System.out.println("Counter");
                out.println("<tr>"); 
                out.println("<td class=\"productName\">");
                out.println(pojo.getusername());
                out.println("</td>");
                out.println("<td class=\"productName\">");
                out.println(pojo.getproductName());
                out.println("</td>");
                out.println("<td class=\"productName\">");
                out.println(pojo.getcategory());
                out.println("</td>");
            	out.println("<td class=\"productName\">");
                out.println(pojo.getrating());
                out.println("</td>");
            	out.println("<td class=\"productName\">");
                out.println(pojo.getreview());
                out.println("</td>");
                
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");
            out.println("</section>");
        }

    	utility.printHtml("Sidebar.html");
    	utility.printHtml("Footer.html");	

    }
}