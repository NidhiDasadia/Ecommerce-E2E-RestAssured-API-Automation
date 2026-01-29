Feature: Login scenarios with valid/invalid credentials

Login scenarios with valid/invalid credentials
Scenario Outline: Login Functionality postive and negative cases
Given Login payload with "<userEmail>" "<userPassword>"
When user calls "loginAPI" with "POST" http request
Then the api call is with status code "<statusCode>"
And message in response body is "<message>"

Examples:
		|userEmail             | userPassword | statusCode | message            		 |
		|dasadianidhi@gmail.com| 1234@Test    | 200        | Login Successfully			 |	
		|dasadianidhi@gmail.com| 1234@Nidhi   | 400		   | Incorrect email or password.|	