package stepDefination;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import pojo.LoginResponse;
import pojo.OrderCreatedResponse;
import pojo.productCreatedResponse;
import resources.APIResources;
import resources.TestData;
import resources.Utils;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepDefination extends Utils {
	RequestSpecification res;
	Response response;
	LoginResponse loginRes= new LoginResponse();
	String userId;
	String token;
	String productId;
	String orders;
	productCreatedResponse productres= new productCreatedResponse();
	String orderId;
	OrderCreatedResponse orderRes= new OrderCreatedResponse();
	
	
TestData data=new TestData();	
	
@Given("Login payload with {string} {string}")
public void login(String userEmail, String userPassword) throws IOException {
 res=given().spec(requestSpecification()).
		 body(data.login(userEmail, userPassword))
	;
}

@When("user calls {string} with {string} http request")
public void user_calls_with_post_request(String resource, String method) {
	
	APIResources resourceAPI= APIResources.valueOf(resource);
System.out.println(resourceAPI.getResource());

if(method.equalsIgnoreCase("POST"))
	response =res.when().post(resourceAPI.getResource());
else if(method.equalsIgnoreCase("GET"))
	response=res.when().get(resourceAPI.getResource());
else if(method.equalsIgnoreCase("DELETE")) {
	  if(resource.equals("deleteProductAPI"))
	        response = res.pathParam("productId", productId).when().delete(resourceAPI.getResource());
	    else if(resource.equals("deleteOrderAPI"))
	        response = res.pathParam("orderId", orderId).when().delete(resourceAPI.getResource());
}

}

@Then("the api call is with status code {string}")
public void api_all_success_with_statuscode(String statusCode) {
assertEquals(response.getStatusCode(),Integer.parseInt(statusCode));
}

@And("the user is logged in")
public void user_logs_in() throws IOException {
   
    
    token = response.path("token");
    userId = response.path("userId");
    System.out.println("Extracted token: " + token);
    System.out.println("Extracted userId: " + userId);
}
	

@And("message in response body is {string}")
public void in_response_body_is(String message) {
	loginRes = response.as(LoginResponse.class);
	
	
	assertEquals(loginRes.getMessage(), message);
}

@Given("Form data with following fields")
public void form_data(io.cucumber.datatable.DataTable dataTable) throws IOException {
	
	
	Map<String, String> data = dataTable.asMap(String.class, String.class);
	
	res = given().spec(requestSpecificationWithAuth(token))
		.formParam("productName", data.get("productName"))
		.formParam("productAddedBy", userId)
		.formParam("productCategory", data.get("productCategory"))
		.formParam("productSubCategory", data.get("productSubCategory"))
		.formParam("productPrice", data.get("productPrice"))
		.formParam("productDescription", data.get("productDescription"))
		.formParam("productFor", data.get("productFor"))
		.multiPart("productImage", new File(data.get("productImage")));
	
}

@And("I extract orderId")
public void extract_order_id() {
	//loginRes = response.as(LoginResponse.class);
	orderRes = response.as(OrderCreatedResponse.class);
    orderId = orderRes.getOrders().get(0);
    System.out.println("Extracted orderId: " + orderId);
}

@Then("I verify my product is added")
public void get_order_details() throws IOException {
    
	
	
	res = given().spec(requestSpecificationWithAuth(token))
        .queryParam("id", orderId);
}

@Then("extract productId from response")
public void extract_product_id() {
	productId = response.jsonPath().getString("productId");
	System.out.println("Extracted productId: " + productId);
}

@Given("Create new order payload")
public void create_order() throws IOException {
	
	 System.out.println("Token in create_order: " + token);
	    System.out.println("ProductId in create_order: " + productId);

	    if (productId == null) {
	        throw new RuntimeException("productId is NULL before creating order");
	    }

	    res = given().spec(requestSpecificationWithAuth(token)).contentType(ContentType.JSON)
	                 .body(data.orders(productId));
	}


@And("I delete the product added")
public void delete_product() throws IOException {
	res= given().spec(requestSpecificationWithAuth(token)).pathParam("productId",productId);
}

@And("I delete the Order created")
public void delete_order() throws IOException {
	res= given().spec(requestSpecificationWithAuth(token)).pathParam("orderId", orderId);
}

}
