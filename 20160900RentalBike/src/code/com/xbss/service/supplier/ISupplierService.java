package com.xbss.service.supplier;

import com.xbss.entity.supplier.Supplier;

/**
 * @author xbss
 * 供应商
 */
public interface ISupplierService {
	public String getById(String supplierId);
	
	public String add(Supplier supplier);
	
	public String deleteById(String supplierId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(Supplier supplier);
	
	
	public String getWithPage(int rows, int page, String sort, String supplierName);
	public String server_getSelectWithPage(int rows, int page, String sort);
}
