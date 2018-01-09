package com.xbss.dao.suggestion;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.suggestion.Suggestion;
/**
 * @author xbss
 * 意见建议
 */
public interface SuggestionDao {
	public int save(Suggestion suggestion);
	public int saveEntities(@Param("entities")Suggestion[] suggestions);
	
	public int updateByID(@Param("entity")Suggestion suggestion, @Param("id")String ID);
	public int updateByCondition(@Param("entity")Suggestion suggestion, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public Suggestion getByID(@Param("ID")String ID);
	public List<Suggestion> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
