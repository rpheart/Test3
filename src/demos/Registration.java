package demos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import java.io.File;
//import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import org.apache.commons.io.FileUtils;


public class Registration {
      
	  ExtentReports report;//global variable
	  ExtentTest logger;//global variable
 	  WebDriver driver;//global variable
	
 	  @Test
 	 // public static void main(String[] args) {
		public void registerVerify() throws IOException {
				
				report = new ExtentReports("c:\\Result\\Registration.html");
 		        logger= report.startTest("Test1RegisterVerify");
 		     //open the browser
 		        
 		        String browserType= "chrome";
 			
				
							
						    		
				//Navigate to the webapplication
 		        
			    driver = utilities.DriverFactory.open(browserType);
				driver.get("http://newtours.demoaut.com/");
				driver.manage().window().maximize();
				logger.log(LogStatus.INFO ,"Application running");
				
				//username
				driver.findElement(By.name("userName")).sendKeys ("rpheart");	
				//Password
				driver.findElement(By.name("password")).sendKeys("london02");
				driver.findElement(By.name("login")).click();
				logger.log(LogStatus.INFO ,"Username and Password Not valid");
				//registration form
				driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p/font/a")).click();
				driver.findElement(By.name("firstName")).sendKeys("rahul");
				driver.findElement(By.name("lastName")).sendKeys("shah");
				driver.findElement(By.name("phone")).sendKeys("9876678767");
				driver.findElement(By.name("userName")).sendKeys("rpheart@yahoo.com");
				driver.findElement(By.name("address1")).sendKeys("15, raj bhavan ");
				driver.findElement(By.name("city")).sendKeys("ahmedabad");
				WebElement dropdown=driver.findElement(By.name("country"));
				dropdown.click();
				//WebElement dropdown=driver.findElement(By.name("country"));
				//Select drpCountry = new Select(driver.findElement(By.name("country")));
				//drpCountry.selectByVisibleText("ANTARCTICA");
//				WebElement element = driver.findElement(By.name("Country"));
//				Select oSelect = new Select(element);
//				oSelect.selectByVisibleText("India");
//				Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select")));
//				//Select dropdown = new Select(driver.findElement(By.id("country")));
//				dropdown.selectByVisibleText("India");
//				Select select = new Select(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select")));
//				select.deselectAll();
//				select.selectByVisibleText("India");
				
				driver.findElement(By.name("email")).sendKeys ("rpheart@yahoo.com");	
				//Password
				driver.findElement(By.name("password")).sendKeys("london02");
				
				driver.findElement(By.name("confirmPassword")).sendKeys("london02");
				driver.findElement(By.name("register")).click();
				//confirm the registration
				String message = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText();
			 System.out.println("Confirmation :" + message);
			 
			 logger.log(LogStatus.PASS, " Registration Verified ");
 	  
 	  
 	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	// Now you can do whatever you need to do with it, for example copy somewhere
 	    FileUtils.copyFile(scrFile, new File("c:\\Result\\screenshot1.png"));
 	  }
		/*	// take screenshot
			 File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			 try { 
			 FileUtils.copyFile(src, new File("c:\\Result\\screenshot.png"));
			 } catch (IOException e) 
			 {
			  
			  e.printStackTrace();
			 }		 */
			 
			 
			 @AfterMethod
			 public void tearDown(ITestResult result)
			 {
			 if (result.getStatus()== ITestResult.FAILURE)
			 {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL ,"Registration Verification", screenshot_path);
			 
			}
			 report.endTest(logger);
			 report.flush();
			 
			 driver.get("c:\\Result\\Registration.html");
			 }}
	
	
						

		
