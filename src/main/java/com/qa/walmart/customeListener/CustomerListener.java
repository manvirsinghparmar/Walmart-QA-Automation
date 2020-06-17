package com.qa.walmart.customeListener;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.walmart.qa.base.Base;

public class CustomerListener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test started for... " + result.getMethod().getMethodName() +".......");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test Passed for... " + result.getMethod().getMethodName() +".......");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test Failed for... " + result.getMethod().getMethodName() +".......");
		
		failedTestScreenShot(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
}
