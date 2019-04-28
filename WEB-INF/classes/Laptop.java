import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Laptop")

public class Laptop extends HttpServlet{

	private String id;
	private String name;
	private String condition;
	private String image;
	private double price;
	
	public Laptop(String id,String name, double price, String image,String condition){
		
		this.id=id;
		this.name=name;
		this.condition=condition;
		this.image=image;
		this.price=price;		
	}
	
	public Laptop(){}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
		
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
}
