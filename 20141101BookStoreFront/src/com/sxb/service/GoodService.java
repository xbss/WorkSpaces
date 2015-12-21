package com.sxb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sxb.entity.Good;
import com.sxb.entity.GoodType;

public class GoodService implements IService {

	public int AddGood(Good good) {
		String sql = "INSERT INTO `bookstore`.`good` (`goodid`, `userid`, `name`, `author`, `isbn`, `price`, `publisher`, `goodtypeid`, `description`, `mainpic`, `stock`, `sales`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return dao.executeUpdate(
				sql,
				new Object[] { good.getGOODID(), good.getUSERID(),
						good.getNAME(), good.getAUTHOR(), good.getISBN(),
						good.getPRICE(), good.getPUBLISHER(),
						good.getGOODTYPEID(), good.getDESCRIPTION(),
						good.getMAINPIC(), good.getSTOCK(), good.getSALES() });
	}

	public int DeleteGoodByCondition(String name, String value) {
		String sql = "delete from good where " + name + "=?";
		return dao.executeUpdate(sql, new Object[] { value });
	}

	public ArrayList<Good> getAllGoods() {
		String sql = "select * from good order by `name`";
		List<Map<String, Object>> good = dao.excuteQuery(sql, new Object[0]);
		// 最终的数据集
		ArrayList<Good> goodList = new ArrayList<Good>();
		// 将结果取出放入goodTypeList中
		for (Map<String, Object> map : good) {
			Good object = new Good();
			object.setAUTHOR((String) map.get("author"));
			object.setDESCRIPTION((String) map.get("description"));
			object.setGOODTYPEID((String) map.get("goodtypeid"));
			object.setGOOGID((String) map.get("goodid"));
			object.setISBN((String) map.get("isbn"));
			object.setMAINPIC((String) map.get("mainpic"));
			object.setNAME((String) map.get("name"));
			object.setPRICE((Double) map.get("price"));
			object.setPUBLISHER((String) map.get("publisher"));
			object.setSALES((Long) map.get("sales"));
			object.setSTOCK((Long) map.get("stock"));
			object.setUSERID((String) map.get("userid"));
			object.setNAME((String) map.get("name"));
			goodList.add(object);
		}
		return goodList;
	}

	public ArrayList<Good> getGoodsByCondition(String name, String value) {
		String sql = "select * from good where " + name + "=? order by `name`";
		List<Map<String, Object>> good = dao.excuteQuery(sql,
				new Object[] { value });
		// 最终的数据集
		ArrayList<Good> goodList = new ArrayList<Good>();
		// 将结果取出放入goodTypeList中
		for (Map<String, Object> map : good) {
			Good object = new Good();
			object.setAUTHOR((String) map.get("author"));
			object.setDESCRIPTION((String) map.get("description"));
			object.setGOODTYPEID((String) map.get("goodtypeid"));
			object.setGOOGID((String) map.get("goodid"));
			object.setISBN((String) map.get("isbn"));
			object.setMAINPIC((String) map.get("mainpic"));
			object.setNAME((String) map.get("name"));
			object.setPRICE((Double) map.get("price"));
			object.setPUBLISHER((String) map.get("publisher"));
			object.setSALES((Long) map.get("sales"));
			object.setSTOCK((Long) map.get("stock"));
			object.setUSERID((String) map.get("userid"));
			object.setNAME((String) map.get("name"));
			goodList.add(object);
		}
		System.out.println("get all good finish");
		return goodList;
	}

	// 处理首页的模糊查询
	public ArrayList<Good> fuzzyQuery(String goodquery, String value) {
		String sql = "select * from good where " + goodquery
				+ " like '%" + value + "%' order by name";
		List<Map<String, Object>> good = dao.excuteQuery(sql,
				new Object[0]);
		// 最终的数据集
		ArrayList<Good> goodList = new ArrayList<Good>();
		// 将结果取出放入goodTypeList中
		for (Map<String, Object> map : good) {
			Good object = new Good();
			object.setAUTHOR((String) map.get("author"));
			object.setDESCRIPTION((String) map.get("description"));
			object.setGOODTYPEID((String) map.get("goodtypeid"));
			object.setGOOGID((String) map.get("goodid"));
			object.setISBN((String) map.get("isbn"));
			object.setMAINPIC((String) map.get("mainpic"));
			object.setNAME((String) map.get("name"));
			object.setPRICE((Double) map.get("price"));
			object.setPUBLISHER((String) map.get("publisher"));
			object.setSALES((Long) map.get("sales"));
			object.setSTOCK((Long) map.get("stock"));
			object.setUSERID((String) map.get("userid"));
			object.setNAME((String) map.get("name"));
			goodList.add(object);
		}
		System.out.println("get all good finish");
		return goodList;
	}

	public int EditGood(Good good) {
		Good good2 = getGoodsByCondition("goodid", good.getGOODID()).get(0);
		String sql = "UPDATE `bookstore`.`good` SET `goodid`=?, `userid`=?, `name`=?, `author`=?, `isbn`=?, `price`=?, `publisher`=?, `goodtypeid`=?, `description`=?, `mainpic`=?, `stock`=?, `sales`=? WHERE (`goodid`=?)";
		return dao.executeUpdate(
				sql,
				new Object[] { good2.getGOODID(), good.getUSERID(),
						good.getNAME(), good.getAUTHOR(), good.getISBN(),
						good.getPRICE(), good.getPUBLISHER(),
						good.getGOODTYPEID(), good.getDESCRIPTION(),
						good.getMAINPIC(), good.getSTOCK(), good.getSALES(),
						good2.getGOODTYPEID()});
	}

	@Override
	public boolean uploadPhoto(String ID, String photoPath) {
		String updateSql = "update good set mainpic=? where goodid=?";
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
