package listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genericutility.BaseClass;
import genericutility.UtilityClassObject;

public class ListImpClass implements ITestListener,ISuiteListener {
	public static ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		String time=new Date().toString().replace(" ", "_").replace(":", " ");
		Reporter.log("Report configuration");
		ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM TITLE");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		 report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "window-11 pro");
		report.setSystemInfo("Browser", "Edge");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report back up");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("====="+ result.getMethod().getMethodName()+"<====START===>");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"<====STARTED===>");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("====="+ result.getMethod().getMethodName()+"====COMPLETE==" ,true);
		test.log(Status.PASS, result.getMethod().getMethodName()+"<====COMPLETED===>");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		String time=new Date().toString().replace(" ", "_").replace(":", " ");
		/*TakesScreenshot efd= (TakesScreenshot)BaseClass.sdriver;
		//EventFiringWebDriver efd= new EventFiringWebDriver(BaseClass.sdriver);
		File src=efd.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./screenshot/"+testname+"+"+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		TakesScreenshot tks= (TakesScreenshot)BaseClass.sdriver;
		String filepath=	tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(filepath,testname+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"<====FAILED===>");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	

}
