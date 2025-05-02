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
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericutility.BaseClass;
import objectrepository.ContactPage;

public class ContactcreateTest extends BaseClass{
	@Test(groups = "regressionTest")
	public void createContactTest() throws IOException {
		
		String LASTNAME=fu.getDataFromProp("lastname");
		ContactPage cp=new ContactPage(driver);
		cp.contactPagel(LASTNAME);
		cp.getSavec().click();
		System.out.println("===contact created successfully===");
		//verify contac header
		String header=cp.getheaderVer().getText();
		boolean status=header.trim().contains(LASTNAME);
		Assert.assertEquals(status, true);
		System.out.println("headerverify");
		String actLastname=cp.getlastnamVer().getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actLastname,LASTNAME);
		System.out.println("lastname verify");
		//sa.assertAll();
		
		
		
		
	}

}
