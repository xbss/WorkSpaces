package com.sxb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.service.UserService;

public class User extends HttpServlet {
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
		System.out.println("用户信息: " + req.getParameter("userid"));
		com.sxb.entity.User user = userService.getUsersByCondition("userid", req.getParameter("userid")).get(0);
		req.getRequestDispatcher("modules/user/jsp/userinfo.jsp").forward(req, resp);
		
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
