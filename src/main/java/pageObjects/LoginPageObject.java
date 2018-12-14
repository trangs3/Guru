package pageObjects;

import org.openqa.selenium.WebDriver;
import commons.AbstractPage;
import pageUIs.LoginPageUI;

public class LoginPageObject extends AbstractPage {

	WebDriver driver;
	
	public LoginPageObject (WebDriver mappingDriver) {
		
		driver = mappingDriver;
	}
	
	
	public String getLoginPageURL() {
		
		return getCurrentURL(driver);
	} 
	
	public HomePageObject clickLoginButton() {

		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageFactoryManager.openHomePage(driver);

	}

	public RegisterPageObject clickHereLinkToOpenRegisterPage() {
		
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
				
		return PageFactoryManager.openRegisterPage(driver);
	}


	public void inputEmailAddressTextbox(String email) {
		
		waitForControlVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, email);
	}


	public void inputPasswordTextbox(String password) {
		
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
}
