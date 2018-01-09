package com.xbss.controller.bikeType;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.bikeInfo.BikeInfo;
import com.xbss.entity.bikeType.BikeType;
import com.xbss.service.bikeType.IBikeTypeService;

/**
 * @author xbss
 * 自行车车型
 */
@Controller
@RequestMapping("/bikeTypeController")
public class BikeTypeController{
	
	@Resource(name="bikeTypeService")
	IBikeTypeService service;
	
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String bikeTypeId){
		return service.getById(bikeTypeId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(BikeType bikeType){
		return service.add(bikeType);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String bikeTypeId){
		return service.deleteById(bikeTypeId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(BikeType bikeType){
		return service.updatePropByID(bikeType);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String bikeTypeName){
		return service.getWithPage(rows, page, sort, bikeTypeName);
	}
	
	@RequestMapping("/server_getSelectWithPage")
	@ResponseBody
	public String server_getSelectWithPage(int rows, int page, String sort){
		return service.server_getSelectWithPage(rows, page, sort);
	}
}
