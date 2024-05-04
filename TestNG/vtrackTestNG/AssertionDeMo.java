package vtrackTestNG;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionDeMo {

	//example for soft Assertion
	@Test(description="soft Assertion Testing")
	public void testCase1() {
		SoftAssert assertion=new SoftAssert();
		assertion.assertTrue(false);
		System.out.println("------SoftAssert Is Displayed-----");
		assertion.assertAll();
	}
	
	//example for Hard Assertion
	@Test(description="Hard Assertion Testing")
	public void testCase2() {
		Assert.assertTrue(false);
		System.out.println("-------Hard Is Displayed--------");
	}
}
