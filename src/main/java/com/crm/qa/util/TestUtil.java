package com.crm.qa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.crm.qa.base.TestBase;
//to import everything use ctrl+shift+O


public class TestUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 50;

	public static void switchtoFrame() {
		Alert alert=Driver.switchTo().alert();
		alert.accept();
	}
	public static void clickElementByJS(WebDriver Driver, WebElement element) {
		JavascriptExecutor js=((JavascriptExecutor) Driver);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\santo\\eclipse-workspacet\\SantoshDG\\src\\main\\java\\com\\crm\\qa\\testdata\\com.crm.qa.testdata.xlsx";

	static Workbook book;
	static Sheet sheet;

		public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
//				System.out.println(data[i][k] +" ");
			}
		}
		return data;
	}
	
		public static void takeScreenshotAtEndOfTest() throws IOException {
			File scrFile = ((TakesScreenshot) Driver).getScreenshotAs(OutputType.FILE);
			String currentDir = System.getProperty("user.dir");
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		}
	
}
