package Smoketests;

import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PageTitleJunit {

    WebDriver driver;
    String webURL = "http://sdettraining.com/trguitransactions/AccountManagement.aspx";
    
    @Test
    
	public void pageTitleTest(){
		
	
		System.out.println("Running the test");
	
        driver.get(webURL);	
        String actualTitle = driver.getTitle();
        String expectedTitle = "SDET Training | Account Management"; 
        Assert.assertEquals(expectedTitle,actualTitle);
	}
    
	@Before
	public void setUP(){
	System.out.println("setting up the test"); 
	System.out.println("Initializing the driver");
	driver = utilities.DriverFactory.open("firefox");
}
    @After
    public void tearDown(){
    	System.out.println("Closing the test");
    driver.close();
    }
}
