import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class OrderP implements Serializable {
    
    String OrderId;
    String username;
    int price;
    String Address;
	String Zip;
	String Date;
	String state;
	//String price;
    
    //List<String> accessories;
	
    public OrderP()
	{}
	
	public void setprice(int price) {
		this.price = price;
	}

	public int getprice()
	{
		return price;
	}

	public void setOrderId(String OrderId) {
		this.OrderId = OrderId;
	}

	public String getOrderId()
	{
		return OrderId;
	}

	public void setZip(String Zip) {
		this.Zip = Zip;
	}

	public String getZip()
	{
		return Zip;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername()
	{
		return username;
	}
	
	public void setAddress(String Address) {
		this.Address = Address;
	}
	
	public String getAddress()
	{
		return Address;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	public String getState()
	{
		return state;
	}
	
	public void setDate(String Date) {
		this.Date = Date;
	}
	public String getDate()
	{
		return Date;
	}
}
