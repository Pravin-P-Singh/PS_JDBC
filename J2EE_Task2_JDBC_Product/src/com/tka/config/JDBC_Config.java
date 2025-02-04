package com.tka.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Config {
	public static final String URL = "jdbc:mysql://localhost:3306/product";
	public static final String USER = "root";
	public static final String PASSWORD = "tevd0161";
	
	
	public static Connection getConnectionToDB() {
		Connection connection = null;
		try {
			//load the class driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//creating the connection
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
