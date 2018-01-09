package com.xbss.service.rbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xbss.entity.rbUser.RbUser;

/**
 * @author xbss
 * 用户
 */
public interface IRbUserService {
	public String Login(String userName, String password, HttpServletRequest request);
	
	public String Exit(HttpServletRequest request);
	
	public void getRandomCode(HttpServletRequest request,
			HttpServletResponse response);
	
	public String getById(String userId);
	
	public String getByName(String userName);
	
	public String add(RbUser rbUser);
	
	public String deleteById(String userId);
	
	public String deleteByCondition(String condition);
	
	public String deleteEntities(String[] ids);
	
	public String updateById(String userId, RbUser rbUser);
	
	public String updatePropByID(RbUser rbUser);
	
	
	public String getWithPage(int rows, int page, String sort, String userName);
	
	public String modifyPassword(String userId, String password);
	
	public String client_getUserById(String userId);
	public String client_updateUserInfo(String userId, String mobileNumber, String email,String password, int age);
	
}
