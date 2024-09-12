package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBFetchDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		
		//step1 : Register DB
		Driver driver = new Driver();		
		DriverManager.registerDriver(driver);
		System.out.println("step 1 done");
		//step2 : Connect to DB
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium1","root","root");
		System.out.println("step 2 done");
		//step 3 : create statement
		Statement state = con.createStatement();
	//	String query= select * from selenium;
		System.out.println("step 3 done");
		
		//step 4
		ResultSet result = state.executeQuery("select * from selenium;");
		
		while(result.next())
		{
		int ID = result.getInt(1);
		System.out.println(ID);
		
		String fname=result.getString(2);
		System.out.println(fname);
		}
		System.out.println("step 4 done");
		
		con.close();
		System.out.println("step 5 done");
	}
}
