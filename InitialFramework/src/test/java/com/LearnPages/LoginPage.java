package com.LearnPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	
	@FindBy(name="email") WebElement uname;
	@FindBy(name="password") WebElement pass;
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	public void LoginToApp(String UserNameApp, String PasswordApp)
	{
		uname.sendKeys(UserNameApp);
		pass.sendKeys(PasswordApp);
		loginButton.click();
	}
	
	
	

}
