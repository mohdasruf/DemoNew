package com.demo.Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.constants.Constants;

public class TestUtil {
	
	public static boolean isExecutable(String testName, ExcelReader xls) {
		for (int rowNum = 2; rowNum <= xls.getRowCount("Test Cases"); rowNum++) {
			if (xls.getCellData("Test Cases", "TCID", rowNum).equals(testName)) {
				if (xls.getCellData("Test Cases", "Runmode", rowNum).equals("Y"))
					return true;
				else
					return false;
			}
		}
		return false;
	}

	public static boolean isSiteUpAndRunning() {
		boolean status = false;
		try {
			final URLConnection connection = new URL(Constants.MAINURL).openConnection();
			connection.connect();
			status = true;
		} catch (final MalformedURLException e) {
			throw new IllegalStateException("Bad URL: " + Constants.MAINURL, e);
		} catch (final IOException e) {
			status = false;
		}
		return status;
	}

	public static Boolean elementWaitForVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
	}

	public static Object[][] getData(String testName, ExcelReader xls) {
		// find the row number from which test starts
		// find the number of columns in the test
		// find the number of rows in the test
		// put the data in hastable and put hastable in array

		int testStartRowNum = 0;
		// find the row num from which test starts
		for (int rNum = 1; rNum <= xls.getRowCount("Test Data"); rNum++) {
			if (xls.getCellData("Test Data", 0, rNum).equals(testName)) {
				testStartRowNum = rNum;
				break;
			}
		}

		int colStartRowNum = testStartRowNum + 1;
		int totalCols = 0;
		while (!xls.getCellData("Test Data", totalCols, colStartRowNum).equals("")) {
			totalCols++;
		}

		// rows
		int dataStartRowNum = testStartRowNum + 2;
		int totalRows = 0;
		while (!xls.getCellData("Test Data", 0, dataStartRowNum + totalRows).equals("")) {
			totalRows++;
		}

		// extract data
		Object[][] data = new Object[totalRows][1];
		int index = 0;
		Hashtable<String, String> table = null;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + totalRows); rNum++) {
			table = new Hashtable<String, String>();
			for (int cNum = 0; cNum < totalCols; cNum++) {
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum), xls.getCellData("Test Data", cNum, rNum));
				System.out.print(xls.getCellData("Test Data", cNum, rNum) + " -- ");
			}
			data[index][0] = table;
			index++;
		}
		return data;
	}

}