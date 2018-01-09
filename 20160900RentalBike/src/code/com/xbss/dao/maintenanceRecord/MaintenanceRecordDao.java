package com.xbss.dao.maintenanceRecord;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.maintenanceRecord.MaintenanceRecord;
/**
 * @author xbss
 * 维修记录
 */
public interface MaintenanceRecordDao {
	public int save(MaintenanceRecord maintenanceRecord);
	public int saveEntities(@Param("entities")MaintenanceRecord[] maintenanceRecords);
	
	public int updateByID(@Param("entity")MaintenanceRecord maintenanceRecord, @Param("id")String ID);
	public int updateByCondition(@Param("entity")MaintenanceRecord maintenanceRecord, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public MaintenanceRecord getByID(@Param("ID")String ID);
	public List<MaintenanceRecord> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
