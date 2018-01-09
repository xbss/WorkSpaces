package com.xbss.entity.operator;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 管理员/工作人员
 */
public class Operator{
	
	@ID
	private String  operatorCode;
	private String operatorName;
	private int sex;
	private int age;
	private String password;
	private int state;
	private int level;
	private String introduction;
	private String storageId;
	
	
	public String getOperatorCode() {
		return operatorCode;
	}	
	
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	public String getOperatorName() {
		return operatorName;
	}	
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public int getSex() {
		return sex;
	}	
	
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}	
	
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public int getLevel() {
		return level;
	}	
	
	public void setLevel(int level) {
		this.level = level;
	}
	public String getIntroduction() {
		return introduction;
	}	
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getStorageId() {
		return storageId;
	}	
	
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	
	@Override
	public String toString() {
		return   operatorCode  + "\t" +  operatorName  + "\t" +  sex  + "\t" +  age  + "\t" +  password  + "\t" +  state  + "\t" +  level  + "\t" +  introduction  + "\t" +  storageId  + "\t"  ;
	}
}
