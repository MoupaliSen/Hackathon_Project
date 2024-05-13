package com.cognizant.enquiry_building_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class EnquiryBuilding {
	public static WebDriver driver;
	public static void handlePopups() {
		if(driver.findElement(By.xpath("//div[@class='dialog-message dialog-lightbox-message']")).isDisplayed()) {
		    
			driver.findElement(By.xpath("//a[@class='dialog-close-button dialog-lightbox-close-button']/i")).click();
			}	
		if(driver.findElement(By.xpath("//a[@class='lp-live-button']")).isDisplayed()) {
			driver.findElement(By.xpath("//a[@class='lp-live-button']")).click();
			driver.findElement(By.xpath("//a[@class='livprop_close']")).click();

			}
		else
			{
			driver.findElement(By.xpath("//a[@class='livprop_close']")).click();

			}
		
	}
	

	public static void main(String[] args) throws InterruptedException, IOException {
			// TODO Auto-generated method stub
		
		
			System.setProperty("webdriver.edge.driver","C:\\Users\\2317616\\Mini_Project\\Enquiry_Building_Project\\Browsers\\msedgedriver.exe");
			driver=new EdgeDriver();
			
			driver.get("https://ishahomes.com");
			//Handle any popups and the live chat that may appear

			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
			handlePopups();
			
			//Maximize the browser 
			driver.manage().window().maximize();
			
		
		 	//Navigate to the “Completed Projects” page by clicking on “Completed Projects” menu link.
			driver.findElement(By.xpath("//li[@id='menu-item-25810']//a[normalize-space()='Completed Projects'][@class='nav-link ']")).click();
			handlePopups();
		   //It displays all the projects completed by Isha’s homes company.
			//Scroll down and count total number of completed projects and print it to console.
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
			Thread.sleep(3000);
			js.executeScript("window.scrollBy(0,500)", "");
			
	        LinkedHashSet<String> set = new LinkedHashSet<String>(); 
	        
	        
			List<WebElement> a = driver.findElements(By.xpath("//h2[@class='item-title']"));
			for(WebElement e:a)
			{
				
				set.add(e.getText());
			}
			System.out.println("Number of Completed Projects: "+ set.size());
			//Display the names of first five completed projects to the console

			List<String> listOfProjects = new ArrayList<String>(set);

			for(int i=0;i<5;i++)
			{
				
				System.out.println(listOfProjects.get(i));
			}
			//Scroll down
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			
			//Verify if “Contact Us” text is displayed on the page
		   	driver.findElement(By.xpath("//span[normalize-space()='Contact Us']")).click();
		   	WebElement contact =driver.findElement(By.xpath("//h1[@class='elementor-heading-title elementor-size-default']"));
		   	if(contact.isDisplayed())
		   	{
		   		System.out.println("The 'Contact Us' message is displayed");
		   		
		   	}
		   	//click on “Enquire Now” button
		   	driver.findElement(By.xpath("//div[@class='mci-ph enq-tooltip-new']")).click();

		   	//Read and display the email address for contact to console
		   	driver.findElement(By.xpath("//li[@class='elementor-icon-list-item']//a[normalize-space()='Other Enquiry']")).click();
		   	WebElement display = driver.findElement(By.xpath("//div[@class='cont-pop']//a"));
		   
		   	if(display.isDisplayed()) {
		   		System.out.println("The displayed Email Id is: "+display.getText());
		   	}
		   	else
		   	{
			   	System.out.println("Email Id not displayed");

		   	}
		   	//take screenshots
		   	TakesScreenshot ts = (TakesScreenshot) driver;
			File src =ts.getScreenshotAs(OutputType.FILE);
			File targetlocation = new File("C:\\Users\\2317616\\OneDrive - Cognizant\\Desktop\\Screenshots\\page.png");
			
			FileHandler.copy(src, targetlocation);
			
		   	Thread.sleep(5000);
		   	driver.quit();
	}

}
