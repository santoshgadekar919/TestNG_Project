package com.crm.qa.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
public class ABC {

		public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Testing Class\\Selenium\\New folder\\chromedriver.exe");
//			System.setProperty("webdriver.gecko.driver", "E:\\Testing Class\\Selenium\\New folder\\geckodriver(1).exe");
			WebDriver Driver=new ChromeDriver();
//			WebDriver Driver1=new InternetExplorerDriver();
//			WebDriver Driver2=new OperaDriver();
//			WebDriver Driver3=new SafariDriver();
//			WebDriver Driver4=new HtmlUnitDriver();
//			WebDriver Driver=new FirefoxDriver();
			Driver.manage().deleteAllCookies();
			Driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			Driver.get("https://www.amazon.in/");
			Driver.navigate().to("https://www.facebook.com/");
			Driver.navigate().back();
			Driver.navigate().forward();
			Driver.navigate().refresh();
			String a=Driver.getTitle();
			System.out.println(a);
			String b=Driver.getCurrentUrl();
			System.out.println(b);
			System.out.println(Driver.getPageSource());
			Driver.quit();
		}
	}

