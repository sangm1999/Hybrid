package com.hybridFW.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtils implements IAutoConstant {
	public void waitConditionTitle(WebDriver driver, String expected_Title) {
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
		wait.until(ExpectedConditions.titleContains(expected_Title));
	}

	public void waitConditionClick(WebDriver driver, WebElement button) {
		WebDriverWait wait = new WebDriverWait(driver, WEBDRIVER_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(button));
	}
}
