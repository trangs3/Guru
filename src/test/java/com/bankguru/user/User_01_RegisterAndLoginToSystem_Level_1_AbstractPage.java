package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class User_01_RegisterAndLoginToSystem_Level_1_AbstractPage {

	WebDriver driver;
	WebDriverWait wait;

	private String userID, password, loginPageURL;
	private AbstractPage abstractPage;

	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
		abstractPage.openAnyURL(driver, "http://demo.guru99.com/v4/");
		
	}

	@Test
	public void TC_01_Register() {

		loginPageURL = abstractPage.getCurrentURL(driver);

		// click here link to open register page
		abstractPage.clickToElement(driver, "//a[text()='here']");

		// wait for email box is visible
		abstractPage.waitForControlVisible(driver, "//input[@name='emailid']");

		// input random email
		String email = "test" + randomNumber() + "@gmail.com";
		abstractPage.sendkeyToElement(driver, "//input[@name='emailid']", email);
		
		// click submit button
		abstractPage.clickToElement(driver,"//input[@name='btnLogin']");
		
		// wait for userID to visible
		abstractPage.waitForControlVisible(driver, "//td[text()='User ID :']//following-sibling::td");
		
		// get UserID
		userID = abstractPage.getTextElement(driver, "//td[text()='User ID :']//following-sibling::td");

		// get password
		password = abstractPage.getTextElement(driver, "//td[text()='Password :']//following-sibling::td");
	}

	@Test
	public void TC_02_Login() {

		driver.get(loginPageURL);
		
		abstractPage.openAnyURL(driver, loginPageURL);

		// wait for email box to visible
		abstractPage.waitForControlVisible(driver, "//input[@name='uid']");

		// input email and password
		abstractPage.sendkeyToElement(driver, "//input[@name='uid']", userID);
		abstractPage.sendkeyToElement(driver, "//input[@name='password']", password);
		
		// click login button
		abstractPage.clickToElement(driver,"//input[@name='btnLogin']");
		
		// wait for welcome text to visible
		abstractPage.waitForControlVisible(driver, "//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(999999) + 1;
		return number;
	}

}
