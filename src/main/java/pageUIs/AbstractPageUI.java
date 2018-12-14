package pageUIs;

public class AbstractPageUI {

	public static final String DYNAMIC_PAGE_LINK = "//a[contains(text(),'%s')]";
	public static final String DELETE_CUSTOMER_PAGE_LINK = "//ul[@class='menusubnav']//a[text() = 'Delete Customer']";
	public static final String DYNAMIC_INPUT_ELEMENT = "//input[@name='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_LABEL = "//label[@id='%s']";
	public static final String DYNAMIC_TEXT_AREA = "//textarea[@name='%s']";
	public static final String DYNAMIC_VALUE_TEXT = "//td[text()='%s']//following-sibling::td";
	public static final String DYNAMIC_SUCCESS_MESSAGE = "//p[text()='%s']";
		
}
