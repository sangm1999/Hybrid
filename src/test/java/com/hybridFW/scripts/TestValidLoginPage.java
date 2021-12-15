package com.hybridFW.scripts;

import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LoginPage;

public class TestValidLoginPage extends BaseTest {
	@Test
	public void testValidLoginPage() throws InterruptedException {
		LoginPage lIP = new LoginPage(driver);
		lIP.login();
		EnterTimeTrackPage eTTP = new EnterTimeTrackPage(driver);
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_HOME_PAGE);
		// eTTP.verifyPage(driver, EXPECTED_HOME_PAGE);
		eTTP.verifyPage(driver);
	}
}
