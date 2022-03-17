package com.crm.Practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
public class SampleJDBCExecuteQuery
{
	@Test
	public void sampleJDBCExecuteQuery() throws SQLException
	{
		//Step 1:resister the database
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		//Step 2:get connector from database
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
		//Step 3:issue create statement
		Statement stat = con.createStatement();
		//Step 4:execute query
		ResultSet result = stat.executeQuery("select * from student;");
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		//Step 5: close the database
		con.close();
	}
}
