package com.project.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.project.Configuration.Configuration;

public class Browser {

	public static WebDriver driver;

	public static WebDriver getBrowser(String browser) {
		switch (browser) {
		case "chrome": {
			System.setProperty("webdriver.chrome.driver", Configuration.CHROMEDRIVER_LOCATION);
//			ChromeOptions chrome = new ChromeOptions();
//			chrome.setBinary("");
//			chrome.setExperimentalOption("UseAutomationExtension", false);

		}
		case "firefox": {

		}

		case "ie": {

		}

		}
		return driver;
	}
}