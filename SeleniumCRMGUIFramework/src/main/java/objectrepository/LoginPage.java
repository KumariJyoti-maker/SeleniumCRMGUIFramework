package objectrepository;
/**
 * pom class for login crm
 * 
 * @author Jyoti
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericutility.WebDrIverUtility;

public class LoginPage extends WebDrIverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private WebElement userFild;
	public WebElement getuserFild() {
		return userFild;
	}
	
	@FindBy(name="user_password")
	private WebElement passEdit;
	public WebElement getpassEdit() {
		return passEdit;
	}
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	public WebElement getloginBtn() {
		return loginBtn;
	}
	/**
	 * login with un,pass and url
	 * @param url
	 * @param username
	 * @param password
	 */
	public void login(String url,String username,String password) {
		driver.manage().window().maximize();
		waitForPagetoLoad(driver);
		driver.get(url);
		getuserFild().sendKeys(username);
		getpassEdit().sendKeys(password);
		getloginBtn().click();
	}
	
	

}
