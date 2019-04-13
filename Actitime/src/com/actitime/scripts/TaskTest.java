package com.actitime.scripts;

	import org.testng.annotations.Test;

	import com.actitime.generic.BaseLib;
	import com.actitime.generic.ExcelUtilities;
import com.actitime.pageobjects.ActiveProjNCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
	

	public class TaskTest extends BaseLib {

		@Test(groups={"Regression"}, description="verifying new customer")
		public void createCustomer()
		{
			ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
			LoginPage lp= new LoginPage(driver);
			lp.login(eu.readData("Sheet1", 3, 1), eu.readData("Sheet1", 3, 2));
			EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
			ettp.clickOnTasks();
			OpenTaskPage otp=new OpenTaskPage(driver);
			otp.clickonProjCustLink();
			
			
			ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
			apcp.clickoncreatenewcust();
			
			
			CreateNewCustPage cncp=new CreateNewCustPage(driver);
			cncp.CreateCustomer(eu.readData("Sheet1", 3, 3));
			
			apcp.verifyCreateNewCustomer(eu.readData("Sheet1", 3, 3));
			apcp.logout();
			
		}
		@Test(dependsOnMethods={"createCustomer"}, groups={"Regression"}, description="verify deletecustomer")
		public void deleteCustomer(){
			ExcelUtilities eu=new ExcelUtilities("./testdata/testdata.xlsx");
			LoginPage lp= new LoginPage(driver);
			lp.login(eu.readData("Sheet1", 4, 1), eu.readData("Sheet1", 4, 2));
			EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
			ettp.clickOnTasks();
			OpenTaskPage otp=new OpenTaskPage(driver);
			otp.clickonProjCustLink();
			
			ActiveProjNCustPage apcp=new ActiveProjNCustPage(driver);
			
			apcp.cus
			
			
		}
	}


