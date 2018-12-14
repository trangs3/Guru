package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class WithdrawPageObject extends AbstractPage {

	WebDriver driver;

	public WithdrawPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
	
}
