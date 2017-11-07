package Testcases;

import objectrepository.RediffHomepage;
import objectrepository.RediffLoginpage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import demos.Utility;

public class Loginapplication {
    
	
	 
	  ExtentReports report;//global variable
	  ExtentTest logger;//global variable
 	  WebDriver driver;//global variable
	public Loginapplication() {
    }

    @Test
    public void Login() throws IOException {
    	
    	report = new ExtentReports("c:\\Result\\POM.html");
    		        logger= report.startTest("Test1RegisterVerify");
    		        
    	//open the browser
        System.setProperty("webdriver.chrome.driver", "C:\\Ghecko\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.manage().window().maximize();
    	logger.log(LogStatus.INFO ,"Application running");
        
         //Go to rediff login page
        
        RediffLoginpage rd = new RediffLoginpage(driver);
        rd.Emaild().sendKeys(new CharSequence[]{"hello"});
        rd.Password().sendKeys(new CharSequence[]{"hello"});
        rd.Home().click();
    	logger.log(LogStatus.INFO ,"Username and Password");
    	
      
        //Go to Rediff Home page
        RediffHomepage rh = new RediffHomepage(driver);
    	logger.log(LogStatus.INFO ,"Homepage");
        rh.Search().sendKeys(new CharSequence[]{"rediff"});
        rh.Submit().click();
		logger.log(LogStatus.PASS, "Cannot find the search result ");
        
       // confirm message
      //verify message
	//	String message = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")).getText();
		
	//	System.out.println("Confirmation :" + message);
		 
		// logger.log(LogStatus.PASS, " Verified ");
		
		//Take Screenshot
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 	// Now you can do whatever you need to do with it, for example copy somewhere
		 	    FileUtils.copyFile(scrFile, new File("c:\\Result\\pageobjectmodel.png"));
        
        driver.close();
            
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
	 
	 driver.get("c:\\Result\\POM.html");
	 }}



