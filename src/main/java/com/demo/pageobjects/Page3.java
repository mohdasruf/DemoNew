package com.demo.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.demo.Utils.TestUtil;
import com.demo.automation.core.Verifications;
import com.demo.constants.Constants;

public class Page3 {
	
	public static class Expected{
		public static final String CONFIRMATIONMESSAGE = "Your free valuation is confirmed.";
	}
	
	@FindBy(xpath = Constants.CONFIRMATIONMESSAGE)
	public WebElement confirmationMessage;
	
	public void verifyConfirmationMessage(WebDriver driver,String finalMessage){
		if (TestUtil.elementWaitForVisibility(confirmationMessage, driver)){
			Verifications.assertTrue("Final message is as expected", confirmationMessage.getText().equalsIgnoreCase(finalMessage));
}
	}
	
}
