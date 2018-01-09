package com.xbss.dao.dayFinancialSheet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.dayFinancialSheet.DayFinancialSheet;
/**
 * @author xbss
 * 日财务表
 */
public interface DayFinancialSheetDao {
	public int save(DayFinancialSheet dayFinancialSheet);
	public int saveEntities(@Param("entities")DayFinancialSheet[] dayFinancialSheets);
	
	public int updateByID(@Param("entity")DayFinancialSheet dayFinancialSheet, @Param("id")String ID);
	public int updateByCondition(@Param("entity")DayFinancialSheet dayFinancialSheet, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public DayFinancialSheet getByID(@Param("ID")String ID);
	public List<DayFinancialSheet> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
