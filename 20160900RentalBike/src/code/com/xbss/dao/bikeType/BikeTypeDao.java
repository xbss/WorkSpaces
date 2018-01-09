package com.xbss.dao.bikeType;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.bikeType.BikeType;
/**
 * @author xbss
 * 自行车车型
 */
public interface BikeTypeDao {
	public int save(BikeType bikeType);
	public int saveEntities(@Param("entities")BikeType[] bikeTypes);
	
	public int updateByID(@Param("entity")BikeType bikeType, @Param("id")String ID);
	public int updateByCondition(@Param("entity")BikeType bikeType, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public BikeType getByID(@Param("ID")String ID);
	public List<BikeType> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
