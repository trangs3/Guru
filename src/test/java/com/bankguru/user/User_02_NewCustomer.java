package com.bankguru.user;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import testData.NewCustomer;

public class User_02_NewCustomer extends AbstractTest {

	WebDriver driver;

	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {

		driver = openMultiBrowsers(browser, url);
		loginPage = PageFactoryManager.openLoginPage(driver);
		loginPage.inputToDynamicTextbox(driver, "uid", NewCustomer.LoginInfo.USERID);
		loginPage.inputToDynamicTextbox(driver, "password", NewCustomer.LoginInfo.PASSWORD);
		homePage = loginPage.clickLoginButton();
		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");
	}

	@Test
	public void TC_01_Verify_Name_Can_Not_Be_Empty() {

		log.info("New Customer - TC 01 - Step 01: Press Tab on name textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "name", Keys.TAB);

		log.info("New Customer - TC 01 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message"), NewCustomer.ValidationMessage.Name.EMTPY_NAME);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_02_Verify_Name_Can_Not_Be_Numberic() {

		log.info("New Customer - TC 02 - Step 01: Enter name with numberic to name textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "name123");

		log.info("New Customer - TC 02 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message"), NewCustomer.ValidationMessage.Name.NAME_CONTAINS_NUMBER);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_03_Verify_Name_Can_Not_Have_Special_Characters() {

		log.info("New Customer - TC 03 - Step 01: Enter special charater to name textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "name", "name!@#");

		log.info("New Customer - TC 03 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message"), NewCustomer.ValidationMessage.Name.NAME_CONTAINS_SPECIAL_CHARACTERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_04_Verify_Name_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 04 - Step 01: Enter first chararter as space to name textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "name", " test");

		log.info("New Customer - TC 04 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message"), NewCustomer.ValidationMessage.Name.NAME_STARTS_WITH_SPACE);

		log.info("-----------------------------------------");
	}

	@Test
	public void TC_05_Verify_Address_Can_Not_Be_Empty() {

		log.info("New Customer - TC 05 - Step 01: Enter nothing  to address textbox");
		newCustomerPage.inputToDynamicTextarea(driver, "addr", Keys.TAB);

		log.info("New Customer - TC 05 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message3"), NewCustomer.ValidationMessage.Address.EMPTY_ADDRESS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_06_Verify_Address_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 06 - Step 01: Enter first chararter as space to address textbox");
		newCustomerPage.inputToDynamicTextarea(driver, "addr", " test");

		log.info("New Customer - TC 06 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message3"), NewCustomer.ValidationMessage.Address.ADDRESS_START_WITH_SPACE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_07_Verify_City_Can_Not_Be_Empty() {

		log.info("New Customer - TC 07 - Step 01: Enter tab to city textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "city", Keys.TAB);

		log.info("New Customer - TC 07 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message4"), NewCustomer.ValidationMessage.City.EMPTY_CITY);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_08_Verify_City_Can_Not_Be_Numberic() {

		log.info("New Customer - TC 08 - Step 01: Enter name contains number to city textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "name123");

		log.info("New Customer - TC 08 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message4"), NewCustomer.ValidationMessage.City.CITY_CONTAINS_NUMBERIC);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_09_Verify_City_Can_Not_Have_Special_Characters() {

		log.info("New Customer - TC 09 - Step 01: Enter special charaters to city textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "city", "name!@#");

		log.info("New Customer - TC 09 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message4"), NewCustomer.ValidationMessage.City.CITY_CONTAINS_SPECIAL_CHARACTERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_10_Verify_City_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 10 - Step 01: Enter first character as space to city textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "city", " test");

		log.info("New Customer - TC 10 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message4"), NewCustomer.ValidationMessage.City.CITY_STARTS_WITH_SPACE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_11_Verify_State_Can_Not_Be_Empty() {

		log.info("New Customer - TC 11 - Step 01: Enter tab to state textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "state", Keys.TAB);

		log.info("New Customer - TC 11 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message5"), NewCustomer.ValidationMessage.State.EMPTY_STATE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_12_Verify_State_Can_Not_Be_Numberic() {

		log.info("New Customer - TC 12 - Step 01: Enter number to state textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "123");

		log.info("New Customer - TC 12 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message5"), NewCustomer.ValidationMessage.State.STATE_CONTAINS_NUMBERIC);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_13_Verify_State_Can_Not_Have_Special_Characters() {

		log.info("New Customer - TC 13 - Step 01: Enter special characters to state textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "state", "name!@#");

		log.info("New Customer - TC 13 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message5"), NewCustomer.ValidationMessage.State.STATE_CONTAINS_SPECIAL_CHARACTERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_14_Verify_State_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 14 - Step 01: Enter first character as space to state textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "state", " test");

		log.info("New Customer - TC 14 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message5"), NewCustomer.ValidationMessage.State.STATE_STARTS_WITH_SPACE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_15_Verify_Pin_Must_Be_Numberic() {

		log.info("New Customer - TC 15 - Step 01: Enter characters to pin textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "test");

		log.info("New Customer - TC 15 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message6"), NewCustomer.ValidationMessage.Pin.PIN_CONTAINS_CHARATERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_16_Verify_Pin_Can_Not_Be_Empty() {

		log.info("New Customer - TC 16 - Step 01: Enter tab to pin textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", Keys.TAB);

		log.info("New Customer - TC 16 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message6"), NewCustomer.ValidationMessage.Pin.EMPTY_PIN);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_17_Verify_Pin_Must_Have_6_Digits() {

		log.info("New Customer - TC 17 - Step 01: Enter 3 numbers to pin textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "123");

		log.info("New Customer - TC 17 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message6"), NewCustomer.ValidationMessage.Pin.PIN_DOES_NOT_HAVE_6_DIGITS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_18_Verify_Pin_Can_Not_Have_Special_Characters() {

		log.info("New Customer - TC 18 - Step 01: Enter special characters to pin textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", "name!@#");

		log.info("New Customer - TC 18 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message6"), NewCustomer.ValidationMessage.Pin.PIN_CONTAINS_SPECIAL_CHARACTERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_19_Verify_Pin_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 19 - Step 01: Enter first character as space to pin textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", " test");

		log.info("New Customer - TC 19 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message6"), NewCustomer.ValidationMessage.Pin.PIN_STARTS_WITH_SPACE);

		log.info("-----------------------------------------");

	}

	/*
	 * @Test public void TC_20_Verify_Pin_Can_Not_Have_First_Blank_Space() {
	 * 
	 * inputToDymaticTextbox(driver, "pinno", " test"); verifyEquals(getDynamicErrorMessage(driver, "message6"), "First character can not have space");
	 * 
	 * }
	 */

	@Test
	public void TC_21_Verify_Telephone_Can_Not_Be_Empty() {

		log.info("New Customer - TC 21 - Step 01: Enter tab to telephone textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", Keys.TAB);

		log.info("New Customer - TC 21 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message7"), NewCustomer.ValidationMessage.Telephone.EMPTY_TELEPHONE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_22_Verify_Telephone_Can_Not_Have_First_Charater_As_Blank() {

		log.info("New Customer - TC 22 - Step 01: Enter first charcter as space to telephone textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", " test");

		log.info("New Customer - TC 22 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message7"), NewCustomer.ValidationMessage.Telephone.TELEPHONE_STARTS_WITH_SPACE);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_23_Verify_Telephone_Must_Be_Numberic() {

		log.info("New Customer - TC 23 - Step 01: Enter characters to telephone textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "123 123");

		log.info("New Customer - TC 23 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message7"), NewCustomer.ValidationMessage.Telephone.TELEPHONE_CONTAINS_CHARATERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_24_Verify_Telephone_Can_Not_Have_Special_Characters() {

		log.info("New Customer - TC 24 - Step 01: Enter special characters to telephone textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", "name!@#");

		log.info("New Customer - TC 24 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message7"), NewCustomer.ValidationMessage.Telephone.TELEPHONE_CONTAINS_SPECIAL_CHARACTERS);

		log.info("-----------------------------------------");

	}

	@Test
	public void TC_25_Verify_Email_Can_Not_Be_Empty() {

		log.info("New Customer - TC 25 - Step 01: Enter tab to email textbox");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", Keys.TAB);

		log.info("New Customer - TC 25 - VP 01: Verify validation message is displayed");
		verifyEquals(newCustomerPage.getDynamicErrorMessage(driver, "message9"), NewCustomer.ValidationMessage.Email.EMPTY_EMAIL);

		log.info("-----------------------------------------");

	}

	@AfterClass
	public void afterClass() {

		quitDriver(driver);
	}

}
