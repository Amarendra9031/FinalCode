package com.crm.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class DataVerificationInDB 
{
	@Test
	public void dataverification() throws Throwable
	{
		String expData = "Shashi";
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
			String actData = result.getString(2);
			if(expData.equalsIgnoreCase(actData))
			{
				System.out.println(actData+" "+" data is verified");
				break;
			}
		}
		//Step 5: close the database
		con.close();
	}
}
