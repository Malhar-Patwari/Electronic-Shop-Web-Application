import java.io.*;
import java.sql.*;
import java.io.IOException;
import java.util.*;

public class ProductRecommenderUtility{
	
	static Connection conn = null;
    static String message;
	static PreparedStatement ps= null;
	
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql");							
			message="Successfull";
			return conn;
		}
		catch(SQLException e)
		{
			 message="unsuccessful";
		     return conn;
		}
		catch(Exception e)
		{
			 message="unsuccessful";
		     return conn;
		}
	}

	public HashMap<String,String> readOutputFile(){

		String TOMCAT_HOME = System.getProperty("catalina.home");
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
		HashMap<String,String> prodRecmMap = new HashMap<String,String>();
		try 
		{
            br = new BufferedReader(new FileReader(new File(TOMCAT_HOME+"\\webapps\\Assignment\\output.csv")));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] prod_recm = line.split(cvsSplitBy,2);
				prodRecmMap.put(prod_recm[0],prod_recm[1]);
            }			
		} 
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            if (br != null) 
            {
                try 
                {
                    br.close();
                }
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
		}
		
		return prodRecmMap;
	}
	
	public static Product getProduct(String product){
		
		Product prodObj = new Product();
		System.out.println("fskjfhsa");
		
		try 
		{
			Connection conn = getConnection();
			
			ps = conn.prepareStatement("SELECT * FROM exampledatabase.product where name= ?"); 
			ps.setString(1, product);
			
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next())
			{	
				System.out.println("jdgajsfgj"+rs.getString("name"));
				//System.out.println("fskjfhsa"+rs.getString("name"));
				prodObj = new Product(rs.getString("name"), rs.getString("category"),rs.getString("itemcondition"),rs.getInt("price"),rs.getString("image"),rs.getString("id"),rs.getString("manufacturer"), rs.getString("rebate"), rs.getInt("quantity"), rs.getString("onsale"));
				//prodObj = new Product(rs.getName(), rs.getCategory(),rs.getCondition(),rs.getPrice(),rs.getImage(),rs.getId(),rs.getManufacturer(), rs.getRebate(), rs.getQuantity(), rs.getOnsale());
			}

			rs.close();
			ps.close();
			conn.close();
		}
		catch(Exception e)
		{}
		
		return prodObj;	
	}
}