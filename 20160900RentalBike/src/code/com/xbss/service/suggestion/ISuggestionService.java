package com.xbss.service.suggestion;

import com.xbss.entity.suggestion.Suggestion;

/**
 * @author xbss
 * 意见建议
 */
public interface ISuggestionService {
	
	public String getById(String suggestionId);
	
	public String add(Suggestion suggestion);
	
	public String deleteById(String suggestionId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(Suggestion suggestion);
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName, String userName);
	
	public String client_getUserSuggestionWithPage(int rows, int page, String sort, String userId);
	
	public String client_addASuggestion(String userId, String content);
}
