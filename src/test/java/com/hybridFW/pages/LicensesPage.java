package com.hybridFW.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LicensesPage {
	@FindBy(xpath = "//nobr[text()='Issue Date:']/../../td[2]")
	private WebElement issue_Date;
	@FindBy(xpath = "//nobr[text()='Product Edition:']/../../td[2]")
	private WebElement product_Edition;

	public LicensesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void verifyIssueDate(String expectedIssueDate) {
		String actualIssuDate = issue_Date.getText();
		Assert.assertEquals(actualIssuDate, expectedIssueDate);
		Reporter.log("issueDate is verified" + actualIssuDate, true);
	}

	public void verifyProductEdition(String expectedProductEdition) {
		String actualProductEdition = product_Edition.getText();
		Assert.assertEquals(actualProductEdition, expectedProductEdition);
		Reporter.log("productEdition is verified" + actualProductEdition, true);
	}

	public void verifyPage(WebDriver driver, String expected_Title) {
		String actual_Title = driver.getTitle();
		Assert.assertEquals(actual_Title, expected_Title);
		Reporter.log("Expected title is displated--------->" + expected_Title, true);
	}
}
