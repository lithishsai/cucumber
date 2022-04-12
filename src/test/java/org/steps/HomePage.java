package org.steps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {
	public HomePage() {
		PageFactory.initElements(driver, this);
	} 
	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(xpath="//input[@name='login']")
	private WebElement login;

	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	@FindBy(xpath="//select[@name='location']")
	private WebElement location;
	@FindBy(xpath="//select[@name='hotels']")
	private WebElement hotels;
	@FindBy(xpath="//select[@name='room_type']")
	private WebElement roomType;
	@FindBy(xpath="//select[@name='room_nos']")
	private WebElement numberOfRooms;
	@FindBy(xpath="//input[@name='datepick_in']")
	private WebElement checkInDate;
	@FindBy(xpath="//input[@name='datepick_out']")
	private WebElement checkOutDate;
	@FindBy(xpath="//select[@name='adult_room']")
	private WebElement adultsPerRoom;
	@FindBy(xpath="//select[@name='child_room']")
	private WebElement childrenperRoom;
	@FindBy(xpath="//select[@name='cc_type']")
	private WebElement CreditCardType;
	@FindBy(xpath="//select[@name='cc_exp_month']")
	private WebElement expiryDate;
	@FindBy(xpath="//select[@name='cc_exp_year']")
	private WebElement expiryYear;
	@FindBy(xpath="//input[@value='Search']")
	private WebElement search;

	public WebElement getLocation() {
		return location;
	}
	public WebElement getHotels() {
		return hotels;
	}
	public WebElement getCreditCardType() {
		return CreditCardType;
	}
	public WebElement getExpiryDate() {
		return expiryDate;
	}
	public WebElement getExpiryYear() {
		return expiryYear;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getNumberOfRooms() {
		return numberOfRooms;
	}
	public WebElement getCheckInDate() {
		return checkInDate;
	}
	public WebElement getCheckOutDate() {
		return checkOutDate;
	}
	public WebElement getAdultsPerRoom() {
		return adultsPerRoom;
	}
	public WebElement getChildrenperRoom() {
		return childrenperRoom;
	}
	public WebElement getSearch() {
		return search;
	}


}
