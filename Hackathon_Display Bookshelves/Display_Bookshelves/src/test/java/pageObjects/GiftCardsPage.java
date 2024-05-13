package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardsPage extends BasePage {

	public GiftCardsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Elements
	
	@FindBy(xpath="//a[text()=' Gift Cards ']")
	WebElement giftCard;
	
	@FindBy(xpath="//ul[@class='_2sedU']/li[3]")
	WebElement birthdayORanniversary;
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@FindBy(xpath="//input[@placeholder='Amount']")
	public WebElement Amount;

	@FindBy(xpath="//div[@class='_3PNvG']/select[2]")
	public WebElement date_dropdown;
	
	@FindBy(xpath="//button[text()='Next']")
	public WebElement NextBtn;
	
	@FindBy(xpath="//input[@name='recipient_name']")
	public WebElement Receipent_Name;
	
	@FindBy(xpath="//input[@name='recipient_email']")
	public WebElement Receipent_Email;
	
	@FindBy(xpath="//input[@name='recipient_mobile_number']")
	public WebElement Receipent_Mobile;
	
	@FindBy(xpath="//input[@name='customer_name']")
	public WebElement Customer_Name;
	
	@FindBy(xpath="//input[@name='customer_email']")
	public WebElement Customer_Email;
	
	@FindBy(xpath="//input[@name='customer_mobile_number']")
	public WebElement Customer_mobile;
	
	@FindBy(xpath="//input[@name='customer_address']")
	public WebElement Customer_address;
	
	@FindBy(xpath="//input[@name='zip']")
	public WebElement Customer_pincode;
	
	@FindBy(xpath="//button[@type='submit' and text()='Confirm']")
	public WebElement ConfirmBtn;
	


	
	//Actions
	
	public void clickGiftCard()
	{
		giftCard.click();
	}
	
	public void clickBirthdayORAnniversary() throws InterruptedException
	{
        WebElement ele = driver.findElement(By.xpath("//ul[@class='_2sedU']/li[3]"));
		jse.executeScript("arguments[0].scrollIntoView();", ele);
		ele.click();
		Thread.sleep(5000);
		
		
	}
	
	public void entercarddetails(String amt) {
		Amount.sendKeys(amt);
	}
	public void clickonNextBtn()
	{
		NextBtn.click();
	}
	public void addressform(String rec_name,String rec_email,String rec_mobile,String yr_name,String yr_email,
			String yr_mobile,String address,String pin) throws InterruptedException {
		//ts=new Takescreenshot(driver);
		Receipent_Name.sendKeys(rec_name);
		Receipent_Email.sendKeys(rec_email);
		Receipent_Mobile.sendKeys(rec_mobile);
		Customer_Name.sendKeys(yr_name);
		Customer_Email.sendKeys(yr_email);
		Customer_mobile.sendKeys(yr_mobile);
		Customer_address.sendKeys(address);
		Customer_pincode.sendKeys(pin);
		Thread.sleep(3000);
		//ts.ScreenShot("AddressForm");
		ConfirmBtn.click();
	}
	public void addressform2(String rec_email) {
		Receipent_Email.clear();
		Receipent_Email.sendKeys(rec_email);
		ConfirmBtn.click();
	}
	public void captureerrormessage() {
		//ts=new Takescreenshot(driver);
		//ts.ScreenShot("Errormessage");
		String error=Receipent_Email.getAttribute("validationMessage");
		//ExcelUtils.setCellData(xfile,"Sheet3", 1, 0,error);
		System.out.println(error);
	}



}
