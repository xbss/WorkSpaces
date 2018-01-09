package com.xbss.dao.bikeInfo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.bikeInfo.BikeInfo;
/**
 * @author xbss
 * 自行车信息
 */
public interface BikeInfoDao {
	public int save(BikeInfo bikeInfo);
	public int saveEntities(@Param("entities")BikeInfo[] bikeInfos);
	
	public int updateByID(@Param("entity")BikeInfo bikeInfo, @Param("id")String ID);
	public int updateByCondition(@Param("entity")BikeInfo bikeInfo, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public BikeInfo getByID(@Param("ID")String ID);
	public List<BikeInfo> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
