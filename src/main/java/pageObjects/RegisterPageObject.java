package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends AbstractPage {

	WebDriver driver;

	public RegisterPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}

	public void openLoginPageURL(String url) {

		openAnyURL(driver, url);

	}

	public void inputEmailTextbox(String email) {

		waitForControlVisible(driver, RegisterPageUI.EMAIL_ID_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_ID_TEXTBOX, email);

	}

	public String getErrorMessage() {

		waitForControlVisible(driver, RegisterPageUI.ERROR_MESSAGE);
		return getTextElement(driver, RegisterPageUI.ERROR_MESSAGE);

	}

	public void clickToSubmitButton() {

		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);

	}

	public String getUserIDText() {

		waitForControlVisible(driver, RegisterPageUI.USER_ID_VALUE);
		return getTextElement(driver, RegisterPageUI.USER_ID_VALUE);

	}

	public String getPasswordText() {

		waitForControlVisible(driver, RegisterPageUI.PASSWORD_VALUE);
		return getTextElement(driver, RegisterPageUI.PASSWORD_VALUE);

	}
}
