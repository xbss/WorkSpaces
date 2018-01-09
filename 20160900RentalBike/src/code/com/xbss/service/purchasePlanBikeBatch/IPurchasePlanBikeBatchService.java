package com.xbss.service.purchasePlanBikeBatch;

import com.xbss.entity.purchasePlanBikeBatch.PurchasePlanBikeBatch;

/**
 * @author xbss
 * 采购计划批次表
 */
public interface IPurchasePlanBikeBatchService {
	public String getById(String pPBikeBatchId);
	
	public String add(PurchasePlanBikeBatch purchasePlanBikeBatch);
	
	public String deleteById(String pPBikeBatchId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(PurchasePlanBikeBatch purchasePlanBikeBatch);
	
	
	public String getWithPage(int rows, int page, String sort, String pPId);
}
