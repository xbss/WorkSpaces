package com.xbss.dao.tableCreator;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface TableCreatorDao {
	public void createTable(@Param("tableName")String tableName, @Param("fieldSqls")Set<String> fieldSqls);
	public String existsTable(@Param("tableName")String tableName);
}
