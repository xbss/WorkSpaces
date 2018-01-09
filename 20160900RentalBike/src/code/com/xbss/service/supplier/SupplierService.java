package com.xbss.service.supplier;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.supplier.SupplierDao;
import  com.xbss.entity.supplier.Supplier;

/**
 * @author xbss
 * 供应商
 */
@Service
public class SupplierService extends SearchService implements ISupplierService{
	
	@Resource(name="supplierDao")
	SupplierDao dao ;

	@Override
	public String getBaseEntityName() {
		return "supplier";
	}

	@Override
	public String getBasePrimaryKey() {
		return "supplier.supplierId";
	}

	@Override
	public String getById(String supplierId) {
		return dao.getByID(supplierId).toString();
	}

	@Override
	public String add(Supplier supplier) {
		supplier.setSupplierId(EntityIDFactory.createId());
		return dao.save(supplier) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String supplierId) {
		return dao.deleteByID(supplierId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(Supplier supplier) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("supplierName", supplier.getSupplierName());
		temp.put("introduction", supplier.getIntroduction());
		
		return dao.updatePropByID(temp.entrySet(), supplier.getSupplierId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String supplierName) {
		String condition = "";
		if (supplierName != null && !supplierName.equals("")) {
			condition = " supplierName like '%" + supplierName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"supplierId","supplierName","introduction"},
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
				new String[]{"supplierId","supplierName","introduction"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
}
