package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.NewAccountPageUI;

public class NewAccountPageObject extends AbstractPage {

	WebDriver driver;

	public NewAccountPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}

	public void selectAccountType(String value) {

		selectItemInDropdown(driver, NewAccountPageUI.ACCOUNT_TYPE_SELECT, value);
	}

	public boolean isAccountGeneratedSuccessfullyMessageDisplayed() {

		return isControlDisplayed(driver, NewAccountPageUI.SUCCESS_MESSAGE_TEXT);

	}
}
