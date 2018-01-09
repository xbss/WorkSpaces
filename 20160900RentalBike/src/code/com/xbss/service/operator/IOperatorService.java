package com.xbss.service.operator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbss.entity.operator.Operator;

/**
 * @author xbss
 * 管理员/工作人员
 */
public interface IOperatorService {
	public String Login(String operatorName, String password, String randomCode, HttpServletRequest request);
	
	public String Exit(HttpServletRequest request);
	
	public void getRandomCode(HttpServletRequest request,
			HttpServletResponse response);
	
	public String getById(String operatorCode);
	
	public String add(Operator operator);
	
	public String deleteById(String operatorCode);
	
	public String deleteByCondition(String condition);
	
	public String deleteEntities(String[] ids);
	
	public String updateById(String operatorCode, Operator operator);
	
	public String updatePropByID(Operator operator);
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName);
	
	public String modifyPassword(String operatorCode, String password);
	
	public Operator getCurrentOperator(HttpServletRequest request);
}
