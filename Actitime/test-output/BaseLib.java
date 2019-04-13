package com.actitime.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.actitime.generic.DriverFactory;

public abstract class BaseLib {
	
	public static WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser","baseurl"})
	public void preCondition(String browserName, String url)
	{
		driver=DriverFactory.launch(browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
	}
	
/*	@AfterMethod
	public void postCondition()
	{
		driver.close();
		if(driver!=null)
		{
			driver.quit();
		}
	}
	*/

}
