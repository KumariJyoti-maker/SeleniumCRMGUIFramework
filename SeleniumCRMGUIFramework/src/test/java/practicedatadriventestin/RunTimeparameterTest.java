package practicedatadriventestin;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class RunTimeparameterTest {

	@Test
	public void seleniumTest() throws EncryptedDocumentException, IOException, ParseException {
		JSONParser par=new JSONParser();
		Object obj=par.parse(new FileReader("C:\\Users\\Owner\\AppData\\Roaming\\Microsoft\\Windows\\Network Shortcuts\\ppt\\appCommonData.json"));
		JSONObject map=(JSONObject)obj;
		//String BROWSER=System.getProperty("browser");
		//String URL=System.getProperty("url");
		//String USERNAME=System.getProperty("username");
		//String PASSWORD=System.getProperty("password");
		String BROWSER=(String) map.get("browser");
		String URL=(String) map.get("url");
		String USERNAME=(String) map.get("username");
		String PASSWORD=map.get("password").toString();
		
		
		
		
		//Scanner s=new Scanner(System.in);
		//System.out.println("ask browser");
		//String browser=s.next();
		//System.out.println(browser);
		//genarate random no
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
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
         //String orgName="qspider_"+(int)(Math.random()*1000);
		driver.findElement(By.name("accountname")).sendKeys(data1);
		driver.findElement(By.name("button")).click();
		driver.quit();
	}

}
