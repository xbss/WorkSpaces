package com.xbss.dao.maintenancePlan;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.maintenancePlan.MaintenancePlan;
/**
 * @author xbss
 * 维修计划
 */
public interface MaintenancePlanDao {
	public int save(MaintenancePlan maintenancePlan);
	public int saveEntities(@Param("entities")MaintenancePlan[] maintenancePlans);
	
	public int updateByID(@Param("entity")MaintenancePlan maintenancePlan, @Param("id")String ID);
	public int updateByCondition(@Param("entity")MaintenancePlan maintenancePlan, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public MaintenancePlan getByID(@Param("ID")String ID);
	public List<MaintenancePlan> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
