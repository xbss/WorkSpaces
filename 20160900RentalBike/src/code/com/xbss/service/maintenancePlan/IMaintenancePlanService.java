package com.xbss.service.maintenancePlan;

import com.xbss.entity.maintenancePlan.MaintenancePlan;

/**
 * @author xbss
 * 维修计划
 */
public interface IMaintenancePlanService {
	public String getById(String mPId);
	
	public String add(MaintenancePlan maintenancePlan);
	
	public String deleteById(String mPId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(MaintenancePlan maintenancePlan);
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName);
}
