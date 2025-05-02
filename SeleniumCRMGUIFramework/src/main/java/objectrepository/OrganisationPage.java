package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganisationPage {
	WebDriver driver;
	public OrganisationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement orgC;
	public WebElement getOrgC() {
		return orgC;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement plus;
	public WebElement getPlus() {
		return plus;
	}
	@FindBy(name="accountname")
	private WebElement orgName;
	public WebElement getOrgName() {
		return orgName;
	}
	@FindBy(name="industry")
	private WebElement indName;
	public WebElement getIndName() {
		return indName;
	}
	@FindBy(id="phone")
	private WebElement phoneName;
	public WebElement getPhoneName() {
		return phoneName;
	}
	@FindBy(name="button")
	private WebElement save;
	public WebElement getSave() {
		return save;
	}
	@FindBy(name="search_text")
	private WebElement searche;
	public WebElement getsearche() {
		return searche;
	}
	@FindBy(name="search_field")
	private WebElement searcdd;
	public WebElement getsearcdd() {
		return searcdd;
	}
	@FindBy(name="submit")
	private WebElement srchnow;
	public WebElement getsrchnow() {
		return srchnow;
	}
	public void dynamiceDD(String orgnam) {
		Select seld= new Select(searcdd);
		seld.selectByVisibleText(orgnam);
	}
	public void createorgnisation(String org) {
		getPlus().click();
		getOrgName().sendKeys(org);
	}
	public void createorgnisation(String org,String indname,String phone) {
		getPlus().click();
		getOrgName().sendKeys(org);
		Select sel= new Select(indName);
		sel.selectByVisibleText(indname);
		
		getPhoneName().sendKeys(phone);
		getSave().click();
		
	}
}
