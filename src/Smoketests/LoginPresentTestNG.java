package Smoketests;


//import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPresentTestNG {

    WebDriver driver;
	
     @Test
	public void loginElementPresentTest(){
		System.out.println("Running the test");
			
	
	boolean loginEmailBox = driver.findElement(By.id("MainContent_txtUserName")).isDisplayed();
	boolean passwordBox = driver.findElement(By.id("MainContent_txtPassword")).isDisplayed();

	Assert.assertTrue(loginEmailBox);
	Assert.assertTrue(passwordBox);
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
