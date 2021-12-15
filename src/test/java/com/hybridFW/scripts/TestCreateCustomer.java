package com.hybridFW.scripts;

import java.util.Scanner;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.generics.WebDriverUtils;
import com.hybridFW.pages.EnterTimeTrackPage;
import com.hybridFW.pages.LoginPage;
import com.hybridFW.pages.TasksListPage;

public class TestCreateCustomer extends BaseTest {
	@Test
	@Parameters({"customersheet","customerrow","customercell"})
	public void test_CreateCustomerModule(String customersheet, int customerrow, int customercell) throws InterruptedException
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
		tlp.clickOnNewCustomerBtn();
		tlp.setCustomerName(readXLData(XL_PATH, customersheet, customerrow, customercell));
		Scanner s=new Scanner(System.in);
		System.out.println("add the description of customer");
		String customer_Decription=s.nextLine();
		Thread.sleep(3000);
		tlp.setCstmerDescription(customer_Decription);
		tlp.clickOnCreatCustomerBtn();
	}

}
