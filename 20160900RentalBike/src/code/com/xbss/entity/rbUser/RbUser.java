package com.xbss.entity.rbUser;

import java.util.Date;
import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 用户
 */
public class RbUser{
	
	@ID
	private String  userId;
	private String userName;
	private int userKind;
	private int userState;
	private String mobileNumber;
	private String email;
	private String password;
	private int sex;
	private int age;
	private Date lastLoginTime;
	private Date signTime;
	
	
	public String getUserId() {
		return userId;
	}	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getUserKind() {
		return userKind;
	}	
	
	public void setUserKind(int userKind) {
		this.userKind = userKind;
	}
	public int getUserState() {
		return userState;
	}	
	
	public void setUserState(int userState) {
		this.userState = userState;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}	
	
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}	
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}	
	
	public void setPassword(String password) {
		this.password = password;
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
	public Date getLastLoginTime() {
		return lastLoginTime;
	}	
	
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Date getSignTime() {
		return signTime;
	}	
	
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	
	@Override
	public String toString() {
		return   userId  + "\t" +  userName  + "\t" +  userKind  + "\t" +  userState  + "\t" +  mobileNumber  + "\t" +  email  + "\t" +  password  + "\t" +  sex  + "\t" +  age  + "\t" +  lastLoginTime  + "\t" +  signTime  + "\t"  ;
	}
}
