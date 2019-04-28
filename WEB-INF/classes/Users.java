public class Users implements java.io.Serializable{
	public String username;
	public String password;
	public String firstname;
	public String lastname;
	public String usertype;
	
	public Users(String username, String password, String firstname,String lastname, String usertype){
		this.username=username;
		this.password=password;
		this.firstname=firstname;
		this.lastname=lastname;
		this.usertype=usertype;
	}
	
	
	public Users() {
		
	}

	public String getusername() 
	{
		return username;
	}

	public void setusername(String username) 
	{
		this.username = username;
	}

	public String getpassword() 
	{
		return password;
	}

	public void setpassword(String password) 
	{
		this.password = password;
	}

	public String getfirstname() 
	{
		return firstname;
	}

	public void setfirstname(String firstname) 
	{
		this.firstname = firstname;
	}

	public String getlastname() 
	{
		return lastname;
	}

	public void setlastname(String lastname) 
	{
		this.lastname = lastname;
	}
	
	public String getusertype() 
	{
		return usertype;
	}

	public void setusertype(String usertype) 
	{
		this.usertype = usertype;
	}

}

      