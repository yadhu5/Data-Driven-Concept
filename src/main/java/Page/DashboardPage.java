package Page;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class DashboardPage extends BasePage{

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		
		this.driver = driver;
	}
	@FindBy(how=How.XPATH,using ="//h2[contains(text(),' Dashboard ')]") WebElement DASHBOARD_PAGE;
	@FindBy(how=How.XPATH,using ="//span[contains(text(),'Customers')]") WebElement CLICK_CUSTOMER_FIELD;
	@FindBy(how=How.XPATH,using = "//a[contains(text(),'Add Customer')]") WebElement ADD_CUSTOMER_FIELD;
	@FindBy(how=How.XPATH,using ="//*[@id=\"application_ajaxrender\"]/table[1]/thead/tr/th") WebElement CUSTOMER_SUMMERY_PAGE;
	
	public void verifyingthedashboardpage() {
		waitForElement(driver,4,DASHBOARD_PAGE);
		Assert.assertEquals(DASHBOARD_PAGE.getText(), "Dashboard", "Page not found");
		
	}

	public void ClickCustomerButton() {
		CLICK_CUSTOMER_FIELD.click();
	}
	public void ClickAddCustomerButton() {
		ADD_CUSTOMER_FIELD.click();
	}
	public void verifyingthecustomersummerypage() {
		Assert.assertEquals(CUSTOMER_SUMMERY_PAGE.getText(), "Accounting Summary", "Page not found");
	}
}

