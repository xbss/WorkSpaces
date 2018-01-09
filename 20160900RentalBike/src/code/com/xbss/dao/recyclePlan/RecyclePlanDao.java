package com.xbss.dao.recyclePlan;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.recyclePlan.RecyclePlan;
/**
 * @author xbss
 * 回收计划表
 */
public interface RecyclePlanDao {
	public int save(RecyclePlan recyclePlan);
	public int saveEntities(@Param("entities")RecyclePlan[] recyclePlans);
	
	public int updateByID(@Param("entity")RecyclePlan recyclePlan, @Param("id")String ID);
	public int updateByCondition(@Param("entity")RecyclePlan recyclePlan, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public RecyclePlan getByID(@Param("ID")String ID);
	public List<RecyclePlan> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
