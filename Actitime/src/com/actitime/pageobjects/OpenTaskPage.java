package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class OpenTaskPage {
	
	SeleniumLib slib;
	@FindBy(linkText="Projects & Customers")
	private WebElement Projncust;
	
	public OpenTaskPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickonProjCustLink()
	{
		slib.clickElement(Projncust);
	}
	
	

}



