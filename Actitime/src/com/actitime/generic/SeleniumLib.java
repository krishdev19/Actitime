package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib {
	WebDriver driver;
	
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
	}
	/***********enterData**********/
	public void enterData(WebElement txtBx, String input)
	{
		if(txtBx.getAttribute("value")!=null)
		{
			txtBx.clear();
			txtBx.sendKeys(input);
		}
		else{
			txtBx.sendKeys(input);
		}
	}
	public void clickElement(WebElement element){
		if(element.getTagName().equalsIgnoreCase("input"))//input
		{
			if(element.getAttribute("type").contains("checkbox"))
			{
				if(element.isSelected())
				{
					System.out.println("checkbox is already selected");
				}
				else{
					element.click();
				}
			}
			else if(element.getAttribute("type").contains("radio"))
			{
				element.click();
			}
			else if(element.getAttribute("type").contains("button"))
			{
				element.click();
			}
			else if(element.getAttribute("type").contains("submit"))
			{
				element.submit();
			}
		}
		else if(element.getTagName().equalsIgnoreCase("button"))//button
		{
			if(element.getAttribute("type").contains("submit"))
			{
				element.submit();
			}
			else if(element.getAttribute("type").contains("button"))
			{
				element.click();
			}
		}
		else if(element.getTagName().equalsIgnoreCase("div") || element.getTagName().equalsIgnoreCase("img") || element.getTagName().equalsIgnoreCase("span") || element.getTagName().equalsIgnoreCase("a"))//div span a img
		{
			element.click();
		}
	}
	/*****************selectoptionBYtext*****************/
	
	public void selectOptionByText(WebElement drpDwn, String optionText)
	{
		Select sel=new Select(drpDwn);
		sel.selectByVisibleText(optionText);
	}
	
	/******************mousehover*********/
	
	public void mouseOver(WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/***************explicitwait****************/
	
	public void eWaitForVisible(int secs, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, secs);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/****************HardcodeWait**************/
	
	public void iSleep(int secs)
	{
		try{
			Thread.sleep(secs*1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/******************validatesrting***********/
	
	public void validateString (String actual, String expected, String Msg)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(Msg, true);
	}
	
	/*******************validateTitle*************/
	
	public void validateTitle(String expected, String Msg)
	{
		Assert.assertEquals(driver.getTitle(), expected);
		Reporter.log(Msg, true);
	}
	
	/*******************validateElementDisplay*************/
	
	public void validateElementDisplay(WebElement element, String Msg)
	{
		Assert.assertTrue(element.isDisplayed());
		Reporter.log(Msg, true);
	}
}