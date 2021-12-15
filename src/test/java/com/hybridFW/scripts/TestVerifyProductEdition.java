package com.hybridFW.scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LicensesPage;
import com.hybridFW.pages.LoginPage;

public class TestVerifyProductEdition extends BaseTest {
	@Test
	@Parameters({"productsheet","productrow","productcell"})
	public void test_IssueDate(String productsheet, int productrow,int productcell) throws InterruptedException
	{
		LoginPage lip=new LoginPage(driver);
		lip.login();
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_HOME_PAGE);
		etp.verifyPage(driver);
		etp.clickOnSetting(driver);
		etp.clickOnLicenses();
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_LICENCES_PAGE);
		etp.verifyPage(driver);
		LicensesPage lp=new LicensesPage(driver);
		lp.verifyProductEdition(readXLData(XL_PATH, productsheet, productrow, productcell));
	}

}
