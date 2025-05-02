package genericutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class WebDrIverUtility {
	public void waitForPagetoLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));	
	}
public void switchWindow(WebDriver driver,String partialURL) {
	Set<String>set=driver.getWindowHandles();
	Iterator<String> it=set.iterator();
	while(it.hasNext()) {
		String windowID=it.next();
		driver.switchTo().window(windowID);
		String actUrl=driver.getCurrentUrl();
		if(actUrl.contains("module=accounts")) {
			break;
		}
	}
}
	public void switchWindowTitle(WebDriver driver,String partialTitle) {
		Set<String>set=driver.getWindowHandles();
		Iterator<String> it=set.iterator();
		while(it.hasNext()) {
			String windowID=it.next();
			driver.switchTo().window(windowID);
			String actUrl=driver.getTitle();
			if(actUrl.contains("partialTitle")) {
				break;
			}
		}
	}
	public void switchtoFrame(WebDriver driver,int index) {
	driver.switchTo().frame(index);
	
	}
}

