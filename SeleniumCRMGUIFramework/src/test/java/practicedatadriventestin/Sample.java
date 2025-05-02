package practicedatadriventestin;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Sample {
	public static void main(String[] args) throws IOException {
		//data from prop file
		//1.get the java representation objectof physical file
		//FileInputStream fis = new FileInputStream("‪./src/test/resources/commondata.properties");
		FileInputStream fis = new FileInputStream("C:\\Users\\Owner\\Desktop\\commondata.properties");
		//2.using properties class,load all the key
		Properties pro = new Properties();
		pro.load(fis);
		//3. get the value based on key
		String BROWSER=pro.getProperty("browser");
		String URL=pro.getProperty("url");
		String USERNAME=pro.getProperty("username");
		String PASSWORD=pro.getProperty("password");
		//Scanner s=new Scanner(System.in);
		//System.out.println("ask browser");
		//String browser=s.next();
		//System.out.println(browser);
		//genarate random no
		Random ran=new Random();
		int ranno=ran.nextInt(20000);
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
		//create organisation
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//String orgName="qspider_"+(int)(Math.random()*1000);
		driver.findElement(By.name("accountname")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		//verification
		String actorgName=driver.findElement(By.className("dvHeaderText")).getText();
		if(actorgName.contains(data1)) {
			System.out.println("Organisation created successfully");
		}
	}

}
