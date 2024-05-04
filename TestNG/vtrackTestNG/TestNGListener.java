package vtrackTestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListener implements ITestListener {

	public void onStart(ITestResult result) {
		System.out.println("TestCase started and details are "+result.get
		
	}
	
	public void onFinish(ITestResult result) {
		System.out.println("TestCase Finished and details are "+result.getName());
	}
	
	
	
	public void onTestFailure(ITestResult result) {
		System.out.println("TestCase Failed and details are "+result.getName());
	}
	
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("TestCase Skipped and details are "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("TestCase Successful and details are "+result.getName());
	}
	
	
}
