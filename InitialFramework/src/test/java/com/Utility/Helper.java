package com.Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentReports;

public class Helper {
	
	String timestamp = new SimpleDateFormat("yyyy/MM/dd").format(Calendar.getInstance().getTime());
	public static ExtentReports extent = new ExtentReports();
	
	public static String captureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/ScreenShots/Image_"+ getCurrentDateTime() + ".png";
		try {
			//FileHandler.copy(src, new File("./Screenshots/FailureImage_"+ getCurrentDateTime() +".png"));
			FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
		return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		SimpleDateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
	}
	
	/*public ExtentReports getReportObject() {
		//String reportPath =  System.getProperty("user.dir")+"//Reports//" + timestamp + "//"  + "index.html";
		String reportPath =  System.getProperty("user.dir")+"//reports//" + timestamp + "//"  + "index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
		//ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/index.html");
		reporter.config().setReportName("Assignment");
		reporter.config().setDocumentTitle("Assignment Test Report");		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		return extent;
	}*/
	
}
