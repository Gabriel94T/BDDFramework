package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import Listeners.ExtentReportListener;
import Pages.PageLogin;
import Utility.Constants;
import Utility.ExcelReader;
import Utility.Log;
import Utility.GenericUtility;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest extends ExtentReportListener {
    //Calling classes
	WebDriver driver;
	GenericUtility utils;
	PageLogin login;
	ExtentTest logInfo;
	

	@Given("browser is open")
	public void browser_is_open() {
		//Calling browser driver and other classes
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		login = new PageLogin(driver);
		utils = new GenericUtility(driver);
		

		try {
			//Adding Extent Report information
			test = extent.createTest(Feature.class, "LoginTest");
			test = test.createNode(Scenario.class, "Login");
			logInfo = test.createNode(new GherkinKeyword("Given"), "check the Chrome browser is open");
			logInfo.pass("Browser is opened...");
             //If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}
	}

	@And("navigate to login page")
	public void user_is_on_google_login_page() {

		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("And"), "navigate to testproject homepage");
			logInfo.pass("Navigate to testproject....");
             //Navigate to Website
			utils.goToUrl(Constants.LoginTest);
			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@When("user enters {string} and {int}")
	public void user_enters(String Login, Integer RowNumber)
			throws InterruptedException, InvalidFormatException, IOException {
		//Calling ExcelReader class for reading spreadsheet
		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> testData = reader.getData(Constants.data, Login);
		
		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("When"), "user enters data");
			logInfo.pass("The datas has been used");
			String runMode = testData.get(RowNumber).get(Constants.RUNMODE);
			//Checking the spreadsheet for data with Letters Y
			if(runMode.equals("Y")) {
				Log.info("Found data for test");
				String dataUser = testData.get(RowNumber).get(Constants.USERNAME);
				String dataPassword = testData.get(RowNumber).get(Constants.PASSWORD);
				utils.navigateToForm(Constants.LOGINBTN_L);
				login.ProvideData(dataUser, dataPassword);
			} else {
				Log.info("Skipping  test data");
			}
			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@And("user click on login button and fill out the form")
	public void user_click_on_login_button() throws InterruptedException, IOException, InvalidFormatException {

		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("And"), "user click on login button and fill out the form");
			logInfo.pass("user is succesfully logged on..");
            //Click on Login button and fill out the information then  save and logout
			utils.clickOnButton(Constants.LOGINBTN_L);
			login.setupForm(Constants.COUNTRY, Constants.ADDRESS, Constants.EMAIL, Constants.PHONE);
			utils.clickOnButton(Constants.SAVEBTN_L);
			utils.clickOnButton(Constants.LOGOUTBTN_L);

			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@Then("user is navigate to home page")
	public void user_is_navigate_to_home_page() {
		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("Then"), "user is to navigate to homepage");
			logInfo.pass("Navigate to homepage....");
			//Closes the current driver
			utils.close();

			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}
	}

}
