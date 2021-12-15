package com.hybridFW.generics;

public interface IAutoConstant {
	long WEBDRIVER_WAIT = 20;
	long IMPLICITLY_WAIT = 10;
	String EXPECTED_HOME_PAGE = "actiTIME - Enter Time-Track";
	String EXPECTED_LICENCES_PAGE = "actiTIME - Licenses";
	String EXPECTED_TASKSLISTS_PAGE = "actiTIME - Task List";
	String XL_PATH = "./testdata/input.xlsx";
	String PHOTO_FOLDER_PATH = "./photo/";
	String REPORT_FOLDER = "./report/report.xlsx";
	String CHRO_KEY = "webdriver.chrome.driver";
	String CHRO_VALUE = "./driver/chromedriver.exe";
	String FIREFOX_KEY = "webdriver.gecko.driver";
	String FIREFOX_VALUE = "./driver/geckodriver.exe";
	String APP_URL = "http://localhost/login.do";

}
