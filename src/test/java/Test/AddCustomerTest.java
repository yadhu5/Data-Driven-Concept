package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.AddCustomerPage;
import Page.DashboardPage;
import Page.LoginPage;
import Util.BrowserFactory;
import Util.ExcelReader;

public class AddCustomerTest {

	WebDriver driver;
	
	ExcelReader exlRead= new ExcelReader("src\\main\\java\\Data\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo","Password",2);
	
	String customername= exlRead.getCellData("AddContactsInfo", "FullName", 2);
	String compnayname = exlRead.getCellData("AddContactsInfo", "CompanyName", 2);
	String email = exlRead.getCellData("AddContactsInfo", "Email", 2);
	String phone = exlRead.getCellData("AddContactsInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactsInfo", "Address", 2);
	String city = exlRead.getCellData("AddContactsInfo", "City",2);
	String country = exlRead.getCellData("AddContactsInfo", "Country",2);
	String state = exlRead.getCellData("AddContactsInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactsInfo", "Zip", 2);
	
	
	@Test
	public void validatingcustomer() {
		
		driver = BrowserFactory.init();
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.insertusername(username);
		loginpage.insertpassword(password);
		loginpage.clickonSigninField();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.verifyingthedashboardpage();
		dashboardpage.ClickCustomerButton();
		dashboardpage.ClickAddCustomerButton();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.insertcustomerfullname(customername);
		addcustomerpage.insertcomapnyname(compnayname);
		addcustomerpage.insertemail(email);
		addcustomerpage.insertphonenumber(phone);
		addcustomerpage.insertaddress(address);
		addcustomerpage.insertcity(city);
		addcustomerpage.insertcountry(country);
		addcustomerpage.insertstate(state);
		addcustomerpage.insertzipcode(zip);
		addcustomerpage.clicksubmitbutton();
		
		dashboardpage.verifyingthecustomersummerypage();
		addcustomerpage.clicklistcustomerbutton();
		
		addcustomerpage.verifyEnteredCustomerNameAnddelete();
		addcustomerpage.clikokconfirmationbutton();
	}
}
