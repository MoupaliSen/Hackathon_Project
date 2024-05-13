package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeCognizantPage extends BasePage{
	
	//Constructor
		public BeCognizantPage(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
		}
		
	//Elements
		//profile
		@FindBy(id="O365_MainLink_MePhoto")
		WebElement imgtag;


		
		//User-name element
		@FindBy(xpath = "//div[@class='mectrl_dropdownbody expanded']//div[@class = 'mectrl_name mectrl_truncate']")
		WebElement txt_userName;
		
		//Email element
		@FindBy(xpath = "//div[@class='mectrl_dropdownbody expanded']//div[@class = 'mectrl_truncate']")
		WebElement txt_userEmail;
		
		//news header 
		@FindBy(xpath="//div[@class='z_a_91bed31b l_a_91bed31b']//a[@data-automation-id='newsItemTitle']")
		List<WebElement> list_news;
		
		
		
	//Actions
		
		//click On User-Info-button
		public void ClickOnProfile() throws InterruptedException
		{
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement user= wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("O365_MainLink_MePhoto"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id='O365_MainLink_Settings']/div"))));
			Thread.sleep(2000);
			imgtag.click();
			imgtag.click();

			//imgtag.click();

		}
		
		//check user-name is visible or not
		public String userNameVisibility()
		{
			try {
				String userName = txt_userName.getText();
				System.out.println("Username:" +userName);
				return userName;

			}
			catch(Exception e)
			{
				return(e.getMessage());
			}
		}
		//check user-Email is visible or not
		public String userEmailVisibility()
		{
			try {
				String userEmail = txt_userEmail.getText();
				System.out.println("Useremail:" +userEmail);

				return userEmail;
			}
			catch(Exception e)
			{
				return(e.getMessage());
			}
		}
		//check news header & tool-tip
		public void newsHeaderVisibility()
		{
//			System.out.println("News Headline"+"          "+"Tool-tip");
			for(WebElement e:list_news)
			{
				System.out.println("News Headline: "+e.getText());
				System.out.println("Tooltip: "+e.getAttribute("title"));

				
			}
					
		}
		
		
}
