Feature: Add Product

Background: User login
Given Login payload with "dasadianidhi@gmail.com" "1234@Test"
When user calls "loginAPI" with "POST" http request
And the user is logged in
Then the api call is with status code "200"
And message in response body is "Login Successfully"

Scenario: Addition of a new product
Given Form data with following fields
	|productName       | iphone 15  |
	|productAddedBy    | userId     |
	|productCategory   | phone      |
	|productSubCategory| iphone     | 
	|productPrice      | 1500       |
	|productDescription| Iphone15	|
	|productFor        | All        |
	|productImage      |/Users/dhruvdasadia/Desktop/VisionBoard/2026/image.jpg|
When user calls "addProductAPI" with "POST" http request 
Then the api call is with status code "201"
And message in response body is "Product Added Successfully"
Then extract productId from response
And Create new order payload
When user calls "createOrderAPI" with "POST" http request
Then the api call is with status code "201"
And message in response body is "Order Placed Successfully"
And I extract orderId
Then I verify my product is added
When user calls "viewOrderAPI" with "GET" http request
Then the api call is with status code "200"
And I delete the product added
When user calls "deleteProductAPI" with "DELETE" http request
Then the api call is with status code "200"
And message in response body is "Product Deleted Successfully"
And I delete the Order created
When user calls "deleteOrderAPI" with "DELETE" http request
Then the api call is with status code "200"
And message in response body is "Orders Deleted Successfully"







