package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private   WebElement emailidfield;
	@FindBy(id = "input-password")
	private   WebElement passwordfield;
	@FindBy(css = "input[value='Login']")
	   private WebElement loginicon;
	
	public WebElement  emailidfield()
	{
		return  emailidfield;
	}
	public  WebElement passwordfield()
	{
		return passwordfield;
	}
	public WebElement loginicon()
	{
		return loginicon;
	}
	
}
