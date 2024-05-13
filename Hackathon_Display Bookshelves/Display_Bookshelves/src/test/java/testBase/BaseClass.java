package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import freemarker.log.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Properties p;
	public int choice;
	public Logger logger;
	Scanner sc;
	@BeforeTest
	public void setup() throws IOException
	{
				//loading properties file
				FileReader file = new FileReader(".//src//test//resources//config.properties");
				p = new Properties();
				p.load(file);
			
				
				
			    sc = new Scanner(System.in);
			    
			    //choosing browser
				System.out.println("Press 1 : Chrome ");
				System.out.println("Press 2 : Edge ");
				System.out.println("Press 3 : Exit ");
				choice = sc.nextInt();
				//Switch Case to Choose the browser
				switch(choice) {
				case 1: 
					driver = new ChromeDriver();     //  Launch Chrome
					break;
				case 2:
					driver = new EdgeDriver();		 // Launch Edge 
					break;
				case 3:
					System.out.println("Program Closed");
					System.exit(0);
					break;
				default:
					System.out.println("Please Select the correct choice");
					System.exit(0);
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.manage().window().maximize();
				driver.get(p.getProperty("appURL"));
				
	}
	
	//Quit the browser
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
