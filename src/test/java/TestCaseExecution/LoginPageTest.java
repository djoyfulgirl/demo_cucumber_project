package TestCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import BaseClass.BrowserSetupOne;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjectory.LoginPage;

public class LoginPageTest {
	WebDriver driver;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	LoginPage lp;
	
	
	@Given("^Launch the browser$")
	public void launch_the_browser() throws Throwable {
		fileInput = new FileInputStream(filepath);
	    prop = new Properties();
		prop.load(fileInput);
		driver= BrowserSetupOne.StartBrowser(prop.getProperty("browserName"), prop.getProperty("url"));
		lp = new LoginPage(driver);
		lp.pause(5000);
	}

	@When("^i click on sigin button$")
	public void i_click_on_sigin_button() throws Throwable {
		lp = new LoginPage(driver);
		lp.getSigninButton();
		lp.pause(5000);
	}
	
	@Then("^i enter  UserName \"([^\"]*)\"$")
	public void i_enter_UserName(String username) throws Throwable {
		lp.SetUserName(username);
	    lp.pause(5000);
	}

	@Then("^i click the continue button$")
	public void i_click_the_continue_button() throws Throwable {
		lp.getContinueButton();
		lp.pause(5000);
	}
	
	@Then("^i enter Password \"([^\"]*)\"$")
	public void i_enter_Password(String password) throws Throwable {
		lp.SetPassword(password);
		lp.pause(5000);
	}

	@Then("^i click the signin button$")
	public void i_click_the_signin_button() throws Throwable {
		lp.getLogininbutton();
		lp.pause(5000);
	}

	@Then("^i verify the title of the page$")
	public void i_verify_the_title_of_the_page() throws Throwable {
		String gettitle =driver.getTitle();
		System.out.println(gettitle);
		lp.pause(10000);
		Assert.assertEquals("Amazon", gettitle);
		   lp.pause(5000);
		driver.close();
	}
}