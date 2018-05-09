package com.test.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.test.base.BaseClass;

public class Util extends BaseClass{
	
	public static long implicitly_Wait_time = 20;
	public static long pageLoad_Timeout_time = 30;
	
	public static  void captureScreencast(WebDriver driver ,String  ScreencastName)
	{
		TakesScreenshot ts =  (TakesScreenshot)driver;
	   File source = ts.getScreenshotAs(OutputType.FILE);
	   try {
		FileUtils.copyFile(source, new File ("./Screencast" + ScreencastName + ".png"));
    	} catch (IOException e) {
		 System.out.println(e.getMessage());
	}
	}

}
