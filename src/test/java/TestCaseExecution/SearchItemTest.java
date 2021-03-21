package TestCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetupOne;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectory.LoginPage;
import pageobjectory.SearchFunction;

public class SearchItemTest {
	
	WebDriver driver;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	SearchFunction sf;
	LoginPage lp;
	

	@Given("^i Launch the browser$")
	public void i_Launch_the_browser() throws Throwable {
		fileInput = new FileInputStream(filepath);
	    prop = new Properties();
		prop.load(fileInput);
		driver= BrowserSetupOne.StartBrowser(prop.getProperty("browserName"), prop.getProperty("url"));
		  lp= new LoginPage(driver);
		  lp.loginToPage();
		   lp.pause(5000);
		
	    
	}

	@When("^i entered the searchitem  \"([^\"]*)\"$")
	public void i_entered_the_searchitem(String searchitem) throws Throwable {
		sf = new SearchFunction(driver);
		sf.pause(10000);
		   sf.SearchFor(searchitem);
		   sf.pause(5000);
	    
	}

	@Then("^i click the search icon$")
	public void i_click_the_search_icon() throws Throwable {
	   sf.SearchButton();
	   sf.pause(5000);
	}

	@Then("^i verify the page$")
	public void i_verify_the_page() throws Throwable {
		String gettitle =driver.getTitle();
		System.out.println(gettitle);
		sf.pause(5000);
		driver.close();
	}	
	
	
	
	
	
	
}
