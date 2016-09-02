package com.demo.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.constants.Constants;

public class Page1 {

	@FindBy(name = Constants.POSTCODE)
	public WebElement postcode;

	public Page1() {

	}
	
	public void getPage(WebDriver driver){
		driver.get(Constants.MAINURL);
	}

	public Page2 submitPostcode(WebDriver driver,String Postcode) {
		postcode.sendKeys(Postcode);
		postcode.sendKeys(Keys.ENTER);
		Page2 page2 = PageFactory.initElements(driver, Page2.class);
		return page2;
	}

}
