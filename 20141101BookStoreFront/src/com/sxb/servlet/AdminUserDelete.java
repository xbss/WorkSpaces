package com.sxb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.service.UserService;

public class AdminUserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("正在删除用户信息");
		// 获取参数
		String userId = req.getParameter("userId");
		int flag = userService.DeleteUserByCondition("userid", userId);
		if (flag > 0) {
			// 增加自动跳转的代码
			String html = "<script language='JavaScript' type='text/javascript'>" +
					"function delayURL(url) {" +
					"var delay = document.getElementById('time').innerHTML;" +
					"	if(delay > 0) {" +
					"delay--;" +
					"document.getElementById('time').innerHTML = delay;" +
							"} else {" +
							"window.top.location.href = url;" +
							"}" +
							"setTimeout('delayURL('' + url + '')', 1000);" +
									"}" +
									"</script>" +
								"<span id='time' style='background: #00BFFF'>4</span>秒钟后自动跳转，如果不跳转，请点击下面的链接<a href='AdminIndex?actionType=Column&ColumnId=1'>用户管理</a>" +
							"<script type='text/javascript'>" +
								"delayURL('AdminIndex?actionType=Column&ColumnId=0');" +
							"</script>";
			// 加入
			req.setAttribute("html", html);
			req.getRequestDispatcher("success.jsp").forward(req, resp);
		} else {
			// 增加自动跳转的代码
			String html = "<script language='JavaScript' type='text/javascript'>" +
					"function delayURL(url) {" +
					"var delay = document.getElementById('time').innerHTML;" +
					"	if(delay > 0) {" +
					"delay--;" +
					"document.getElementById('time').innerHTML = delay;" +
							"} else {" +
							"window.top.location.href = url;" +
							"}" +
							"setTimeout('delayURL('' + url + '')', 1000);" +
									"}" +
									"</script>" +
								"<span id='time' style='background: #00BFFF'>4</span>秒钟后自动跳转，如果不跳转，请点击下面的链接<a href='AdminIndex?actionType=Column&ColumnId=1'>用户管理</a>" +
							"<script type='text/javascript'>" +
								"delayURL('AdminIndex?actionType=Column&ColumnId=0');" +
							"</script>";
			// 加入
			req.setAttribute("html", html);
			req.getRequestDispatcher("failed.jsp").forward(req, resp);
		}
		
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
