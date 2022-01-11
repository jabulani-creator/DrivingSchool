package com.drivingschool.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtil {
	public static Connection getConnection() {
		
		String url = "";
		String userName = "";
		String pass = "";

		try 
		{
			Properties p = new Properties();
			p.load(DbUtil.class.getClassLoader().getResourceAsStream("Connection.properties"));
			
			url  = p.getProperty("url");
			userName = p.getProperty("user");
			pass = p.getProperty("pass");
		
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("unable to connect");
		}
		
		try
		{
			Connection conn = DriverManager.getConnection(url, userName, pass);
			return conn;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

}












