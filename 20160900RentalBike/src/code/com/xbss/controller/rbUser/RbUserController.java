package com.xbss.controller.rbUser;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.rbUser.RbUser;
import com.xbss.service.rbUser.IRbUserService;

/**
 * @author xbss
 * 用户
 */
@Controller
@RequestMapping("/rbUserController")
public class RbUserController{
	
	@Resource(name="rbUserService")
	IRbUserService service;
	
	
	@RequestMapping("/Login")
	@ResponseBody
	public String Login(String userName, String password, HttpServletRequest request) {
		return service.Login(userName, password, request);
	}
	
	@RequestMapping("/Exit")
	@ResponseBody
	public String Exit(HttpServletRequest request) {
		return service.Exit(request);
	}
	
	@RequestMapping("/getRandomCode")
	@ResponseBody
	public void getRandomCode(HttpServletRequest request, HttpServletResponse response) {
		service.getRandomCode(request, response);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String userName) {
		return service.getWithPage(rows, page, sort, userName);
	};
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(RbUser rbUser) {
		return service.add(rbUser);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String Id) {
		return service.deleteById(Id);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(RbUser rbUser ){
		return service.updatePropByID(rbUser);
	}
	
	
	@RequestMapping("/client_getUserById")
	@ResponseBody
	public String client_getUserById(String userId){
		return service.client_getUserById(userId);
	}
	@RequestMapping("/client_updateUserInfo")
	@ResponseBody
	public String client_updateUserInfo(String userId, String mobileNumber, String email, String password,
			int age) {
		return service.client_updateUserInfo(userId, mobileNumber, email, password, age);
	}
}
