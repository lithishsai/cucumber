Feature: Validation Of Adactinhotel
Scenario: Validation Of Adactinhotel with correct username and password 
Given User must lsunch the Adactinhotelapp url
When User enters the correct user name and password
And User click on the login button
Then User Validates url is navigated to Home page
And Select the Location,Hotels,Room type,No Of Rooms for travel
When User enters the CheckInDate and CheckOutDate
And Select the Adult and Children per Room
And User Click on the Search button
Then User Validates url is navigated to Select Hotel
And Select the Hotel
And Click on the Continue
Then User Validates url is navigated to Book a Hotel
When User enters the First and Last name , Billing Address , Credit card no
And select the Credit card Type and Expire date and CVV no
And Click on the Booking now
Then User Validates url is navigated to Booking confirmation


