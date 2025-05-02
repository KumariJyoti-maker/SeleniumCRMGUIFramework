package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText="Organizations")
	private WebElement orgC;
	public WebElement getOrgC() {
		return orgC;
	}
	@FindBy(linkText="Contacts")
	private WebElement contact;
	public WebElement getContact() {
		return contact;
	}
	@FindBy(linkText="Opportunities")
	private WebElement opportunity;
	public WebElement getOpportunity(){
		return opportunity;
	}
	@FindBy(linkText="Leads")
	private WebElement lead;
	public WebElement getLead() {
		return lead;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement imgso;
	public WebElement getImgso() {
		return imgso;
	}
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	public WebElement getSignOut() {
		return signOut;
	}
	public void organisation() {
		getOrgC()	.click();
	}
	public void contact() {
		getContact().click();
	}
	public void opportunity() {
		getOpportunity().click();
	}
	public void lead() {
		getLead().click();
	}
	public void signout() {
		Actions act= new Actions(driver);
		act.moveToElement(imgso).perform();
		getImgso().click();
		getSignOut().click();
		
	}
}
