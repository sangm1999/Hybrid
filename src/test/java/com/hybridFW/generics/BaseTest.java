package com.hybridFW.generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.hybridFW.pages.EnterTimeTrackPage;

public class BaseTest extends Futils implements IAutoConstant {
	public static WebDriver driver;
	static {
		System.setProperty(CHRO_KEY, CHRO_VALUE);
		System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
	}

	@BeforeClass
	@Parameters("brows")
	public void openBrowser(String brows) {
		if (brows.equals("chrome"))
			driver = new ChromeDriver();
		else if (brows.equals("firefox"))
			driver = new FirefoxDriver();
		else if (brows.equals("ie"))
			driver = new InternetExplorerDriver();
		driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void openApplication() {
		driver.get(APP_URL);
	}

	@AfterMethod
	public void logoutApplication(ITestResult res) {
		int testStatus = res.getStatus();
		String testName = res.getName();
		int psaaCount = 0;
		int failCount = 0;
		if (testStatus == 1)
			psaaCount++;
		else {
			failCount++;
			Futils.takeScreenshot(driver, PHOTO_FOLDER_PATH + testName + ".png");
		}
		EnterTimeTrackPage etp = new EnterTimeTrackPage(driver);
		etp.clickOnLogout(driver);
	}
	// @AfterClass
	// public void closeApplication()
	// {
	// driver.close();
	// }

}
