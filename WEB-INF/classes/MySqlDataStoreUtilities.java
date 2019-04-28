import java.sql.*;
import java.io.*; 
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;


public class MySqlDataStoreUtilities
{	
	Connection conn = null;
	PreparedStatement ps= null;
	
	public boolean getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql");
			
			if(conn!=null)
			{
				return true;
			}
			else
			{
				return false;
			}
		
		}
		catch(Exception e)
		{
			 e.printStackTrace();
			return false;
		}
	}
	
	public void insert(String firstname, String lastname, String username, String password, String usertype)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql");
			
			ps = conn.prepareStatement("insert into registration(firstname,lastname,username,password,usertype)  values(?,?,?,?,?)"); 
		
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, username);
			ps.setString(4, password);
			ps.setString(5, usertype);
			
			ps.executeUpdate();
			conn.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//return false;
		} 
		finally 
		{
			try
			{ 
				if (conn != null) conn.close(); 
			} 
			catch (SQLException e)
			{ 
				e.printStackTrace(); 
			}
    	}
	}

	public boolean checkuser(String username, String password) {
   
		boolean st =false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			ps = conn.prepareStatement("select * from registration where username =? and password=? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs= ps.executeQuery();
			st = rs.next();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{
			try { if (conn != null) conn.close(); } 
			catch (SQLException e) { e.printStackTrace(); }
		}
		return st;
	}

	public boolean checkusertype(String username, String password,String usertype)
	{
		
		boolean st =false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
		   
			ps = conn.prepareStatement("select * from registration where username =? and password=? and usertype=?"); 
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3,usertype);
			ResultSet rs= ps.executeQuery();
			st = rs.next();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{ 
				if (conn != null)
				{
					conn.close();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
		}
			return st;
	}
	
	public boolean checkusertypeonly(String usertype)
	{		
		boolean st =false;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
		   
			ps = conn.prepareStatement("select * from registration where usertype=?"); 
			ps.setString(1,usertype);
			ResultSet rs= ps.executeQuery();
			st = rs.next();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{ 
				if (conn != null)
				{
					conn.close();
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace(); 
			}
		}
			return st;
	}
	
	public void insertProduct(String  productname, String category, String itemcondition, int price, String image,String id,String manufacturer,int quantity , String onsale, String rebate)
	{
			
	    try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 


			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
	        ps = conn.prepareStatement("INSERT INTO product(name,category,itemcondition,price,image,id,manufacturer,rebate,quantity,onsale) VALUES(?,?,?,?,?,?,?,?,?,?);"); 
	  
	        ps.setString(1, productname);
			ps.setString(2, category);
			ps.setString(3, itemcondition);
	        ps.setInt(4, price);
			ps.setString(5,image );
			ps.setString(6,id );
			ps.setString(7,manufacturer);
			ps.setString(8,rebate);
			ps.setInt(9,quantity);
			ps.setString(10,onsale);


	        ps.execute();
	        conn.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}

	}
	
	public void insertProduct1(String  pname, String pcategory, String itemcondition, int Price, String image,String id, String manufacturer, String rebate, String onsale, int quantity)	
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			java.sql.Date sqlDate = new java.sql.Date(System.currentTimeMillis());
			ps = conn.prepareStatement("INSERT INTO product(name,category,itemcondition,price,image,id,manufacturer,rebate,onsale,quantity) VALUES(?,?,?,?,?,?,?,?,?,?);"); 
	        ps.setString(1, pname);
			ps.setString(2, pcategory);
			ps.setString(3, itemcondition);
	        ps.setInt(4, Price);
			ps.setString(5,image );
			ps.setString(6,id );
			ps.setString(7,manufacturer);
			ps.setString(8,rebate);
			ps.setString(9,onsale);
			ps.setInt(10,quantity);
		
			ps.execute();
			conn.close();

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
		finally 
		{
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	}

	public void insertOrder(String  OrderId, String Username, String price, String address,String id,java.sql.Date sqlDate,String Zip,String state,ArrayList<Cart> list)
	{
		System.out.println("In mysql price : "+price);
		int Order= 0;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			ps = conn.prepareStatement("INSERT INTO orders(OrderId,username,price,address,id,addressdate,Zip,state) VALUES(?,?,?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS); 
 
			ps.setString(1, OrderId);
			ps.setString(2, Username);
			ps.setInt(3, Integer.parseInt(price));
			ps.setString(4, address);
			ps.setInt(5, Integer.parseInt(id));
			ps.setString(6,(sqlDate).toString() );
			ps.setString(7,Zip );
			ps.setString(8,state);
			ps.execute();
			ResultSet rs = ps.getGeneratedKeys();

			if(rs.next())
			{
				Order = rs.getInt(1);
			}
	        conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally
		{
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//insertcart(list,Order,Zip);
	}
	
	public void insertcart(String name,String productid,String price,String image,String discount,String warranty)
	{
		try
		{
			getConnection();
			ps = conn.prepareStatement("insert into cart(name,productid,price,image,discount,warranty)  values(?,?,?,?,?,?)"); 
  
			ps.setString(1, name);
			ps.setString(2, productid);
			//ps.setString(3, cart.getImage());
			ps.setString(3, price);
			ps.setString(4, image);
			//ps.setString(5, id);
			ps.setString(5, discount);
			ps.setString(6, warranty);
			//ps.setString(5, usertype);

			ps.execute();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}	
	}
	
	public LinkedHashMap<String, String>  ZipCode()
	{

		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			LinkedHashMap<String, String> hm = new LinkedHashMap();
			ps = conn.prepareStatement("SELECT *,count(*) FROM exampledatabase.orders group by exampledatabase.orders.Zip order by Count(exampledatabase.orders.id) desc  limit 5 ; "); 
	  
			ResultSet rs= ps.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("Zip") + rs.getString("count(*)"));
				//item.setDiscount(rs.getString("discount"));
				hm.put(rs.getString("Zip"),rs.getString("count(*)"));
			}
			return hm;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}

	public LinkedHashMap<String, List<String>>  SoldProduct()
	{
	  	try 
	  	{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			LinkedHashMap<String,List<String>> hm = new LinkedHashMap();
		  
			ps = conn.prepareStatement("SELECT *,count(*) FROM exampledatabase.orders,exampledatabase.product WHERE exampledatabase.orders.id = exampledatabase.product.id group by exampledatabase.orders.id order by Count(exampledatabase.orders.id) desc  limit 5 ; "); 
	  		ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				List<String> topp = new ArrayList<String>();
				System.out.println(rs.getString("id")+rs.getString("name")+rs.getString("category")+rs.getString("count(*)"));
				//item.setDiscount(rs.getString("discount"));
				topp.add(rs.getString("name"));
				topp.add(rs.getString("count(*)"));
				hm.put(rs.getString("id"),topp);
			}
			return hm;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}
	
	public void  CancelOrder(String OrderId) {
	  
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			System.out.println(OrderId);
			ps = conn.prepareStatement("DELETE FROM exampledatabase.orders WHERE exampledatabase.orders.Orderid = ?"); 
			ps.setString(1, OrderId);
		   
			ps.executeUpdate();
					
		} 
		catch (Exception e) {
			e.printStackTrace();	
		} 
		finally {
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}
	
	public  HashMap<String, Product> checkproduct(String makers) {
	  
	 	HashMap<String, Product> hm = new HashMap<String, Product>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
  
			ps = conn.prepareStatement("select * from product where category = ? "); 
	  
			ps.setString(1, makers);
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
				item.setCondition(rs.getString("ItemCondition"));
				//item.setCondition(rs.getString("manufacturere"));
				//item.setDiscount(rs.getString("discount"));
				hm.put(item.getName(),item);
			}
			return hm;	
			//st = rs.next();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally {
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}
	
	public  HashMap<String, List<OrderP>> orderView(String username) {
	   	  
	 	HashMap<String, List<OrderP>> hm = new HashMap<String, List<OrderP>>();
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			List<OrderP> orderarray = new ArrayList<OrderP>();
		  
			ps = conn.prepareStatement("select * from orders where username = ? "); 
	  
			ps.setString(1, username);
			//ps.setString(2, password);
		 
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				System.out.println("COunter");
				OrderP item = new OrderP();
				//item.setType(rs.getString("type"));
				item.setUsername(rs.getString("username"));
				item.setprice(rs.getInt("price"));
				item.setOrderId(rs.getString("OrderId"));
				//tem.setId(rs.getString("id"));
				item.setAddress(rs.getString("address"));
				//item.setDiscount(rs.getString("discount"));
				item.setZip(rs.getString("Zip"));
				orderarray.add(item);
				//hm.put(item.getUsername(),item);
				username = item.getUsername();
			}
			hm.put(username,orderarray);
			return hm;	
			//st = rs.next();
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
		finally {
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}

	public  void truncateTable() {
	  
	 	HashMap<String, Product> hm = new HashMap<String, Product>();
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
	 		conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			ps = conn.prepareStatement("truncate table Product");
			ps.execute();
		    //return rs;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//return null;
		}
		finally 
		{
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}

	public ArrayList<Product> checkInventory() {
 		ArrayList<Product> products = new ArrayList<Product>();
    	try
    	 {
			Class.forName("com.mysql.jdbc.Driver");  
 			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

	        ps = conn.prepareStatement("select name,price,quantity from product; "); 
	   	    ResultSet rs= ps.executeQuery();
        	
        	while(rs.next())
        	{
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				products.add(product);
			}
			return products;	

    }
    catch (Exception e)
    {
        e.printStackTrace();
		return null;
    } 
    finally
    {
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}

	public ArrayList<Product> checkInventoryonsale() {
   
	 	ArrayList<Product> products = new ArrayList<Product>();
	    try 
	    {
			Class.forName("com.mysql.jdbc.Driver");  
 			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

	        ps = conn.prepareStatement("select name,price,quantity,onsale,category from product where onsale = \"yes\"; "); 
     
  	        ResultSet rs= ps.executeQuery();
      	    while(rs.next())
      	    {
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setCategory(rs.getString("category"));
				product.setOnsale(rs.getString("onsale"));
				products.add(product);
			}
			return products;	
    	}
    	catch (Exception e)
    	{
        	e.printStackTrace();
			return null;
    	} 
    	finally 
    	{
        	try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    	}
	}
	public ArrayList<Product> checkInventoryrebate() {
   
		 ArrayList<Product> products = new ArrayList<Product>();
		 try 
		 {
			Class.forName("com.mysql.jdbc.Driver");  
		 	conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

	        ps = conn.prepareStatement("select name,price,quantity,rebate,category from product  where rebate = \"yes\"; "); 
  		    ResultSet rs= ps.executeQuery();
        	
        	while(rs.next())
        	{
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("quantity"));
				product.setCategory(rs.getString("category"));
				product.setRebate(rs.getString("rebate"));
				products.add(product);
			}
			return products;	

    	}
    	catch (Exception e) 
    	{
        	e.printStackTrace();
			return null;
    	}
    	finally 
    	{
        	try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    	}
	}

	public ArrayList<Product> checkSales() {
   
 		ArrayList<Product> products = new ArrayList<Product>();
	    try 
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	 		conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
	        ps = conn.prepareStatement("SELECT *,count(*) as c FROM exampledatabase.cart group by name order by c desc;"); 
  
    	    ResultSet rs= ps.executeQuery();
        	 
			while(rs.next())
			{
				Product product = new Product();
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				product.setQuantity(rs.getInt("c"));
				products.add(product);
			}
			return products;	
    	} 
    	catch (Exception e) 
    	{
        	e.printStackTrace();
			return null;
    	} 
    	finally 
    	{
        	try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    	}
	}

	public ArrayList<OrderP> checkSalesdate() {   
 		
 		ArrayList<OrderP> orders = new ArrayList<OrderP>();
    	try
    	{
			Class.forName("com.mysql.jdbc.Driver");  
 			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

	        ps = conn.prepareStatement("select *,sum(price) as totalsale from orders group by AddressDate order by totalsale desc; "); 
	        ResultSet rs= ps.executeQuery();
	        while(rs.next())
	        {
				OrderP  order = new OrderP();
				order.setDate(rs.getString("AddressDate"));
				order.setprice(rs.getInt("totalsale"));
				orders.add(order);
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
	        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
	}

	public HashMap<String, Product>  selectproduct(String pid,String category) {
   
  		ResultSet rs = null;
	    try 
	    {
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 

			HashMap<String, Product> hm = new HashMap<String, Product>();
			
        	ps = conn.prepareStatement("SELECT * FROM exampledatabase.product where id= ? and category = ? ; "); 
        
			ps.setString(1, pid);
			ps.setString(2,category);
       
    	    rs= ps.executeQuery();
        		
	        while(rs.next())
	        {
				Product item = new Product();
				//item.setType(rs.getString("type"));
				item.setName(rs.getString("name"));
				item.setCategory(rs.getString("category"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
				//item.setCategory(rs.getString("category"));
				item.setId(rs.getString("id"));
				item.setQuantity(rs.getInt("quantity"));
				item.setOnsale(rs.getString("onsale"));
				item.setRebate(rs.getString("rebate"));
				item.setCondition(rs.getString("ItemCondition"));
				item.setCondition(rs.getString("ItemCondition"));
				item.setCondition(rs.getString("manufacturer"));
				//item.setDiscount(rs.getString("discount"));
				hm.put(item.getName(),item);
				//item.setDiscount(rs.getString("discount"));
				//hm.put(rs.getString("pname"),rs.getString("Zip"));
			}

			return hm;	
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
			return null;
	    }
	    finally
	    {
	        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
		//return st;
	}

	public int  updateproduct(String pid,String category,String  productname, String ItemCondition, String price,  String image,String quantity,String onsale,String rebate) {
   		
   		try
   		{
			Class.forName("com.mysql.jdbc.Driver");  
 			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
 			HashMap<String, Product> hm = new HashMap<String, Product>();
			ps = conn.prepareStatement("UPDATE  exampledatabase.product set name=?,Itemcondition=?,price=?,image=?,quantity=?,onsale=?,rebate=? where id=? and category=?; "); 
  
	      	ps.setString(1, productname);
			ps.setString(2,ItemCondition);
			ps.setString(3,price);
			ps.setString(4,image);
			ps.setString(5,quantity);
			ps.setString(6,onsale);
			ps.setString(7,rebate);
			ps.setString(8,pid);
			ps.setString(9,category);			
	   
        	int  rs= ps.executeUpdate();     
			return rs;	
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return 0;
		}
		finally
		{
			try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		//return st;
	}

	public int  deleteproduct(String pid,String category) {
	    
	    try
	    {
			Class.forName("com.mysql.jdbc.Driver");  
 			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
 			HashMap<String, Product> hm = new HashMap<String, Product>();
       		ps = conn.prepareStatement("delete from product where id= ? and category= ?; "); 
        	
			ps.setString(1, pid);
			ps.setString(2,category);
		
        	int  rs= ps.executeUpdate();
			return rs;	

    	} 
    	catch(Exception e)
    	{
        	e.printStackTrace();
			return 0;
    	}
    	finally
    	{
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    	}
		//return st;
	}

	public HashMap<String, Product>  getProductData() {
   	
		ResultSet rs = null;
	    try 
	    {
			Class.forName("com.mysql.jdbc.Driver");  
	 		conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
	 		HashMap<String, Product> hm = new HashMap<String, Product>();
	        ps = conn.prepareStatement("SELECT * FROM exampledatabase.product ; "); 
	  
	        rs= ps.executeQuery();
	        
		    while(rs.next())
		    {
				Product item = new Product();
				//item.setType(rs.getString("type"));
				item.setName(rs.getString("name"));
				item.setCategory(rs.getString("category"));
				item.setPrice(rs.getInt("price"));
				item.setImage(rs.getString("image"));
				item.setCategory(rs.getString("category"));
				item.setId(rs.getString("id"));
				item.setQuantity(rs.getInt("quantity"));
				item.setOnsale(rs.getString("onsale"));
				item.setRebate(rs.getString("rebate"));
				item.setCondition(rs.getString("ItemCondition"));
				//item.setDiscount(rs.getString("discount"));
				hm.put(item.getName(),item);
				//item.setDiscount(rs.getString("discount"));
				//hm.put(rs.getString("pname"),rs.getString("Zip"));
			}
			return hm;	
	    } 
	    catch (Exception e) 
	    {
	        e.printStackTrace();
			return null;
	    }
	    finally
	    {
	        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	    }
	//return st;
	}

	public HashMap<String,Product> getData()
	{
		HashMap<String,Product> hm=new HashMap<String,Product>();
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");  
			conn=DriverManager.getConnection ("jdbc:mysql://localhost:3306/exampledatabase","root","dds@sql"); 
			//getConnection();
			Statement stmt=conn.createStatement();
			String selectCustomerQuery="select * from  product";
			ResultSet rs = stmt.executeQuery(selectCustomerQuery);
			while(rs.next())
			{	Product p = new Product(rs.getString("name"), rs.getString("category"),rs.getString("itemcondition"),rs.getInt("price"),rs.getString("image"),rs.getString("id"),rs.getString("manufacturer"), rs.getString("rebate"), rs.getInt("quantity"), rs.getString("onsale"));
				hm.put(rs.getString("id"), p);
			}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		return hm;			
	}
	
}	
