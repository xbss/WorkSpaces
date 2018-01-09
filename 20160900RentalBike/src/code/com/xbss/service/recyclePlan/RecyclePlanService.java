package com.xbss.service.recyclePlan;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.recyclePlan.RecyclePlanDao;
import  com.xbss.entity.recyclePlan.RecyclePlan;

/**
 * @author xbss
 * 回收计划表
 */
@Service
public class RecyclePlanService extends SearchService implements IRecyclePlanService{
	
	@Resource(name="recyclePlanDao")
	RecyclePlanDao dao ;

	@Override
	public String getBaseEntityName() {
		return "recyclePlan";
	}

	@Override
	public String getBasePrimaryKey() {
		return "recyclePlan.rPId";
	}

	@Override
	public String getById(String rPId) {
		return dao.getByID(rPId).toString();
	}

	@Override
	public String add(RecyclePlan recyclePlan) {
		recyclePlan.setRPId(EntityIDFactory.createId());
		return dao.save(recyclePlan) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String rPId) {
		return dao.deleteByID(rPId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(RecyclePlan recyclePlan) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("operatorName", recyclePlan.getOperatorName());
		
		return dao.updatePropByID(temp.entrySet(), recyclePlan.getRPId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName) {
		String condition = "";
		if (operatorName != null && !operatorName.equals("")) {
			condition = " operatorName like '%" + operatorName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"rPId","rPInfo","operatorId","operatorName","pPBikeBatchIds","evaluation","totalPrice","carryStatus"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
}
