package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_01_RegisterAndLoginToSystem_Level_3_ApplyAbstractTest extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private String email, userID, password, loginPageURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {

		driver = openMultiBrowsers(browser, url);
		loginPage = new LoginPageObject(driver);
		email = "test" + randomNumber() + "@gmail.com";

	}

	@Test
	public void TC_01_Register() {

		loginPageURL = loginPage.getLoginPageURL();

		loginPage.clickHereLinkToOpenRegisterPage();

		registerPage = new RegisterPageObject(driver);

		registerPage.inputEmailTextbox(email);

		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDText();

		password = registerPage.getPasswordText();
	}

	@Test
	public void TC_02_Login() {

		registerPage.openLoginPageURL(loginPageURL);

		loginPage.inputEmailAddressTextbox(userID);

		loginPage.inputPasswordTextbox(password);

		loginPage.clickLoginButton();

		homePage = new HomePageObject(driver);
		
		Assert.assertTrue(homePage.isHomePageDisplayed());
		
	}
	
	@Test
	public void TC_03_OpenMultiPages() {
		
		
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
