package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestNGListner implements ITestListener
{
	public static int executionCount, passCount, failCount,skipCount=0;
	
	@Override
	public void onTestStart(ITestResult result) {
		executionCount++;
		Reporter.log(result.getName()+" script execution starts "+new Date(),true);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		passCount++;
		
		Reporter.log(result.getName()+" script is passed", true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		failCount++;
		Reporter.log(result.getName()+" script is failed" +new Date(), true);
		
		TakesScreenshot ts=(TakesScreenshot) BaseLib.driver;
		
		File srcFile=ts.getScreenshotAs(OutputType.FILE);
		
		File destFile=new File("./screenshots/"+result.getName()+".png");
		
		try{
			Files.copy(srcFile, destFile);
			
			
		}
		
		catch(IOException e)
		{
			
			
			e.printStackTrace();
				
			
		}
			
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		skipCount++;
		
		Reporter.log(result.getName()+" script is skipped "+new Date(), true);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("Suit execution starts"+new Date(), true);
	}

	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Suit execution starts"+new Date(), true);
		
		Reporter.log("Total script executed"+executionCount,true);
		Reporter.log("Total script Passed"+passCount, true);
		Reporter.log("Total script Failed"+failCount,true);
		Reporter.log("Total script skipped"+skipCount,true);
		
	}
	
	
	
	

}
