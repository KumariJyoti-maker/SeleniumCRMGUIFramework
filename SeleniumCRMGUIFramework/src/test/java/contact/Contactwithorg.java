package contact;

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

public class Contactwithorg {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
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
		 String LASTNAME=pro.getProperty("lastname");	
		
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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		//String LASTNAME=poj.getProperty("lastname");
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		String header=driver.findElement(By.className("dvHeaderText")).getText();
		if(header.equals(LASTNAME)) {
			System.out.println(LASTNAME+ "===Pass===");
		}
		else {
			System.out.println(LASTNAME+ "==FAIL==");
		}
		String actLastname=driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actLastname.equals(LASTNAME)) {
			System.out.println(LASTNAME + " ===Pass===");
		}
		else {
			System.out.println(LASTNAME+ "==FAIL==");
		}
		
		
		
	}

}
