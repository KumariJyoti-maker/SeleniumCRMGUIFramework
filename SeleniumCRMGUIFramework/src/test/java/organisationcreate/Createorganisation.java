package organisationcreate;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import genericutility.ExcelUtility;
import genericutility.Fileutility;
import genericutility.JavaUtility;
import objectrepository.LoginPage;

public class Createorganisation {
public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
	Fileutility fit=new Fileutility();
	ExcelUtility ex=new ExcelUtility();

	String BROWSER=fit.getDataFromProp("browser");
	String URL=fit.getDataFromProp("url");
	String USERNAME=fit.getDataFromProp("username");
	String PASSWORD=fit.getDataFromProp("password");
	JavaUtility jv=new JavaUtility();
	
	//Random ran=new Random();
	//int ranno=ran.nextInt(20000);
	//System.out.println(ranno);
	
		
		String data1=ex.getDataFromXls("Sheet1", 2, 0)+jv.getRandomNum();
		
	
	WebDriver driver=null;
	if (BROWSER.equals("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equals("firefox")) {
		driver= new FirefoxDriver();
	}
	else if(BROWSER.equals("edge")) {
		driver= new EdgeDriver();
	}
	else {
		driver= new ChromeDriver();
	}
	//login
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	lp.login(URL,USERNAME ,PASSWORD);
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//driver.findElement(By.id("submitButton")).click();
	//create organisation
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

	driver.findElement(By.name("accountname")).sendKeys(data1);
	driver.findElement(By.name("button")).click();
	//verification of header
	Thread.sleep(2000);
	String headerName=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	System.out.println(headerName);
	if(headerName.contains(data1)) {
		System.out.println(data1 + "Organisation created successfully");
	}
	else {
		System.out.println(data1 + "Organisation  not created successfully");
	}
	//actual verification
	Thread.sleep(20000);
	String actorg=driver.findElement(By.id("mouseArea_Organization Name")).getText();
	System.out.println(actorg);
	if(actorg.equals(data1)) {
		System.out.println(data1  +  " AOrganisation created successfully");
	}
	else {
		System.out.println(data1 + " AOrganisation  not created successfully");
	}
	
	
}


}

