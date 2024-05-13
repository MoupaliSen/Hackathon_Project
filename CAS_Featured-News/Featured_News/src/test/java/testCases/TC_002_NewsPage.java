package testCases;

import java.io.IOException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObjects.NewsPage;
import Utility.ScreenShots;
import testBase.BaseClass;
@Listeners(Utility.ExtentReportManager.class)

public class TC_002_NewsPage extends BaseClass {
	
	@Test
	public void newsPageValidation() throws InterruptedException, IOException
	{
		ScreenShots ss = new ScreenShots(driver);
		NewsPage nsp = new NewsPage(driver);
		int newssize = nsp.newsSize();
				
		for(int i=0;i<newssize-1;i++)
		{
			
			nsp.clickEachNews(i);
			ss.ScreenShot("News"+i);
			nsp.showNewsDetails();
			
		}
		
	
				
	
		
	}

}
