package com.hybridFW.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.hybridFW.generics.IAutoConstant;
import com.hybridFW.generics.WebDriverUtils;

public class EnterTimeTrackPage implements IAutoConstant {
	@FindBy(xpath = "//a[text()='Logout']/..")
	private WebElement lgOut;
	@FindBy(xpath = "//div[contains(text(),'Settings')]/..")
	private WebElement settings;
	@FindBy(xpath = "//div[text()='TASKS']/ancestor::a[@href='/tasks/tasklist.do']")
	private WebElement tasks_Tab;
	@FindBy(xpath = "//a[text()='Licenses']")
	private WebElement licenses;

	public EnterTimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void clickOnLogout(WebDriver driver) {
		new WebDriverUtils().waitConditionClick(driver, lgOut);
		lgOut.click();
	}

	public void clickOnLicenses() {
		licenses.click();
	}

	public void clickOnTasksTab(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICITLY_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(tasks_Tab));
		tasks_Tab.click();
	}

	public void clickOnSetting(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, IMPLICITLY_WAIT);
		wait.until(ExpectedConditions.elementToBeClickable(settings));
		settings.click();
	}

	public void verifyPage(WebDriver driver) {
		String actual_Title = driver.getTitle();
		Assert.assertEquals(actual_Title, EXPECTED_HOME_PAGE);
		Reporter.log("Expected title is displated--------->" + EXPECTED_HOME_PAGE, true);
	}
}
