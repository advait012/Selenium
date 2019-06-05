package com.project.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.project.base.BaseTest;
import com.project.page.FirstPage;
import com.project.utilities.TestListener;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(TestListener.class)
public class FirstTest extends BaseTest {

	@Test(description="This is my First Test Case")
	public void executeFirstTest() throws IOException{
		
		try {
			logger=report.startTest("This is my first test case");
			FirstPage fp = new FirstPage(driver);
			logger.log(LogStatus.PASS,"Google is Opened");
		}
		catch(Exception e)
		{
			logger.log(LogStatus.FAIL,e);
			Assert.fail("Exception occured"+e);
		}
	}
	
	@Test(description="Fail the test case")
	public void failTheTestCase(){
		
		logger=report.startTest("This is my second test case");
		Assert.assertTrue(false);
	}
}
