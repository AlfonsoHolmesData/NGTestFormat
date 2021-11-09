package com.qa.zerobank.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mongodb.connection.Connection;
import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.HomePage;
import com.qa.zerobank.pages.LoginPage;
import com.qa.zerobank.util.ResualSet;
import com.qa.zerobank.util.TestUtil;

public class HomePageTestCases extends TestBase{
	
	LoginPage logInPage;
	HomePage homePage;
	Connection testcon;
	TestUtil testUtil;

	public HomePageTestCases() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		// initiate all the classes and driver from base class
		initialization();
		logInPage = new LoginPage();
		homePage = new HomePage();
		testUtil = new TestUtil();
	}
	
	@AfterMethod
	public void teardown() {

		driver.close();
		driver.quit();
		
	}
	
	public void dbConnectionTest() throws ClassNotFoundException, SQLException{
		//load driver jar class
		Connection testcon = testUtil.createDBConnection();
		ResultSet rs = testUtil.executeDBQuery(testcon , "select * from student");
	}
	
	@Test
	public void validateHomePage() {
		homePage.assertHomePageTitle();
	}
	
	
	@Test
	public void validateCheckstate() {
		homePage.assertsearchBarClearsOnRerender();
		
	}
	@Test
	public void validateLogo() {
		assertTrue(homePage.validateBandLogo());
	}

}
