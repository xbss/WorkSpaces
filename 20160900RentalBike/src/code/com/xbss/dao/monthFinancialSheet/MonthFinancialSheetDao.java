package com.xbss.dao.monthFinancialSheet;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.monthFinancialSheet.MonthFinancialSheet;
/**
 * @author xbss
 * 月财务
 */
public interface MonthFinancialSheetDao {
	public int save(MonthFinancialSheet monthFinancialSheet);
	public int saveEntities(@Param("entities")MonthFinancialSheet[] monthFinancialSheets);
	
	public int updateByID(@Param("entity")MonthFinancialSheet monthFinancialSheet, @Param("id")String ID);
	public int updateByCondition(@Param("entity")MonthFinancialSheet monthFinancialSheet, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public MonthFinancialSheet getByID(@Param("ID")String ID);
	public List<MonthFinancialSheet> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
