package practicedatadriventestin;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericutility.BaseClass;


//@Listeners(listenerUtility.ListImpClass.class)
public class Listener extends BaseClass {
	@Test(retryAnalyzer = listenerUtility.RetryListener.class)
	public void createTest() {
System.out.println("==excute==");
	//String actTitle= driver.getTitle();
	Assert.assertEquals("", "login");
	System.out.println("step1");
	System.out.println("step2");
	System.out.println("step3");
	System.out.println("step4");
	}
	/*@Test
	public void createContTest() {
		System.out.println("step1");
		//Reporter.log("step2");
		//Reporter.log("step3");
		System.out.println("step4");
	}*/
}
