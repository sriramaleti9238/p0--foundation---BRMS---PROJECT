package com.revature.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.sql.SQLException;

public class DataBaseConnection
{
	private static Connection connection = null;
	private DataBaseConnection() 
	{

	}
	public static Connection getConnection() 
	{
		if (connection == null) 
		{
			ResourceBundle resourceBundle = ResourceBundle.getBundle ("databaseproperties"); 
			String driver= resourceBundle.getString("driver");
			String dburl= resourceBundle.getString("dburl"); 
			String username= resourceBundle.getString("username");
			String password=resourceBundle.getString("password");

			try 
			{
				Class.forName(driver);
				connection = DriverManager.getConnection (dburl, username, password);
			} 
			catch (ClassNotFoundException | SQLException e) 
			{
				e.printStackTrace(); 
			}
		}
		return connection;
	}
}
