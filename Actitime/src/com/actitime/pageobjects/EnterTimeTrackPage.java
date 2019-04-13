package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class EnterTimeTrackPage extends BasePage {
	
	SeleniumLib slib;
	
	@FindBy(xpath="(//td[@class='pagetitle'])[2]")
	private WebElement pageTitle;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
		super(driver);
		slib = new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void verifyHomePage()
	{
		String expText ="Enter Time-Track";
		String actText = pageTitle.getText();
		slib.validateString(actText, expText, "Passed");
		
		String expTitle = "actiTIME - Enter Time-Track";
		slib.validateTitle(expTitle, "verified");
		
	}

}
