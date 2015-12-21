package com.sxb.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.entity.Operator;
import com.sxb.entity.User;
import com.sxb.service.OperatorService;

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OperatorService  operatorService = new OperatorService();

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
		List<Operator> operatorList = operatorService.getAllOperators();
		// 
		Operator operatorFlag=null;
		for (Operator operator : operatorList) {
			if (loginName.equals(operator.getLOGINNAME())) {
				isLoginNameError = false;
				if (passWord.equals(operator.getPASSWORD())) {
					isPassWordError = false;
					operatorFlag = operator;
				}
			}
		}
		// 
		if (!isLoginNameError && !isPassWordError) {
			// 清除session里面的所有信息
			req.getSession().invalidate();
			req.getSession().setAttribute("Operator", operatorFlag);
			String url = req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/"+"BookStore" +"/modules/admin/jsp/AdminIndex.jsp";
			System.out.println("URL:  "+url);
			// 为了避免F5刷新重复提交页面使用response对象跳转
			resp.sendRedirect(url);
			return;
		} else {
			if (isLoginNameError) {
				System.out.println("管理员不存在！");
				req.setAttribute("adminLoginNameMessage", "管理员不存在");
			}
			if (isPassWordError) {
				System.out.println("密码错误！");
				req.setAttribute("adminLoginPasswordMessage", "密码错误");
			}
			req.getRequestDispatcher("/modules/admin/jsp/AdminLogin.jsp").forward(req, resp);
		}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
