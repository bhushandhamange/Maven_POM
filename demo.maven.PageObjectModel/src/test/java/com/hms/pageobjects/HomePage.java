package com.hms.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	
	By signIn = By.linkText("Sign in");
	
	public HomePage(WebDriver driver2){
		driver = driver2;
	}
	
	public LoginPage goToLoginPage(){
	
		driver.findElement(signIn).click();
		LoginPage lp = new LoginPage(driver);
		new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lp.userId));
		return lp;
	}
	
}
