package com.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
	
	public static WebDriver SetUpBrowser(WebDriver driver,String browserName, String appURL)
	
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();					
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("We do not support this Browser!!!!");
		}
		driver.manage().timeouts().getPageLoadTimeout();
		driver.manage().window().maximize();
		driver.get(appURL);
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		return driver;
		
	}
	
	public static void TearDown(WebDriver driver)
	{
		Helper.extent.flush();
		driver.quit();
	}

}
