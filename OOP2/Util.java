package com.student.utils;

import java.sql.*;
import java.util.*;

import com.student.entity.Student;
/**
 * 
 * @author Administrator
 * @category 对student表的操作
 *
 */

public class Util {
	private Connection connection;
	
	public Util(){
		this.connection = DataBaseConnection.getConnection();
	}
	
	/* 返回所有学生信息的collection  */
	public Collection getAllStudent()throws Exception{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
		Collection result = new ArrayList();
		while (resultSet.next()) {
			Student student = new Student();
			student.setSid(resultSet.getString("sid"));
			student.setName(resultSet.getString("name"));
			student.setSex(resultSet.getInt("sex"));
			student.setPhone(resultSet.getString("phone"));
			student.setBirth(resultSet.getString("birth"));
			result.add(student);
		}
		statement.close();
		connection.close();
		return result;
	}
	
	/* 返回按照学号进行查询的collection */
	public Collection getStudentBySid(String sid) throws Exception{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE sid='"+ sid +"'");
		Collection result = new ArrayList();
		while (resultSet.next()) {
			Student student = new Student();
			student.setSid(resultSet.getString("sid"));
			student.setName(resultSet.getString("name"));
			student.setSex(resultSet.getInt("sex"));
			student.setPhone(resultSet.getString("phone"));
			student.setBirth(resultSet.getString("birth"));
			result.add(student);
		}
		statement.close();
		connection.close();
		return result;
	}
	
	/* 添加学生信息 传入student对象 */
	public boolean addStudent(Student student) throws Exception{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"INSERT INTO student VALUES(?,?,?,?,?)");
			preparedStatement.setString(1, student.getSid());
			System.out.println(student.getSid());
			preparedStatement.setString(2, student.getName());
			System.out.println(student.getName());
			preparedStatement.setInt(3, student.getSex());
			preparedStatement.setString(4, student.getPhone());
			preparedStatement.setString(5, student.getBirth());
			
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	/* 更改学生的信息  传入student对象*/
	public boolean modifyStudent(Student student) throws Exception{
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE student SET name=?, sex=?, phone=?, birth=? WHERE sid=?");
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getSex());
			preparedStatement.setString(3, student.getPhone());
			preparedStatement.setString(4, student.getBirth());
			preparedStatement.setString(5, student.getSid());
			
			preparedStatement.execute();
			preparedStatement.close();
			connection.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	/* 删除给定学号的学生 */
	public boolean deleteStudent(String sid) throws Exception{
		try {
			Statement statement = connection.createStatement();
			statement.execute(
					"DELETE FROM student WHERE sid='"+ sid +"'");
			statement.close();
			connection.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	
	/* 返回指定学号的学生对象 */
	public Student getStudentInfo(String sid) throws Exception{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT * FROM student WHERE sid='"+ sid +"'");
		Student student = null;
		while (resultSet.next()) {
			student = new Student();
			student.setSid(resultSet.getString("sid"));
			student.setName(resultSet.getString("name"));
			student.setSex(resultSet.getInt("sex"));
			student.setPhone(resultSet.getString("phone"));
			student.setBirth(resultSet.getString("birth"));
		}
		statement.close();
		connection.close();
		return student;
	}
	
	/* 字符串转Date */
	public synchronized static java.util.Date getStringToDate(String date, String type) throws Exception{
		if (type == null ) {
			type = "yyyyMMdd";
		}
		java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(type);
		java.util.Date result = simpleDateFormat.parse(date);
		return result;
	}

}
