package com.xbss.dao.rbCard;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import  com.xbss.entity.rbCard.RbCard;
/**
 * @author xbss
 * 一卡通/会员卡
 */
public interface RbCardDao {
	public int save(RbCard rbCard);
	public int saveEntities(@Param("entities")RbCard[] rbCards);
	
	public int updateByID(@Param("entity")RbCard rbCard, @Param("id")String ID);
	public int updateByCondition(@Param("entity")RbCard rbCard, @Param("condition")String condition);
	public int updatePropByID(@Param("prop")Set<Entry<String, Object>> prop,  @Param("id")String ID);
	public int updatePropByCondition(@Param("prop")Set<Entry<String, Object>> prop,  @Param("condition")String condition);
	
	public int deleteByID(@Param("ID")String ID);
	public int deleteByCondition(@Param("condition")String condition);
	public int deleteEntities(@Param("ids")String[] IDs);
	
	public RbCard getByID(@Param("ID")String ID);
	public List<RbCard> getByCondition(@Param("condition")String condition);
	public Map<String,Object> findByID(@Param("properties")String[] properties, @Param("id")String id);
	public List<Map<String,Object>> findByCondition(@Param("properties")String[] properties, @Param("condition")String condition);
	
	public int getCountByCondition(@Param("condition")String condition);
	
	
}
