package com.xbss.jdbc._01simple;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;



public class TestJDBC {
	public static void main(String[] args)  {
		try {
			// 获取connection 连接
			Connection connection = SimpleJDBCConnection.getConnection();
			// 查询语句
			Statement statement = connection.createStatement();
			// 建立sql对象执行查询
			ResultSet resultSet = statement.executeQuery("SELECT * FROM person;");
			// 存储对象
			Collection<Person> persons = new ArrayList<Person>();
			// 循环取值
			Person person = new Person();
			while(resultSet.next()){
				person.setPid(resultSet.getString("pid"));
				person.setPname(resultSet.getString("pname"));
				person.setPsex(resultSet.getInt("psex"));
				persons.add(person);
			}
			// 关闭连接
			statement.close();
			System.out.println("查询结果:\n" + persons);
		} catch (Exception e) {
			System.out.println("数据库错误LOG：");
			e.printStackTrace();
		}
		
	}
}
