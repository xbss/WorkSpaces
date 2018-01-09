package com.xbss.service.compensationRecord;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.compensationRecord.CompensationRecordDao;
import  com.xbss.entity.compensationRecord.CompensationRecord;

/**
 * @author xbss
 * 赔偿记录
 */
@Service
public class CompensationRecordService extends SearchService implements ICompensationRecordService{
	
	@Resource(name="compensationRecordDao")
	CompensationRecordDao dao ;

	@Override
	public String getBaseEntityName() {
		return "compensationRecord";
	}

	@Override
	public String getBasePrimaryKey() {
		return "compensationRecord.cRId";
	}

	@Override
	public String getById(String cRId) {
		return dao.getByID(cRId).toString();
	}

	@Override
	public String add(CompensationRecord compensationRecord) {
		compensationRecord.setCRId(EntityIDFactory.createId());
		return dao.save(compensationRecord) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String cRId) {
		return dao.deleteByID(cRId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(CompensationRecord compensationRecord) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("userName", compensationRecord.getUserName());
		
		return dao.updatePropByID(temp.entrySet(), compensationRecord.getCRId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String userName) {
		String condition = "";
		if (userName != null && !userName.equals("")) {
			condition = " userName like '%" + userName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"cRId","bikeId","userId","userName","rentalId","price"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	/**
	 * @title 客户端查看单条赔款记录详情
	 */
	@Override
	public String client_getUserComRecordById(String cRId){
		if (cRId != null) {
			return JSONObject.fromObject(dao.getByID(cRId)).toString();
		} else {
			return "";
		}
	}
	
	/**
	 * @title 客户端查看赔款记录
	 */
	@Override
	public String client_getUserComRecordWithPage(String userId, int rows, int page){
		
		String condition = "";
		if (userId != null && !userId.equals("")) {
			condition = " userId = '" + userId + "'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"cRId","bikeId","rentalId","price" , "operatorName" , "DATE_FORMAT(cRTime, '%Y-%m-%d %H:%i:%S')  AS cRTime"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		return JSONObject.fromObject(objects).toString();
	}
	
}
