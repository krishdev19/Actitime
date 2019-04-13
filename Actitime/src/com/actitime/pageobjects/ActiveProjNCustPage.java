package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class ActiveProjNCustPage extends BasePage {
	
	SeleniumLib slib;
	@FindBy(css="input[value='Create New Customer']")
	private WebElement CreateNewCust;
	@FindBy(xpath="//span[@class='successmsg']")
	private WebElement succmsg;
	@FindBy(name="selectedCustomer")
	
	private WebElement CustomerDrpDown;
	
	@FindBy(css="input[value*='show']")
	
	private WebElement showBtn;
	
	public ActiveProjNCustPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	public void clickoncreatenewcust()
	{
		slib.clickElement(CreateNewCust);
	}
	public void verifyCreateNewCustomer(String customerName)
	{
		String expMsg="Customer \""+customerName+"\" has been successfully created.";
		String actMsg=succmsg.getText();
		slib.validateString(actMsg, expMsg, expMsg);
	}
	
	
	public void showCustomer(String customerName){
		
		slib.selectOptionByText(CustomerDrpDown, customerName);
		
		slib.clickElement(showBtn);
	}
	
	
}

