package Page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
public int RandomGenerate(int value1) {
	Random rnd = new Random();
	int value = rnd.nextInt(value1);
	return value;
}

public void SelectDropdown(WebElement locator, String visibletext) {
	Select sel = new Select(locator);
	sel.selectByVisibleText(visibletext);	
}
public void waitForElement(WebDriver driver, int timeInSeconds,WebElement locator) {
	WebDriverWait wait = new WebDriverWait (driver,timeInSeconds);
	wait.until(ExpectedConditions.visibilityOf(locator));
}
}