package com.xbss.service.maintenanceRecord;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.maintenanceRecord.MaintenanceRecordDao;
import  com.xbss.entity.maintenanceRecord.MaintenanceRecord;

/**
 * @author xbss
 * 维修记录
 */
@Service
public class MaintenanceRecordService extends SearchService implements IMaintenanceRecordService{
	
	@Resource(name="maintenanceRecordDao")
	MaintenanceRecordDao dao ;

	@Override
	public String getBaseEntityName() {
		return "maintenanceRecord";
	}

	@Override
	public String getBasePrimaryKey() {
		return "maintenanceRecord.mRId";
	}

	@Override
	public String getById(String mRId) {
		return dao.getByID(mRId).toString();
	}

	@Override
	public String add(MaintenanceRecord maintenanceRecord) {
		maintenanceRecord.setMRId(EntityIDFactory.createId());
		return dao.save(maintenanceRecord) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String mRId) {
		return dao.deleteByID(mRId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(MaintenanceRecord maintenanceRecord) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("barCode", maintenanceRecord.getMRInfo());
		
		return dao.updatePropByID(temp.entrySet(), maintenanceRecord.getMRId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String operatorName, String userName) {
		String condition = "";
		if (userName != null && !userName.equals("")) {
			condition = " userName like '%" + userName + "%'";
		}
		
		if (operatorName != null && !operatorName.equals("")) {
			condition = " operatorName like '%" + operatorName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"mRId","mRInfo","operatorId","operatorName","mRtype","userId","userName", "totalPrice"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	
}
