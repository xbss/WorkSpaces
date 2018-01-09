package com.xbss.dao.rbUser;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.rbUser.RbUser;
/**
 * @author xbss
 * 用户
 */
public interface RbUserDao {
	public int save(RbUser rbUser);
	public int saveEntities(@Param("entities")RbUser[] rbUsers);
	
	public int updateByID(@Param("entity")RbUser rbUser, @Param("id")String ID);
	public int updateByCondition(@Param("entity")RbUser rbUser, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public RbUser getByID(@Param("ID")String ID);
	public List<RbUser> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
