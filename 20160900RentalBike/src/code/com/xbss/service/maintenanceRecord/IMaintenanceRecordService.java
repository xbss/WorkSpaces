package com.xbss.service.maintenanceRecord;

import com.xbss.entity.maintenanceRecord.MaintenanceRecord;

/**
 * @author xbss
 * 维修记录
 */
public interface IMaintenanceRecordService {
	public String getById(String mRId);
	
	public String add(MaintenanceRecord maintenanceRecord);
	
	public String deleteById(String mRId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(MaintenanceRecord maintenanceRecord);
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName, String userName);
}
