package com.xbss.dao.purchasePlanBikeBatch;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.purchasePlanBikeBatch.PurchasePlanBikeBatch;
/**
 * @author xbss
 * 采购计划批次表
 */
public interface PurchasePlanBikeBatchDao {
	public int save(PurchasePlanBikeBatch purchasePlanBikeBatch);
	public int saveEntities(@Param("entities")PurchasePlanBikeBatch[] purchasePlanBikeBatchs);
	
	public int updateByID(@Param("entity")PurchasePlanBikeBatch purchasePlanBikeBatch, @Param("id")String ID);
	public int updateByCondition(@Param("entity")PurchasePlanBikeBatch purchasePlanBikeBatch, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public PurchasePlanBikeBatch getByID(@Param("ID")String ID);
	public List<PurchasePlanBikeBatch> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
