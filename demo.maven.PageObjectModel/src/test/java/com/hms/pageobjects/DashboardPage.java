package com.hms.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage 
{
private WebDriver driver;
	
	
	By logoutLink = By.linkText("Sign out");
	By myDashboardLink = By.linkText("My Dashboard");
	By welcomeMessage = By.linkText("Bhushan Dhamange");
	
	public DashboardPage(WebDriver driver2){
		driver = driver2;
	}
	
	public boolean verifyLogin(String expectedMessage){
		String actualMessage=driver.findElement(welcomeMessage).getText();
		if (actualMessage.equalsIgnoreCase(expectedMessage))
			return true;
		else
			return false;		
	}
}
