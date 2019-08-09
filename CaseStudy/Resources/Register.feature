Feature: Register Functionality
@Case4

Scenario: Register with valid credentials
Given Navigate to Home Page
When user clicks on signup
When user enters username as "priyanka"
When user enters fname as "priyanka"
When user enters lname as "ohri"
When user enters password as "archita123"
And user enters confirmpassword as "archita123"
And user enters gender as "female"
And user enters E-mail as "architaohri@gmail.com"
And user enters Mobile Number as "9897870447"
And user enters DOB as "08/08/1997"
And user enters Address as "xyz, mumbai"
And user selects security question as "What is your favour color?"
And enter answer as "Red"
Then user is registered successfully
And verify he is registered successfully

@Case4
Scenario: Login with valid credentials
Given login page
When user enters as "Lalitha" and "Password123"
Then user logged in successfully

@Case4
Scenario: Search for the product
When user searches below products in search box as "SHOPPING BAG" 
Then product should be added in the cart is available

@Case4
Scenario: Payemnt of the product
When user open cart
And clicks on checkout button
And fills the address and clicks on payment
Then payment should be successful


