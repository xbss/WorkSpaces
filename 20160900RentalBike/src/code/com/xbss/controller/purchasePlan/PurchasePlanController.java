package com.xbss.controller.purchasePlan;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.purchasePlan.PurchasePlan;
import com.xbss.service.purchasePlan.IPurchasePlanService;

/**
 * @author xbss
 * 采购计划
 */
@Controller
@RequestMapping("/purchasePlanController")
public class PurchasePlanController{
	
	@Resource(name="purchasePlanService")
	IPurchasePlanService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String pPId){
		return service.getById(pPId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(PurchasePlan purchasePlan){
		return service.add(purchasePlan);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String bikeId){
		return service.deleteById(bikeId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(PurchasePlan purchasePlan){
		return service.updatePropByID(purchasePlan);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String operatorName){
		return service.getWithPage(rows, page, sort, operatorName);
	}
}
