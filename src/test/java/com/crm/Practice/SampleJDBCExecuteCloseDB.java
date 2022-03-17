package com.crm.Practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.testng.annotations.Test;
import com.mysql.cj.jdbc.Driver;
public class SampleJDBCExecuteCloseDB 
{
	@Test
	public void sampleJDBCExecuteUpdate () throws SQLException
	{
		Connection con=null;
		try
		{
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
			Statement stat = con.createStatement();
			System.out.println("database is opened");
			//insert into student value(10,'Aman','male');
			int result=stat.executeUpdate("insert into stut values(11,'Aman','male')");
			if(result==1)
			{
				System.out.println("data added successfully");
			}
			else
			{
				System.out.println("data not added");
			}
		}
		catch(Exception e)
		{

		}
		finally
		{
			con.close();
			System.out.println("database is closed");
		}
	}
}
