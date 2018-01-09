package com.xbss.dao.yearFinancialSheet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.yearFinancialSheet.YearFinancialSheet;
/**
 * @author xbss
 * 年财务
 */
public interface YearFinancialSheetDao {
	public int save(YearFinancialSheet yearFinancialSheet);
	public int saveEntities(@Param("entities")YearFinancialSheet[] yearFinancialSheets);
	
	public int updateByID(@Param("entity")YearFinancialSheet yearFinancialSheet, @Param("id")String ID);
	public int updateByCondition(@Param("entity")YearFinancialSheet yearFinancialSheet, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public YearFinancialSheet getByID(@Param("ID")String ID);
	public List<YearFinancialSheet> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
