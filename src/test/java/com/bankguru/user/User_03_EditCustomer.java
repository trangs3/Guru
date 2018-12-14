package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.AbstractTest;
import pageObjects.EditCustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;
import testData.EditCustomer;

public class User_03_EditCustomer extends AbstractTest {

	WebDriver driver;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private EditCustomerPageObject editCustomerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {

		driver = openMultiBrowsers(browser, url);
		loginPage = PageFactoryManager.openLoginPage(driver);
		loginPage.inputToDynamicTextbox(driver, "uid", EditCustomer.LoginInfo.USERID);
		loginPage.inputToDynamicTextbox(driver, "password", EditCustomer.LoginInfo.PASSWORD);
		homePage = loginPage.clickLoginButton();
		editCustomerPage = (EditCustomerPageObject) homePage.openDynamicPage(driver, "Edit Customer");

	}

	@Test
	public void TC_01_Verify_CustomerID_Can_Not_Be_Empty() {

		log.info("New Customer - TC 01 - Step 01: Press Tab on customer id textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", Keys.TAB);

		log.info("New Customer - TC 01 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message14"), EditCustomer.ValidationMessage.CustomerID.EMTPY_CUSTOMER_ID);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_02_Verify_CustomerID_Must_Be_Numberic() {

		log.info("New Customer - TC 02 - Step 01: Enter first chararter as space to customer id textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", "aaa");

		log.info("New Customer - TC 02 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message14"), EditCustomer.ValidationMessage.CustomerID.CUSTOMER_ID_CONTAINS_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_03_Verify_CustomerID_Can_Not_Have_Special_Charactor() {

		log.info("New Customer - TC 03 - Step 01: Enter special charater to customer id textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", "123!@#");

		log.info("New Customer - TC 03 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message14"), EditCustomer.ValidationMessage.CustomerID.CUSTOMER_ID_CONTAINS_SPECIAL_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_04_Verify_Valid_Customer_ID() {

		log.info("New Customer - TC 04 - Step 01: Enter valid ID to customer id textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", EditCustomer.CUSTOMER_ID);

		log.info("New Customer - TC 04 - Step 02: Click to submit button");
		editCustomerPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("New Customer - TC 04 - VP 01: Verify validation message is displayed");
		verifyTrue(editCustomerPage.isEditCustomerPageDisplayed());

		log.info("---------------------------------------");
	}

	// TC 05 -> 07: can't do

	@Test
	public void TC_08_Verify_Address_Can_Not_Be_Empty() {

		log.info("New Customer - TC 08 - Step 01: Enter nothing  to address textbox");
		editCustomerPage.inputToDynamicTextarea(driver, "addr", Keys.TAB);

		log.info("New Customer - TC 08 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message3"), EditCustomer.ValidationMessage.Address.EMPTY_ADDRESS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_09_Verify_City_Can_Not_Be_Empty() {

		log.info("New Customer - TC 09 - Step 01: Enter tab to city textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "city", Keys.TAB);

		log.info("New Customer - TC 09 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message4"), EditCustomer.ValidationMessage.City.EMPTY_CITY);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_10_Verify_City_Can_Not_Be_Numberic() {

		log.info("New Customer - TC 10 - Step 01: Enter name contains number to city textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "city", "123");

		log.info("New Customer - TC 10 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message4"), EditCustomer.ValidationMessage.City.CITY_CONTAINS_NUMBERIC);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_11_Verify_City_Can_Not_Have_Special_Charactor() {

		log.info("New Customer - TC 11 - Step 01: Enter special charaters to city textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "city", "!@#");

		log.info("New Customer - TC 11 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message4"), EditCustomer.ValidationMessage.City.CITY_CONTAINS_SPECIAL_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_12_Verify_State_Can_Not_Be_Empty() {

		log.info("New Customer - TC 12 - Step 01: Enter tab to state textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "state", Keys.TAB);

		log.info("New Customer - TC 12 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message5"), EditCustomer.ValidationMessage.State.EMPTY_STATE);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_13_Verify_State_Can_Not_Be_Numberic() {

		log.info("New Customer - TC 13 - Step 01: Enter number to state textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "state", "123");

		log.info("New Customer - TC 13 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message5"), EditCustomer.ValidationMessage.State.STATE_CONTAINS_NUMBERIC);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_14_Verify_State_Can_Not_Have_Special_Charactor() {

		log.info("New Customer - TC 14 - Step 01: Enter special characters to state textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "state", "!@#");

		log.info("New Customer - TC 14 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message5"), EditCustomer.ValidationMessage.State.STATE_CONTAINS_SPECIAL_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_15_Verify_Pin_Can_Not_Be_Empty() {

		log.info("New Customer - TC 15 - Step 01: Enter tab to pin textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", Keys.TAB);

		log.info("New Customer - TC 15 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message6"), EditCustomer.ValidationMessage.Pin.EMPTY_PIN);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_16_Verify_Pin_Must_Be_Numberic() {

		log.info("New Customer - TC 16 - Step 01: Enter characters to pin textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "aaa");

		log.info("New Customer - TC 16 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message6"), EditCustomer.ValidationMessage.Pin.PIN_CONTAINS_CHARATERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_17_Verify_Pin_Must_Have_6_Charater() {

		log.info("New Customer - TC 17 - Step 01: Enter 3 numbers to pin textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "123");

		log.info("New Customer - TC 17 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message6"), EditCustomer.ValidationMessage.Pin.PIN_DOES_NOT_HAVE_6_DIGITS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_18_Verify_Pin_Can_Not_Have_Special_Charactor() {

		log.info("New Customer - TC 18 - Step 01: Enter special characters to pin textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", "!@#");

		log.info("New Customer - TC 18 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message6"), EditCustomer.ValidationMessage.Pin.PIN_CONTAINS_SPECIAL_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_19_Verify_Telephone_Can_Not_Be_Empty() {

		log.info("New Customer - TC 19 - Step 01: Enter first character as space to pin textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", Keys.TAB);

		log.info("New Customer - TC 19 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message7"), EditCustomer.ValidationMessage.Telephone.EMPTY_TELEPHONE);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_20_Verify_Telephone_Can_Not_Have_Special_Charactor() {

		log.info("New Customer - TC 20 - Step 01: Enter tab to telephone textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "!@#");

		log.info("New Customer - TC 20 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message7"), EditCustomer.ValidationMessage.Telephone.TELEPHONE_CONTAINS_SPECIAL_CHARACTERS);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_21_Verify_Email_Can_Not_Be_Empty() {

		log.info("New Customer - TC 21 - Step 01: Enter tab to email textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", Keys.TAB);

		log.info("New Customer - TC 21 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message9"), EditCustomer.ValidationMessage.Email.EMPTY_EMAIL);

		log.info("---------------------------------------");
	}

	@Test
	public void TC_22_Verify_Email_Must_Be_Valid_Format() {

		log.info("New Customer - TC 22 - Step 01: Enter invalid email to email textbox");
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", "a");

		log.info("New Customer - TC 22 - VP 01: Verify validation message is displayed");
		verifyEquals(editCustomerPage.getDynamicErrorMessage(driver, "message9"), EditCustomer.ValidationMessage.Email.INVALID_EMAIL);

		log.info("---------------------------------------");
	}

	@AfterClass
	public void afterClass() {

		quitDriver(driver);
	}

}
