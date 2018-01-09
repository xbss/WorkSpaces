package com.xbss.controller.purchasePlanBikeBatch;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.purchasePlanBikeBatch.PurchasePlanBikeBatch;
import com.xbss.service.purchasePlanBikeBatch.IPurchasePlanBikeBatchService;

/**
 * @author xbss
 * 采购计划批次表
 */
@Controller
@RequestMapping("/purchasePlanBikeBatchController")
public class PurchasePlanBikeBatchController{
	
	@Resource(name="purchasePlanBikeBatchService")
	IPurchasePlanBikeBatchService service;
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String pPBikeBatchId){
		return service.getById(pPBikeBatchId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(PurchasePlanBikeBatch purchasePlanBikeBatch){
		return service.add(purchasePlanBikeBatch);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String pPBikeBatchId){
		return service.deleteById(pPBikeBatchId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(PurchasePlanBikeBatch purchasePlanBikeBatch){
		return service.updatePropByID(purchasePlanBikeBatch);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String pPId){
		return service.getWithPage(rows, page, sort, pPId);
	}
}
