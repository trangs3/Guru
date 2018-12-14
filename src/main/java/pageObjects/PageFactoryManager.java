package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

	public static LoginPageObject openLoginPage(WebDriver driver) {

		return new LoginPageObject(driver);

	}

	public static RegisterPageObject openRegisterPage(WebDriver driver) {

		return new RegisterPageObject(driver);

	}

	public static HomePageObject openHomePage(WebDriver driver) {

		return new HomePageObject(driver);

	}

	public static NewCustomerPageObject openNewCustomerPage(WebDriver driver) {

		return new NewCustomerPageObject(driver);

	}
	
	public static EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		
		return new EditCustomerPageObject(driver);
		
	}
	
	public static DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		
		return new DeleteAccountPageObject(driver);
		
	}
	
	public static WithdrawPageObject openWithdrawPage(WebDriver driver) {
		
		return new WithdrawPageObject(driver);
		
	}

	public static NewAccountPageObject openNewAccountPage(WebDriver driver) {
		
		return new NewAccountPageObject(driver);
		
	}
	
	public static DepositPageObject openDepositPage(WebDriver driver) {
		
		return new DepositPageObject(driver);
		
	}
	
	public static FundTransferPageObject openFundTransferPage(WebDriver driver) {
		
		return new FundTransferPageObject(driver);
		
	}
	
	public static BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		
		return new BalanceEnquiryPageObject(driver);
		
	}
	
	public static DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		
		return new DeleteCustomerPageObject(driver);
		
	}
	
}
