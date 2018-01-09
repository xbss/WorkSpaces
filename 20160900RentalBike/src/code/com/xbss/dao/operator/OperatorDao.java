package com.xbss.dao.operator;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.operator.Operator;
/**
 * @author xbss
 * 管理员/工作人员
 */
public interface OperatorDao {
	public int save(Operator operator);
	public int saveEntities(@Param("entities")Operator[] operators);
	
	public int updateByID(@Param("entity")Operator operator, @Param("id")String ID);
	public int updateByCondition(@Param("entity")Operator operator, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public Operator getByID(@Param("ID")String ID);
	public List<Operator> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
