package com.xbss.entity.supplier;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 供应商
 */
public class Supplier{
	
	@ID
	private String  supplierId;
	private String supplierName;
	private String introduction;
	
	
	public String getSupplierId() {
		return supplierId;
	}	
	
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}	
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getIntroduction() {
		return introduction;
	}	
	
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	@Override
	public String toString() {
		return   supplierId  + "\t" +  supplierName  + "\t" +  introduction  + "\t"  ;
	}
}
