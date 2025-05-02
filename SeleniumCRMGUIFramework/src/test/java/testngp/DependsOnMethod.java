package testngp;

import org.testng.annotations.Test;

public class DependsOnMethod {
	@Test(invocationCount=10)
	public void createOrder() {
		System.out.println("createorder==>123");
		//String str=null;
		//System.out.println(str.equals("123"));
	}
	@Test(enabled=false)
	//@Test(dependsOnMethods ="createOrder")
	public void deleteOrder( ) {
		System.out.println("deletecreateOrder==>123");
	}
}
