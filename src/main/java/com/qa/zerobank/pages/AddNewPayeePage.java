package com.qa.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AddNewPayeePage extends TestBase{
	
	@FindBy(id="np_new_payee_name")
	WebElement npname;
	@FindBy(css="[name='address']")
	WebElement npaddress;
	@FindBy(css = "#np_new_payee_account")
	WebElement npaccount;
	@FindBy(name="details")
	WebElement npdetails;
	@FindBy(id="submit")
	WebElement addbutton;
	
	public AddNewPayeePage() {
		PageFactory.initElements(driver, this);
	}

}
