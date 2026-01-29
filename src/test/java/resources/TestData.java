package resources;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;
import pojo.Login;
import pojo.OrderDetails;
import pojo.Orders;

public class TestData {
	Response response;
	public Login login(String userEmail,String userPassword) {
		Login loginuser= new Login();
		loginuser.setUserEmail(userEmail);
		loginuser.setUserPassword(userPassword);
		return loginuser;
		
	}
	
	public Orders orders(String productId) {
		OrderDetails orderdetail= new OrderDetails();
		Orders order= new Orders();
		
		orderdetail.setCountry("India");
		orderdetail.setProductOrderedId(productId);
		
		List <OrderDetails> orderDetailsList= new ArrayList<OrderDetails>();
		orderDetailsList.add(orderdetail);
		order.setOrders(orderDetailsList);
		return order;
		
		
	}

}
