package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookShelves extends BasePage{

	public BookShelves(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//elements
	@FindBy(xpath="//input[@id='search']")
	public WebElement searchbar;
	
	@FindBy(xpath="//button[@id='search_button']")
	public WebElement searchbtn;

	public void Search(String key) {
		//ts=new Takescreenshot(driver);
		searchbar.sendKeys(key);
		//ts.ScreenShot("HomePage");
		searchbtn.click();
	}
	
	


}
