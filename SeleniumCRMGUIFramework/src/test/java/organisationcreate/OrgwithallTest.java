package organisationcreate;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import genericutility.ExcelUtility;
import genericutility.Fileutility;
import genericutility.JavaUtility;
import objectrepository.ContactPage;
import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.OrganisationPage;
import objectrepository.OrginfoPage;
//@Listeners(listenerUtility.ListImpClass.class)
public class OrgwithallTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void orgallTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		String data1=ex.getDataFromXls("Sheet1", 3, 0)+jv.getRandomNum();
		String industries =ex.getDataFromXls("Sheet1", 1, 1);
	    String phone = ex.getDataFromXls("Sheet1", 1, 3);
	    
		
		HomePage hp= new HomePage(driver);
		hp.organisation();
		OrganisationPage op= new OrganisationPage(driver);
		op.createorgnisation(data1, industries, phone);
		System.out.println("");
		OrginfoPage oip= new OrginfoPage(driver);
		Thread.sleep(30000);
		String actOrgN=oip.getHeaderMsg().getText();
		if(actOrgN.contains(data1)) {
			System.out.println(data1 + " organisation verify==pass");
		}
		else {System.out.println(data1 + "fail");
		}
	}
	@Test(groups = "regressionTest")
	public void contactTest() throws IOException {
		
		String LASTNAME=fu.getDataFromProp("lastname");
		ContactPage cp=new ContactPage(driver);
		cp.contactPagel(LASTNAME);
		cp.getSavec().click();
		System.out.println("===contact created ===");
		
		
		
		
	}
	}


