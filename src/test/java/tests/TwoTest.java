package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.base;

public class TwoTest extends base{
	public  WebDriver driver;
	
	@Test
	public void  TwoTest() throws IOException, InterruptedException
	{
		System.out.println("Inside two test");
		
	 driver=intializeDriver();
	 driver.get("http://tutorialsninja.com/demo/");
	 Thread.sleep(2000);
	 driver.close();
	}

}
