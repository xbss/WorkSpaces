package com.sxb.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.sxb.entity.Student;
import com.sxb.service.StudentAction;

public class StudentInfoAction extends SuperAction{
	public StudentAction service = new StudentAction();
	public String isHave = "";
	public String content = "";
	public String attr = "";
	public String getIsHave(){
		return isHave;
	}
	public void setIsHave(String isHave){
		this.isHave = isHave;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content = content;
	}
	public String getAttr(){
		return attr;
	}
	public void setAttr(String attr){
		this.attr = attr;
	}
	/**
	 * @author XBSS
	 * @title 返回查询参数
	 * @return
	 */
	public String getInfo(){
		
		// 查询结果 
		/*System.out.println(isHave + " " + content);
		System.out.println("ss" + content);*/
		java.util.List<Student> students = service.getStudents(attr, isHave, content);
		// 查询结果写入
		String count = String.valueOf(students.size());
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("students", students);
		actionContext.put("count", count);
		return SUCCESS;
	}
	
	

}
