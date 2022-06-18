package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
//	Page Factory-Object Repository
	@FindBy(xpath = "//*[contains(text(),\"santosh gadekar\")]")
	WebElement userNameLabel;
	@FindBy(xpath = "//*[contains(text(),\"Contacts\")]")
	WebElement contactsLink;
	@FindBy(xpath = "//*[contains(text(),\"Deals\")]")
	@CacheLookup
	WebElement DealsLink;
	@FindBy(xpath = "//*[contains(text(),\"Tasks\")]")
	WebElement TaskLink;
	
//Initializing the Page objects:
	public HomePage() {
		PageFactory.initElements(Driver, this);
	}
	
//Actions:
	public String verifyHomePageTitle() {
		return Driver.getTitle();
	}
	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

	public ContactsPage clickOnContactsLinks() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLinks() {
		DealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLinks() {
		TaskLink.click();
		return new TaskPage();
	}
}
