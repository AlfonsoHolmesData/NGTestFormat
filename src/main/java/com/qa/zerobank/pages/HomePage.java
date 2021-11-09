package com.qa.zerobank.pages;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="signin_button")
	WebElement signInButton;
	
	@FindBy(name="searchTerm")
	WebElement searchBox;
		
	@FindBy(linkText = "Zero Bank")
	WebElement brandLinkZeroBank;
	
	@FindBy(css = "#online-banking")
	WebElement buttonMoreServices;
	
	@FindBy(className = "brand")
	WebElement brandLogo;
	
	
		// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	
//		public String verifyHomePageTitle(){
//			return driver.getTitle();
//		}
		
		public void assertHomePageTitle(){
			assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards", "Home page title assert Failed");
			
		}
		
		public void assertsearchBarClearsOnRerender(){
			
			searchBox.findElement(By.id("searchTerm")).sendKeys("doesn't realy matter just a test");
			String expectedResult = "";
			String actualResult = searchBox.getText();
			assertEquals( actualResult , expectedResult , "SearchBar Does NOT clear on rerender");
			
		}
		
		public LoginPage clickOnSignInButton() {
			signInButton.click();
			return new LoginPage();
			
		}
		
		
		public boolean validateBandLogo() {
			return brandLogo.isDisplayed();
		}
		

}
