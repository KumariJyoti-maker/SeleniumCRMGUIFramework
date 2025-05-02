package testngp;

import org.testng.annotations.Test;

public class PriorityTest {
	@Test(priority=1)
	public void createContact() {
		System.out.println("createContact");
	}
	@Test(priority=2)
	public void modifyContact() {
		//System.out.println("createContact");
		System.out.println("modify createContact");
	}
	@Test(priority=3)
	public void deleteContact() {
		System.out.println("deletecreateContact");
	}
}
