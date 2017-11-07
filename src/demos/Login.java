package demos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
import org.testng.annotations.Test;
//import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


//import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	
	   ExtentReports report;//global variable
	   ExtentTest logger;//global variable
 	  WebDriver driver;//global variable
 	
 	  @Test
 	//  public void main(String[] args) throws IOException {
 	 public void login() throws IOException {
 	  
		 report = new ExtentReports("c:\\Result\\Login.html");
		 logger= report.startTest("Verify");
				
		 // initiate the driver
				WebDriver driver = utilities.DriverFactory.open("Chrome");
				driver.get("http://newtours.demoaut.com/index.php");
			   
				logger.log(LogStatus.INFO ,"Login Page");
				
				// login page
			
				driver.findElement(By.name("userName")).sendKeys ("rpheart@yahoo.com");	
				
				// Password
				
				driver.findElement(By.name("password")).sendKeys("london02");
				// submit
				
				driver.findElement(By.name("login")).click();
				logger.log(LogStatus.INFO ,"Username and Password Entered");
				
				//verify message
				
				
				String message = driver.findElement(By.cssSelector("body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > img:nth-child(1)")).getText();
				
				System.out.println("Confirmation :" + message);
				 
				 logger.log(LogStatus.PASS, " User Login Verified ");
				
				//Take Screenshot
				
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 	// Now you can do whatever you need to do with it, for example copy somewhere
				 	    FileUtils.copyFile(scrFile, new File("c:\\Result\\screenshot.png"));
				
				// close the browser
				
					driver.quit();
					
					

		}
	 
	 @AfterMethod
	 public void tearDown(ITestResult result)
	 {
	 if (result.getStatus()== ITestResult.FAILURE)
	 {
	String screenshot_path = Utility.captureScreenshot(driver, result.getName());
	logger.log(LogStatus.FAIL ,"Verification", screenshot_path);
	 
	}
	 report.endTest(logger);
	 report.flush();
	 
	 driver.get("c:\\Result\\Login.html");
	 }}



