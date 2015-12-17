package com.xbss.jdbc.frame.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
/**
 * @title 读取XML参数
 */
public class PropertiesTool {
	
	// 配置文件存取
	static Properties systemProperties;
	static Map<String, String>systemPropertiesMap = new HashMap<String, String>();
	
	// 获取并存入map中
	public int GetSystemProperties(){
		systemProperties = new Properties();
		InputStream inputStream = PropertiesTool.class.getClassLoader().getResourceAsStream("com/xbss/jdbc/config/system.properties");
		if (inputStream != null) {
			try {
				systemProperties.load(inputStream);
				Set<Object> set = systemProperties.keySet();
				for (Object object : set) {
					String value = systemProperties.getProperty(object.toString()).toString();
					systemPropertiesMap.put(object.toString(), value);
				}
				// 打印参数数据
				//System.out.println(systemPropertiesMap);
			} catch (IOException e) {
				System.out.println("读取系统参数错误");
				e.printStackTrace();
			}
		} else {
			System.out.println("系统配置路径出错");
		}
		return 0;
	}
	

}
