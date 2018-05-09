package com.test.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.util.Util;

public class BaseClass {
	
	public static Properties pro ;
	public static WebDriver driver;
	
  public BaseClass()
  { 
	
	try {
		String Filepath = "C:\\Users\\Varun\\workspace\\Test1\\src\\com\\test\\configuration\\congig.properties";
		File src = new File(Filepath);
		FileInputStream fs = new FileInputStream(src);
		pro = new Properties();
		 pro.load(fs);
	} catch (FileNotFoundException e) {
		}
	catch (IOException e) {
		System.out.println(e.getMessage());
	}
  }
  
 public void initialization()
   {
	 String browser = pro.getProperty("browser");
	 if (browser.equalsIgnoreCase("firefox"))
	 {
		driver = new FirefoxDriver();
	 }
	 
	 else if (browser.equalsIgnoreCase("chrome"))
	 {
		 driver = new FirefoxDriver();
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Util.implicitly_Wait_time, TimeUnit.SECONDS);
	 driver.manage().timeouts().pageLoadTimeout(Util.pageLoad_Timeout_time, TimeUnit.SECONDS);
	 driver.get(pro.getProperty("url"));;
	 
	 
 }
  
}