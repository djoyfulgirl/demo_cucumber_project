package pageobjectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	
	
	public LoginPage(WebDriver driver){
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body[1]/div[1]/header[1]/div[1]/div[1]/div[3]/div[1]/a[2]/div[1]")
	private WebElement SigninButton;
	
	@FindBy(id="ap_email")
	private WebElement UserName;
	
	@FindBy(id="continue")
	private WebElement Continuebutton;
	
	@FindBy(id="ap_password")
	private WebElement Password;
	
	@FindBy(id="signInSubmit")
	private WebElement Logininbutton;
	

	
	public void getSigninButton(){
		SigninButton.click();
	}
	
	public void SetUserName(String username){
		UserName.sendKeys(username);
	}
	
	public void getContinueButton(){
		Continuebutton.click();
	}
	
	public void SetPassword(String password){
		Password.sendKeys(password);
	}
	
	public void getLogininbutton(){
		Logininbutton.click();
	}
	

	public void loginToPage() throws IOException, InterruptedException{
		fileInput = new FileInputStream(filepath);
	    prop = new Properties();
		prop.load(fileInput);
		getSigninButton();
		Thread.sleep(2000);
		SetUserName(prop.getProperty("UserName"));
		Thread.sleep(2000);
		getContinueButton();
		Thread.sleep(2000);
		SetPassword(prop.getProperty("Password"));
		Thread.sleep(2000);
		getLogininbutton();
		Thread.sleep(2000);
	}

	public void pause(Integer milliseconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(milliseconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
