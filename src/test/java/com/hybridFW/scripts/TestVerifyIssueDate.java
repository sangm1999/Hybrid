package com.hybridFW.scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LicensesPage;
import com.hybridFW.pages.LoginPage;

public class TestVerifyIssueDate extends BaseTest {
	@Test
	@Parameters({"issuesheet","issuerow","issuecell"})
	public void test_IssueDate(String issuesheet,int issuerow,int issuecell) 
	{
		LoginPage lip=new LoginPage(driver);
		lip.login();
		new WebDriverUtils().waitConditionTitle(driver,EXPECTED_HOME_PAGE);
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		etp.verifyPage( driver);
		etp.clickOnSetting(driver);
		etp.clickOnLicenses();
		new WebDriverUtils().waitConditionTitle(driver,EXPECTED_LICENCES_PAGE);
		LicensesPage lp=new LicensesPage(driver);
		lp.verifyPage( driver,EXPECTED_LICENCES_PAGE);
		lp.verifyIssueDate(readXLData(XL_PATH, issuesheet, issuerow, issuecell));
	}

}
