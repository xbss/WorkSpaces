package com.xbss.dao.compensationRecord;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.compensationRecord.CompensationRecord;
/**
 * @author xbss
 * 赔偿记录
 */
public interface CompensationRecordDao {
	public int save(CompensationRecord compensationRecord);
	public int saveEntities(@Param("entities")CompensationRecord[] compensationRecords);
	
	public int updateByID(@Param("entity")CompensationRecord compensationRecord, @Param("id")String ID);
	public int updateByCondition(@Param("entity")CompensationRecord compensationRecord, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public CompensationRecord getByID(@Param("ID")String ID);
	public List<CompensationRecord> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
