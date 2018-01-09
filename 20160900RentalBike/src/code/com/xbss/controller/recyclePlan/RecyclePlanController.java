package com.xbss.controller.recyclePlan;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.recyclePlan.RecyclePlan;
import com.xbss.service.recyclePlan.IRecyclePlanService;

/**
 * @author xbss
 * 回收计划表
 */
@Controller
@RequestMapping("/recyclePlanController")
public class RecyclePlanController{
	
	@Resource(name="recyclePlanService")
	IRecyclePlanService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String rPId){
		return service.getById(rPId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(RecyclePlan recyclePlan){
		return service.add(recyclePlan);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String rPId){
		return service.deleteById(rPId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(RecyclePlan recyclePlan){
		return service.updatePropByID(recyclePlan );
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String operatorName){
		return service.getWithPage(rows, page, sort, operatorName);
	}
}
