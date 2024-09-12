package DDT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DBInsertDataIntoDatabase {
public static void main(String[] args) throws SQLException {
	
	//step1 Register DB
	Driver driver= new Driver();	
	DriverManager.registerDriver(driver);
	
	//Step2 get Connection to DB
	Connection Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/advanceselenium1","root","root");
	
	//step3 create statement
	Statement state = Con.createStatement();
	
	String query= "insert into selenium(id,first_name,last_name,address)values(10,'rahul','lipare','FL')";
	
	//step4 execute statement query	
	int result = state.executeUpdate(query);
	
	if(result==1)
		System.out.println("Data updated");
	else
		System.out.println("Data not updated ");
	
	Con.close();
	
}
}
