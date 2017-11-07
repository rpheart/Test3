package Junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	public class Expedia {

		WebDriver driver;
		String browserType = "chrome";
		String city = " New York, NY ";
		String checkIn = "10/10/2017";
		String checkOut = "10/30/2017";
		String numOfHotel = "1";
		String numOfChild = "1";
		String numOfAdult = "2";
		
		@Test
		public void hotelReservation(){
			//1. Search
			
			driver.findElement(By.id("tab-hotel-tab-hp")).click();
			driver.findElement(By.id("hotel-destination-hp-hotel")).clear();
			driver.findElement(By.id("hotel-destination-hp-hotel")).sendKeys(city);
			driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
			driver.findElement(By.id("hotel-checkin-hp-hotel")).sendKeys(checkIn);
			driver.findElement(By.id("hotel-checkin-hp-hotel")).clear();
			driver.findElement(By.id("hotel-checkout-hp-hotel")).sendKeys(checkOut);
     		
			new Select (driver.findElement(By.xpath ("rooms"))).selectByValue(numOfHotel);
     		
     		new Select (driver.findElement(By.id ("hotel-1-adults-hp-hotel"))).selectByValue(numOfAdult);
     		
     		new Select (driver.findElement(By.id ("hotel-1-children-hp-hotel"))).selectByValue(numOfChild);
     		
            driver.findElement(By.xpath("//*[@id=\"gcw-hotel-form-hp-hotel\"]/div[9]/label/button")).click();
//			
			//2. modify the result page, give criteria
//			driver.findElement(By.cssSelector("input [name='star'][value='star 4']")).click();
//			//3. book reservation
			
			//4. fill out contact // billing
			//5. Get Confirmation
			
		}
		@BeforeMethod
		public void setUp(){
	    driver = utilities.DriverFactory.open(browserType);
	    driver.get("https://www.expedia.co.uk");
		}
		
	@AfterMethod
public void tearDown(){
			driver.quit();
	}}