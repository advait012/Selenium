package com.project.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.project.Configuration.Configuration;
import com.project.utilities.Browser;
import com.project.utilities.ReportManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseTest {
	
	public static WebDriver driver;;
	public static ExtentReports report;
	public static ExtentTest logger;
	public static File screenshots;
	public static File reports;
	public static File testoutput;
	public static File originalreport;
	
	@BeforeSuite
	public static void disableAllBrowserTabs() throws IOException{
		Runtime.getRuntime().exec("taskill /F /IM chrome.exe");
		screenshots=new File(Configuration.SCREENSHOT_LOCATION);
		reports=new File(Configuration.REPORTFOLDER_LOCATION);
		testoutput=new File(Configuration.TESTOUTPUT_LOCATION);
		FileUtils.cleanDirectory(screenshots);
		FileUtils.cleanDirectory(reports);
		FileUtils.cleanDirectory(testoutput);
		originalreport=new File(Configuration.ORIGINAL_REPORT_LOCATION);
		if(originalreport.exists())
		{
			originalreport.delete();
		}
	}
	
	@BeforeClass
	@Parameters("browser")
	public static void setup(@Optional("chrome") String browser) throws IOException{
		driver=Browser.getBrowser(browser);
		report=ReportManager.getReporter();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@BeforeMethod
	public static void goToURL()
	{
		driver.get(Configuration.URL);
		
	}
	
	@AfterMethod
	public static void cleanup()
	{
		driver.manage().deleteAllCookies();
	}
	
	@AfterClass
	public static void teardown() {
		report.endTest(logger);
		report.flush();
		driver.quit();
	}
	

}
