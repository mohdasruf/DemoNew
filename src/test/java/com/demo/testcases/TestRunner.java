package com.demo.testcases;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;

import com.demo.Utils.TestUtil;
import com.demo.automation.core.BaseTestCase;
import com.demo.pageobjects.Page1;
import com.demo.pageobjects.Page2;
import com.demo.pageobjects.Page3;

public class TestRunner extends BaseTestCase{
	Page1 page1= null;
	Page2 page2= null;
	Page3 page3=null;
	@Test(dataProvider="getData")
	public void Test1(Hashtable<String,String> data) throws InterruptedException{
		if(!TestUtil.isExecutable("FirstTest", xls) || data.get("Runmode").equals("N"))
			throw new SkipException("Skipping the test");
		page1=PageFactory.initElements(driver, Page1.class);
		page1.getPage(driver);
		page2=page1.submitPostcode(driver, data.get("Postcode"));
		page2.enterHouseNumber(data.get("HouseNumber").toString());
		page2.clickNextButton();
		page2.clickBookButton(driver);
		page2.enterFullName(data.get("Fullname"));
		page2.enterTelephoneNo(data.get("TelephoneNo").toString());
		page2.enterEmail(data.get("Email"));
		page3 =page2.clickConfirmButton(driver);
		page3.verifyConfirmationMessage(driver, Page3.Expected.CONFIRMATIONMESSAGE);
	}

	@DataProvider
	public Object[][] getData(){
		return TestUtil.getData("FirstTest", xls);
	}
	
}
