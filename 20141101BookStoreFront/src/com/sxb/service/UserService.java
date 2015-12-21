package com.sxb.service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sun.swing.internal.plaf.basic.resources.basic;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Occurs;
import com.sxb.entity.User;
import com.sxb.tool.SysDateFormat;

public class UserService implements IService {

	public int AddUser(User user) throws Exception{
		String sql = "INSERT INTO `bookstore`.`user` (`userid`, `name`, `loginname`, `password`, `sex`, `birth`, `phone`, `email`, `address`, `mail`, `type`, `photo`, `money`) " +
				"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return dao.executeUpdate(sql, new Object[]{
				user.getUSERID(),
				user.getNAME(),
				user.getLOGINNAME(),
				user.getPASSWORD(),
				user.getSEX(),
				user.getBIRTH(),
				user.getPHONE(),
				user.getEMAIL(),
				user.getADDRESS(),
				user.getMAIL(),
				user.getTYPE(),
				user.getPHOTO(),
				0
		});
	}

	public int DeleteUserByCondition(String name, String value) {
		String sql = "delete from user where " + name +"=?";
		return dao.executeUpdate(sql, new Object[]{value});
	}

	public ArrayList<User> getAllUsers() {
		String sql = "select * from user order by name";
		List<Map<String, Object>> list = dao.excuteQuery(sql, new Object[0]);
		// 最终的结果集
		ArrayList<User> userList = new ArrayList<User>();
		for (Map<String, Object> map : list) {
			User object = new User();
			object.setADDRESS((String) map.get("address"));
			object.setBIRTH((SysDateFormat.formatDate((Date) map.get("birth"))));
			object.setEMAIL((String) map.get("email"));
			object.setLOGINNAME((String) map.get("loginname"));
			object.setMAIL((String) map.get("mail"));
			object.setNAME((String) map.get("name"));
			object.setPASSWORD((String) map.get("password"));
			object.setPHONE((String) map.get("phone"));
			object.setPHOTO((String) map.get("photo"));
			object.setSEX((Integer) map.get("sex"));
			object.setTYPE((Integer) map.get("type"));
			object.setUSERID((String) map.get("userid"));
			object.setMoney((Double) map.get("money"));
			userList.add(object);
		}
		return userList;
	}

	public ArrayList<User> getUsersByCondition(String name, String value) {
		String sql = "select * from user where " + name +"=? order by name";
		List<Map<String, Object>> list = dao.excuteQuery(sql, new Object[]{value});
		// 最终的结果集
		ArrayList<User> userList = new ArrayList<User>();
		for (Map<String, Object> map : list) {
			User object = new User();
			object.setADDRESS((String) map.get("address"));
			object.setBIRTH((SysDateFormat.formatDate((Date) map.get("birth"))));
			object.setEMAIL((String) map.get("email"));
			object.setLOGINNAME((String) map.get("loginname"));
			object.setMAIL((String) map.get("mail"));
			object.setNAME((String) map.get("name"));
			object.setPASSWORD((String) map.get("password"));
			object.setPHONE((String) map.get("phone"));
			object.setPHOTO((String) map.get("photo"));
			object.setSEX((Integer) map.get("sex"));
			object.setTYPE((Integer) map.get("type"));
			object.setUSERID((String) map.get("userid"));
			object.setMoney((Double) map.get("money"));
			userList.add(object);
		}
		return userList;
	}

	public int EditUser(User user) throws ParseException {
		User user1 = getUsersByCondition("userid", user.getUSERID()).get(0);
		String sql = "UPDATE `bookstore`.`user` SET `userid`=?, `name`=?, `loginname`=?, `password`=?, `sex`=?, `birth`=?, `phone`=?, `email`=?, `address`=?, `mail`=?, `type`=?, `photo`=?, `money`=? WHERE (`userid`=?) AND (`name`=?) AND (`loginname`=?);";
		return dao.executeUpdate(sql, new Object[]{
				user1.getUSERID(),
				user.getNAME(),
				user.getLOGINNAME(),
				user.getPASSWORD(),
				user.getSEX(),
				user.getBIRTH(),
				user.getPHONE(),
				user.getEMAIL(),
				user.getADDRESS(),
				user.getMAIL(),
				user.getTYPE(),
				user.getPHOTO(),
				user.getMoney(),
				user1.getUSERID(),
				user1.getNAME(),
				user1.getLOGINNAME()
		});
	}

	@Override
	public boolean uploadPhoto(String ID, String photoPath) {
		String updateSql = "update user set photo=? where userid=?";
		if (dao.executeUpdate(updateSql, new Object[] { photoPath, ID }) > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean downloadPhoto(String ID, String photoPath) {
		// TODO Auto-generated method stub

		return false;
	}

	@Override
	public boolean uploadFile(String ID, String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean downloadFile(String ID, String filePath) {
		// TODO Auto-generated method stub
		return false;
	}

}
