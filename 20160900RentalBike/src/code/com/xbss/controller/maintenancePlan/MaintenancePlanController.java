package com.xbss.controller.maintenancePlan;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.bikeInfo.BikeInfo;
import com.xbss.entity.maintenancePlan.MaintenancePlan;
import com.xbss.service.maintenancePlan.IMaintenancePlanService;

/**
 * @author xbss
 * 维修计划
 */
@Controller
@RequestMapping("/maintenancePlanController")
public class MaintenancePlanController{
	
	@Resource(name="maintenancePlanService")
	IMaintenancePlanService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String mPId){
		return service.getById(mPId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(MaintenancePlan maintenancePlan){
		return service.add(maintenancePlan);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String mPId){
		return service.deleteById(mPId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(MaintenancePlan maintenancePlan){
		return service.updatePropByID(maintenancePlan);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String operatorName){
		return service.getWithPage(rows, page, sort, operatorName);
	}
}
