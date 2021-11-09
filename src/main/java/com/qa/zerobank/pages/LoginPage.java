package com.qa.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LoginPage extends TestBase{
	@FindBy(id = "signin_button")
	WebElement home_singin_button;
	
	@FindBy(id = "signin")
	WebElement signInButton;
	
	
	public LoginPage() {
		PageFactory.initElements(driver , this);
	}
	
	public void assertHomePageTtle() {
		
	}

	public AccountSummaryPage ClickOnSigninButton() {
		signInButton.click();
		return new AccountSummaryPage();
	}

}
