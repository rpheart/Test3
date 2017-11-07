package utilities;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentTest;


public class ExtentReport {

	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	
	@BeforeTest
	public void startTest(){
	
	reports = new ExtentReports();
	
	
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"//test-output//MyOwnReport.html");
			reports.attachReporter(htmlReporter);
				
			reports.setSystemInfo("Machine", "Rushang");
			reports.setSystemInfo("Browser", "chrome");
			
			
	}
				@Test
				public void failTest() {
					test = reports.createTest("failTest");
					System.out.println("This is my Fail test");
					Assert.assertTrue(false);
					test.pass("Second test failed");
				}
				
				@Test
				public void skipTest(){
			    test = reports.createTest("skipTest");
				System.out.println("This is my skip test");
				throw new SkipException("skip test forcefully");
				}
				 @AfterTest
				    public void tearDown()
				    {
				        
						reports.flush();
				    }
	}


