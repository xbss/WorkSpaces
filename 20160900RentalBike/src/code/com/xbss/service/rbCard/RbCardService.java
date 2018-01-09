package com.xbss.service.rbCard;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.rbCard.RbCardDao;
import  com.xbss.entity.rbCard.RbCard;

/**
 * @author xbss
 * 一卡通/会员卡
 */
@Service
public class RbCardService extends SearchService implements IRbCardService{
	
	@Resource(name="rbCardDao")
	RbCardDao dao ;

	@Override
	public String getBaseEntityName() {
		return "rbCard";
	}

	@Override
	public String getBasePrimaryKey() {
		return "rbCard.cardId";
	}

	@Override
	public String getById(String cardId) {
		return dao.getByID(cardId).toString();
	}

	@Override
	public String add(RbCard rbCard) {
		rbCard.setCardId(EntityIDFactory.createId());
		return dao.save(rbCard) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String cardId) {
		return dao.deleteByID(cardId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(RbCard rbCard) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("signUserName", rbCard.getSignUserName());
		
		return dao.updatePropByID(temp.entrySet(), rbCard.getCardId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String signUserName) {
		String condition = "";
		if (signUserName != null && !signUserName.equals("")) {
			condition = " signUserName like '%" + signUserName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"cardId","signUserId","signUserName","state","signTime"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
}
