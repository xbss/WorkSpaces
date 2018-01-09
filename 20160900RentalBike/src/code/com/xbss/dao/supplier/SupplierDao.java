package com.xbss.dao.supplier;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.supplier.Supplier;
/**
 * @author xbss
 * 供应商
 */
public interface SupplierDao {
	public int save(Supplier supplier);
	public int saveEntities(@Param("entities")Supplier[] suppliers);
	
	public int updateByID(@Param("entity")Supplier supplier, @Param("id")String ID);
	public int updateByCondition(@Param("entity")Supplier supplier, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public Supplier getByID(@Param("ID")String ID);
	public List<Supplier> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
