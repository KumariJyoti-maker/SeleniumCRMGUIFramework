package testngp;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportPractice {
	
	ExtentReports report;
	@BeforeSuite
	public void config() {
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM TITLE");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window-11 pro");
		report.setSystemInfo("Browser", "Edge");
	}
	@AfterSuite
	public void configas() {
	report.flush();
	}


@Test
public void contact2Test() {
	WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot tks= (TakesScreenshot)driver;
	String filepath=	tks.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test=report.createTest("contact2Test");
	test.log(Status.INFO, "login to app");
	test.log(Status.INFO, "navigate to app");
	if("HDFCbank".equals("HDFC")) {
		test.log(Status.PASS, "create contact");
	}else {
		test.addScreenCaptureFromBase64String(filepath,"errorfile");
	}

}


}
