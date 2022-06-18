package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {

//	Page Factory-Object Repository
	@FindBy(xpath = "//*[contains(text(),\"Create\")]")
	WebElement createLabel;
	@FindBy(xpath = "//*[contains(text(),\"Export\")]")
	WebElement Exportbtn;
	@FindBy(name="first_name")
	WebElement ftName;
	@FindBy(name="last_name")
	WebElement ltName;
	@FindBy(name="do_not_call")
	WebElement do_not_callBtn;
	@FindBy(xpath="//button[@class=\"ui linkedin button\"]")
	WebElement savBtn;
	@FindBy(xpath="//button[@class=\"ui primary button\"]")
	WebElement OkBtn;
	
//Initializing the Page objects:
	public ContactsPage() {
		PageFactory.initElements(Driver, this);
	}

	public boolean verifyCreateLabel() {
		return createLabel.isDisplayed();
	}

	public void selectContacts(String name) {
		WebElement contact = Driver.findElement(
				By.xpath("//a[text()='" + name + "']//parent::td//preceding-sibling::td//input[@name=\"id\"]"));
		TestUtil.clickElementByJS(Driver, contact);
	}
	public void createNewContact(String firstName,String lastName) {
		createLabel.click();
		ftName.sendKeys(firstName);
		ltName.sendKeys(lastName);
		savBtn.click();
	}
	public void exportContact(String name) {
		selectContacts(name);
		Exportbtn.click();
		OkBtn.click();
		System.out.println("Hello Demo of GIT repository");
		System.out.println("Hello Demo of GIT repository");
	}
}
