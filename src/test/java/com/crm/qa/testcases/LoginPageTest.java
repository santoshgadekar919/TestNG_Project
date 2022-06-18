package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
		
	@BeforeMethod
	public void setUp() {
		initilization();
		loginPage=new LoginPage();
	}
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title=loginPage.validateLoginTitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	@Test(priority=2)
	public void loginPageForgotBtnTest() {
		boolean a=loginPage.validateForgotBtn();
		Assert.assertEquals(a, true);
	}
	@Test(priority=3)
	public void loginTest() {
		homePage=loginPage.login(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	@AfterMethod
	public void tearDown() {
		Driver.quit();
	}
	
}
