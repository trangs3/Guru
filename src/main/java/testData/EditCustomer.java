package testData;

public class EditCustomer {

	public static final String CUSTOMER_ID = "66158";
	public static final String SUCCESS_MESSAGE = "Customer details updated Successfully!!!";

	public class LoginInfo {

		public static final String USERID = "mngr168114";
		public static final String PASSWORD = "nUpanan";

	}

	public class ValidationMessage {

		public class CustomerID {
			public static final String EMTPY_CUSTOMER_ID = "Customer ID is required";
			public static final String CUSTOMER_ID_CONTAINS_CHARACTERS = "Characters are not allowed";
			public static final String CUSTOMER_ID_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		}

		public class Name {
			public static final String EMTPY_NAME = "Customer name must not be blank";
			public static final String NAME_CONTAINS_NUMBER = "Numbers are not allowed";
			public static final String NAME_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		}

		public class Address {
			public static final String EMPTY_ADDRESS = "Address Field must not be blank";
		}

		public class City {
			public static final String EMPTY_CITY = "City Field must not be blank";
			public static final String CITY_CONTAINS_NUMBERIC = "Numbers are not allowed";
			public static final String CITY_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		}

		public class State {
			public static final String EMPTY_STATE = "State must not be blank";
			public static final String STATE_CONTAINS_NUMBERIC = "Numbers are not allowed";
			public static final String STATE_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		}

		public class Pin {
			public static final String PIN_CONTAINS_CHARATERS = "Characters are not allowed";
			public static final String EMPTY_PIN = "PIN Code must not be blank";
			public static final String PIN_DOES_NOT_HAVE_6_DIGITS = "PIN Code must have 6 Digits";
			public static final String PIN_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";
		}

		public class Telephone {
			public static final String EMPTY_TELEPHONE = "Mobile no must not be blank";
			public static final String TELEPHONE_CONTAINS_SPECIAL_CHARACTERS = "Special characters are not allowed";

		}

		public class Email {
			public static final String EMPTY_EMAIL = "Email-ID must not be blank";
			public static final String INVALID_EMAIL = "Email-ID is not valid";
		}
	}

	public class EditCustomerInfo {
		public static final String ADDRESS = "1883 Cursus Avenue";
		public static final String CITY = "Houston";
		public static final String STATE = "Texas";
		public static final String PIN = "166455";
		public static final String MOBILE = "1779728081";
		public static final String EMAIL = "test%s@gmail.com";
	}

}
