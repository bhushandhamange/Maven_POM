package com.hms.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hms.pageobjects.DashboardPage;
import com.hms.pageobjects.HomePage;
import com.hms.pageobjects.LoginPage;
import com.hms.setup.BasePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsClass extends BasePage {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		driver = getDriver();
	}
	
	@BeforeMethod
	public void setUp() {
		reports = new ExtentReports("user.dir"+"\\extentreports.html");
		test = reports.startTest("ExtentDemo");
		test.log(LogStatus.INFO, "Home page of the application is opened");		
	}

	@Test
	public void verifyLogin() throws IOException {
		test.log(LogStatus.INFO, "Verify Login test case start");
		HomePage home = new HomePage(driver);
		LoginPage login = home.goToLoginPage();
		
		DashboardPage d = login.Sigin("bhushan.dhamange@gmail.com", "digit@123");
		Boolean status = d.verifyLogin("Bhushan Dhamange");
		if(status){
			System.out.println("Login success");
			test.log(LogStatus.PASS, "Login Success");
			test.log(LogStatus.PASS, test.addScreenCapture(capture(driver))+ "test passed"); 
		} else {
			System.out.println("Login failure");
			test.log(LogStatus.FAIL, "Login failure");
		}		
	}
	
	@AfterMethod
	public void tearDown() {
		
		reports.endTest(test);
		reports.flush();		
	}
	
	private String capture(WebDriver driver) throws IOException {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("src/../ErrImages"+System.currentTimeMillis()+".png");
		String errflpath = destFile.getAbsolutePath();
		FileUtils.copyFile(srcFile, destFile);
		return errflpath;
		
	}
}
