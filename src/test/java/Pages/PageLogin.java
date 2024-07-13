package Pages;

import org.openqa.selenium.WebDriver;

import Utility.Constants;




//POM - Page Object Model for LoginTest.java
public class PageLogin {

	
	WebDriver driver;
	
	
	
	
	
	public PageLogin(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		
		
	}
	
	
	public void ProvideData(String username, String password) {
		driver.findElement(Constants.TXTUSERNAME_L).sendKeys(username);
		driver.findElement(Constants.TXTPASSWORD_L).sendKeys(password);
		
	}

	
	
	public void setupForm(String country,String address,String email, String phone) {
		driver.findElement(Constants.COUNTRY_L).sendKeys(country);
		driver.findElement(Constants.ADDRESS_L).sendKeys(address);
		driver.findElement(Constants.EMAIL_L).sendKeys(email);
	    driver.findElement(Constants.PHONE_L).sendKeys(phone);
	}
	
	
}

	