package com.xbss.controller.rbCard;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.rbCard.RbCard;
import com.xbss.service.rbCard.IRbCardService;

/**
 * @author xbss
 * 一卡通/会员卡
 */
@Controller
@RequestMapping("/rbCardController")
public class RbCardController{
	
	@Resource(name="rbCardService")
	IRbCardService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String cardId){
		return service.getById(cardId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(RbCard rbCard){
		return service.add(rbCard);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String cardId){
		return service.deleteById(cardId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(RbCard rbCard){
		return service.updatePropByID(rbCard);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String signUserName){
		return service.getWithPage(rows, page, sort, signUserName);
	}
}
