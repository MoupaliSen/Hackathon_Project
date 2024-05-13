package testCases;

import org.testng.annotations.Test;

import pageObjects.GiftCardsPage;
import testBase.BaseClass;

public class TC_003_GiftCardsPage extends BaseClass{
	
	
		GiftCardsPage gcp;
		
		@Test(priority=8)
		public void choosegiftcard() throws InterruptedException {
			gcp=new GiftCardsPage(driver);
			gcp.clickGiftCard();
			gcp.clickBirthdayORAnniversary();
			
		}
		
		@Test(priority=9)
		public void entergiftcarddetails() {
			gcp=new GiftCardsPage(driver);
			gcp.entercarddetails(p.getProperty("Amount"));
			gcp.clickonNextBtn();
		}
		
		@Test(priority=10)
		public void filladdressform() throws InterruptedException  {
			gcp=new GiftCardsPage(driver);
			gcp.addressform(p.getProperty("Receipent_Name"),p.getProperty("Receipent_Email_invalid"),p.getProperty("Receipent_mobile"), p.getProperty("Customer_Name"),p.getProperty("Customer_Email"),p.getProperty("Customer_mobile"),p.getProperty("Address"),p.getProperty("Pincode"));
			Thread.sleep(3000);
			gcp.captureerrormessage();
			gcp.addressform2(p.getProperty("Receipent_Email_valid"));
			
		}
		
	}


