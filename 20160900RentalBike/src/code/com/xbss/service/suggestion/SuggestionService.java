package com.xbss.service.suggestion;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import com.xbss.dao.operator.OperatorDao;
import com.xbss.dao.rbUser.RbUserDao;
import  com.xbss.dao.suggestion.SuggestionDao;
import com.xbss.entity.rbUser.RbUser;
import  com.xbss.entity.suggestion.Suggestion;

/**
 * @author xbss
 * 意见建议
 */
@Service
public class SuggestionService extends SearchService implements ISuggestionService{
	
	@Resource(name="suggestionDao")
	SuggestionDao dao ;
	
	@Resource(name="rbUserDao")
	RbUserDao userDao ;
	
	@Resource(name="operatorDao")
	OperatorDao operatorDao ;
	
	@Override
	public String getBaseEntityName() {
		return "suggestion";
	}

	@Override
	public String getBasePrimaryKey() {
		return "suggestion.suggestionId";
	}

	@Override
	public String getById(String suggestionId) {
		return dao.getByID(suggestionId).toString();
	}

	@Override
	public String add(Suggestion suggestion) {
		suggestion.setSuggestionId(EntityIDFactory.createId());
		return dao.save(suggestion) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String suggestionId) {
		return dao.deleteByID(suggestionId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(Suggestion suggestion) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("content", suggestion.getContent());
		
		return dao.updatePropByID(temp.entrySet(), suggestion.getSuggestionId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName, String userName) {
		String condition = "";
		
		if (operatorName != null && !operatorName.equals("")) {
			condition = " operatorName like '%" + operatorName + "%'";
		}
		
		if (userName != null && !userName.equals("")) {
			condition = " userName like '%" + userName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"suggestionId","content","state","operatorId","operatorName","userId","userName", "submitTime","feedBackInfo"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	/**
	 * @title 客户端查看当前用户的反馈记录
	 */
	public String client_getUserSuggestionWithPage(int rows, int page, String sort, String userId){
		String condition = "";
		
		if (userId != null && !userId.equals("")) {
			condition = " userId = '" + userId + "'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"suggestionId","content","state","operatorId","operatorName","userId","userName", "submitTime","feedBackInfo"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		System.out.println(JSONObject.fromObject(objects).toString());
		return JSONObject.fromObject(objects).toString();
	}
	
	/**
	 * @title 客户端提交建议/意见
	 */
	@Override
	public String client_addASuggestion(String userId, String content){
		
		if (userId == null || userId == "" || content == null || content == "null") {  // 反馈错误
			return "-1";
		} else{ // 进行对象组装
			RbUser rbUser = userDao.getByID(userId);
			Suggestion suggestion = new Suggestion();
			suggestion.setSuggestionId(EntityIDFactory.createId());
			suggestion.setContent(content);
			suggestion.setUserId(userId);
			suggestion.setUserName(rbUser.getUserName());
			suggestion.setSubmitTime(new Date());
			suggestion.setState(0);
			return dao.save(suggestion) >0 ? "1" : "-1" ;
		}
	}
}
