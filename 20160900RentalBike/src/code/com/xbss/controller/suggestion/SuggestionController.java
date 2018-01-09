package com.xbss.controller.suggestion;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.suggestion.Suggestion;
import com.xbss.service.suggestion.ISuggestionService;

/**
 * @author xbss
 * 意见建议
 */
@Controller
@RequestMapping("/suggestionController")
public class SuggestionController{
	
	@Resource(name="suggestionService")
	ISuggestionService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String suggestionId){
		return service.getById(suggestionId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(Suggestion suggestion){
		return service.add(suggestion);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String suggestionId){
		return service.deleteById(suggestionId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(Suggestion suggestion){
		return service.updatePropByID(suggestion);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String operatorName,String userName){
		return service.getWithPage(rows, page, sort, operatorName, userName);
	}
	
	@RequestMapping("/client_getUserSuggestionWithPage")
	@ResponseBody
	public String client_getUserSuggestionWithPage(int rows, int page, String sort, String userId){
		return service.client_getUserSuggestionWithPage(rows, page, sort, userId);
	}
	
	@RequestMapping("/client_addASuggestion")
	@ResponseBody
	public String client_addASuggestion(String userId, String content){
		return service.client_addASuggestion(userId, content);
	}
}
