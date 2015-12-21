package com.sxb.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将结果集每一行里面的放入map中
 * @author 小小镔
 *
 */
public class ResultSetHandler implements IResultSetHandler {

	@Override
	public Object doHandler(ResultSet rs) throws SQLException {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		ResultSetMetaData resultSetMetaData = rs.getMetaData();
		int cols = resultSetMetaData.getColumnCount();

		HashMap<String, Object> m = null;
		// 遍历结果集
		while (rs.next()) {
			m = new HashMap<String, Object>();
			// 保存到HashMap中
			for (int i = 1; i <= cols; i++) {
				/*System.out.println("Label:"+resultSetMetaData.getColumnLabel(i) +":" +resultSetMetaData.getColumnName(i)+","+rs.getObject(i));*/
				m.put(resultSetMetaData.getColumnLabel(i), rs.getObject(i));
			}
			resultList.add(m);
		}
		return resultList;
	}

}
