package com.sxb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;




import net.sf.json.JSONArray;

import com.sxb.dao.Dao;

public class StudentAction {
	public Dao dao = new Dao();

	// 得到基本属性
	public String getBaseInfo() {

		return "student";
	}

	// 获取和查询
	public String getStudents(String attr, String isHave, String content) {
		List<Map<String, Object>> students = new ArrayList<Map<String, Object>>();
		// 判断参数
		String sql = "";
		if (isHave.equals("is") ) {
			sql += "select sno , sname, sage from student where " + attr
					+ " like '%" + content + "%' ";
		} else if (isHave.equals("no") ) {
			sql += "select  sno , sname, sage from student where " + attr
					+ " not like '%" + content + "%' ";
		} else {
			sql += "select sno , sname, sage from student ";
		}
		students = dao.excuteQuery(sql, new Object[] {});
		return JSONArray.fromObject(students).toString();
	}

	// 获取总数
	public String getCount(String attr, String isHave, String content) {
		String sql = "select count(student.sno ) as count from student";
		// 判断参数
		if (isHave.equals("is") ) {
			sql += " where " + attr
					+ " like '%" + content + "%' ";
		} else if (isHave.equals("no") ) {
			sql += " where " + attr
					+ " not like '%" + content + "%' ";
		} else {
			
		}
		List<Map<String, Object>> result = dao.excuteQuery(sql, new Object[0]);
		return String.valueOf(result.get(0).get("count"));
	}

}
