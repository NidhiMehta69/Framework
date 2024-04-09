package com.TestCases;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.LearnPages.BaseClass;
import com.LearnPages.LoginPage;
import com.Utility.Helper;
import com.aventstack.extentreports.MediaEntityBuilder;

public class LoginTest extends BaseClass
{
	
	
	@Test
	public void loginApp() throws InterruptedException {
	
	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	Thread.sleep(1000);
	//logger.info("Applicatio Started");
	loginPage.LoginToApp(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));	
	//logger.info("Successful Login ");
	}
	
	@Test
	public void verifyPageTitle()
	{
		logger = report.createTest("Verify the Home Page title").assignAuthor("Nidhi").assignCategory("Functional Test case");
				
		String pageTitle = driver.getTitle();
		logger.info("Capture Page title" + pageTitle);
		if(pageTitle.equalsIgnoreCase("My Account"))
		{
			logger.pass("Test Case passed and Page title is " + pageTitle, MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else {			
			logger.fail("Page title is incorrect. It should be : "+ pageTitle, MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			
		}
		
	}
	


}
