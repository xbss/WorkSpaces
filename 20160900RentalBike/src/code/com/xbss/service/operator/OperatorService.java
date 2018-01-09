package com.xbss.service.operator;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;
import com.xbss.system.tool.MD5;
import com.xbss.system.tool.RandomValidateCode;

import net.sf.json.JSONObject;

import  com.xbss.dao.operator.OperatorDao;
import  com.xbss.entity.operator.Operator;

/**
 * @author xbss
 * 管理员/工作人员
 */
@Service
public class OperatorService extends SearchService implements IOperatorService{
	
	@Resource(name="operatorDao")
	OperatorDao dao ;

	@Override
	public String getBaseEntityName() {
		return "operator";
	}

	@Override
	public String getBasePrimaryKey() {
		return "operator.operatorCode";
	}

	/**
	 * @author XBSS
	 * @title 登录操作
	 */
	@Override
	public String Login(String operatorName, String password, String randomCode, HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 获取系统验证码
		String randomCodeServer = (String) session.getAttribute("randomCodeServer");
		
		// 验证码错误
		if (randomCode == null) {
			return "2";
		} else if (!randomCode.toUpperCase().equals(randomCodeServer.toUpperCase())) {
			return "2";
		}
		
		// 查询数据库 
		String condition = "operatorName= '" + operatorName + "' and password='" + MD5.GetMD5Code(password) + "'";
		List<Operator> operators = dao.getByCondition(condition);
		// 账号不存在
		if (operators.size() <= 0) {
			return "3";
		}
		// 账号禁用
		if (operators.get(0).getState() == 0) {
			return "4";
		}
		// 正常登录
		System.out.println("用户：" +  operatorName + " 登录");
		session.setAttribute("operator", operators.get(0));
		return "1";
	}

	/**
	 * @title 退出系统
	 */
	@Override
	public String Exit(HttpServletRequest request) {
		request.getSession().removeAttribute("operator");
		return "1";
	}

	/**
	 * @title 获取验证码
	 */
	@Override
	public void getRandomCode(HttpServletRequest request, HttpServletResponse response) {
		RandomValidateCode randCode = new RandomValidateCode();
		randCode.getRandcode(request, response);
		
	}
	
	@Override
	public String getById(String operatorCode) {
		return dao.getByID(operatorCode).toString();
	}

	@Override
	public String add(Operator operator) {
		operator.setOperatorCode(EntityIDFactory.createId());
		operator.setPassword("e10adc3949ba59abbe56e057f20f883e");
		return dao.save(operator) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String operatorCode) {
		return dao.deleteByID(operatorCode) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteByCondition(String condition) {
		return null;
	}
	
	@Override
	public String deleteEntities(String[] ids){
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updateById(String operatorCode, Operator operator) {
		return dao.updateByID(operator, operatorCode) > 0 ? "1" : "-1";
	}
	@Override
	public String updatePropByID(Operator operator ){
		Map<String, Object> temp = new HashMap<>();
		temp.put("operatorName", operator.getOperatorName());
		temp.put("sex", operator.getSex());
		temp.put("age", operator.getAge());
		temp.put("state", operator.getState());
		temp.put("level", operator.getLevel());
		temp.put("introduction", operator.getIntroduction());
		temp.put("storageId", operator.getStorageId());
		
		return dao.updatePropByID(temp.entrySet(), operator.getOperatorCode()) > 0 ? "1" : "-1";
	}
	
	/**
	 * @title 获取当前登录的操作人员，用于确定是否有权限操作相关功能
	 * @param request
	 * @return
	 */
	@Override
	public Operator getCurrentOperator(HttpServletRequest request){
		if (request.getSession().getAttribute("operator") == null || request.getSession().getAttribute("operator").equals("")) {
			return null;
		} else {
			return (Operator)request.getSession().getAttribute("operator");
		}
	}

	/**
	 * @title 分页获取数据，返回json字符串数据
	 */
	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName) {
		String condition = "";
		if (operatorName != null && !operatorName.equals("")) {
			condition = " operatorName like '%" + operatorName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"operatorCode","operatorName","state","sex","age","level","storageId"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}

	/**
	 * @title 修改密码
	 */
	@Override
	public String modifyPassword(String operatorCode, String password) {
		MD5.GetMD5Code(password);
		Map<String, Object> temp = new HashMap<>();
		temp.put("password", MD5.GetMD5Code(password));
		
		return dao.updatePropByID(temp.entrySet(), operatorCode) > 0 ? "1" : "-1";
	}
	
	
}
