package com.xbss.jdbc._01simple;

import java.sql.Connection;
import java.sql.DriverManager;


public class SimpleJDBCConnection {
	public static Connection getConnection(){
		java.sql.Connection connection = null;
		String clazz = "com.mysql.jdbc.Driver";
		String url = ""
				+ "jdbc:mysql://localhost:3306/myjdbc?"
				+ "user=root&"
				+ "password=96333369bu";
		try {
			// 装载数据库驱动
			Class.forName(clazz);
			connection = DriverManager.getConnection(url);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return connection;
	}
}
