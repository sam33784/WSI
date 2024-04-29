package com.qa.factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private  WebDriver driver;
	
	// this is used for parallel execution of the scripts 
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(String browser) {
		
		System.out.println("The browser value is " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			
			System.out.println("Please enter the correct browser value" + browser );
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return getDriver();
		
		
		
		
		
	}

	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
	}
	
	
	
	
	
	

	

}
