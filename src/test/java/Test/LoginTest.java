package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page.LoginPage;
import Util.BrowserFactory;
import Util.ExcelReader;

public class LoginTest {

WebDriver driver;
			
		ExcelReader exlRead= new ExcelReader("src\\main\\java\\Data\\TF_TestData.xlsx");
		String username = exlRead.getCellData("LoginInfo", "UserName", 2);
		String password = exlRead.getCellData("LoginInfo","Password",2);
	@Test
public void validatingloginpage() {
		
			
		driver = BrowserFactory.init();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);	
		loginpage.insertusername(username);
		loginpage.insertpassword(password);
		loginpage.clickonSigninField();
}
}
