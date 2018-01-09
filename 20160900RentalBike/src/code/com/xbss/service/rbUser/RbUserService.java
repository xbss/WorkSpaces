package com.xbss.service.rbUser;


import java.util.Date;
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

import  com.xbss.dao.rbUser.RbUserDao;
import  com.xbss.entity.rbUser.RbUser;

/**
 * @author xbss
 * 用户
 */
@Service
public class RbUserService extends SearchService implements IRbUserService{
	
	@Resource(name="rbUserDao")
	RbUserDao dao ;

	@Override
	public String getBaseEntityName() {
		return "rbUser";
	}

	@Override
	public String getBasePrimaryKey() {
		return "rbUser.userId";
	}

	@Override
	public String Login(String userName, String password, HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		// 查询数据库 
		// 第二步 使用正则判断email和电话号码登录
		/*if (userName.endsWith("")) {
			
		}*/
		String condition = "userName= '" + userName + "' and password='" + MD5.GetMD5Code(password) + "'";
		List<RbUser > rbUsers = dao.getByCondition(condition);
		// 账号不存在
		if (rbUsers.size() <= 0) {
			return "3";
		}
		// 账号禁用
		if (rbUsers.get(0).getUserState() == 0) {
			return "4";
		}
		// 正常登录
		System.out.println("用户：" +  userName + " 登录");
		session.setAttribute("rbUser", rbUsers.get(0));
		
		return "1";
	}

	@Override
	public String Exit(HttpServletRequest request) {
		request.getSession().removeAttribute("rbUser");
		return "1";
	}

	@Override
	public void getRandomCode(HttpServletRequest request, HttpServletResponse response) {
		RandomValidateCode randCode = new RandomValidateCode();
		randCode.getRandcode(request, response);
	}

	@Override
	public String getById(String userId) {
		return dao.getByID(userId).toString();
	}

	@Override
	public String getByName(String userName) {
		return dao.getByID(userName).toString();
	}

	@Override
	public String add(RbUser rbUser) {
		rbUser.setUserId(EntityIDFactory.createId());
		rbUser.setPassword("e10adc3949ba59abbe56e057f20f883e");
		rbUser.setSignTime(new Date());
		rbUser.setLastLoginTime(new Date());
		return dao.save(rbUser) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String userId) {
		return dao.deleteByID(userId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updateById(String userId, RbUser rbUser) {
		return dao.updateByID(rbUser, userId) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(RbUser rbUser) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("userName", rbUser.getUserName());
		temp.put("sex", rbUser.getSex());
		temp.put("age", rbUser.getAge());
		temp.put("userState", rbUser.getUserState());
		temp.put("mobileNumber", rbUser.getMobileNumber());
		temp.put("email", rbUser.getEmail());
		
		return dao.updatePropByID(temp.entrySet(), rbUser.getUserId()) > 0 ? "1" : "-1";
	}
	/**
	 * @title 分页获取数据，返回json字符串数据
	 */
	@Override
	public String getWithPage(int rows, int page, String sort, String userName) {
		String condition = "";
		if (userName != null && !userName.equals("")) {
			condition = " userName like '%" + userName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"userId","userName","userState","sex","age","userKind","mobileNumber", "lastLoginTime"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}

	@Override
	public String modifyPassword(String userId, String password) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("password", MD5.GetMD5Code(password));
		
		return dao.updatePropByID(temp.entrySet(), userId) > 0 ? "1" : "-1";
	}

	/**
	 * @title 客户端用户更改基本信息
	 */
	@Override
	public String client_getUserById(String userId){
		return JSONObject.fromObject(dao.getByID(userId)).toString();
	}
	/**
	 * @title 用户更改个人信息 如果数据项为空就中断操作
	 * @
	 */
	@Override
	public String client_updateUserInfo(String userId, String mobileNumber, String email, String password,
			int age) {
		if (mobileNumber == null ) return "-2";
		if (email == null ) return "-3";
		/*if (password == null) return "-4";*/
		if (age <= 0 || age > 130) return "-5";
		/*if (sex != 0 || sex != 1) return "-6";*/
		
		Map<String, Object> map = new HashMap<>();
		map.put("mobileNumber", mobileNumber);
		map.put("email", email);
		/*map.put("password", password);*/
		/*map.put("sex", sex);*/
		map.put("age", age);
		
		return dao.updatePropByID(map.entrySet(), userId) > 0 ? "1" : "-1";
	}
	
	
}
