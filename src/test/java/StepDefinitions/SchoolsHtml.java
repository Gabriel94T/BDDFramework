package StepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Listeners.ExtentReportListener;
import Utility.Constants;
import Utility.GenericUtility;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SchoolsHtml extends ExtentReportListener {
	//Calling classes
	WebDriver driver;
	GenericUtility utils;
	ExtentTest logInfo;

	
	@Given("check the Firefox browser is open")
	public void check_the_firefox_browser_is_open() throws IOException {
		//Calling browser driver and other classes
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		utils = new GenericUtility(driver);

		
		try {
			//Adding Extent Report information
			test = extent.createTest(Feature.class, "3schools Feature");
			test = test.createNode(Scenario.class, "Scenario 3schools");
			logInfo = test.createNode(new GherkinKeyword("Given"), "check the Firefox browser is open");
			logInfo.pass("Browser is opened...");

			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	
	@When("navigate to 3schools home page")
	public void navigate_to_3schools_home_page() throws IOException {

	
		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("When"), "navigate to 3schools home page");
			logInfo.pass("Navigate to 3Wschools....");
			//Navigate to Website wait 1 sec and accept cookie
			utils.goToUrl(Constants.URL_3SCHOOLS);
			utils.dynamicWait(Constants.ACCEPT_COOKIE_3SCHOOLS, 1000);
			utils.clickOnButton(Constants.ACCEPT_COOKIE_3SCHOOLS);
			
			
			//If fails calls method in ExtentReportListener
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	
	@Then("validate title text")
	public void validate_title_text() {

		
		try {
			//Adding Extent Report information
			logInfo = test.createNode(new GherkinKeyword("Then"), "validate title text");
			logInfo.pass("The Title has been validated succesfully");
			//Validate page title
			utils.validateTitle("HTML Tutorial");

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}
		//Closes the current driver
		utils.close();

	}

}
