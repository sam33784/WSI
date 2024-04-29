package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// 1. By class locators

	private By emailId = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='pass']");
	private By loginbutton = By.xpath("//button[@id='loginbutton']");
	private By forgottenpwd = By.xpath("//a[contains(text(),'Forgotten account?')]");
	private By signupforfb = By.xpath("//a[contains(text(),'Sign up for Facebook')]");
	private By homepage = By.xpath("");
	private By passwdresetpage = By.xpath("");
	private By signuppage = By.xpath("");

	// 2. Constructor of the class

	public LoginPage(WebDriver driver) {

		this.driver = driver;
	}

	// 3. Page actions (functiaonlity of the page)

	public String getloginpagetitle() {

		return driver.getTitle();
	}

	public boolean isforgotpwdlinkexist() {

		return driver.findElement(forgottenpwd).isDisplayed();

	}

	public boolean signupforfb() {

		return driver.findElement(signupforfb).isDisplayed();

	}

	public void enterusername(String username) {

		driver.findElement(emailId).sendKeys(username);

	}

	public void enterpassword(String Password) {

		driver.findElement(password).sendKeys(Password);

	}

	public void clicklogin() {

		driver.findElement(loginbutton).click();

	}

	public void homepage() {

		if (driver.findElement(homepage).isDisplayed()) {

			System.out.println("Navigate to home page");
		} else

		{

			System.out.println("Not navigated to home page");
		}

	}

	public void passwdresetpage() {

		if (driver.findElement(passwdresetpage).isDisplayed()) {

			System.out.println("Navigate to password reset  page");
		} else

		{

			System.out.println("Not navigated to password reset  page");
		}

	}

	public void signuppage() {

		if (driver.findElement(signuppage).isDisplayed()) {

			System.out.println("Navigate to sign up  page");
		} else

		{

			System.out.println("Not navigated to sign up  page");
		}

	}

}
