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

public class UserLogin extends HttpServlet {
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
		String loginName = req.getParameter("LOGINNAME");
		System.out.println(loginName);
		String passWord = req.getParameter("PASSWORD");
		System.out.println(passWord);
		
		boolean isLoginNameError = true;
		boolean isPassWordError = true;
		
		System.out.println("验证登陆信息");
		// 查询数据库获取用户信息并验证用户登录名和密码
		List<User> userList = userService.getAllUsers();
		// 
		User userFlag=null;
		for (User user : userList) {
			if (loginName.equals(user.getLOGINNAME())) {
				isLoginNameError = false;
				if (passWord.equals(user.getPASSWORD())) {
					isPassWordError = false;
					userFlag = user;
				}
			}
		}
		// 
		if (!isLoginNameError && !isPassWordError) {
			/*userFlag.setLOGINNAME(loginName);
			userFlag.setPASSWORD(passWord);
			userFlag.setNAME("小小镔");
			userFlag.setPHOTO("modules/admin/image/head.jpg");
			System.out.println(userFlag.toString());*/
			// 清除session里面的所有信息
			req.getSession().invalidate();
			req.getSession().setAttribute("User", userFlag);
			String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/"+"BookStore";
			System.out.println("URL:  "+url);
			// 为了避免F5刷新重复提交页面使用response对象跳转
			resp.sendRedirect(url);
			return;
		} else {
			if (isLoginNameError) {
				System.out.println("账户名错误！");
				req.setAttribute("loginNameMessage", "账户不存在");
			}
			if (isPassWordError) {
				System.out.println("密码错误！");
				req.setAttribute("loginPasswordMessage", "密码错误");
			}
			req.getRequestDispatcher("modules/user/jsp/login.jsp").forward(req, resp);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
