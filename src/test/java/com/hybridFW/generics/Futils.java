package com.hybridFW.generics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Futils {
	static public String readXLData(String path, String sheet, int row, int cell) {
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
	}

	static public List<String> readXLdataLastRow(String path, String sheet, int cell) {
		Workbook wb = null;
		List<String> tasks = new ArrayList<>();
		try {
			wb = WorkbookFactory.create(new FileInputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		int lastrow = wb.getSheet(sheet).getLastRowNum();
		for (int i = 1; i <= lastrow; i++) {
			tasks.add(wb.getSheet(sheet).getRow(i).getCell(cell).toString());
		}
		return tasks;
	}

	static public void takeScreenshot(WebDriver driver, String path) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File(path);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
