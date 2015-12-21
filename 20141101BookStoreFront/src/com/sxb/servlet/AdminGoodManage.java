package com.sxb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.entity.Good;
import com.sxb.entity.User;
import com.sxb.service.GoodService;
import com.sxb.service.GoodTypeService;

public class AdminGoodManage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodService goodService = new GoodService();
	GoodTypeService goodTypeService = new GoodTypeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		StringBuilder html = new StringBuilder();
		// 存 list
		List<Good> goodList = new ArrayList<Good>();
		// 如果参数为空就直接取所有数据
		if (req.getParameter("goodqueryname") != null && !req.getParameter("goodqueryname").equals("")) {
			goodList = goodService.getGoodsByCondition("name", req.getParameter("goodqueryname"));
			for (Good good : goodList) {
				if (!goodTypeService.getGoodTypesByCondition("goodtypeid", good.getGOODTYPEID()).get(0).getNAME().equals(req.getParameter("goodquerytype"))) {
					goodList.remove(good);
				}
			}
		} else {
			// 获取所有的用户
			goodList = goodService.getAllGoods();
		}
		
		// 开始创建html字符串
		html.append("<form action=\"modules/admin/jsp/AdminGoodManage.jsp\" method=\"post\"  class=\"handle\">");
		html.append("<tr>" + "<th align=\"left\">书名：<input type=\"text\" placeholder=\"请输入搜索条件\"> 类型：" +
				"<select><option value =\"儿童类\">儿童类</option><option value =\"科技类\">科技类</option><option value=\"广州\">广州</option><option value=\"深圳\">深圳</option></select>" +
				" <button type=\"submit\" >搜索</button>&nbsp;&nbsp;&nbsp;</th><th>" +
				"<a href=modules/admin/jsp/AdminGoodAdd.jsp>新增</a>&nbsp;" +
				"<a href=modules/admin/jsp/AdminGoodSales.jsp>销售统计</a>&nbsp;" +
				"<a href=modules/admin/jsp/AdminGoodStock.jsp>库存统计</a>&nbsp;" +
				"</th></tr>");
		html.append("</form><br><HR style='FILTER: alpha(opacity=100,finishopacity=0,style=2)' width='100%' color=#35a02c SIZE=6>");
		
		html.append("<table class=\"datatable\">");
		html.append("" +
				"<thead>" +
				"<tr>" +
				"" + "<th>ISBN</th><th>书名</th><th>作者</th><th>价格</th><th>出版社</th><th>库存</th><th>类型</th><th>操作</th>" +
				"</tr>" +
				"</thead><tbody>");
		for (Good good : goodList) {
			html.append("" +
					"<tr>" + 
					"<td>"+good.getISBN()+"</td>"+"<td>"+good.getNAME()+"</td>"+"<td>"+good.getAUTHOR()+"</td>"+"<td>"+good.getPRICE()+"</td>"+"<td>"+good.getPUBLISHER()+"</td>"+"<td>"+good.getSTOCK()+"</td>"+"<td>"+goodTypeService.getGoodTypesByCondition("goodtypeid", good.getGOODTYPEID()).get(0).getNAME()+"</td>"+
					"<td align=center><a href=modules/admin/jsp/AdminGoodEdit.jsp?goodId="+good.getGOODID()+" style=\"color:blue;\">编辑</a> <a href=AdminGoodDelete?goodId="+good.getGOODID()+" style=\"color:red;\">删除</a></td>"+
					"</tr>");
		}
		html.append("</tbody></table>");
		// 装载数据
		req.setAttribute("html", html.toString());
		req.getRequestDispatcher("/modules/admin/jsp/AdminGoodManage.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
