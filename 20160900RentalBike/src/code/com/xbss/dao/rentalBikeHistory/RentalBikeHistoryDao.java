package com.xbss.dao.rentalBikeHistory;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.rentalBikeHistory.RentalBikeHistory;
/**
 * @author xbss
 * 车辆租借记录
 */
public interface RentalBikeHistoryDao {
	public int save(RentalBikeHistory rentalBikeHistory);
	public int saveEntities(@Param("entities")RentalBikeHistory[] rentalBikeHistorys);
	
	public int updateByID(@Param("entity")RentalBikeHistory rentalBikeHistory, @Param("id")String ID);
	public int updateByCondition(@Param("entity")RentalBikeHistory rentalBikeHistory, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public RentalBikeHistory getByID(@Param("ID")String ID);
	public List<RentalBikeHistory> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
