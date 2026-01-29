package resources;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification req;
	private static PrintStream log;
	
	private static PrintStream getLog() throws IOException {
		if(log == null) {
			log = new PrintStream(new FileOutputStream("logging.txt"));
		}
		return log;
	}
	
	public RequestSpecification requestSpecification() throws IOException {
		
		if(req==null) {
		req= new RequestSpecBuilder().setBaseUri(GlobalValue("baseUrl"))
				.addFilter(RequestLoggingFilter.logRequestTo(getLog()))
				.addFilter(ResponseLoggingFilter.logResponseTo(getLog()))
				.setContentType(ContentType.JSON).build();
		  return req;
		}
		return req;
	}
	public static String GlobalValue(String key) throws IOException {
		Properties prop= new Properties();
		FileInputStream fis= new FileInputStream("/Users/dhruvdasadia/eclipse-workspaceNidhi/EcommAPIAutomation/src/test/java/resources/global.properties");
		prop.load(fis);
		prop.getProperty(key);
		return prop.getProperty(key);
	}
	
	public String getJsonPath(String response, String key) {
		String resp= response.toString();
		JsonPath js= new JsonPath(resp);
		 return js.get(key).toString();
	}
	
	public RequestSpecification requestSpecificationWithAuth(String token) throws IOException {
		return new RequestSpecBuilder().setBaseUri(GlobalValue("baseUrl"))
				.addHeader("authorization", token)
				.addFilter(RequestLoggingFilter.logRequestTo(getLog()))
				.addFilter(ResponseLoggingFilter.logResponseTo(getLog()))
				.build();
	}
	

}
