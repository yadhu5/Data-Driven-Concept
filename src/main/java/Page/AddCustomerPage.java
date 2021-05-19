package Page;

import java.util.Random;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {

	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@name='account']")
	WebElement FULL_NAME_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	WebElement COMPANY_NAME_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	WebElement EMAIL_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	WebElement PHONE_NO_FIELD;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement ADDRESS_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement CITY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//select[@name='country']")
	WebElement COUNTRY_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement STATE_FIELD_LOCATOR;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	WebElement ZIPCODE_LOCATOR;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	WebElement SUBMIT_BUTTON;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customer')]")
	WebElement LIST_CUSTOMER_BUTTON;
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	WebElement OK_CONFIRMATION_BUTTON;

	String customerenteredname;

	public void insertcustomerfullname(String customername) {
		waitForElement(driver, 3, FULL_NAME_LOCATOR);
		int generaterandom = RandomGenerate(999);

		customerenteredname = customername + generaterandom;
		FULL_NAME_LOCATOR.sendKeys(customerenteredname);
	}

	public void insertcomapnyname(String companyname) {
		int generaterandom = RandomGenerate(999);
		SelectDropdown(COMPANY_NAME_LOCATOR, companyname);
		COMPANY_NAME_LOCATOR.sendKeys(companyname + generaterandom);

	}

	public void insertemail(String email) {
		int generaterandom = RandomGenerate(999);
		EMAIL_FIELD_LOCATOR.sendKeys(generaterandom + email);
	}

	public void insertphonenumber(String phone) {
		int generaterandom = RandomGenerate(999);
		PHONE_NO_FIELD.sendKeys(phone + generaterandom);

	}

	public void insertaddress(String address) {
		ADDRESS_FIELD_LOCATOR.sendKeys(address);
	}

	public void insertcity(String city) {
		CITY_FIELD_LOCATOR.sendKeys(city);
	}

	public void insertcountry(String country) {
		COUNTRY_FIELD_LOCATOR.sendKeys(country);
	}

	public void insertstate(String state) {
		STATE_FIELD_LOCATOR.sendKeys(state);
	}

	public void insertzipcode(String zip) {
		ZIPCODE_LOCATOR.sendKeys(zip);
	}

	public void clicksubmitbutton() {
		SUBMIT_BUTTON.click();
	}

	public void clicklistcustomerbutton() {
		waitForElement(driver, 4, LIST_CUSTOMER_BUTTON);
		LIST_CUSTOMER_BUTTON.click();
	}
	// tbody/tr[1]/td[3]
	// tbody/tr[2]/td[3]
	// tbody/tr[3]/td[3]
	// tbody/tr[i]/td[3]
	// tbody/tr[i]/td[3]/following-sibling::td[4]/a[2]

	public void verifyEnteredCustomerNameAnddelete() {
		String before_xpath = "//tbody/tr[";
		String after_xpath = "]/td[3]";

		for (int i = 1; i <= 10; i++) {
			String enteredname = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//		System.out.println(enteredname);
//	Assert.assertEquals(enteredname, customerenteredname, " Name not found as entered!");
//	break;

			if (enteredname.contains(customerenteredname)) {
				System.out.println(customerenteredname);
				driver.findElement(By.xpath(before_xpath + i + after_xpath + "/following-sibling::td[4]/a[2]")).click();

			}

		}
	}

	public void clikokconfirmationbutton() {
		waitForElement(driver, 4, OK_CONFIRMATION_BUTTON);
		OK_CONFIRMATION_BUTTON.click();
		Alert alert = driver.switchTo().alert();

		// Capturing alert message.
		driver.switchTo().alert().getText();

		// Accepting alert
		alert.accept();
		
		
	}
}
