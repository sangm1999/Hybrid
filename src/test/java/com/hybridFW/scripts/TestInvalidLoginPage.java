package com.hybridFW.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hybridFW.generics.BaseTest;
import com.hybridFW.pages.LoginPage;

public class TestInvalidLoginPage extends BaseTest{
	@Test(dataProvider="dataValue")
	public void testInValidLoginPage(String un,String pw)
	{
		LoginPage lIP=new LoginPage(driver);
		lIP.login(un, pw);
		lIP.verifyERRMsg();
	}
	@DataProvider
	public Object[][] dataValue()
	{
		Object[][] o=new Object[3][2];
		o[0][0]="hdgfj";
		o[0][1]="";
		o[1][0]="1234";
		o[1][1]="#$%^&";
		o[2][0]="admin";
		o[2][1]=" ";
		return o;
	}

}
