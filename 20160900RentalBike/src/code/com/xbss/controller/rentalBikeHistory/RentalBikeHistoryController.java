package com.xbss.controller.rentalBikeHistory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.rentalBikeHistory.RentalBikeHistory;
import com.xbss.service.rentalBikeHistory.IRentalBikeHistoryService;

/**
 * @author xbss
 * 车辆租借记录
 */
@Controller
@RequestMapping("/rentalBikeHistoryController")
public class RentalBikeHistoryController{
	
	@Resource(name="rentalBikeHistoryService")
	IRentalBikeHistoryService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String retalId){
		return service.getById(retalId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(RentalBikeHistory rentalBikeHistory){
		return service.add(rentalBikeHistory);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String rentalId){
		return service.deleteById(rentalId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(RentalBikeHistory rentalBikeHistory ){
		return service.updatePropByID(rentalBikeHistory);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String userName){
		return service.getWithPage(rows, page, sort, userName);
	}
	
	@RequestMapping("/getRentalBikeInfo")
	@ResponseBody
	public String getRentalBikeInfo(String bikeId, HttpServletRequest request){
		return service.getRentalBikeInfo(bikeId, request);
	}
	
	@RequestMapping("/rentalABike")
	@ResponseBody
	public String rentalABike(String bikeId, String userId){
		return service.rentalABike(bikeId, userId);
	}
	
	@RequestMapping("/getRecordNoBackIWithPage")
	@ResponseBody
	public String getRecordNoBackIWithPage(int rows, int page, String userId){
		return service.getRecordNoBackIWithPage(rows, page, userId);
	}
	
	@RequestMapping("/backABike")
	@ResponseBody
	public String backABike(String rentalId, String bikeId, String userId){
		return service.backABike(rentalId, bikeId, userId);
	}
	
	@RequestMapping("/getRecordHaveBackIWithPage")
	@ResponseBody
	public String getRecordHaveBackIWithPage(int rows, int page, String userId){
		return service.getRecordHaveBackIWithPage(rows, page, userId);
	}
	
	@RequestMapping("/server_checkABike")
	@ResponseBody
	public String server_checkABike(String rentalId, int damage, HttpServletRequest request){
		return service.server_checkABike(rentalId, damage, request);
	}
	
	@RequestMapping("/server_getRecordNoCheckWithPage")
	@ResponseBody
	public String server_getRecordNoCheckWithPage(int rows, int page, String userName){
		return service.server_getRecordNoCheckWithPage(rows, page, userName);
	}
}
