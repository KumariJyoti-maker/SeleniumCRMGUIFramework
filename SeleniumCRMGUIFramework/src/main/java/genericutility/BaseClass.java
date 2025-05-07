package genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericutility.ExcelUtility;
import genericutility.Fileutility;
import genericutility.JavaUtility;
import objectrepository.HomePage;
import objectrepository.LoginPage;

public class BaseClass {
	
	public WebDriver driver=null;
	public  static WebDriver sdriver;
	public Fileutility fu = new Fileutility();
	public ExcelUtility ex=new ExcelUtility();
	public JavaUtility jv=new JavaUtility();
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void configBSuit() {
		System.out.println("===connect to DB,Report config====");
		
		
	}
	//@Parameters("browser")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	//For cross browser 
	//public void configBClass(String browser) throws IOException {
		public void configBClass() throws IOException {
		
		System.out.println("===launch the browser====");
		String BROWSER=System.getProperty("browser" , fu.getDataFromProp("browser"));
		//String BROWSER=fu.getDataFromProp("browser");
		//String BROWSER=browser;
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
		sdriver=driver;
		//UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void configBM() throws IOException {
		System.out.println("===login====");
		String URL=System.getProperty("url" , fu.getDataFromProp("url"));
		String USERNAME=System.getProperty("username" , fu.getDataFromProp("username"));
		String PASSWORD=System.getProperty("password" , fu.getDataFromProp("password"));
		
		//String URL=fu.getDataFromProp("url");
		//String USERNAME=fu.getDataFromProp("username");
		//String PASSWORD=fu.getDataFromProp("password");
		
		
		LoginPage lp= new LoginPage(driver);
		lp.login(URL,USERNAME,PASSWORD);
	}
	
	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void configas() {
		System.out.println("=== close DB connection and Report back up  ====");
		
	}
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configac() {
		System.out.println("===Close the browse====");
		driver.close();
		
	}
	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void configam() {
		System.out.println("===logout====");
		HomePage hp =new HomePage(driver);
		hp.signout();
	}

}
