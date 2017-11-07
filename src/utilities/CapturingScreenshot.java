package utilities;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CapturingScreenshot {

	ExtentReports extent;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void init()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/testoutput/ExtentScreenshot.html");
				
	}
@Test
public void capturescreenshot(){
	test = extent.startTest("capturescreenshot");
	driver = new FirefoxDriver();
	driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
	String title =  driver.getTitle();
	Assert.assertEquals("Login or Create an Account", title);
	test.log(LogStatus.PASS,"Test passed as titles are equals");
}
		
@AfterMethod
public void getResult(ITestResult result) throws IOException {
	
if (result.getStatus()== ITestResult.FAILURE)
{
String screenshotPath = GetScreenshot.capture(driver, "screenshotForExtentReport");
test.log(LogStatus.FAIL, result.getThrowable());
test.log(LogStatus.FAIL, "screenshot below :" + test.addScreenCapture(screenshotPath));
}
extent.endTest(test);
}
@AfterTest
public void endReport()
{
	
	driver.close();
	extent.flush();
	extent.close();
}
}

