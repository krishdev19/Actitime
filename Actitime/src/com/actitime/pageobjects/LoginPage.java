package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.SeleniumLib;

public class LoginPage {
	
	SeleniumLib slib;
	
	@FindBy(name="username")
	private WebElement unTxtbx;
	@FindBy(name="pwd")
	private WebElement pwdTxtBX;
	@FindBy(id="loginButton")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		
		slib=new SeleniumLib(driver);
		
		PageFactory.initElements(driver, this);
		
	}
	
	//Feature
	
	public void login(String username, String password)
	{
	
		slib.enterData(unTxtbx, username);
		slib.enterData(pwdTxtBX, password);
		slib.clickElement(loginBtn);
	}

}
