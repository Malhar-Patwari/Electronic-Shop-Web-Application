import java.sql.*;
import java.io.*; 
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class DataExploration
{
	
	Connection con = null;
	PreparedStatement ps= null;
	public DataExploration() {}
	
	public boolean getConnection()
	{
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			
			if(con!=null)
			{
				return true;
			}
			
			else 
			{
				return false;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		} 
	}

	public ArrayList<OrderP> checkStateSold()
	{
		ArrayList<OrderP> orders = new ArrayList<OrderP>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			ps = con.prepareStatement("select state,sum(price) as totalsale from orders group by state order by totalsale;  "); 
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				OrderP  order = new OrderP();
				order.setState(rs.getString("state"));
				//order.setPrice(rs.getInt("price"));
				order.setprice(rs.getInt("totalsale"));
				//order.setprice(rs.getInt("totalsale"));
				orders.add(order);
				//product.setPrice(rs.getInt("price"));
				//product.setQuantity(rs.getInt("quantity"));
				//products.add(product);
			}
			return orders;	
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		} 
		finally
		{
			try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

}