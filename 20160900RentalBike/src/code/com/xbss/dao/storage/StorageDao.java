package com.xbss.dao.storage;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.storage.Storage;
/**
 * @author xbss
 * 仓库
 */
public interface StorageDao {
	public int save(Storage storage);
	public int saveEntities(@Param("entities")Storage[] storages);
	
	public int updateByID(@Param("entity")Storage storage, @Param("id")String ID);
	public int updateByCondition(@Param("entity")Storage storage, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public Storage getByID(@Param("ID")String ID);
	public List<Storage> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
