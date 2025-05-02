package practicedatadriventestin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Databaseread {

	public static void main(String[] args) throws SQLException {
		//load/register the database
		Driver ref=new Driver();
		DriverManager.registerDriver(ref);
		//connect to database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		System.out.println("===done===");
		//create sql stataemnet
		Statement sts=con.createStatement();
		//execute select query and get ressult
		ResultSet set=sts.executeQuery("select * from project");
		while(set.next()) {
			System.out.println(set.getString(1) + "\t" + set.getString(2) + "\t"+ set.getString(3)+ "\t"+ set.getString(4));
		}
		//close the connection
		con.close();
	}

}
