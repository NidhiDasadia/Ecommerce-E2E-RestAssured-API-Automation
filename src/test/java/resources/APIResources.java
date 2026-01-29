package resources;

public enum APIResources {
	
	loginAPI("/api/ecom/auth/login"),
	addProductAPI("/api/ecom/product/add-product"),
	createOrderAPI("/api/ecom/order/create-order"),
	viewOrderAPI("/api/ecom/order/get-orders-details"),
	deleteOrderAPI("api/ecom/order/delete-order/{orderId}"),
	deleteProductAPI("/api/ecom/product/delete-product/{productId}");
	
	
	private String resource;
	
	APIResources(String resource){
		this.resource=resource;
	}

	public String getResource() {
		return resource;
		
	}
}
