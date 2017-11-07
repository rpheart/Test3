package Smoketests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.DashboardPage;
import pages.LoginPage;




public class Login {

	
	@Test
	public void loginTestPOM() throws IOException{
		
		//Initialization of bowser
		
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		//driver.manage().window().maximize();
		
		//Enter login Information (Login Page)
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setUsername("rpheart@yahoo.com");
		loginpage.setPassword("london02");
		loginpage.clickSubmit();
		//Get Confirmation (Dashboard Page)
		DashboardPage dashboardpage = new DashboardPage(driver);
		String conf = dashboardpage.confirmationMessage();
		loginpage.setPassword("london02");
		String title = dashboardpage.title();
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	// Now you can do whatever you need to do with it, for example copy somewhere
		 	    FileUtils.copyFile(scrFile, new File("c:\\Result\\screenshot.png"));
		//System.out.println(conf);
		
		//Assertion
		//Assert.assertTrue(conf.contains("Success"));
		//Assert.assertTrue(conf.contains("Account"));
		
		//close the driver
		driver.quit();
	}
	
		
				
	
}
