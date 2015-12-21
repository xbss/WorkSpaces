package com.sxb.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.sxb.entity.Operator;
import com.sxb.entity.User;
/**
 * 
 * @author 小小镔
 * @Title 作为一个基础过滤器，过滤所有的用户请求。
 */
public class BookStoreFilter implements Filter {

	public BookStoreFilter() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 设置基本信息
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		/*request.setCharacterEncoding("GBK");
		response.setCharacterEncoding("GBK");*/
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		// 打印请求的 URL 到控制台
		urlFilter(httpServletRequest);

		// 只有登陆后才可以访问 /user/ 路径下面的jsp和servlet
		String requestURL = httpServletRequest.getRequestURL().toString();
		String loginPage = "userlogin";
		String registerPage = "userregister";

		// 是否是注册请求
		boolean isRegister = requestURL.contains(registerPage)
				|| requestURL.contains("/modules/user/jsp/userregister");
		// 是否是登陆请求
		boolean isLogin = requestURL.contains("/modules/user/jsp/userlogin")
				|| requestURL.contains(loginPage);
		// 是否是登陆请求管理员
		boolean isManage = requestURL.contains("/modules/admin/jsp/adminlogin") || requestURL.contains("adminlogin");
		// 是否是访问管理员下的目录
		boolean isAdminPages = requestURL.contains("/modules/admin") || requestURL.contains("Admin");
		if (isRegister) {
			System.out.println("请求注册用户");
			httpServletRequest.getRequestDispatcher(
					"modules/user/jsp/register.jsp").forward(
					httpServletRequest, response);
		} else if (isLogin) {
			// 得到user的对象，为空则没有登陆跳转到登陆界面，不为空就是登陆的继续执行
			System.out.println("请求登陆用户：");
			User user = (User) httpServletRequest.getSession().getAttribute(
					"User");
			if (user == null) {
				httpServletRequest.getRequestDispatcher(
						"/modules/user/jsp/login.jsp").forward(
						httpServletRequest, response);
			} else
				chain.doFilter(httpServletRequest, response);
		} else if (isManage) {
			System.out.println("请求登陆管理员");
			Operator operator = (Operator) httpServletRequest.getSession()
					.getAttribute("Operator");
			if (operator == null) {
				System.out.println("管理员为空");
				httpServletRequest.getRequestDispatcher(
						"/modules/admin/jsp/AdminLogin.jsp").forward(
						httpServletRequest, response);
			} else
				chain.doFilter(httpServletRequest, response);
		} /*else if (isAdminPages) {
			System.out.println("正在访问管理员下pages");
			// 判断operator 在session中是否过期，如果过期就跳转到管理员登陆界面
			Operator operator = (Operator) httpServletRequest.getSession().getAttribute("Operator");
			if (operator == null) {
				// 可以打印“ 信息已过期 请重新登陆 ”
				System.out.println("管理员已过期");
				httpServletRequest.getRequestDispatcher("/modules/admin/jsp/AdminLogin.jsp").forward(httpServletRequest, response);
			}else {
				chain.doFilter(httpServletRequest, response);
			}
		}*/
		else {
			chain.doFilter(httpServletRequest, response);
		}

	}

	// 过滤url请求信息
	public void urlFilter(HttpServletRequest request) {
		String[] url = { ".css", ".js", ".jpg", ".png", ".gif", ".jepg" };
		boolean flag = true;
		/*for (String string : url) {
			if (request.getRequestURL().toString().contains(string)) {
				flag = false;
			}
		}*/
		if (flag) {
			System.out.println("请求路径： " + request.getRequestURL().toString());
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
