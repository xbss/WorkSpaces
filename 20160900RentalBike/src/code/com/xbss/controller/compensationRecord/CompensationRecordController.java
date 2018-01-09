package com.xbss.controller.compensationRecord;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.compensationRecord.CompensationRecord;
import com.xbss.service.compensationRecord.ICompensationRecordService;

/**
 * @author xbss
 * 赔偿记录
 */
@Controller
@RequestMapping("/compensationRecordController")
public class CompensationRecordController{
	
	@Resource(name="compensationRecordService")
	ICompensationRecordService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String cRId){
		return service.getById(cRId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(CompensationRecord compensationRecord){
		return service.add(compensationRecord);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String cRId){
		return service.deleteById(cRId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(CompensationRecord compensationRecord){
		return service.updatePropByID(compensationRecord);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String userName){
		return service.getWithPage(rows, page, sort, userName);
	}
	
	@RequestMapping("/client_getUserComRecordById")
	@ResponseBody
	public String client_getUserComRecordById(String cRId){
		return service.client_getUserComRecordById(cRId); 
	}
	
	@RequestMapping("/client_getUserComRecordWithPage")
	@ResponseBody
	public String client_getUserComRecordWithPage(String userId, int rows, int page){
		return service.client_getUserComRecordWithPage(userId, rows, page);
	}
}
