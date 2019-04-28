import java.sql.*;
import java.io.*; 
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class AjaxUtilities{
	// + "Cognome, Email, Password) VALUES (?, ?, ?, ?)";
	Connection con = null;
     
	PreparedStatement ps= null;
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

 
	public  HashMap<String, Product> getProduct() {
		//PreparedStatement ps = null;
		// String queryString = "INSERT INTO Utente(Nome, "
		// boolean st =false;

		HashMap<String, Product> hm = new HashMap<String, Product>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 	  
	    	ps = con.prepareStatement("select * from product"); 

		    // ps.setString(1, makers);
			//ps.setString(2, password);
		   
	    	ResultSet rs= ps.executeQuery();
		    while(rs.next())
		    {
				Product item = new Product();
				//item.setType(rs.getString("type"));
				item.setName(rs.getString("name"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
				item.setCategory(rs.getString("category"));
				item.setId(rs.getString("id"));
				item.setQuantity(rs.getInt("quantity"));
				item.setOnsale(rs.getString("onsale"));
				item.setRebate(rs.getString("rebate"));
				item.setCondition(rs.getString("ItemCondition"));
				item.setManufacturer(rs.getString("manufacturer"));
				hm.put(item.getName(),item);
			}
			return hm;	
			//st = rs.next();
		} 
		catch (Exception e) {
	    	e.printStackTrace();
			return null;
		} 
		finally {
	    	try { if (con != null) con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}
 
 
 
 
 
}

