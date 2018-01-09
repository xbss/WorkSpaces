package com.xbss.service.bikeType;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.bikeType.BikeTypeDao;
import  com.xbss.entity.bikeType.BikeType;

/**
 * @author xbss
 * 自行车车型
 */
@Service
public class BikeTypeService extends SearchService implements IBikeTypeService{
	
	@Resource(name="bikeTypeDao")
	BikeTypeDao dao ;

	@Override
	public String getBaseEntityName() {
		return "bikeType";
	}

	@Override
	public String getBasePrimaryKey() {
		return "bikeType.bikeTypeId";
	}

	@Override
	public String getById(String bikeTypeId) {
		return dao.getByID(bikeTypeId).toString();
	}

	@Override
	public String add(BikeType bikeType) {
		bikeType.setBikeTypeId(EntityIDFactory.createId());
		bikeType.setCreateTime(new Date());
		return dao.save(bikeType) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String bikeTypeId) {
		return dao.deleteByID(bikeTypeId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(BikeType bikeType) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("supplierId", bikeType.getSupplierId());
		temp.put("supplierName", bikeType.getSupplierName());
		temp.put("price", bikeType.getPrice());
		
		return dao.updatePropByID(temp.entrySet(), bikeType.getBikeTypeId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String bikeTypeName) {
		String condition = "";
		if (bikeTypeName != null && !bikeTypeName.equals("")) {
			condition = " bikeTypeName like '%" + bikeTypeName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"bikeTypeId","supplierId","supplierName","bikeTypeName","createTime","price"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	@Override
	public String server_getSelectWithPage(int rows, int page, String sort){
		String condition = "";
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"bikeTypeId","price","supplierName","bikeTypeName","createTime"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
}
