package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	String sheetName="contacts";
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		contactsPage=homePage.clickOnContactsLinks();
	}
	@Test(priority = 3)
	public void verifyCreateLabelTest() {
		Assert.assertTrue(contactsPage.verifyCreateLabel(), "The Create lebel is available");
	}
	@Test(priority = 2)
	public void selectSingleContactsTest() {
		contactsPage.selectContacts("ghsgjhsgjgdhsjkd dsdsdss");
		
	}
	@Test(priority = 4)
	public void selectMultipleContactsTest() {
		contactsPage.selectContacts("Shubhi Ravate");
		contactsPage.selectContacts("FFF FFFF");
	
		contactsPage.selectContacts("hhjjjhbhbh czczczc ddsccz");
	}
	@DataProvider
	public Object[][] getCRMDATATest() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	@Test(priority = 1,dataProvider="getCRMDATATest")
	public void createNewContactTest(String firstName, String lastName) {
		contactsPage.createNewContact(firstName, lastName);
	}
	@Test(priority = 5)
	public void exportContactTest() {
		contactsPage.exportContact("FFF FFFF");
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
}
