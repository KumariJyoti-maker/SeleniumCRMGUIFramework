package hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageVerTest {
	@Test
	public void homepageTest(Method met) {
		System.out.println(met.getName() + " method start ");
		
		String expectedValue="Home page";
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		String actValue=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		//hard assert
	Assert.assertEquals(actValue, expectedValue);
		driver.close();
		System.out.println(met.getName() + " method end ");
		}
		
	
	@Test
	public void homepageLogoTest(Method met) {
System.out.println(met.getName() + " method start ");
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		Assert.assertTrue(status);
		System.out.println(met.getName() + " method end ");
		driver.close();
	}

}
