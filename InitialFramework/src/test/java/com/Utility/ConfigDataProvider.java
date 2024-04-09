package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	// To read properties we have separate class.
	Properties pro;
	
	//Constr is helpful in initialize object and variable.  
	public ConfigDataProvider() {
		File src=new File("./Config/Config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			
			pro = new Properties();
			
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Not able to load config file" + e.getMessage());
		} 
	}
	
	//takes key and return value
	public String getDataFromConfig(String keyToSearch)
	{
		return pro.getProperty(keyToSearch);
	}
	
	// return browser 
	public String getBrowser()
	{
		return pro.getProperty("Browser");
	}
	
	// return URL 
		public String getEnvURL()
		{
			return pro.getProperty("qaURL");
		}

}
