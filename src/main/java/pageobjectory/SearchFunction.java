package pageobjectory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFunction {

	WebDriver driver;

		public SearchFunction(WebDriver driver){
		     this.driver = driver;
		     PageFactory.initElements(driver, this);
		}


		@FindBy(xpath="//input[@id='twotabsearchtextbox']")
		private WebElement SearchBox;

		@FindBy(id= "nav-search-submit-button"  )
		private WebElement SearchButton;    


		public void SearchFor(String SearchTerm)   
		{
		    SearchBox.sendKeys(SearchTerm);
		}   
	
		public void SearchButton()  
		{
			SearchButton.click();
		}
		
		
	
		public void pause(Integer milliseconds) {
			try {
				TimeUnit.MILLISECONDS.sleep(milliseconds);
			} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		}
}
		
	
