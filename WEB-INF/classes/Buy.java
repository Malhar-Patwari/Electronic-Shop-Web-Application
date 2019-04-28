import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.HashMap;

public class Buy implements Serializable {

    String name;
    int id;
    String image;
	String price;
	String discount;
	String warranty;   
	HashMap<String, Double> buyitems;
    
    public Buy(String name,String price,String image,int id,String discount, String warranty){
		
		this.name = name;
		this.price = price;
		this.image = image;
		this.id = id;
		this.discount = discount;
		this.warranty = warranty;
		buyitems = new HashMap<String, Double>();
		
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public int getId()
	{
		return id;
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
	 
    public HashMap getbuyitems()
    {
        return buyitems;
    }
    
    public void addToBuy(String itemid, double price)
    {
        buyitems.put(itemid, price);
    }

    public void deleteFromBuy(String itemid)
    {
        buyitems.remove(itemid);
    }
     


}
