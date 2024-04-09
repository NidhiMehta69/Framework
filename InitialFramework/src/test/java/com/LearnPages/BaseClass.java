package com.LearnPages;

//import java.text.SimpleDateFormat;
//import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Utility.BrowserFactory;
import com.Utility.ConfigDataProvider;
import com.Utility.ExcelDataProvider;
import com.Utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class BaseClass {
	
public WebDriver driver;
public ExcelDataProvider excel;
public ConfigDataProvider config;
public ExtentReports report;
public ExtentTest logger;


@BeforeSuite
public void setUpExcelData()
{
	 Reporter.log("Setting up reports and Test is getting started ",true);
	 excel=new ExcelDataProvider();
	 config = new ConfigDataProvider();
	
	 String reportPath =  System.getProperty("user.dir")+"//Reports//Index_" + Helper.getCurrentDateTime()  + ".html";
	
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		reporter.config().setReportName("Assignment");
		reporter.config().setDocumentTitle("Assignment Test Report");		
		report = new ExtentReports();
		report.attachReporter(reporter);
		Reporter.log("Setting done - execution of TC can be started.",true);
}
	
	@BeforeClass
	
	public void SetUp()
	{
		Reporter.log("Trying to start Browser ",true);
		driver= BrowserFactory.SetUpBrowser(driver, config.getBrowser(),config.getEnvURL());
		Reporter.log("Browser Application is Up and Running ",true);

	}	
	
	
	@AfterClass
	
	public void TearDown()
	{
		BrowserFactory.TearDown(driver);
		
	}
//It will execute when testcase failed
	@AfterMethod
	public void CaptureFailureScreenshot(ITestResult result)
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			logger.fail("Test Case failed ", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
	
	report.flush();
}

}
