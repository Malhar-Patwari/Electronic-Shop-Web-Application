import com.mongodb.*;
import java.util.*;
import java.io.*;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.*;
import com.mongodb.Block;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import static java.util.Arrays.asList;

public class MongoDbDataStoreUtility
{
	DBCollection myReviews;
	
	public  void getConnection()
	{	
		MongoClient mongo;
		mongo = new MongoClient("localhost",27017);
		DB db = mongo.getDB("ProductReviews");
		myReviews =db.getCollection("myReviews");		
	}
	
	public  void insertReview(String Uname,String ProductModelName,String ProductCategory,String ProductPrice,String RetailerName,String RetailerZip,String RetailerCity,String RetailerState,String ProductOnSale,String ManufacturerName,String ManufacturerRebate,String UserId,String UserAge,String UserGender,String UserOccupation,String ReviewRating,java.sql.Date ReviewDate,String ReviewText)
	{
		getConnection();
		BasicDBObject doc = new BasicDBObject("title","myReviews").
		append("User",Uname).
		append("ProductModelName",ProductModelName).
		append("ProductCategory",ProductCategory).
		append("ProductPrice",ProductPrice).
		append("RetailerName",RetailerName).
		append("RetailerZip",RetailerZip).
		append("RetailerCity",RetailerCity).
		append("RetailerState",RetailerState).
		append("ProductOnSale",ProductOnSale).
		append("ManufacturerName",ManufacturerName).
		append("ManufacturerRebate",ManufacturerRebate).
		append("UserId",UserId).
		append("UserAge",UserAge).
		append("UserGender",UserGender).
		append("UserOccupation",UserOccupation).
		append("ReviewRating",ReviewRating).
		append("ReviewDate",ReviewDate).
		append("ReviewText",ReviewText);
		myReviews.insert(doc);
		
	}
	
	public  HashMap<String, ArrayList<ReviewP>> selectReview()
	{
		getConnection();
		HashMap<String, ArrayList<ReviewP>> reviewHashmap=new HashMap<String, ArrayList<ReviewP>>();
		DBCursor cursor = myReviews.find();

		while (cursor.hasNext())				
		{							
			BasicDBObject obj = (BasicDBObject) cursor.next();		
			if(! reviewHashmap.containsKey(obj.getString("ProductModelName")))
			{							
									
				ArrayList<ReviewP> arr = new ArrayList<ReviewP>();				
				reviewHashmap.put(obj.getString("ProductModelName"), arr);		
			}							
				ArrayList<ReviewP> listReview = reviewHashmap.get(obj.getString("ProductModelName"));
				ReviewP review =new	ReviewP(obj.getString("User"),obj.getString("ProductModelName"),obj.getString("ProductCategory"),obj.getString("ReviewRating"),obj.getString("ReviewText"));		
				listReview.add(review);							
		}//Iterate through Cursor and Store each review	
		return  reviewHashmap;	//into class object	
	}							

	public  ArrayList <Bestrating> LikedProducts(){
		
		ArrayList <Bestrating> Bestrate = new ArrayList <Bestrating> ();
		try
		{
			System.out.println("top5");
			getConnection();
			int retlimit =5;
			DBObject sort = new BasicDBObject();
			sort.put("reviewRating",-1);
			DBCursor cursor = myReviews.find().limit(retlimit).sort(sort);
			while(cursor.hasNext()) 
			{
				BasicDBObject obj = (BasicDBObject) cursor.next();
				System.out.println(obj.get("ProductModelName").toString()+obj.get("ReviewRating").toString());		  		   
				String prodcutnm = obj.get("ProductModelName").toString();
				String rating = obj.get("ReviewRating").toString();
				Bestrating best = new Bestrating(prodcutnm,rating);
				Bestrate.add(best);
		  	}		
		}
		catch (Exception e){ System.out.println(e.getMessage());}
        return Bestrate;
	}
}