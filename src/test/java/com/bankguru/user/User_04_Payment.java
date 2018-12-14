package com.bankguru.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawPageObject;
import testData.EditCustomer;
import testData.NewCustomer;
import testData.Payment;

public class User_04_Payment extends AbstractTest {

	WebDriver driver;

	private String customerID, email, accountIdAdded;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	private NewCustomerPageObject newCustomerPage;
	private EditCustomerPageObject editCustomerPage;
	private NewAccountPageObject newAccountPage;
	private DepositPageObject depositPage;
	private WithdrawPageObject withDrawPage;
	private FundTransferPageObject fundTransferPage;
	private BalanceEnquiryPageObject balanceEnquiryPage;
	private DeleteAccountPageObject deleteAccountPage;
	private DeleteCustomerPageObject deleteCustomerPage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browser, String url) {

		driver = openMultiBrowsers(browser, url);

	}

	@Test
	public void TC_01_Create_New_Customer_Account() {

		email = String.format(NewCustomer.NewCustomerInfo.EMAIL, randomNumber());

		loginPage = PageFactoryManager.openLoginPage(driver);

		log.info("Payment - TC 01 - Step 01: Enter valid user id to userID textbox");
		loginPage.inputToDynamicTextbox(driver, "uid", EditCustomer.LoginInfo.USERID);

		log.info("Payment - TC 01 - Step 02: Enter valid password to passowrd textbox");
		loginPage.inputToDynamicTextbox(driver, "password", EditCustomer.LoginInfo.PASSWORD);

		log.info("Payment - TC 01 - Step 03: Click login button");
		homePage = loginPage.clickLoginButton();

		newCustomerPage = (NewCustomerPageObject) homePage.openDynamicPage(driver, "New Customer");

		log.info("Payment - TC 01 - Step 04: Enter customer name");
		newCustomerPage.inputToDynamicTextbox(driver, "name", NewCustomer.NewCustomerInfo.CUSTOMER_NAME);

		log.info("Payment - TC 01 - Step 05: Enter DOB");
		newCustomerPage.removeDOBReadOnlyAttribute();
		newCustomerPage.inputToDynamicTextbox(driver, "dob", NewCustomer.NewCustomerInfo.DOB);

		log.info("Payment - TC 01 - Step 06: Enter Address");
		newCustomerPage.inputToDynamicTextarea(driver, "addr", NewCustomer.NewCustomerInfo.ADDRESS);

		log.info("Payment - TC 01 - Step 07: Enter city");
		newCustomerPage.inputToDynamicTextbox(driver, "city", NewCustomer.NewCustomerInfo.CITY);

		log.info("Payment - TC 01 - Step 08: Enter state");
		newCustomerPage.inputToDynamicTextbox(driver, "state", NewCustomer.NewCustomerInfo.STATE);

		log.info("Payment - TC 01 - Step 09: Enter pin");
		newCustomerPage.inputToDynamicTextbox(driver, "pinno", NewCustomer.NewCustomerInfo.PIN);

		log.info("Payment - TC 01 - Step 10: Enter mobile");
		newCustomerPage.inputToDynamicTextbox(driver, "telephoneno", NewCustomer.NewCustomerInfo.MOBILE);

		log.info("Payment - TC 01 - Step 11: Enter email");
		newCustomerPage.inputToDynamicTextbox(driver, "emailid", email);

		log.info("Payment - TC 01 - Step 12: Enter password");
		newCustomerPage.inputToDynamicTextbox(driver, "password", NewCustomer.NewCustomerInfo.PASSWORD);
		newCustomerPage.clickToDymaticButton(driver, "sub");

		log.info("Payment - TC 01 - VP 01: Verify add customer successfully mesage displayed");
		verifyTrue(newCustomerPage.isDynamicSuccessMessageDisplayed(driver, NewCustomer.SUCCESS_MESSAGE));

		// TODO verify customer info after created

		customerID = newCustomerPage.getDynamicTextByRowName(driver, "Customer ID");

		log.info("-------------------------------------------------");
	}

	@Test
	public void TC_02_Edit_Customer_Account() {

		// TODO: Update log for TC 02 to 09
		email = String.format(EditCustomer.EditCustomerInfo.EMAIL, randomNumber());

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage = (EditCustomerPageObject) homePage.openDynamicPage(driver, "Edit Customer");

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextarea(driver, "addr", EditCustomer.EditCustomerInfo.ADDRESS);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "city", EditCustomer.EditCustomerInfo.CITY);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "state", EditCustomer.EditCustomerInfo.STATE);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "pinno", EditCustomer.EditCustomerInfo.PIN);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "telephoneno", EditCustomer.EditCustomerInfo.MOBILE);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.inputToDynamicTextbox(driver, "emailid", email);

		log.info("Payment - TC 02 - Step 01: Enter ");
		editCustomerPage.clickToDymaticButton(driver, "sub");

		log.info("Payment - TC 02 - Step 01: Enter ");
		verifyTrue(editCustomerPage.isDynamicSuccessMessageDisplayed(driver, EditCustomer.SUCCESS_MESSAGE));

		// TODO verify customer info after updated

		log.info("-------------------------------------------------");
	}

	@Test
	public void TC_03_Add_New_Account() {

		log.info("Payment - TC 03 - Step 01: Enter ");
		newAccountPage = (NewAccountPageObject) homePage.openDynamicPage(driver, "New Account");

		log.info("Payment - TC 03 - Step 01: Enter ");
		newAccountPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("Payment - TC 03 - Step 01: Enter ");
		newAccountPage.selectAccountType("Current");

		log.info("Payment - TC 03 - Step 01: Enter ");
		newAccountPage.inputToDynamicTextbox(driver, "inideposit", Payment.Wallet.INIT_AMOUNT);

		log.info("Payment - TC 03 - Step 01: Click ");
		newAccountPage.clickToDymaticButton(driver, "button2");

		log.info("Payment - TC 03 - VP 01: Verify ");
		verifyTrue(newAccountPage.isDynamicSuccessMessageDisplayed(driver, Payment.ADDED_ACCOUNT_SUCCESS_MESSAGE));

		log.info("Payment - TC 03 - VP 01: Verify ");
		verifyEquals(newAccountPage.getDynamicTextByRowName(driver, "Current Amount"), Payment.Wallet.INIT_AMOUNT);

		accountIdAdded = newAccountPage.getDynamicTextByRowName(driver, "Account ID");

		log.info("-------------------------------------------------");

	}

	@Test
	public void TC_04_Transef_Money() {

		log.info("Payment - TC 04 - Step 01: Enter ");
		depositPage = (DepositPageObject) homePage.openDynamicPage(driver, "Deposit");

		log.info("Payment - TC 04 - Step 01: Enter ");
		depositPage.inputToDynamicTextbox(driver, "accountno", accountIdAdded);

		log.info("Payment - TC 04 - Step 01: Enter ");
		depositPage.inputToDynamicTextbox(driver, "ammount", Payment.Wallet.DEPOSIT_AMOUNT);

		log.info("Payment - TC 04 - Step 01: Enter ");
		depositPage.inputToDynamicTextbox(driver, "desc", Payment.DEPOSIT_DESCIPTION);

		log.info("Payment - TC 04 - Step 01: Enter ");
		depositPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 04 - Step 01: Enter ");
		verifyEquals(depositPage.getDynamicTextByRowName(driver, "Current Balance"), Payment.Wallet.EXPECTED_AMOUNT_AFTER_DEPOSIT);

		log.info("-------------------------------------------------");
	}

	@Test
	public void TC_05_Withdraw_Money() {

		log.info("Payment - TC 05 - Step 01: Enter ");
		withDrawPage = (WithdrawPageObject) homePage.openDynamicPage(driver, "Withdrawal");

		log.info("Payment - TC 05 - Step 01: Enter ");
		withDrawPage.inputToDynamicTextbox(driver, "accountno", accountIdAdded);

		log.info("Payment - TC 05 - Step 01: Enter ");
		withDrawPage.inputToDynamicTextbox(driver, "ammount", Payment.Wallet.WITHDRAW_AMOUNT);

		log.info("Payment - TC 05 - Step 01: Enter ");
		withDrawPage.inputToDynamicTextbox(driver, "desc", Payment.WITHDRAW_DESCIPTION);

		log.info("Payment - TC 05 - Step 01: Enter ");
		withDrawPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 05 - Step 01: Enter ");
		verifyEquals(withDrawPage.getDynamicTextByRowName(driver, "Current Balance"), Payment.Wallet.EXPECTED_AMOUNT_AFTER_WITHDRAW);

		log.info("-------------------------------------------------");

	}

	@Test
	public void TC_06_Transfer_Money_To_Anthoer_Account() {

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage = (FundTransferPageObject) homePage.openDynamicPage(driver, "Fund Transfer");

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage.inputToDynamicTextbox(driver, "payersaccount", accountIdAdded);

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage.inputToDynamicTextbox(driver, "payeeaccount", Payment.TRANSFERED_ACCOUNT_ID);

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage.inputToDynamicTextbox(driver, "ammount", Payment.Wallet.TRANSFER_AMOUNT);

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage.inputToDynamicTextbox(driver, "desc", Payment.TRANSFER_DESCIPTION);

		log.info("Payment - TC 06 - Step 01: Enter ");
		fundTransferPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 06 - Step 01: Enter ");
		verifyEquals(fundTransferPage.getDynamicTextByRowName(driver, "Amount"), Payment.Wallet.TRANSFER_AMOUNT);

		log.info("-------------------------------------------------");

	}

	@Test
	public void TC_07_Check_Current_Amount_After_Transfer() {

		log.info("Payment - TC 07 - Step 01: Enter ");
		balanceEnquiryPage = (BalanceEnquiryPageObject) homePage.openDynamicPage(driver, "Balance Enquiry");

		log.info("Payment - TC 07 - Step 01: Enter ");
		balanceEnquiryPage.inputToDynamicTextbox(driver, "accountno", accountIdAdded);

		log.info("Payment - TC 07 - Step 01: Enter ");
		balanceEnquiryPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 07 - Step 01: Enter ");
		verifyEquals(balanceEnquiryPage.getDynamicTextByRowName(driver, "Balance"), Payment.Wallet.EXPECTED_AMOUNT_AFTER_TRANFER);

		log.info("-------------------------------------------------");
	}

	@Test
	public void TC_08_Delete_Customer_Amount() {

		log.info("Payment - TC 08 - Step 01: Enter ");
		deleteAccountPage = (DeleteAccountPageObject) homePage.openDynamicPage(driver, "Delete Account");

		log.info("Payment - TC 08 - Step 01: Enter ");
		deleteAccountPage.inputToDynamicTextbox(driver, "accountno", accountIdAdded);

		log.info("Payment - TC 08 - Step 01: Enter ");
		deleteAccountPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 08 - Step 01: Enter ");
		deleteAccountPage.acceptAlert(driver);

		log.info("Payment - TC 08 - Step 01: Enter ");
		verifyEquals(deleteAccountPage.getTextAlert(driver), Payment.DELETED_ACCOUNT_SUCCESS_MESSAGE);

		log.info("Payment - TC 08 - Step 01: Enter ");
		deleteAccountPage.acceptAlert(driver);

		log.info("-------------------------------------------------");
	}

	@Test
	public void TC_09_Delete_Customer() {

		log.info("Payment - TC 09 - Step 01: Enter ");
		deleteCustomerPage = homePage.openDeleteCsutomerPage(driver);

		log.info("Payment - TC 09 - Step 01: Enter ");
		deleteCustomerPage.inputToDynamicTextbox(driver, "cusid", customerID);

		log.info("Payment - TC 09 - Step 01: Enter ");
		deleteCustomerPage.clickToDymaticButton(driver, "AccSubmit");

		log.info("Payment - TC 09 - Step 01: Enter ");
		deleteCustomerPage.acceptAlert(driver);

		log.info("Payment - TC 09 - Step 01: Enter ");
		verifyEquals(deleteCustomerPage.getTextAlert(driver), Payment.DELETED_CUSTOMER_SUCCESS_MESSAGE);

		log.info("-------------------------------------------------");
	}

	@AfterClass
	public void afterClass() {

		quitDriver(driver);
	}

}
