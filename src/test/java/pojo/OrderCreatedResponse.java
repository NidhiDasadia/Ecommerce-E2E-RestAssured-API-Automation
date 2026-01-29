package pojo;

import java.util.List;

public class OrderCreatedResponse {
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	private List<String> orders;
	public void setOrders(List<String> orders) {
		this.orders = orders;
	}
	public void setProductOrderId(List<String> productOrderId) {
		this.productOrderId = productOrderId;
	}
	private List<String> productOrderId;
	public List<String> getOrders() {
		return orders;
	}
	public List<String> getProductOrderId() {
		return productOrderId;
	}
	
	

}
