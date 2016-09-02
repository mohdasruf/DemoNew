package com.demo.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.Utils.TestUtil;
import com.demo.constants.Constants;

public class Page2 {
	@FindBy(name = Constants.DEFAULTHOUSENUMBER)
	public WebElement defaultHouseName;
	
	@FindBy(id = Constants.NEXTBUTTON)
	public WebElement nextButton;
	
	@FindBy(id = Constants.BOOKBUTTON)
	public WebElement bookButton;
	
	@FindBy(name = Constants.FULLNAME)
	public WebElement fullName;
	
	@FindBy(name = Constants.TELEPHONE)
	public WebElement telephone;
	
	@FindBy(name = Constants.EMAIL)
	public WebElement email;
	
	@FindBy(xpath = Constants.CONFIRMBUTTON)
	public WebElement confirmButton;

	public Page2() {

	}
	
	public void enterHouseNumber(String houseName){
		defaultHouseName.sendKeys(houseName);
	}
	
	public void clickNextButton(){
		nextButton.click();
	}
	
	public void clickBookButton(WebDriver driver){
		if (TestUtil.elementWaitForVisibility(bookButton, driver))
			{bookButton.click();}
	}
	
	public void enterFullName(String Name){
		fullName.sendKeys(Name);
	}
	
	public void enterTelephoneNo(String telNo){
		telephone.sendKeys(telNo);
	}
	
	public void enterEmail(String emailAddress){
		email.sendKeys(emailAddress);
	}
	
	public Page3 clickConfirmButton(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", confirmButton);	
		Page3 page3 = PageFactory.initElements(driver, Page3.class);
		return page3;
	}
}
