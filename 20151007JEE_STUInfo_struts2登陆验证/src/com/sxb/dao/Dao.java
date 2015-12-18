package com.sxb.dao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/**
 * @author  xiaobin xiaobin (邵小镔) 
 * @title JDBC
 *  数据库操作
 */
public class Dao {
	/**
	 * @Title 执行Sql查询语句，把结果集放在List<Map<String , Object>>
	 * @param sql
	 * @param params
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> excuteQuery(String sql, Object[] params){
		return (List<Map<String, Object>>) this.excuteQuery(sql, params, new ResultSetHandler());
	}
	public Object excuteQuery(String sql, Object[] params, IResultSetHandler resultSetHandler){
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = DataBaseConnection.getConnection();
		List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
		try {
			statement = connection.prepareStatement(sql);
			// 打印数据库操作信息
			System.out.println("DEBUG:" + sql);
			System.out.println("Params: " + Arrays.deepToString(params));
			// 填充参数到statement
			fillStatement(statement,params);
			// 执行Sql查询语句
			resultSet = statement.executeQuery();
			// 调用dohandler转换结果
			Object object = resultSetHandler.doHandler(resultSet);
			return object;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(connection, statement, resultSet);
		}
		return resultList;
	}
	/**
	 * @Title 数据库更新 利用一个事务来处理更新过程
	 * @param sql
	 * @param params
	 * @return
	 */
	public int executeUpdate(String sql, Object[] params){
		PreparedStatement statement = null;
		Connection connection = DataBaseConnection.getConnection();
		
		int result = 0;
		try {
			// 数据安全，事务提交自动化False
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			// 填充参数
			fillStatement(statement, params);
			// 打印数据库操作信息
			System.out.println("DEBUG:" + sql);
			System.out.println("Params: " + Arrays.deepToString(params));
			// 执行更新
			result = statement.executeUpdate();
			// 提交事务
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			// 检测到异常的时候事务回滚
			try {
				connection.rollback();
				if (!connection.getAutoCommit()) {
					connection.setAutoCommit(true);
				}
			} catch ( SQLException e1) {
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			close(connection, statement, null);
		}
		return result;
	}
	public void fillStatement(PreparedStatement statement, Object[] params) {
		ParameterMetaData parameterMetaData = null;
		// 检测参数的个数是否合法
		try {
			parameterMetaData = statement.getParameterMetaData();
			int statementCount = parameterMetaData.getParameterCount();
			int paramsCount = params == null ? 0 : params.length;
			if (statementCount != paramsCount) {
				throw new SQLException("Wrong number of paramters: expected " + statementCount + ". was given " + paramsCount);
			}
			
			// 如果 params 为 null 直接返回
			if (params == null) {
				return;
			}
			// params 不为空填充参数
			for (int i = 0; i < params.length; i++) {
				if (params[i] != null) {
					statement.setObject(i+1, params[i]);
				} else {
					int sqlType = Types.VARCHAR;
					try {
						sqlType = parameterMetaData.getParameterType(i + 1);
					} catch (SQLException e) {
						e.printStackTrace();
					}
					statement.setNull(i+1, sqlType);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DEBUG:"  + "数据库填充错误");
			e.printStackTrace();
		}
	}
	/**
	 * @Title: 关闭数据库连接
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	private void close(Connection connection, Statement statement,
			ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (statement != null) {
					try {
						statement.close();
					} catch (SQLException e) {
						e.printStackTrace();
					} finally {
						if (connection != null) {
							try {
								connection.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
}
