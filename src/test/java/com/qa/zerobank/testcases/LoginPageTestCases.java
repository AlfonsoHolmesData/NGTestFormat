package com.qa.zerobank.testcases;

import java.io.IOException;
import java.sql.Connection;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LogInPage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.util.TestUtil;

public class LoginPageTestCases extends TestBase{

	LoginPage logInPage;
	AccountSummaryPage accountSummaryPage;
	HomePage homePage;

	public LoginPageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// initiate all the classes and driver from base class
		initialization();
		homePage = new HomePage();
		logInPage = new LoginPage();
		accountSummaryPage = new AccountSummaryPage();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
	
	@Test
	public void validateLogInFunctionality() {
		logInPage = homePage.clickOnSignInButton();
		//accountSummaryPage = logInPage.logIn();
		accountSummaryPage.assertAccountSummaryPageTitle();
	}
	

	
}
