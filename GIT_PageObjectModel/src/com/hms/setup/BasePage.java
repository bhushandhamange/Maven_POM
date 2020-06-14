package com.hms.setup;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BasePage
{
	private WebDriver driver;
	Logger logger = Logger.getLogger(BasePage.class);
	

	public WebDriver getDriver() {
		return driver;
	}

	public void initilaize(String browser, String url) {
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Browser : "+ browser);
		logger.info("URL : "+ url);
		
		String basePath = "D:\\Software\\Selenium\\Driver\\";   //System.getProperty("user.dir");
		
		switch (browser) {
		case "IE":
			System.setProperty("webdriver.ie.driver",basePath + "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			break;
		case "FF":
			System.setProperty("webdriver.gecko.driver",basePath+ "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(url);
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver",basePath+ "chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			break;
		default:
			driver = new FirefoxDriver();
			driver.get(url);
		}
	}
	
	@BeforeClass
	@Parameters({ "browserName", "url" })
	public void setup(String browser, String url1) {
		initilaize(browser, url1);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
