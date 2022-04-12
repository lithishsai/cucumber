package org.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StrpDefine extends Base{
	@Given("User must lsunch the Adactinhotelapp url")
	public static void user_must_lsunch_the_Adactinhotelapp_url() {
		launchBrowser("http://adactinhotelapp.com/HotelAppBuild2/SearchHotel.php");

	}

	@When("User enters the correct user name and password")
	public static void user_enters_the_correct_user_name_and_password() {
		HomePage h = new HomePage();
		sendText(h.getUsername(),"saranyasuresh");
		sendText(h.getPassword(),"Sara@1411");
	}

	@When("User click on the login button")
	public void user_click_on_the_login_button() {
		HomePage h = new HomePage();

		buttonClick(h.getLogin());
	}

	@Then("User Validates url is navigated to Home page")
	public void user_Validates_url_is_navigated_to_Home_page() {
		boolean contains = driver.getTitle().contains("Search Hotel");
		Assert.assertTrue(contains);
		System.out.println("Adactin validation");
	}

	@Then("Select the Location,Hotels,Room type,No Of Rooms for travel")
	public void select_the_Location_Hotels_Room_type_No_Of_Rooms_for_travel() {
		HomePage h = new HomePage();

		WebElement location = h.getLocation();
        singleSelect(location, "Brisbane");	
        WebElement hotels = h.getHotels();
        singleSelect(hotels, "Hotel Sunshine");
        WebElement roomType = h.getRoomType();
    	singleSelect(roomType, "Double");
        WebElement numberOfRooms = h.getNumberOfRooms();
    	singleSelect(numberOfRooms, "3");
        }

	@When("User enters the CheckInDate and CheckOutDate")
	public void user_enters_the_CheckInDate_and_CheckOutDate() {
		HomePage h = new HomePage();

	    WebElement checkInDate = h.getCheckInDate();
	    checkInDate.sendKeys("25/03/2022");
	    WebElement checkOutDate = h.getCheckOutDate();
	    checkOutDate.sendKeys("29/03/2022");

	}

	@When("Select the Adult and Children per Room")
	public void select_the_Adult_and_Children_per_Room() {
		HomePage h = new HomePage();

		 WebElement adultsPerRoom = h.getAdultsPerRoom();
			singleSelect(adultsPerRoom, "2");
			WebElement childrenperRoom = h.getChildrenperRoom();
			singleSelect(childrenperRoom, "2");
			
	    }

	@When("User Click on the Search button")
	public void user_Click_on_the_Search_button() {
		HomePage h = new HomePage();

	    h.getSearch().click();

	    }

	@Then("User Validates url is navigated to Select Hotel")
	public void user_Validates_url_is_navigated_to_Select_Hotel() {
		boolean contains = driver.getTitle().contains("Select Hotel");
		Assert.assertTrue(contains);
		System.out.println("Adactin Select Hotel");
	
	    
	}

	@Then("Select the Hotel")
	public void select_the_Hotel() {
	    driver.findElement(By.name("radiobutton_0")).click();

	}

	@Then("Click on the Continue")
	public void click_on_the_Continue() {
	    driver.findElement(By.name("continue")).click();

	}

	@Then("User Validates url is navigated to Book a Hotel")
	public void user_Validates_url_is_navigated_to_Book_a_Hotel() {
		boolean contains = driver.getTitle().contains("Book A Hotel");
		Assert.assertTrue(contains);
		System.out.println("Book Hotel");

	}

	@When("User enters the First and Last name , Billing Address , Credit card no")
	public void user_enters_the_First_and_Last_name_Billing_Address_Credit_card_no() {

	    driver.findElement(By.name("first_name")).sendKeys("saranya");
	    driver.findElement(By.name("last_name")).sendKeys("suresh");
	    driver.findElement(By.name("address")).sendKeys("no 56, neru st, ram nagar, ch-90");
	    driver.findElement(By.name("cc_num")).sendKeys("9876544332112345");
}

	@When("select the Credit card Type and Expire date and CVV no")
	public void select_the_Credit_card_Type_and_Expire_date_and_CVV_no() {
		HomePage h = new HomePage();

	    WebElement creditCardType = h.getCreditCardType();
		singleSelect(creditCardType, "VISA");
		WebElement expiryDate = h.getExpiryDate();
		singleSelect(expiryDate, "4");
		WebElement expiryYear = h.getExpiryYear();
		singleSelect(expiryYear, "2022");
		driver.findElement(By.name("cc_cvv")).sendKeys("6786897989");

	}

	@When("Click on the Booking now")
	public void click_on_the_Booking_now() {
		driver.findElement(By.name("book_now")).click();
	}

	@Then("User Validates url is navigated to Booking confirmation")
	public void user_Validates_url_is_navigated_to_Booking_confirmation() {
		boolean contains = driver.getTitle().contains("Adactin.com - Book A Hotel");
		Assert.assertTrue(contains);
		//System.out.println(driver.getTitle());
		System.out.println("Hotel Booking Confirmation");

	}


}
