package com.xbss.service.storage;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xbss.service.operator.OperatorService;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.storage.StorageDao;
import  com.xbss.entity.storage.Storage;

/**
 * @author xbss
 * 仓库
 */
@Service
public class StorageService extends SearchService implements IStorageService{
	
	@Resource(name="storageDao")
	StorageDao dao ;
	
	@Resource(name="operatorService")
	OperatorService operatorService ;

	@Override
	public String getBaseEntityName() {
		return "storage";
	}

	@Override
	public String getBasePrimaryKey() {
		return "storage.storageId";
	}

	@Override
	public String getById(String storageId) {
		return dao.getByID(storageId).toString();
	}

	@Override
	public String add(Storage storage, HttpServletRequest request) {
		storage.setStorageId(EntityIDFactory.createId());
		storage.setCreateTime(new Date());
		storage.setOperatorId(operatorService.getCurrentOperator(request).getOperatorCode());
		storage.setOperatorName(operatorService.getCurrentOperator(request).getOperatorName());
		return dao.save(storage) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String storageId) {
		return dao.deleteByID(storageId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(Storage storage, HttpServletRequest request) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("address", storage.getAddress());
		temp.put("state", storage.getState());
		temp.put("operatorId", operatorService.getCurrentOperator(request).getOperatorCode());
		temp.put("operatorName", operatorService.getCurrentOperator(request).getOperatorName());
		temp.put("information", storage.getInformation());
		
		return dao.updatePropByID(temp.entrySet(), storage.getStorageId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String address) {
		String condition = "";
		if (address != null && !address.equals("")) {
			condition = " address like '%" + address + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"storageId","address","state","createTime","operatorId","operatorName","information"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	@Override
	public String server_getSelectWithPage(int rows, int page, String sort){
		String condition = " state = 1";
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"storageId","address","createTime","operatorName","information"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
}
