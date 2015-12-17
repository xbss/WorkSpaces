package com.sxb.test;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxb.dao.Dao;
import com.sxb.service.StudentAction;

public class TestJSON {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*StudentActionService service = new StudentActionService();
		StudentActionDelegate studentActionDelegate = service.getStudentActionPort();
		
		System.out.println("jieguo: " + studentActionDelegate.getBaseInfo());
		System.out.println(studentActionDelegate.getStudents("sname", "is", "二"));*/

		StudentAction action = new StudentAction();
		String string = action.getStudents("", "", "二");
		JSONObject jsonObject = (JSONObject) JSONArray.fromObject(string).get(0);
		System.out.println(jsonObject.get("sage"));
		/*Dao dao = new Dao();
		String sql  = "select count(student.sno ) as count from student";
		System.out.println(dao.excuteQuery(sql, new Object[0]));*/
	}

}
