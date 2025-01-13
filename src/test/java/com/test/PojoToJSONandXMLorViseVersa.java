package com.test;

import org.apache.juneau.html.HtmlSerializer;
import org.apache.juneau.json.JsonParser;
import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.xml.XmlSerializer;

public class PojoToJSONandXMLorViseVersa {

	
	
	// POJO(Plain old java Object) convert to JSON to XML or HTML, that is Serialization 
	
	//  JSON to XML or HTML  convert into POJO(Plain old java Object)  that is deserialization 
	
	//there are third party libraries are available to convert (POJO to JSON or vise versa) 
	//Third party libraries - Jacskon, Google Gson, SimpleJson  and Apache Juneau libraries 
	
	
	public static void main(String[] args) {
		
		//pojo to json
		
		JsonSerializer jsonSerializer=JsonSerializer.DEFAULT_READABLE;
		
		String seller[] ={"Wipro", "HCL", "xyz technology"};
		Product product = new Product("MacBookM1", 10000, "Golden", seller);
		
		String json=jsonSerializer.serialize(product);
		
		System.out.println(json);
		
		
		//pojo to xml
		XmlSerializer xmlSerializer=XmlSerializer.DEFAULT_NS_SQ_READABLE;
		
		String xml=xmlSerializer.serialize(product);
		
		System.out.println(xml);
		
		
		//pojo to HTML
		HtmlSerializer htmlSerializer=HtmlSerializer.DEFAULT_SQ_READABLE;
				
		String html=htmlSerializer.serialize(product);
				
		System.out.println(html);
		
		
		
		// Deserialization
		// Json to Pojo
		
		JsonParser jsonparser= JsonParser.DEFAULT;
		
		String JsonValue= "{\n"
				+ "	\"color\": \"Golden\",\n"
				+ "	\"name\": \"MacBookM1\",\n"
				+ "	\"price\": 10000,\n"
				+ "	\"sellerNames\": [\n"
				+ "		\"Wipro\",\n"
				+ "		\"HCL\",\n"
				+ "		\"xyz technology\"\n"
				+ "	]\n"
				+ "}";
		
		
		
		
		Product pro= jsonparser.parse(JsonValue, Product.class); // Product is class name where we have created getter and setter methods
		System.out.println("Color is "+ pro.getColor());
		System.out.println(pro);

	}





}
