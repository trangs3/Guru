package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AbstractPageUI;
import pageUIs.NewCustomerPageUI;

public class NewCustomerPageObject extends AbstractPage {

	WebDriver driver;

	public NewCustomerPageObject(WebDriver mappingDriver) {

		driver = mappingDriver;
	}

	public Object removeDOBReadOnlyAttribute() {

		return removeAttributeInDOM(driver, AbstractPageUI.DYNAMIC_INPUT_ELEMENT, "type", "dob");
	}

	public boolean isCustomerRegisterSuccessfullyDisplayd() {

		return isControlDisplayed(driver, NewCustomerPageUI.SUCSESS_MESSAGE);
	}

	public String getCustomerID() {

		return getTextElement(driver, NewCustomerPageUI.CUSTOMER_ID_TEXT);
		
	}

}
