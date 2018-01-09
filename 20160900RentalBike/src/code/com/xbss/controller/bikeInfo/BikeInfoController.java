package com.xbss.controller.bikeInfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.bikeInfo.BikeInfo;
import com.xbss.service.bikeInfo.IBikeInfoService;

/**
 * @author xbss
 * 自行车信息
 */
@Controller
@RequestMapping("/bikeInfoController")
public class BikeInfoController{
	
	@Resource(name="bikeInfoService")
	IBikeInfoService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String cardId){
		return service.getById(cardId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(BikeInfo bikeInfo){
		return service.add(bikeInfo);
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
	public String updatePropByID(BikeInfo bikeInfo){
		return service.updatePropByID(bikeInfo);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String bikeId){
		return service.getWithPage(rows, page, sort, bikeId);
	}
}
