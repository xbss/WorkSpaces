package com.xbss.system.tool;

import java.io.UnsupportedEncodingException;

/**
 * 在冷轧和热轧中通过网页传入汉字时来转码
 * @author wangxizhu
 *
 */
public class Decode {
	public static String getDecode(String time){
		try {
			return new String(time.getBytes( "iso-8859-1" ),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return new String();
		}
	}
}
