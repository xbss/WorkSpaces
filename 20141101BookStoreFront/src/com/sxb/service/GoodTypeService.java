package com.sxb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sxb.dao.Dao;
import com.sxb.entity.Good;
import com.sxb.entity.GoodType;

public class GoodTypeService {
	Dao dao = new Dao();

	public int AddGoodType(GoodType goodType){
		String sql = "INSERT INTO `bookstore`.`goodtype` (`goodtypeid`, `name`) VALUES (?, ?)";
		return dao.executeUpdate(sql,new Object[]{goodType.getGOODTYPEID(), goodType.getNAME()});
	}
	public int DeleteGoodTypeByCondition(String name, String value){
		String sql = "delete from goodtype where " +name +"=?";
		return dao.executeUpdate(sql, new Object[]{value});
	}
	public ArrayList<GoodType> getAllGoodTypes() {
		String sql = "select * from goodtype order by `goodtypeid`";
		List<Map<String, Object>> goodType = dao.excuteQuery(sql, new Object[0]);
		// 最终的数据集
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		// 将结果取出放入goodTypeList中
		for (Map<String, Object> map : goodType) {
			GoodType object = new GoodType();
			object.setGOODTYPEID((String) map.get("goodtypeid"));
			object.setNAME((String) map.get("name"));
			goodTypeList.add(object);
		}
		return goodTypeList;
	}
	public ArrayList<GoodType> getGoodTypesByCondition(String name, String value){
		String sql = "select * from goodtype where "+ name +"=? order by `goodtypeid`";
		List<Map<String, Object>> goodType = dao.excuteQuery(sql, new Object[]{value});
		// 最终的数据集
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		// 将结果取出放入goodTypeList中
		for (Map<String, Object> map : goodType) {
			GoodType object = new GoodType();
			object.setGOODTYPEID((String) map.get("goodtypeid"));
			object.setNAME((String) map.get("name"));
			goodTypeList.add(object);
		}
		return goodTypeList;
	}
	public int EditGoodType(GoodType goodType){
		GoodType goodType2 = getGoodTypesByCondition("goodtypeid", goodType.getGOODTYPEID()).get(0);
		String sql = "UPDATE `bookstore`.`goodtype` SET `goodtypeid`=?, `name`=? WHERE (`goodtypeid`=?)";
		return dao.executeUpdate(sql,new Object[]{goodType.getGOODTYPEID(), goodType.getNAME(), goodType.getGOODTYPEID()});
	}

}
