package hometest;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertmtd {
	@Test
	public void homePageTest(Method met) {
		System.out.println(met.getName()+ " start ");
		SoftAssert sa= new SoftAssert();
		System.out.println("a1");
		System.out.println("a2");
		sa.assertEquals("Home", "HomePage");
		System.out.println("a3");
		Assert.assertEquals("Crm", "Crm");
		System.out.println("a4");
		sa.assertAll();
		System.out.println(met.getName()+ " start ");
	}
	@Test
	public void homePageLogoTest(Method met) {
		System.out.println(met.getName()+ " start ");
		SoftAssert sa= new SoftAssert();
		System.out.println("a1");
		System.out.println("a2");
		sa.assertTrue(true);
		System.out.println("a3");
		System.out.println("a4");
		sa.assertAll();
		System.out.println(met.getName()+ " start ");
	}

}
