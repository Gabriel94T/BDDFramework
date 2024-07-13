package Utility;

import org.openqa.selenium.By;

public class Constants {
	
	
     // URLS for Pages
	public static final String URL_3SCHOOLS = "https://www.w3schools.com/html/default.asp";
	 public static final String LoginTest = "https://example.testproject.io/web/";
    
    // Data path  for LoginTest
    public static final String data = System.getProperty("user.dir")+"//automation.xlsx";
    
    //Page Elements
    public static final String HOMEPAGE_TXT = "/html[1]/body[1]/div[1]/div[2]/a[1]";
    public static final By HOMEPAGE_TEXT_LOCATOR=By.xpath(HOMEPAGE_TXT);
    
   public static final By ACCEPT_COOKIE_3SCHOOLS=By.id("accept-choices");
    
    public static final String LOGINBTN = "login";
    public static final By LOGINBTN_L = By.id(LOGINBTN);
    
    public static final String SAVEBTN = "save";
    public static final By SAVEBTN_L = By.id(SAVEBTN);
    
    public static final String LOGOUTBTN = "logout";
    public static final By LOGOUTBTN_L = By.id(LOGOUTBTN);
    
    public static final String COUNTRYEL = "country";
    public static final By COUNTRY_L = By.id(COUNTRYEL);
    
    public static final String ADDRESSEL = "address";
    public static final By ADDRESS_L = By.id(ADDRESSEL);
    
    public static final String EMAILEL = "email";
    public static final By EMAIL_L = By.id(EMAILEL);
    
    public static final String PHONEEL = "phone";
    public static final By PHONE_L = By.id(PHONEEL);
    
    public static final String TXTUSERNAME = "name";
    public static final By TXTUSERNAME_L = By.id(TXTUSERNAME);
    
    public static final String TXTPASSWORD = "password";
    public static final By TXTPASSWORD_L = By.id(TXTPASSWORD);
    
    
    //Data for LoginTest
    public static final String COUNTRY = "Ireland";
    public static final String ADDRESS = "12 Herbert Street";
    public static final String EMAIL = "greg@gmail.com";
    public static final String PHONE = "01010101010";
	public static final String RUNMODE = "Runmode";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	
	
}
