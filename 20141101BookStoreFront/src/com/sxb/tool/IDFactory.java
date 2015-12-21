package com.sxb.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 * 
 * @author 小小镔
 * @Title 使用当前的时间生成数据库主键  ID
 */
public class IDFactory {
	private static final SimpleDateFormat format= new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static String preId = "";
	
	public static synchronized String createId(){
		String id = format.format(Calendar.getInstance().getTime());
		while(id.equals(preId)){
			id = format.format(Calendar.getInstance().getTime());
		}
		preId = id;
		return id;
	}
}
