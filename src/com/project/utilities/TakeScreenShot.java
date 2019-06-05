package com.project.utilities;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.project.Configuration.Configuration;

public class TakeScreenShot {
	public static void takeFailScreen(String testCaseName,WebDriver driver) throws IOException{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile,new File(Configuration.SCREENSHOT_LOCATION+testCaseName+".png"));
		//add apache common io jars 
	}

}
