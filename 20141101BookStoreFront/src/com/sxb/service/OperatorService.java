package com.sxb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sxb.dao.Dao;
import com.sxb.entity.Operator;

public class OperatorService implements IService{
	Dao dao = new Dao();
	
	public int AddOperator(Operator operator){
		String sql = "INSERT INTO `bookstore`.`operator` (`operatorid`, `name`, `loginname`, `password`, `permission`, `photo`) VALUES (?, ?, ?, ?, ?, ?)";
		return dao.executeUpdate(sql, new Object[]{operator.getOPERATORID(), operator.getNAME(), operator.getLOGINNAME(), operator.getPASSWORD(), operator.getPERMISSION(), operator.getPHOTO()});
	}
	public int DeleteOperatorByCondition(String name, String value){
		String sql = "delete from operator where " + name + "=?";
		return dao.executeUpdate(sql, new Object[]{value});
	}
	public ArrayList<Operator> getAllOperators() {
		String sql = "select * from operator order by operatorid";
		List<Map<String, Object>> list = dao.excuteQuery(sql, new Object[0]);
		// 最终的结果集
		ArrayList<Operator> operatorList = new ArrayList<Operator>();
		// 将结果放入list 中
		for (Map<String, Object> map : list) {
			Operator operator = new Operator();
			operator.setLOGINNAME((String) map.get("loginname"));
			operator.setNAME((String) map.get("name"));
			operator.setOPERATORID((String) map.get("operatorid"));
			operator.setPASSWORD((String) map.get("password"));
			operator.setPERMISSION((Integer) map.get("permission"));
			operator.setPHOTO((String) map.get("photo"));
			operatorList.add(operator);
		}
		return operatorList;
	}
	public ArrayList<Operator> getOperatorsByCondition(String name, String value){
		String sql = "select * from operator where " + name +"=? order by operatorid";
		List<Map<String, Object>> list = dao.excuteQuery(sql, new Object[]{value});
		// 最终的结果集
		ArrayList<Operator> operatorList = new ArrayList<Operator>();
		// 将结果放入list 中
		for (Map<String, Object> map : list) {
			Operator operator = new Operator();
			operator.setLOGINNAME((String) map.get("loginname"));
			operator.setNAME((String) map.get("name"));
			operator.setOPERATORID((String) map.get("operatorid"));
			operator.setPASSWORD((String) map.get("password"));
			operator.setPERMISSION((Integer) map.get("permission"));
			operator.setPHOTO((String) map.get("photo"));
			operatorList.add(operator);
		}
		return operatorList;
	}

	@Override
	public boolean uploadPhoto(String ID, String photoPath) {
		String updateSql = "update operator set photo=? where operatorid=?";
		if (dao.executeUpdate(updateSql, new Object[] {photoPath, ID}) > 0) {
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
