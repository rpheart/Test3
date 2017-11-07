package utilities;


	
	import java.io.FileReader;
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import com.opencsv.CSVReader;

	public class CSV{

	 //Provide CSV file path. It Is In D: Drive.
		
	 String CSV_PATH="C:\\CSV\\Detail.csv";
	 WebDriver driver;

	 
	 @BeforeTest
	 public void setup() throws Exception {
	  //driver = new FirefoxDriver();
	  
		 WebDriver driver = utilities.DriverFactory.open("chrome");
		 driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("http://only-testing-blog.blogspot.in/2014/05/form.html");
	 }
	 
	 @Test
	 
	 public void csvRead() throws IOException{
	  
	 // @SuppressWarnings("resource")
	  
	  CSVReader read = new CSVReader(new FileReader(CSV_PATH));
	  String [] csvCell;
	  //while loop will be executed till the last line In CSV.
	  while ((csvCell = read.readNext()) != null) {   
	   String FName = csvCell[0];
	   String LName = csvCell[1];
	   String Email = csvCell[2];
	   String Mob = csvCell[3];
	   String company = csvCell[4];
	   driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
	   driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
	   driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
	   driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(Mob);
	   driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(company);
	   driver.findElement(By.xpath("//input[@value='Submit']")).click();
	   driver.switchTo().alert().accept();
	  }  
	 }
	
	{

		
	}}

	
	
