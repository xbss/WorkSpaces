package com.sxb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IResultSetHandler {
	/**
	 * @Title: 处理来自查询数据库的集合
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	public Object doHandler(ResultSet rs) throws SQLException;
}
