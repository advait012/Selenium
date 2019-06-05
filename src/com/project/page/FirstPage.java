package com.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.project.base.BasePage;

public class FirstPage extends BasePage {

	@FindBy(css="")
	private WebElement element;

	public FirstPage(WebDriver driver) {
	super(driver);
	Assert.assertTrue(element.isDisplayed());
    //Logger.log(LogStatus.PASS,"Checking Correct Page is Displayed");
}
}
