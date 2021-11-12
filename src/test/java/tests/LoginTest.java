package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Data.ExcelDataConfig;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import pageobjects.Myaccountpage;
import resources.base;

public class LoginTest extends base {

	WebDriver driver;
	Logger log ;

	@Test(dataProvider = "getLoginData")
	public void LoginTest(String username, String password, String exceptedresult) throws IOException {

		LandingPage landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		log.debug("myaccountdropdown button got clicked");
		landingPage.loginButton().click();
	    log.debug("login option got clicked");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.emailidfield().sendKeys(username);
		  log.debug("Username got entered");
		loginPage.passwordfield().sendKeys(password);
		  log.debug("passwordfield got entered");
		loginPage.loginicon().click();
		  log.debug("login icon  got clicked");
		Myaccountpage myaccountpage = new Myaccountpage(driver);
		String actualresult = null;
		// Assert.assertTrue(myaccountpage.accountOption().isDisplayed());
		try {

			if (myaccountpage.accountOption().isDisplayed()) {
				actualresult = "Successfull";
				
			}
		} catch (Exception e) {
			actualresult = "failure";

		}

		Assert.assertEquals(actualresult, exceptedresult);

	}

	@BeforeMethod
	public void openApplication() throws IOException {
		
	    log = LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDriver();
     
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to applicatiob url");
	}

	@AfterMethod
	public void closebrowser() {
		driver.close();
		log.debug("the browser got lauched");
	}

	@DataProvider
	public  Object[][] getLoginData() throws IOException  {
		
		ExcelDataConfig config=new ExcelDataConfig("C:\\Users\\saipa\\eclipse-workspace\\sampleAutomation\\ExcelData\\information.xlsx ");
		
	int rows = config.getRow(0);
	Object data [][] =new Object[rows][3];
	
	for(int i=0;i<rows;i++)
	{
	
		
	
		data[i][0]=config.getData(0, i, 0);
		data[i][1]=config.getData(0, i, 1);
		data[i][2]=config.getData(0, i, 2);
		
	}
	return data;
	
}
}