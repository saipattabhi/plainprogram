package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.base;



public class FourTest extends base {
	public WebDriver driver;
	@Test
	public void FourTest() throws IOException, InterruptedException
	{
		
		System.out.println("Inside four test");
		
     driver=	intializeDriver();
     
     driver.get("http://tutorialsninja.com/demo/");
     Thread.sleep(3000);
   Assert.assertTrue(false);
	}
	@AfterMethod
	public void closure()
	{
		driver.close();
	}

}
