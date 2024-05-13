package testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObjects.BeCognizantPage;
import Utility.ScreenShots;
import testBase.BaseClass;
@Listeners(Utility.ExtentReportManager.class)


public class TC_001_BeCognizantPage extends BaseClass{
	
	@Test
	public void beCognizantValidation() throws InterruptedException, IOException
	{   
		//profile validation
		

		BeCognizantPage bcp = new BeCognizantPage(driver);
		bcp.ClickOnProfile();
		
		Thread.sleep(8000);

		
		ScreenShots ss = new ScreenShots(driver);
	

		String userName = bcp.userNameVisibility();
		Assert.assertEquals(userName,p.getProperty("uname"));
		ss.ScreenShot(userName);
		
		String userEmail = bcp.userEmailVisibility();
		Assert.assertEquals(userEmail, p.getProperty("uemail"));
		ss.ScreenShot(userEmail);
		
		//News Header and tool-tip validation
		bcp.newsHeaderVisibility();
		
		Thread.sleep(3000);
		
		
		
	}
	
		
	

}
