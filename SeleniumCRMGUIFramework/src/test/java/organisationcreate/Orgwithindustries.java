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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Orgwithindustries {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Owner\\Desktop\\commondata.properties");

		Properties pro = new Properties();
		pro.load(fis);

		String BROWSER=pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		
		Random ran=new Random();
		int ranno=ran.nextInt(20000);
		System.out.println(ranno);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\otms test cases.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Sheet1");
		
			
			Row rw=sh.getRow(1);
			
			String data1=rw.getCell(0).toString()+ranno;
			String industries=rw.getCell(1).toString();
		 String type=rw.getCell(2).toString();
			
		
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
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//create organisation
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	//String orgName="qspider_"+(int)(Math.random()*1000);
		driver.findElement(By.name("accountname")).sendKeys(data1);
		WebElement wes=driver.findElement(By.name("industry"));
		Select sel=new Select(wes);
		sel.selectByVisibleText(industries);
		WebElement wes1=driver.findElement(By.name("accounttype"));
		Select sel1=new Select(wes1);
		sel1.selectByVisibleText(type);
		
		
		driver.findElement(By.name("button")).click();
		//verify the industry and type
		Thread.sleep(2000);
		String indName=driver.findElement(By.id("dtlview_Industry")).getText();
		if(indName.equals(industries)) {
			System.out.println(industries + "Organisation created successfully");
		}
		else {
			System.out.println(industries + "Organisation  not created successfully");
		}
		//actual verification
		String acttype=driver.findElement(By.id("mouseArea_Type")).getText();
		if(acttype.equals(type)) {
			System.out.println(type + "TOrganisation created successfully");
		}
		else {
			System.out.println(type + "TOrganisation  not created successfully");
		}
		//integration 
		  driver.findElement(By.linkText("Organizations")).click();
		  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(data1);
		  WebElement searchfield= driver.findElement(By.id("bas_searchfield"));
		  Select sel2= new Select(searchfield);
		 sel2.selectByVisibleText("Organization Name");
		  driver.findElement(By.xpath("//input[@value=' Search Now ']")).click();
		  driver.findElement(By.xpath("//a[@title='Organizations']")).click();
		  //industry verification
		  Thread.sleep(2000);
		String indust =  driver.findElement(By.id("dtlview_Industry")).getText();
		if(indust.equals(industries)) {
			System.out.println("verified industry name");
		}
		else {
			System.out.println("ind not verify");
		}
		
		
	}

}
