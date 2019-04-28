import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Product implements Serializable {
   //String retailer;
    String name;
    String id;
    String category;
    String condition;
    int price;
	int discount;
	int warranty;
    String accessories;
	String image;
	String manufacturer;
	String rebate;
	int quantity;
	String onsale;
	
	public Product(String name, String category, String condition, int price, String image, String id, String manufacturer ,String rebate, int quantity, String onsale){
		
		this.name=name;
		this.category = category;
		this.condition = condition;
		this.price=price;
		this.image = image;
		this.id=id;
		this.manufacturer = manufacturer;
		this.rebate = rebate;
		this.quantity = quantity;
		this.onsale = onsale;
	}
	
    public Product(){}
		
	public void setId(String id) {
		this.id = id;
	}
	public String getId()
	{
		return id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCategory()
	{
		return category;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition()
	{
		return condition;
	}
	
	public void setImage(String image) {
		this.image = image;
	}

	public String getImage()
	{
		return image;
	}

	public void setAccesory(String accessories) {
		this.accessories = accessories;
	}

	public String getAccesory()
	{
		return accessories;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice()
	{
		return price;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getDiscount()
	{
		return discount;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}

	public int getWarranty()
	{
		return warranty;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}
	
	public void setRebate(String rebate) {
		this.rebate = rebate;
	}

	public String getRebate()
	{
		return rebate;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public void setOnsale(String onsale) {
		this.onsale = onsale;
	}
	
	public String getOnsale()
	{
		return onsale;
	} 
}
