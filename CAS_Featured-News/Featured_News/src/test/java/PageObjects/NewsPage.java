package PageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelUtils;




public class NewsPage extends BasePage {


	//Constructor
	public NewsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//elements
	
	//@FindBy(xpath="//a[normalize-space() ='One year of Bluebolt: Advancing our spirit of innovation']")
	
	//click on each news
	@FindBy(xpath="//a[@id='news_text_title']")
    List<WebElement> eachNews;
	
	//News-Header
	@FindBy(xpath="//div[@id='title_text']")
	WebElement txt_heading;
	
	//News-Heading-Details
	@FindBy(xpath="//div[@data-automation-id='textBox']")
	WebElement txt_headingDetails;
	
	
	//Associate details hover
	@FindBy(xpath="//div[@aria-haspopup='dialog']")
	WebElement associateDetails;
	
	Actions action = new Actions(driver);
	
	//HyperLink
	@FindBy(tagName="a")
    List<WebElement> hyperlink;
	
	//Share-Button
	@FindBy(xpath="//button[@data-automation-id='shareButton']")
	WebElement sharebtn;
	
	//Share-Option
	@FindBy(xpath="//span[text()='Share page']/ancestor::ul")
	WebElement shareOptions;
	
	//Scroll-Body
	@FindBy(xpath="//div[@class='fw_aa_9f38462c fw_ap_9f38462c mx_ap_9f38462c']")
	WebElement scrollbody;
	
	//likes and views
	@FindBy(xpath="//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[1]/button/span/span/span")
	WebElement totalLikes;
	
	@FindBy(xpath="//*[@id='vpc_Page.CommentsWrapper.internal.2610b4b4-550c-4548-b431-aa3ab709c184']/div/div/aside/div[4]/button/span/span/span")
	WebElement totalViews;
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@FindBy(xpath="//span[text()='be.cognizant']")
	WebElement becognizant;
	
	
	
	//Actions
	//click each news
	public void clickEachNews(int newsno) throws IOException
	{
		eachNews.get(newsno).click();
		ExcelUtils excel = new ExcelUtils();
		String xlFile = System.getProperty("user.dir")+"\\testData\\testExcel.xlsx";
		
		for(int j=0;j<eachNews.size();j++)
			{
			excel.setCellData(xlFile, "Sheet1", j+1, 0,txt_heading.getText());
			
			}

		
	}
	public void showNewsDetails() throws InterruptedException, IOException
	{
		//news header
		System.out.println("Heading:  "+txt_heading.getText());
		
		System.out.println("Details:   "+txt_headingDetails.getText());
		
		//associate details
        action.moveToElement(associateDetails).perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-haspopup='dialog']")));
        
        //validation of hyperlink
        for(WebElement link:hyperlink)
        {
        	String url = link.getAttribute("href");
        	
        	if(url== null || url.isEmpty())
        	{
        		System.out.println(url);
        		System.out.println("url is empty");
        		
        	}
        	else
        	{
        		System.out.println(url);
        		System.out.println("url is not empty");
        	}
        }
        //check share button is click-able or not
        sharebtn.click();
        //Thread.sleep(2000);
        
        //check share options is visible or not
        System.out.println(shareOptions.getText());

        //check likes and views
        WebElement ele = driver.findElement(By.xpath("//*[@id='CommentsWrapper']"));
		jse.executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(3000);
 
		System.out.println("Number of Likes: " + totalLikes.getText().split(" ")[0]);
		System.out.println("Number of Views : " + totalViews.getText().split(" ")[0]);
		System.out.println();
		
		
		Thread.sleep(2000);
		becognizant.click();
        //driver.navigate().back();
		Thread.sleep(2000);

 }
	//count no of News pages
	public int newsSize()
	{
		return eachNews.size();
	}

	
	public String getTxtHeading()
	{
		return txt_heading.getText();
	}
	//Get back to previous News page
	public void getBack()
	{
        driver.navigate().back();

	}
    
 }
