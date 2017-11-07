package Smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
  
	  WebDriver driver;
		
	     @Test
		public void loginElementPresentTest(){
			System.out.println("Running the test");
				boolean createAccountPresent = false;
				
			//We want to test the presence of A tags >> hyperlinks
		List<WebElement> aElements = driver.findElements(By.tagName("a"));
		
		int numberofAElements = aElements.size ();
		System.out.println(" There are " + numberofAElements + "a tag on the page");
		
		
		for (WebElement aElement : aElements){
			System.out.println(aElement.getText());
			if (aElement.getText().equals (" CREATE ACCOUNT ")){
				createAccountPresent = true;
				break;
		}
//		boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
//		boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();
//
//		Assert.assertTrue(loginEmailBox);
//		Assert.assertTrue(passwordBox);
		}
		//Assertion
	     Assert.assertTrue(!createAccountPresent);
	     }
		@BeforeMethod
		public void setUP(){
			System.out.println("Starting test");
			String webUrl = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
		    driver = utilities.DriverFactory.open("chrome");
			driver.get(webUrl);
		}
		
		 @AfterMethod
		    public void tearDown(){
		    	System.out.println("Closing test");
		    	driver.close();
		    }}
