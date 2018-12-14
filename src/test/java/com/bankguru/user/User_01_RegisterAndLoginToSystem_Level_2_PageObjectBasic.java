package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_01_RegisterAndLoginToSystem_Level_2_PageObjectBasic {

	WebDriver driver;
	WebDriverWait wait;

	private String userID, password, loginPageURL;
	private AbstractPage abstractPage;
	private LoginPageObject loginPage;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) {

		if (browser.equals("firefox")) {

			driver = new FirefoxDriver();

		} else if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", ".\\resources\\chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("headless")) {

			System.setProperty("webdriver.ie.driver", ".\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1366x766");
			driver = new ChromeDriver(options);
		}
		driver.manage().window().maximize();
		abstractPage = new AbstractPage();
		abstractPage.openAnyURL(driver, "http://demo.guru99.com/v4/");

	}

	 @Test
	public void TC_01_Register() {

		loginPage = new LoginPageObject(driver);

		loginPageURL = loginPage.getLoginPageURL();

		loginPage.clickHereLinkToOpenRegisterPage();

		registerPage = new RegisterPageObject(driver);

		String email = "test" + randomNumber() + "@gmail.com";

		registerPage.inputEmailTextbox(email);

		registerPage.clickToSubmitButton();

		userID = registerPage.getUserIDText();

		password = registerPage.getPasswordText();
	}

	@Test
	public void TC_02_Login() {

		registerPage.openLoginPageURL(loginPageURL);

		loginPage = new LoginPageObject(driver);

		loginPage.inputEmailAddressTextbox(userID);
		loginPage.inputPasswordTextbox(password);

		loginPage.clickLoginButton();

		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isHomePageDisplayed());
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
