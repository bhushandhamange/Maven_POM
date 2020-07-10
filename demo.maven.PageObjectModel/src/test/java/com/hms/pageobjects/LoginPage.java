package com.hms.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hms.setup.BasePage;

public class LoginPage {
	
	private WebDriver driver;

	By userId = By.id("email");
	By password = By.id("passwd");
	By loginBtn = By.id("SubmitLogin");

	public LoginPage(WebDriver driver2) {
		driver = driver2;
	}

	public DashboardPage Sigin(String userid, String pass) {
		DashboardPage d1 =null;
		driver.findElement(userId).sendKeys(userid);		
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginBtn).click();
		d1 = new DashboardPage(driver);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(d1.logoutLink));	
		return d1;
	}



}
