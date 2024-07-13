package StepDefinitions;

import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
          // attaching Feature files with StepDefinition package
		features = "src/test/resources/Features",

		glue = { "StepDefinitions" }, monochrome = true,
		
				//tags="@3Shools",
				//tags = "@ExTestWithTable",
		
		plugin = { "pretty" })

public class TestRunner extends AbstractTestNGCucumberTests {
	

	@Override
	@DataProvider(parallel = true)  //Choose to run parallel tests flag
	public Object[][] scenarios() {
		return super.scenarios();

	}
	
	
}
