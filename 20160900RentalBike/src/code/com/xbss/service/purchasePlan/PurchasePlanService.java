package com.xbss.service.purchasePlan;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.purchasePlan.PurchasePlanDao;
import  com.xbss.entity.purchasePlan.PurchasePlan;

/**
 * @author xbss
 * 采购计划
 */
@Service
public class PurchasePlanService extends SearchService implements IPurchasePlanService{
	
	@Resource(name="purchasePlanDao")
	PurchasePlanDao dao ;

	@Override
	public String getBaseEntityName() {
		return "purchasePlan";
	}

	@Override
	public String getBasePrimaryKey() {
		return "purchasePlan.pPId";
	}

	@Override
	public String getById(String pPId) {
		return dao.getByID(pPId).toString();
	}

	@Override
	public String add(PurchasePlan purchasePlan) {
		purchasePlan.setPPId(EntityIDFactory.createId());
		return dao.save(purchasePlan) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String pPId) {
		return dao.deleteByID(pPId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(PurchasePlan purchasePlan) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("pPInfo", purchasePlan.getPPInfo());
		
		return dao.updatePropByID(temp.entrySet(), purchasePlan.getPPId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName) {
		String condition = "";
		if (operatorName != null && !operatorName.equals("")) {
			condition = " bikeId like '%" + operatorName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"pPId","pPInfo","operatorId","operatorName","totalPrice"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
}
