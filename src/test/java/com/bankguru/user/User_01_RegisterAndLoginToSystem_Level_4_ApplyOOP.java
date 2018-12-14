package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;
import pageObjects.WithdrawPageObject;

public class User_01_RegisterAndLoginToSystem_Level_4_ApplyOOP extends AbstractTest {

	WebDriver driver;
	WebDriverWait wait;

	private String email, userID, password, loginPageURL;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;
	private NewCustomerPageObject newCustomerPage;
	private WithdrawPageObject withdrawPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {

		driver = openMultiBrowsers(browser, url);
		loginPage = PageFactoryManager.openLoginPage(driver);
		email = "test" + randomNumber() + "@gmail.com";

	}

	@Test
	public void TC_01_Register() {

		loginPageURL = loginPage.getLoginPageURL();

		registerPage = loginPage.clickHereLinkToOpenRegisterPage();

		registerPage.inputToDynamicTextbox(driver, "emailid", email);

		registerPage.clickToDymaticButton(driver, "btnLogin");

		userID = registerPage.getDynamicTextByRowName(driver, "User ID :");

		password = registerPage.getDynamicTextByRowName(driver, "Password :");		
		
	}

	@Test
	public void TC_02_Login() {

		registerPage.openLoginPageURL(loginPageURL);

		loginPage.inputToDynamicTextbox(driver, "uid", userID);

		loginPage.inputToDynamicTextbox(driver, "password", password);

		homePage = loginPage.clickLoginButton();
		
		verifyTrue(homePage.isHomePageDisplayed());
		
		verifyTrue(homePage.isIncorrectUserDisplayed(password));
		

	}

	@Test
	public void TC_03_OpenMultiPages() {

		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
				
		withdrawPage = (WithdrawPageObject) newCustomerPage.openDynamicPage(driver, "Withdrawal");
		
		editCustomerPage = (EditCustomerPageObject) withdrawPage.openDynamicPage(driver, "Edit Customer");
		
		withdrawPage = (WithdrawPageObject) editCustomerPage.openDynamicPage(driver, "Withdrawal");
	}

	@AfterClass
	public void afterClass() {
		quitDriver(driver);
	}
	

}
