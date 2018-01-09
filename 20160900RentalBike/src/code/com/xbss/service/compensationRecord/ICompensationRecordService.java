package com.xbss.service.compensationRecord;

import com.xbss.entity.compensationRecord.CompensationRecord;

/**
 * @author xbss
 * 赔偿记录
 */
public interface ICompensationRecordService {
	public String getById(String cRId);
	
	public String add(CompensationRecord compensationRecord);
	
	public String deleteById(String cRId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(CompensationRecord compensationRecord);
	
	
	public String getWithPage(int rows, int page, String sort, String userName);
	
	public String client_getUserComRecordById(String cRId);
	public String client_getUserComRecordWithPage(String userId, int rows, int page);
}
