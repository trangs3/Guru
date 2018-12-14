package com.bankguru.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class User_01_RegisterAndLoginToSystem_Level_0_StepByStep {

	WebDriver driver;
	WebDriverWait wait;

	private String userID, password, loginPageURL;
	
	
	@BeforeClass
	public void beforeClass() {

		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
	}

	@Test
	public void TC_01_Register() {

		loginPageURL = driver.getCurrentUrl();

		// click here link to open register page
		driver.findElement(By.xpath("//a[text()='here']")).click();

		// wait for email box is visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='emailid']"))));

		// input random email
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("test" + randomNumber() + "@gmail.com");

		// click submit button
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// wait for userID to visible

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td"))));

		// get UserID
		userID = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();

		// get password
		password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();

	}

	@Test
	public void TC_02_Login() {

		driver.get(loginPageURL);

		// wait for email box to visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@name='uid']"))));

		// input email and password
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		
		// click login button
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

		// wait for welcome text to visible
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"))));

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
