package com.demo.automation.core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.demo.Utils.ExcelReader;
import com.demo.Utils.TestUtil;
import com.demo.constants.Constants;

public abstract class BaseTestCase {
	public static WebDriver driver = null;
	private static boolean driverOpened = false;
	public ExcelReader xls = new ExcelReader(Constants.TESTCASESDATA);
	final Logger log = Logger.getLogger(BaseTestCase.class);
	final String LOG_PROPERTIES_FILE = "/Users/mohamedasruf/Desktop/POM/resources/log4j.properties";

	public BaseTestCase() {
	}

	@BeforeClass
	public void classInit() throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(LOG_PROPERTIES_FILE));
		PropertyConfigurator.configure(props);
		BasicConfigurator.configure();
		log.info("logging initialised");
		log.setLevel(Level.INFO);
	}

	@AfterClass
	public static void classQuit() {
		Verifications.quit();
	}

	@BeforeTest
	public void setUp() {

		Verifications.assertTrue("Site responded with ok status", TestUtil.isSiteUpAndRunning());
		try {
			log.info("inside setup method");
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEBINARY);
			driver = new ChromeDriver();
			driverOpened = true;
		} catch (Throwable e) {
			Verifications.fail("Setup Error! ", e);
		}
	}

	@AfterTest
	public void tearDown() {
		try {
			if (driverOpened) {
				driverOpened = false;
				driver.quit();
			}
		} catch (Exception e) {
			log.info("Tear down Error! ");
		}
	}

}
