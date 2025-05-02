package practicedatadriventestin;

import java.io.FileInputStream;
import java.io.IOException;
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
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadfromXml {
	@Test
	public void readxmlTest(XmlTest test) throws EncryptedDocumentException, IOException {
		
		String BROWSER=test.getParameter("browser");
		System.out.println(test.getParameter("browser"));
		String URL	= test.getParameter("url");
		String USERNAME=test.getParameter("username");
		String PASSWORD=test.getParameter("password");
		
		
		Random ran=new Random();
		int ranno=ran.nextInt(200);
		System.out.println(ranno);
		FileInputStream fis1 = new FileInputStream("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\otms test cases.xlsx");
		Workbook wb=WorkbookFactory.create(fis1);
		Sheet sh=wb.getSheet("Otms smtc ");
		
			
			Row rw=sh.getRow(1);
			
			String data1=rw.getCell(0).toString()+ranno;
			
		
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
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         //String orgName="qspider_"+(int)(Math.random()*1000);
		driver.findElement(By.name("accountname")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		driver.quit();
		
	}

}
