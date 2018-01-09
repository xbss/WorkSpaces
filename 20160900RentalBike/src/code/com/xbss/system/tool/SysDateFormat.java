package com.xbss.system.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SysDateFormat {
	
	
	/**
	 * 日期格式的转换
	 */
	private static SimpleDateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static SimpleDateFormat format2 = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat format3 = new SimpleDateFormat(
			"HH:mm:ss");
    
	// yyyy-mm-dd
	public static String formatDate(Date date) {
		return format.format(date);
	}
	public static Date praseDate(String date) throws java.text.ParseException{
		return format.parse(date);
	}
	// yyyy-mm-dd hh:mm:ss
	public static String formatDateTime(Date date) {
		return format2.format(date);
	}
	public static Date parseDateTime(String dateTime) throws java.text.ParseException{
		return format.parse(dateTime);
	}
	// hh:mm:ss
	public static String formatDateHMS(Date date){
		return format3.format(date);
	}

}