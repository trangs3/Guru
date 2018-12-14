package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPage {

	WebDriver driver;

	public HomePageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}
	
	public boolean isHomePageDisplayed() {
		
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGE);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGE);
		
	}

	public boolean isIncorrectUserDisplayed(String userID) {
		
		return isControlUnDisplayed(driver, HomePageUI.USER_ID_TEXT, userID);
	}

}
