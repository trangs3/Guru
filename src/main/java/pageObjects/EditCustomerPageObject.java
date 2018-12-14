package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.EditCustomerPageUI;

public class EditCustomerPageObject extends AbstractPage {

	WebDriver driver;

	public EditCustomerPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}

	public boolean isEditCustomerPageDisplayed() {
		
		return isControlDisplayed(driver, EditCustomerPageUI.PAGE_TITLE_TEXT);
	}
	

}
