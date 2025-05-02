package testngp;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericutility.ExcelUtility;

public class Productinfo {
	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brandname,String productname) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in");
		//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(30000);
		String x ="//span[text()='"+productname+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		//String x ="//span[text()='Apple iPhone 13 (128GB) - Blue']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span[1]/span[1]";
		String price=driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility eu= new ExcelUtility();
		int roc=eu.getRowCount("Sheet2");
		
		Object[][] objarr=new Object[roc][2];
		for(int i=0;i<roc;i++) {
		objarr[i][0]=eu.getDataFromXls("Sheet2", i+1, 0);
		objarr[i][1]=eu.getDataFromXls("Sheet2", i+1, 1);
		}
		return objarr;
	}
	}

	/*public Object[][] getData() {
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="iphone";
		objarr[0][1]="Apple iPhone 15 (128 GB) - Green";
		
		
		objarr[1][0]="iphone";
		objarr[1][1]="Apple iPhone 15 (128 GB) - Pink";
		
		
		objarr[2][0]="iphone";
		objarr[2][1]="Apple iPhone 13 (128GB) - Blue";
		
		
		return objarr;*/

