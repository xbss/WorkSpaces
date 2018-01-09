package com.xbss.controller.maintenanceRecord;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.maintenanceRecord.MaintenanceRecord;
import com.xbss.service.maintenanceRecord.IMaintenanceRecordService;

/**
 * @author xbss
 * 维修记录
 */
@Controller
@RequestMapping("/maintenanceRecordController")
public class MaintenanceRecordController{
	
	@Resource(name="maintenanceRecordService")
	IMaintenanceRecordService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String mRId){
		return service.getById(mRId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(MaintenanceRecord maintenanceRecord){
		return service.add(maintenanceRecord);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String mRId){
		return service.deleteById(mRId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(MaintenanceRecord maintenanceRecord){
		return service.updatePropByID(maintenanceRecord);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String operatorName, String userName){
		return service.getWithPage(rows, page, sort, operatorName, userName);
	}
}
