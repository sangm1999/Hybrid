package com.hybridFW.scripts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LoginPage;
import com.hybridFW.pages.TasksListPage;

public class TestCreateProject extends BaseTest {
	@Test
	@Parameters({"projectsheet","projectrowp","projectrowc","projectcellp","projectcellc"})
	public void test_createProjectModule(String projectsheet,int projectrowp,int projectrowc,int projectcellp,int projectcellc) throws InterruptedException
	{
		LoginPage lIP=new LoginPage(driver);
		lIP.login();
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_HOME_PAGE);
		EnterTimeTrackPage etp=new EnterTimeTrackPage(driver);
		etp.verifyPage(driver);
		etp.clickOnTasksTab(driver);
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_TASKSLISTS_PAGE);
		TasksListPage tlp=new TasksListPage(driver);
		etp.verifyPage(driver);
		tlp.clickOnAddNewBtn();
		tlp.clickOnNewProjectBtn();
		tlp.setProjectTitle(readXLData(XL_PATH, projectsheet, projectrowp, projectcellp));
		if(!tlp.selectCustomer(readXLData(XL_PATH, projectsheet, projectrowc, projectcellc),driver))
			tlp.clickOnCancelBtn();
		tlp.clickOncreatProjectBtn();
	}

}
