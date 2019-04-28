import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.HashMap;

public class Cart implements Serializable {
    
    //String retailer;
    String productid;
    String name;
    int id;
    String image;
	String price;
	String discount;
	String warranty;	
	String zip;
    
    //List<String> accessories;
	HashMap<String, Double> cartitems;
    public Cart(String name,String productid,String price,String image,int id, String discount, String warranty)
    {
        //accessories=new ArrayList<String>();
		
		this.name = name;
		this.productid = productid;
		this.price = price;
		this.image = image;
		this.id = id;
		this.discount = discount;
		this.warranty = warranty;
		cartitems = new HashMap<String, Double>();
    }

	
	public void setId(int id) {
		this.id = id;
	}

	public int getId()
	{
		return id;
	}
		
	public void setProductId(String productid) {
		this.productid = productid;
	}

	public String getProductId()
	{
		return productid;
	}

	public void setImage(String Image) {
		this.image = image;
	}

	public String getImage()
	{
		return image;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPrice()
	{
		return price;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getDiscount()
	{
		return discount;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public String getWarranty()
	{
		return warranty;
	}   
    
    public HashMap getcartitems()
    {
        return cartitems;
    }
    
    public void addToCart(String itemid, double price)
    {
        cartitems.put(itemid, price);
    }

    public void deleteFromCart(String itemid)
    {
        cartitems.remove(itemid);
    }
     
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getZip()
	{
		return zip;
	}

}
