package testData;

public class NewCustomer {
	
	
	public static final String SUCCESS_MESSAGE = "Customer Registered Successfully!!!";

	public class LoginInfo {

		public static final String USERID = "mngr168114";
		public static final String PASSWORD = "nUpanan";

	}

	public class ValidationMessage {
	
		public class Name {
		public static final String EMTPY_NAME = "Customer name must not be blank";
		public static final String NAME_CONTAINS_NUMBER = "Numbers are not allowed";
		public static final String NAME_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		public static final String NAME_STARTS_WITH_SPACE = "First character can not have space";
		}
		
		public class Address {
		public static final String EMPTY_ADDRESS = "Address Field must not be blank";
		public static final String ADDRESS_START_WITH_SPACE = "First character can not have space";
		}
		
		public class City {
		public static final String EMPTY_CITY = "City Field must not be blank";
		public static final String CITY_CONTAINS_NUMBERIC = "Numbers are not allowed";
		public static final String CITY_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		public static final String CITY_STARTS_WITH_SPACE = "First character can not have space";
		}
		
		public class State {
		public static final String EMPTY_STATE = "State must not be blank";
		public static final String STATE_CONTAINS_NUMBERIC = "Numbers are not allowed";
		public static final String STATE_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		public static final String STATE_STARTS_WITH_SPACE = "First character can not have space";
		}
		
		public class Pin {
		public static final String PIN_CONTAINS_CHARATERS = "Characters are not allowed";
		public static final String EMPTY_PIN = "PIN Code must not be blank";
		public static final String PIN_DOES_NOT_HAVE_6_DIGITS = "PIN Code must have 6 Digits";
		public static final String PIN_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		public static final String PIN_STARTS_WITH_SPACE = "First character can not have space";
		}
		
		public class Telephone {
		public static final String EMPTY_TELEPHONE = "Mobile no must not be blank";		
		public static final String TELEPHONE_CONTAINS_CHARATERS = "Characters are not allowed";
		public static final String TELEPHONE_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		public static final String TELEPHONE_STARTS_WITH_SPACE = "First character can not have space";
		}
		
		public class Email {
		public static final String EMPTY_EMAIL = "Email-ID must not be blank";
		}
	}

	public class NewCustomerInfo {
		public static final String CUSTOMER_NAME = "Automation Testing";
		public static final String DOB = "01/01/1989";
		public static final String ADDRESS = "PO Box 911 8331 Duis Avenue";
		public static final String CITY = "Tampa";
		public static final String STATE = "FL";
		public static final String PIN = "466250";
		public static final String MOBILE = "455442476";
		public static final String PASSWORD = "123123";
		public static final String EMAIL = "test%s@gmail.com";

	}

}
