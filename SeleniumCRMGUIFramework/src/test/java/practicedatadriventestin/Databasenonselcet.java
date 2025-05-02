package practicedatadriventestin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Databasenonselcet {

	public static void main(String[] args) throws SQLException {
		//load/register the database
				Driver ref=new Driver();
				//DriverManager.registerDriver(ref);
				//connect to database
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
				System.out.println("===done===");
				//create sql stataemnet
				Statement sts=con.createStatement();
				//execute select query and get ressult
				int result=sts.executeUpdate("insert into project values(54,'hcggfhj','2025-03-22','Completed');");
				System.out.println(result);
				
		//close the connection
				con.close();
}
	
	
}
	
	
	
	


