package com.xbss.service.maintenancePlan;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.maintenancePlan.MaintenancePlanDao;
import  com.xbss.entity.maintenancePlan.MaintenancePlan;

/**
 * @author xbss
 * 维修计划
 */
@Service
public class MaintenancePlanService extends SearchService implements IMaintenancePlanService{
	
	@Resource(name="maintenancePlanDao")
	MaintenancePlanDao dao ;

	@Override
	public String getBaseEntityName() {
		return "maintenancePlan";
	}

	@Override
	public String getBasePrimaryKey() {
		return "maintenancePlan.mPId";
	}

	@Override
	public String getById(String mPId) {
		return dao.getByID(mPId).toString();
	}

	@Override
	public String add(MaintenancePlan maintenancePlan) {
		maintenancePlan.setMPId(EntityIDFactory.createId());
		return dao.save(maintenancePlan) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String mPId) {
		return dao.deleteByID(mPId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(MaintenancePlan maintenancePlan) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("operatorName", maintenancePlan.getOperatorName());
		
		return dao.updatePropByID(temp.entrySet(), maintenancePlan.getMPId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName) {
		String condition = "";
		if (operatorName != null && !operatorName.equals("")) {
			condition = " operatorName like '%" + operatorName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"mPId","mPInfo","operatorId","operatorName","pPBikeBatchIds","totalPrice","carryStatus"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	
}
