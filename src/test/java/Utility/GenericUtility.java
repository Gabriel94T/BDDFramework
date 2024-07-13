package Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class GenericUtility {

	 WebDriver driver;

	public GenericUtility(WebDriver webDriver) {

		
		this.driver = webDriver;
		driver.manage().window().maximize();
		
	}

	public void goToUrl(String url) {
		driver.get(url);
	}

	public String getTitleOfPage() {
		Log.info("Getting the title...");
		// getting page Title;
		return driver.getTitle();
	}

	public void validateText(By locator, String expectedText) {
		Log.info("validateText");
		String actualText = driver.findElement(locator).getText();
		Log.info("Actual Text {" + actualText + "}. Expected Text {" + expectedText + "}");
		// assert the expected result with actual by getting text
		Assert.assertEquals(actualText, expectedText);
		if (!expectedText.equals(actualText)) {
			Log.error("Text not Matching. Got text as " + actualText);

		}

	}

	public void clickOnButton(By element) {

		driver.findElement(element).click();

	}
	

	public String getElementText(By element) {
		return driver.findElement(element).getText();

	}

	public void login_functionality(String username, String password) {
		try {
			WebElement userName = driver.findElement(By.id("loginID"));
			userName.clear();
			userName.sendKeys(username);
			WebElement passWord = driver.findElement(By.id("Password"));
			passWord.clear();
			passWord.sendKeys(password);
			WebElement signin = driver.findElement(By.id("SignIn_button"));
			signin.click();
			driver.manage().window().maximize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void navigateToForm(By element) {
		
		WebElement loginFormBtn = driver.findElement(element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginFormBtn);
		
		
	}

	public void clickLoginbutton() {

		WebElement login = driver.findElement(By.id("SubmitLogin"));
		login.click();
	}

	public void clickingonCheckboxesInThePage() {
		WebElement checkbox = driver.findElement(By.linkText("Checkbox"));
		checkbox.click();
	}

	public void dropdownFunctionalityOfThePage() {
		WebElement myElement = driver.findElement(By.name("dropdown"));
		Select dropdown = new Select(myElement);
		// selectByVisibleText
		dropdown.selectByVisibleText("Text");
		// selectByIndex
		dropdown.selectByIndex(2);

		// selectByValue
		dropdown.selectByValue("ab");
	}

	public void navigateToNextPage() {

		driver.navigate().forward();

	}

	public void validateTitle(String exTitle) {
		Log.info("Expected Title " + exTitle);
		Log.info("Actual Title " + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), exTitle);
		if (!exTitle.equals(driver.getTitle())) {
			Log.error("Titles do not match. Got title as " + driver.getTitle());

		}
	}

	public void setText(By element, String text) {
		driver.findElement(element).sendKeys(text);

	}

	public void linktext(By element) {
		driver.findElement(By.linkText("link text"));
	}

	public void clearText(By element) {
		driver.findElement(element).clear();
	}

	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void verifyDropDownContent(By locator, int index) {

		/*
		 * Select select = new Select(getElement(locator)); select.selectByIndex(index);
		 * WebElement loginFormBtn = driver.findElement(btn_login);
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", loginFormBtn);
		 */

	}

	public void elementVisible() {
		if (driver.findElement(By.cssSelector("a > font")).isDisplayed()) {
			Log.info("Element is Visible");
		} else {
			Log.info("Element is InVisible");
		}

	}

	public void dynamicWait(By element, int duration) {
		WebElement myDynamicElement = (new WebDriverWait(driver, duration))
				.until(ExpectedConditions.presenceOfElementLocated(element));

	}

	public void bringFocusToElement(WebElement element) {
		new Actions(driver).moveToElement(element).perform();
	}

	public void takeScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public void quit() {
		driver.quit();
	}
	
	public void close() {
		driver.close();
	}

	public void wait(int milisecond) throws InterruptedException {
		Thread.sleep(milisecond);
	}
}