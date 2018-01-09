package com.xbss.dao.purchasePlan;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.purchasePlan.PurchasePlan;
/**
 * @author xbss
 * 采购计划
 */
public interface PurchasePlanDao {
	public int save(PurchasePlan purchasePlan);
	public int saveEntities(@Param("entities")PurchasePlan[] purchasePlans);
	
	public int updateByID(@Param("entity")PurchasePlan purchasePlan, @Param("id")String ID);
	public int updateByCondition(@Param("entity")PurchasePlan purchasePlan, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public PurchasePlan getByID(@Param("ID")String ID);
	public List<PurchasePlan> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
