package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.generic.BaseLib;
import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;

public class LoginTest  extends BaseLib{
	
	
	@Test
	
	public void validLogin(){
		
		
		String filepath="./testdata/testdata.xlsx";
		
		ExcelUtilities eu=new ExcelUtilities(filepath);
		String username=eu.readData("sheet1", 1, 1);
		
		String password=eu.readData("Sheet1", 1, 2);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);	
		
		EnterTimeTrackPage ettp = new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
	 }
	

}
