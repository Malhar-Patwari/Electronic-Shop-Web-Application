
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

 
public class Saxpaser extends DefaultHandler {
    Product product;
    List<Accesory> accessories;
    Accesory accessory;
    String consoleXmlFileName;
    String elementValueRead;
    int a;
    HashMap<String,Product> hm;
    //public Console con ;
    
    public Saxpaser(String consoleXmlFileName) 
    {
		a=1;
		// Product product ;
		hm=new HashMap<String, Product>();
        this.consoleXmlFileName = consoleXmlFileName;
        // accessories = new ArrayList<Accesory>();
        parseDocument();
        prettyPrint();
    }
	
   private void parseDocument() 
   {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try 
        {
            SAXParser parser = factory.newSAXParser();
            parser.parse(consoleXmlFileName, this);
        }
        catch (ParserConfigurationException e) 
        {
            System.out.println("ParserConfig error");
        } 
        catch (SAXException e) 
        {
            System.out.println("SAXException : xml not well formed");
        } 
        catch (IOException e) 
        {
            System.out.println("IO error");
        }
    }

    public HashMap getProducts()
    {
    	 return hm;
    }
    
    private void prettyPrint() {}

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException 
    {
        if (qName.equalsIgnoreCase("Product")) 
        {
			product = new Product();
            product.setId(attributes.getValue("id"));
            product.setCategory(attributes.getValue("category"));
		}

		if (qName.equalsIgnoreCase("Accesories")) 
        {
			accessories = new ArrayList<Accesory>();
		}
		if (qName.equalsIgnoreCase("Accesory")) 
        {
			accessory = new Accesory();
		}
    
	}	
    
    @Override
    public void endElement(String uri, String localName, String element) throws SAXException 
    { 
        if (element.equals("Product")) 
        {
            hm.put("product" + a+"", product);
			a++;
	       return;
        }
		
        if (element.equalsIgnoreCase("name")) 
        {
            product.setName(elementValueRead);
	       return;
        }
        if (element.equalsIgnoreCase("condition")) 
        {
            product.setCondition(elementValueRead);
	       return;
        }
		 if(element.equalsIgnoreCase("image"))
        {
           product.setImage(elementValueRead);
	       return;
        }
		if(element.equalsIgnoreCase("Accesory"))
        {            
           product.setAccesory(elementValueRead);
	       return;
		}
		if(element.equalsIgnoreCase("price"))
        {
            product.setPrice(Integer.parseInt(elementValueRead));
	       return;
        }
		if(element.equalsIgnoreCase("discount"))
        {
            product.setDiscount(Integer.parseInt(elementValueRead));
	       return;
        }
		if(element.equalsIgnoreCase("warranty"))
        {
            product.setWarranty(Integer.parseInt(elementValueRead));
	       return;
        }
		if(element.equalsIgnoreCase("manufacturer"))
        {
            product.setManufacturer(elementValueRead);
	       return;
        }
		if(element.equalsIgnoreCase("rebate"))
        {
            product.setRebate(elementValueRead);
	       return;
        }
		if(element.equalsIgnoreCase("quantity"))
        {
            product.setQuantity(Integer.parseInt(elementValueRead));
	       return;
        }
		if(element.equalsIgnoreCase("onsale"))
        {
            product.setOnsale(elementValueRead);
	       return;
        }
		
    }

    @Override
    public void characters(char content[], int begin, int end) throws SAXException 
    {
        elementValueRead = new String(content, begin, end);	
    }

    public static void main(String[] args) 
    {
        new Saxpaser("ProductCatalog.xml");

    }

}
