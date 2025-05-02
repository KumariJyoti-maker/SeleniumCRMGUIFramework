package practicedatadriventestin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.mysql.jdbc.Driver;

public class Dbselenium {

	public static void main(String[] args) throws SQLException {
		 String projectname=null;
		//create project in gui
		WebDriver driver= new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8081/AppServer/Online_Tourism_Management_System/");
		driver.findElement(By.linkText("Admin Login")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@123");
     driver.findElement(By.name("login")).click();
	
	//verify the project in db
	Driver ref=new Driver();
	//DriverManager.registerDriver(ref);
	//connect to database
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	System.out.println("===done===");
	//create sql stataemnet
	Statement sts=con.createStatement();
	//execute select query and get ressult
	ResultSet set=sts.executeQuery("select * from project");
	while(set.next()) {
		String actprojectname= set.getString(4);
		if(projectname.equals(actprojectname)) {
			//flag=true;
		
		System.out.println(projectname + "is available====PASS");
		Assert.fail();
		}
		
	}
	//if(flag=false) {
		System.out.println(projectname +"is not available==FAIL");
	//}
	//close the connection
	con.close();
	}
}
