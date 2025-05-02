package testngp;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
@Test(dataProvider = "getData")
public void createContactTest(String firstname,String lastname, long phone )
{
	System.out.println("firstnmae is " + firstname + " Lastname is " + lastname + " phonenumber is " + phone);
}
@DataProvider
public Object[][] getData() {
	Object[][] objarr=new Object[3][3];
	objarr[0][0]="Jyoti";
	objarr[0][1]="kumari";
	objarr[0][2]=86644246475l;
	
	objarr[1][0]="munja";
	objarr[1][1]="hffh";
	objarr[1][2]=866442576475l;
	
	objarr[2][0]="gdg";
	objarr[2][1]="qwr";
	objarr[2][2]=86644746475l;
	
	return objarr;
}
}
