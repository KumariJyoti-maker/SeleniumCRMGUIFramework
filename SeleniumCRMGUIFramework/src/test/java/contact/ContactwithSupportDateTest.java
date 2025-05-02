package contact;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericutility.BaseClass;
import genericutility.UtilityClassObject;
import objectrepository.ContactPage;

public class ContactwithSupportDateTest extends BaseClass {
	@Test
	public void contactSupportDate() throws IOException {
		UtilityClassObject.getTest().log(Status.INFO, "actual date");
		Date dat=new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("YYYY-MM-dd");
		String acDate=sdf.format(dat);
		System.out.println(acDate);
		SimpleDateFormat sdf1= new SimpleDateFormat("YYYY-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH,30);
		String dateRequire=sdf1.format(cal.getTime());
		String LASTNAME=fu.getDataFromProp("lastname");
		ContactPage cp=new ContactPage(driver);
		cp.contactPagel(LASTNAME);
		cp.getStartDate().clear();
		cp.getStartDate().sendKeys(acDate);
		cp.getEndDate().clear();
		cp.getEndDate().sendKeys(dateRequire);
		cp.getSavec().click();
		System.out.println("===contact with Date created=====");
		UtilityClassObject.getTest().log(Status.PASS, "contact with Date created");
	}

}
