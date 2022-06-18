package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage = new LoginPage();
		contactsPage=new ContactsPage();
		homePage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
	}
//test cases should be separated --independent with each other
//before each test case--launch the browser and login
//@test--execute test case
//after each test case--close the browser

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "Cogmento CRM", "Home Page Title is not matched");
	}
	@Test(priority = 2)
	public void verifyCorrectUserNameTest() {
		boolean a = homePage.verifyCorrectUserName();
		Assert.assertEquals(a, true, "The User Name displayed is not correct");
	}
	@Test(priority = 3)
	public void verifyContactLinkTest() {
		contactsPage=homePage.clickOnContactsLinks();
	}
	
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
}
