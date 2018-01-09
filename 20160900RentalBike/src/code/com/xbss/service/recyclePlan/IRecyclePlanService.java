package com.xbss.service.recyclePlan;

import com.xbss.entity.recyclePlan.RecyclePlan;

/**
 * @author xbss
 * 回收计划表
 */
public interface IRecyclePlanService {
	public String getById(String rPId);
	
	public String add(RecyclePlan recyclePlan);
	
	public String deleteById(String rPId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(RecyclePlan recyclePlan );
	
	
	public String getWithPage(int rows, int page, String sort, String operatorName);
}
