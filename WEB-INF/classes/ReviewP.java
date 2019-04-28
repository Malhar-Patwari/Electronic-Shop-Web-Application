

public class ReviewP implements java.io.Serializable{
	String productName;
	String rating;
	String review;
	String username;
	String category;
 	
	public ReviewP(String username,String productName,String category,String rating, String review){
		this.productName=productName;
		this.rating = rating;
		this.review = review;
		this.username = username;
		this.category = category;
	}
		
	public ReviewP() {
		
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getrating() {
		return rating;
	}

	public void setrating(String rating) {
		this.rating = rating;
	}

	public String getusername() {
		return username;
	}

	public void setusername(String username) {
		this.username = username;
	}
	
	public String getreview() {
		return review;
	}

	public void setreview(String review) {
		this.review = review;
	}
	
	public String getcategory() {
		return category;
	}

	public void setcategory(String category) {
		this.category = category;
	}
	
}

      