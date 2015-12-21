package com.sxb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *  
 * @author 小小镔
 * @Title 管理员首页的servlet 负责首页的各个请求
 */
public class AdminIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("首页请求");
		// 获取请求类型
		String actionType = req.getParameter("actionType");
		if (actionType.equals("") || actionType == null) {
			req.getRequestDispatcher("/modules/admin/jsp/AdminIndex.jsp").forward(req, resp);
		}
		else if (actionType.equals("Column"))
			// 调用管理栏目请求处理
			processColumn(req, resp);
		else ;
		
	}
	// 处理管理栏目
	public void  processColumn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		// 获取栏目请求id 
		// 0 用户管理 1 商品管理
		String columnId = req.getParameter("ColumnId");
		if (columnId.equals("0")) {
			System.out.println("是用户管理");
			new AdminUserManage().doPost(req, resp);
		} else if (columnId.equals("1")) {
			System.out.println("是商品管理");
			new AdminGoodManage().doPost(req, resp);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
