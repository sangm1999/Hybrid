package com.hybridFW.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id = "username")
	private WebElement unTb;
	@FindBy(name = "pwd")
	private WebElement pwTb;
	@FindBy(xpath = "//div[text()='Login ']")
	private WebElement lgnBtn;
	@FindBy(xpath = "//span[contains(text(),'invalid.')]")
	private WebElement errMsg;
	@FindBy(id = "keepLoggedInLabel")
	private WebElement KML_checkBox;
	@FindBy(id = "licenseLink")
	private WebElement view_Licenses;
	@FindBy(xpath = "//a[text()='actiTIME Inc.']")
	private WebElement actitime_Inc;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public void setUserName(String un) {
		unTb.sendKeys(un);
	}

	public void setPassWord(String pw) {
		pwTb.sendKeys(pw);
	}

	public void clickonLoginBTN() {
		lgnBtn.click();
	}

	public void keepMeLoggedIn() {
		KML_checkBox.click();
	}

	public void verifyERRMsg() {
		Assert.assertTrue(errMsg.isDisplayed());
		Reporter.log("error message is displayed " + errMsg.getText(), true);
	}

	public void clickonViewLicenses() {
		view_Licenses.click();
	}

	public void clickonactiTimeInc() {
		actitime_Inc.click();
	}

	public void login() {
		unTb.sendKeys("admin");
		pwTb.sendKeys("manager");
		KML_checkBox.click();
		lgnBtn.click();
	}

	public void login(String un, String pw) {
		unTb.sendKeys(un);
		pwTb.sendKeys(pw);
		KML_checkBox.click();
		lgnBtn.click();
	}

}
