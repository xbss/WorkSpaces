package com.sxb.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SysDateFormat {
	
	
	/**
	 * 日期格式的转换
	 */
	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	public static String formatDate(Date date) {
		return format.format(date);
	}
	public static Date praseDate(String dateString) throws java.text.ParseException{
		return format.parse(dateString);
	}

}
