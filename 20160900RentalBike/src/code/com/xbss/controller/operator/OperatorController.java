package com.xbss.controller.operator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.operator.Operator;
import com.xbss.service.operator.IOperatorService;

/**
 * @author xbss
 * 管理员/工作人员
 */
@Controller
@RequestMapping("/operatorController")
public class OperatorController{
	
	@Resource(name="operatorService")
	IOperatorService service;
	
	@RequestMapping("/Login")
	@ResponseBody
	public String Login(String operatorName, String password, String randomCode, HttpServletRequest request) {
		return service.Login(operatorName, password, randomCode, request);
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
	public String getWithPage(int rows, int page, String sort, String operatorName) {
		return service.getWithPage(rows, page, sort, operatorName);
	};
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(Operator operator) {
		return service.add(operator);
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
	public String updatePropByID(Operator operator ){
		return service.updatePropByID(operator);
	}
	
	@RequestMapping("/modifyPassword")
	@ResponseBody
	public String modifyPassword(String operatorCode, String password) {
		return service.modifyPassword(operatorCode, password);
	}
}
