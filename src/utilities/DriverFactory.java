package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverFactory {

	public static WebDriver open (String browserType) {
		if (browserType.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Ghecko\\geckodriver.exe");
		return new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
			return new ChromeDriver();
	}
	else {
		
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer.exe");
		return new InternetExplorerDriver();
		
}}}
