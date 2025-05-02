package organisationcreate;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import objectrepository.HomePage;
import objectrepository.OrganisationPage;

public class DynamicverifyOrg extends BaseClass {
	@Test
	public void dynamicVerifyTest() throws EncryptedDocumentException, IOException, InterruptedException {
	//Dynamic element in pom
	//
		String data1=ex.getDataFromXls("Sheet1", 1, 0)+jv.getRandomNum();
		String orgName = ex.getDataFromXls("Sheet1", 1, 4);
		HomePage hp= new HomePage(driver);
	hp.organisation();
	OrganisationPage op= new OrganisationPage(driver);
	op.getsearche().sendKeys(data1);
	Thread.sleep(30000);
	op.dynamiceDD(orgName);
	op.getsrchnow().click();
	System.out.println("dynamic verify");
	}

}
