package com.sxb.dao;

import java.sql.*;

// 返回一个数据库连接
public class DataBaseConnection {
	public static Connection getConnection() {
		Connection connection = null;
		String CLASSFORNAME = "com.mysql.jdbc.Driver";
		String serverInfo = "jdbc:mysql://localhost:3306/stu?"
				+ "user=root&password=96333369bu"
				+ "&useUnicode=true&characterEncoding=utf-8";
		try {
			// 装载类
			Class.forName(CLASSFORNAME);
			connection = DriverManager.getConnection(serverInfo);
		} catch (Exception e) {
			System.out.println("DEBUG:" + "数据库连接出错");
			e.printStackTrace();
		}
		return connection;
	}
	public static void main(String[] args ){
		System.out.println("ss" + getConnection());
	}
}
