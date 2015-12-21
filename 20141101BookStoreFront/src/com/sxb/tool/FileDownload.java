package com.sxb.tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.service.GoodService;
import com.sxb.service.IService;
import com.sxb.service.OperatorService;
import com.sxb.service.UserService;

/**
 * 
 * @author 小小镔
 * @Title 处理图片在客户端的加载
 */
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 图片文件路径
	private String photoPath = "";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 获取类型
		String type = req.getParameter("type");
		// 获取图片请求路径
		photoPath = req.getParameter("photoPath");
		System.out.println("请求图片" + photoPath);
		// 读取文件写入输出字节流
		try {
			ServletOutputStream outputStream = resp.getOutputStream();
			FileInputStream inputStream = new FileInputStream(
					SysConfig.HEAD_UPLOAD + File.separator + photoPath);
			byte buffer[] = new byte[1024];
			int byteTemp;
			while ((byteTemp = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, byteTemp);
			}
			try {
				outputStream.flush();
				outputStream.close();
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			System.out.println("DEBUG: " + "提取图片失败");
			e.printStackTrace();
		}
	}
}
