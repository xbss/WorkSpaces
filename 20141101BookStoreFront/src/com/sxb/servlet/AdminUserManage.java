package com.sxb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.dao.Dao;
import com.sxb.entity.User;
import com.sxb.service.UserService;

public class AdminUserManage extends HttpServlet {
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
		StringBuilder html = new StringBuilder();
		// 获取所有的用户
		List<User> userList = userService.getAllUsers();
		// 开始创建html字符串
		html.append("<form action=\"modules/admin/jsp/AdminUserManage.jsp\" method=\"post\" class=\"handle\">");
		html.append("<tr>" + "<th align=\"left\">用户名：<input type=\"text\" placeholder=\"请输入搜索条件\">地址：" +
				"<select><option value =\"重庆\">重庆</option><option value =\"上海\">上海</option><option value=\"广州\">广州</option><option value=\"深圳\">深圳</option></select>" +
				" <button type=\"submit\" >搜索</button>&nbsp&nbsp&nbsp<a href=modules/admin/jsp/AdminUserAdd.jsp>新增</a></th><th>" +
				"" +
				"</th></tr>");
		html.append("</form><br><HR style='FILTER: alpha(opacity=100,finishopacity=0,style=2)' width='100%' color=#35a02c SIZE=6>");
		
		html.append("<table class=\"datatable\">");
		html.append("" +
				"<thead>" +
				"<tr>" +
				"" + "<th>用户名</th><th>性别</th><th>生日</th><th>电话</th><th>邮政编码</th><th>地址</th><th>真实姓名</th><th>余额</th><th>操作</th>" +
				"</tr>" +
				"</thead><tbody>");
		for (User user : userList) {
			String sex = "";
			if (user.getSEX() == 0)
				sex="男";
			else 
				sex= "女";
			html.append("" +
					"<tr>" + 
					"<td>"+user.getLOGINNAME()+"</td>"+"<td>"+sex+"</td>"+"<td>"+user.getBIRTH()+"</td>"+"<td>"+user.getPHONE()+"</td>"+"<td>"+user.getMAIL()+"</td>"+"<td>"+user.getADDRESS()+"</td>"+"<td>"+user.getNAME()+"</td>"+"<td>"+user.getTYPE()+"</td>"+
					"<td align=center><a href=modules/admin/jsp/AdminUserEdit.jsp?userId="+user.getUSERID()+" style=\"color:blue;\">编辑</a> <a href=AdminUserDelete?userId="+user.getUSERID()+" style=\"color:red;\">删除</a></td>"+
					"</tr>");
		}
		// 补充需要的javascript代码片
		html.append("<script language=\"javascript\" src=\"modules/admin/js/AdminUserManage.js\"></script>");
		// 装载数据
		req.setAttribute("html", html.toString());
		req.getRequestDispatcher("/modules/admin/jsp/AdminUserManage.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
