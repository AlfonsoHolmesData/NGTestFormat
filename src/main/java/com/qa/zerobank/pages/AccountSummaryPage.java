package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AccountSummaryPage extends TestBase{
	
			// add locators here
			
			
			
			
			
			
			// Initializing the Page Objects:
			public AccountSummaryPage() {
				PageFactory.initElements(driver, this);
			}
			
			
			// assert Title
			public void assertAccountSummaryPageTitle(){
				assertEquals(driver.getTitle(), "Zero - Account Summary");
				
			}
			
			
			

}
