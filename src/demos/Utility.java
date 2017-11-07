package demos;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class Utility 
     
{

	public static String captureScreenshot(WebDriver driver,String screenshotName)
	
	{
		// TODO Auto-generated method stub
		try
		{
	TakesScreenshot ts=(TakesScreenshot)driver;
	
	File source=ts.getScreenshotAs (OutputType.FILE);
	
	String dest= "c:\\Result\\"+ screenshotName +".png";

	File destination=new File(dest);
	
	FileUtils.copyFile(source,destination);
	System.out.println("Screenshot taken");
	return dest;
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot"+e.getMessage());
		return e.getLocalizedMessage();
		}
		}
	}
		
	
	


