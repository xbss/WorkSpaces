package com.sxb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;







import net.sf.json.JSONArray;

import com.sxb.dao.Dao;
import com.sxb.entity.Student;

public class StudentAction {
	public Dao dao = new Dao();

	// 得到基本属性
	public String getBaseInfo() {
		return "student";
	}

	// 获取和查询
	public List<Student> getStudents(String attr, String isHave, String content) {
		
		List<Map<String, Object>> studentsMap = new ArrayList<Map<String, Object>>();
		List<Student> students = new ArrayList<Student>();
		Student student = new Student();
		// 判断参数
		String sql = "select sno, sname, sage from student where ";
		if (isHave.equals("is") ) {
			sql += attr + " like '%" + content + "%' ";
		} else if (isHave.equals("no") ) {
			sql += attr + " not like '%" + content + "%' ";
		} else if (isHave.equals("more")) {
			sql += attr + " >" + content + " ";
		} else if (isHave.equals("less")) {
			sql += attr + " <" + content + " ";
		} else if (isHave.equals("equal")) {
			sql += attr + " =" + content + " ";
		}else {
			sql = "select sno , sname, sage from student ";
		}
		
		studentsMap = dao.excuteQuery(sql, new Object[] {});
		for (int i = 0; i < studentsMap.size(); i++) {
			student.setSage((int) studentsMap.get(i).get("sage"));
			student.setSname((String) studentsMap.get(i).get("sname"));
			student.setSno((String) studentsMap.get(i).get("sno"));
			students.add(student);
		}
		return students;
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
