package com.sxb.tool;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author 小小镔
 * @Title 获取一些系统的参数
 */
public class SysConfig {
	// 服务器端名
	public static String serverName = "BookStore";

	// 获取相对用于客户机来说server的绝对路径
	public static String serverPath(HttpServletRequest request) {
		return request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + "/" + serverName;
	}

	// 用户上传头像的文件的路径
	public static String HEAD_UPLOAD = "D:\\Project\\BookStore\\head";

	// 头像缓存目录
	public static String HEAD_TEMP = "D:\\Project\\BookStore\\temp";

	// 检查文件是否存在，如果不存在就创建新文件夹
	static {
		File file = new File(HEAD_UPLOAD);
		if (!file.exists()) {
			boolean flag = file.mkdirs();
			if (flag) {
				System.out.println("DEBUG: " + "创建新文件夹" + file.getPath());
			}
		}

		File file1 = new File(HEAD_UPLOAD);
		if (!file1.exists()) {
			boolean flag = file1.mkdirs();
			if (flag) {
				System.out.println("DEBUG: " + "创建新文件夹" + file1.getPath());
			}
		}
	}

	// 获取相对于服务器的当前请求URL
	public static String getRelativeUrl(HttpServletRequest request,
			HttpServletResponse response) {
		String url = request.getRequestURL().toString();

		int indexofurl = url.lastIndexOf(SysConfig.serverPath(request));
		/* url = url.substring(indexofurl).replace("BookStore", ""); */
		url = url.replace(SysConfig.serverPath(request), "");
		System.out.println("URL: " + url);
		return url;
	}
}
