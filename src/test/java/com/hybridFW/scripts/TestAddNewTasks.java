package com.hybridFW.scripts;

import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LoginPage;
import com.hybridFW.pages.TasksListPage;

public class TestAddNewTasks extends BaseTest {
	@Test
	@Parameters({ "taskssheet", "tasksrowc", "taskscellc", "tasksrowp", "taskscellp", "taskscell" })
	public void test_AddNewTasks(String taskssheet, int tasksrowc, int taskscellc, int tasksrowp, int taskscellp,
			int taskscell) throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.login();
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_HOME_PAGE);
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.verifyPage(driver);
		etp.clickOnTasksTab(driver);
		new WebDriverUtils().waitConditionTitle(driver, EXPECTED_TASKSLISTS_PAGE);
		TasksListPage tlp = new TasksListPage(driver);
		etp.verifyPage(driver);
		tlp.clickOnAddNewTaskBtn();
		tlp.clickOnCreatNewTaskBtn();
		Thread.sleep(1000);
		tlp.selectCustomer(readXLData(XL_PATH, taskssheet, tasksrowc, taskscellc), driver);
		if (tlp.selectProject(readXLData(XL_PATH, taskssheet, tasksrowp, taskscellp), driver)) {
			List<String> tasks = readXLdataLastRow(XL_PATH, taskssheet, taskscell);
			tlp.setTasksName(tasks);
			tlp.clickOnCreatTaskBtn();
		} else
			tlp.clickOnNewProjectBtn();
	}

}
