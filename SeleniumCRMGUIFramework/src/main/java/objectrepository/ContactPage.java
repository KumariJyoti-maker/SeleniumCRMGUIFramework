package objectrepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactPage {
	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contacts")
	private WebElement contact;

	public WebElement getContact() {
		return contact;
	}

	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plus;

	public WebElement getPlus() {
		return plus;
	}

	@FindBy(name = "lastname")
	private WebElement lastName;

	public WebElement getLastName() {
		return lastName;
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savec;

	public WebElement getSavec() {
		return savec;
	}

	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement splus;

	public WebElement getSplus() {
		return splus;
	}

	@FindBy(name = "search_text")
	private WebElement ccf;

	public WebElement getCcf() {
		return ccf;
	}

	@FindBy(name = "search_field")
	private WebElement corgn;

	public WebElement getcorgn() {
		return corgn;
	}

	@FindBy(name = "search")
	private WebElement search;

	public WebElement getSearch() {
		return search;
	}

	@FindBy(linkText = "qspider_0")
	private WebElement searchQ;

	public WebElement getSearchQ() {
		return searchQ;
	}	
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement startDate;

	public WebElement getStartDate() {
		return startDate;
	}		
	@FindBy(id ="jscal_field_support_end_date")
	private WebElement endDate;

	public WebElement getEndDate() {
		return endDate;
	}
	@FindBy(className ="dvHeaderText")
	private WebElement headerVer;

	public WebElement getheaderVer() {
		return headerVer;
	}
	@FindBy(id ="mouseArea_Last Name")
	private WebElement lastnamVer;

	public WebElement getlastnamVer() {
		return lastnamVer;
	}
	
		
	
	public void contactPagel(String lastname) {
		getContact().click();
		getPlus().click();
		getLastName().sendKeys(lastname);
	}

	public void contactPage(String lastname) {
		getContact().click();
		getPlus().click();
		getLastName().sendKeys(lastname);
		
		String parentd = driver.getWindowHandle();
		getSplus().click();
		Set<String> ids = driver.getWindowHandles();
		ids.remove(parentd);
		for (String x : ids) {

			driver.switchTo().window(x);

		}
		OrganisationPage orp = new OrganisationPage(driver);
		//String orgn = orp.orgnisation();
	//getCcf().sendKeys("qspider_"+ (int)(Math.random()*1000));
		Select sel = new Select(corgn);
		sel.selectByVisibleText("Organization Name");
		getcorgn();
		getSearch().click();
		getSearchQ().click();
		driver.switchTo().window(parentd);

	}
}
