package com.xbss.service.purchasePlan;

import com.xbss.entity.purchasePlan.PurchasePlan;

/**
 * @author xbss
 * 采购计划
 */
public interface IPurchasePlanService {
	public String getById(String pPId);
	
	public String add(PurchasePlan purchasePlan);
	
	public String deleteById(String pPId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(PurchasePlan purchasePlan);
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName);
}
