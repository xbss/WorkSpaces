package com.sxb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.sxb.service.StudentAction;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Service 
	public StudentAction service = new StudentAction();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// 获得前台的参数
		String attr = req.getParameter("attr");
		String isHave = "";
		if (req.getParameter("isHave") != null) {
			isHave = req.getParameter("isHave");
		}
		String content = req.getParameter("content");
		// 处理后的结果
		JSONArray result = JSONArray.fromObject(service.getStudents(attr, isHave, content));
		System.out.println("ss" + content + result);
		String count = service.getCount(attr, isHave, content);
		String data = "";
		// 生成html
		for (Object object : result) {
			JSONObject jsonObject = (JSONObject) object;
			data += "<tr><td>" + jsonObject.get("sno") + "</td>";
			data += "<td>" + jsonObject.get("sname") + "</td>";
			data += "<td>" + jsonObject.get("sage") + "</td>";
			data += "</tr>";
		}
				
		// 查询结果写入
		req.setAttribute("data", data);
		req.setAttribute("count", count);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	

}
