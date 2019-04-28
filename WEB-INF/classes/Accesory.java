import java.util.ArrayList;
import java.util.List;
import java.io.*;


public class Accesory implements Serializable {
   
    String Aname;
    String id;
    String Aimage;
	
    public Accesory(){
      
    }

	public void setId(String id) {
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public void setAImage(String AImage) {
		this.Aimage = Aimage;
	}

	public String getAImage()
	{
		return Aimage;
	}

	public void setAName(String Aname) {
		this.Aname = Aname;
	}
	
	public String getAName()
	{
		return Aname;
	}

}
