package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method to read data from database
 * @author Amarendra kumar
 *
 */
public class DataBaseUtility
{
	Connection con=null;//declare globally
	/**
	 * This method will register the driver and establish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.dbURL,IpathConstants.dbUserName,IpathConstants.dbPassword);
	}
	/**
	 * This method will close database connection
	 * @throws Throwable 
	 */
	public void closeDB() throws Throwable
	{
		con.close();
	}
	/**
	 * This method will execute the query and return the matching data to the user 
	 * @param query
	 * @param coulumnIndex
	 * @param expData
	 * @return 
	 * @return
	 * @throws Throwable 
	 */
	public String executeQueryAndGetData(String query,int coulumnIndex,String expData) throws Throwable
	{
		String data=null;
		boolean flag = false;
		ResultSet result = con.createStatement().executeQuery(query);
		while(result.next())
		{
			data=result.getNString(coulumnIndex);
			if(data.equalsIgnoreCase(expData));
			{
				flag=true;//flag rising
				break;
			}
		}
		if(flag)//flag==true
		{
			System.out.println(data +" ------> data verified");
			return expData;

		}
		else 
		{
			System.out.println(data + " --------> data not verified");
			return "";
		}

	}

}

