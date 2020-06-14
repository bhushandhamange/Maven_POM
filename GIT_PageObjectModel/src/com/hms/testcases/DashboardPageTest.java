package com.hms.testcases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hms.pageobjects.DashboardPage;
import com.hms.pageobjects.HomePage;
import com.hms.pageobjects.LoginPage;
import com.hms.setup.BasePage;

public class DashboardPageTest extends BasePage {
	WebDriver driver;
	Logger logger = Logger.getLogger(DashboardPageTest.class);

	@BeforeClass
	public void setup() {
		driver = getDriver();
	}

	@Test
	public void verifyLogin() {
//		BasicConfigurator.configure();
		PropertyConfigurator.configure("log4j.properties");
		
		logger.info("starting test");

		HomePage home = new HomePage(driver);
		LoginPage login = home.goToLoginPage();
//		LoginPage login = new LoginPage(driver);
		
		DashboardPage d = login.Sigin("bhushan.dhamange@gmail.com", "digit@123");
		Boolean status = d.verifyLogin("Bhushan Dhamange");
		if(status){
//			System.out.println("Login success");
			logger.info("Login success");
//			Assert.assertTrue(status);
		} else {
//			System.out.println("Login failure");
			logger.info("Login failure");
//			Assert.assertFalse(status);
		}		
	}
}
