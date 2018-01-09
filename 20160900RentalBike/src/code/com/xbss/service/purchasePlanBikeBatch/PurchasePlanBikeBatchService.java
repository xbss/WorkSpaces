package com.xbss.service.purchasePlanBikeBatch;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.purchasePlanBikeBatch.PurchasePlanBikeBatchDao;
import  com.xbss.entity.purchasePlanBikeBatch.PurchasePlanBikeBatch;

/**
 * @author xbss
 * 采购计划批次表
 */
@Service
public class PurchasePlanBikeBatchService extends SearchService implements IPurchasePlanBikeBatchService{
	
	@Resource(name="purchasePlanBikeBatchDao")
	PurchasePlanBikeBatchDao dao ;

	@Override
	public String getBaseEntityName() {
		return "purchasePlanBikeBatch";
	}

	@Override
	public String getBasePrimaryKey() {
		return "purchasePlanBikeBatch.pPBikeBatchId";
	}

	@Override
	public String getById(String pPBikeBatchId) {
		return dao.getByID(pPBikeBatchId).toString();
	}

	@Override
	public String add(PurchasePlanBikeBatch purchasePlanBikeBatch) {
		purchasePlanBikeBatch.setPPBikeBatchId(EntityIDFactory.createId());
		return dao.save(purchasePlanBikeBatch) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String pPBikeBatchId) {
		return dao.deleteByID(pPBikeBatchId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(PurchasePlanBikeBatch purchasePlanBikeBatch) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("amount", purchasePlanBikeBatch.getAmount());
		
		return dao.updatePropByID(temp.entrySet(), purchasePlanBikeBatch.getPPBikeBatchId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String pPId) {
		String condition = "";
		if (pPId != null && !pPId.equals("")) {
			condition = " pPId like '%" + pPId + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"pPBikeBatchId","pPId","bikeTypeId","bikeTypeName","amount","carryStatus"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	
}
