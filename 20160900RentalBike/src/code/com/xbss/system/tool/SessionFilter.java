package com.xbss.system.tool;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.xbss.entity.operator.Operator;
/**
 * @author XBSS
 * @title 分为用户登录和管理员登录
 *
 */
public class SessionFilter  implements Filter {
	
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		doFilter(request, response, filterChain);
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
	protected void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// 开发模式下自动注入管理员session
		String isDebug = SystemConfig.getSystemPram("isDebug");
		
		if (isDebug.equals("true")) {
			System.out.println("TIP:当前为开发者模式。自动注入管理员session");
			Operator operator = new Operator();
			operator.setPassword(SystemConfig.getSystemPram("password"));
			operator.setOperatorCode(SystemConfig.getSystemPram("operatorCode"));
			operator.setOperatorName(SystemConfig.getSystemPram("operatorName"));
			request.getSession().setAttribute("operator", operator);
		} else{
			System.out.println("TIP: 当前为系统运营模式。" + isDebug);
		}
		
		// 设置基本信息
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		// 获取请求网址
		String url = request.getRequestURL().toString();  
		// 获取项目名
		String baseObject = request.getContextPath();
		
		// 是否是管理员权限页面
		boolean isAdmin = url.contains(baseObject+"/admin") || url.contains(baseObject+"/admin/index.jsp");
		// 是否是访问用户权限页面
		boolean isUser = url.contains(baseObject+"/user") || !url.endsWith("login.jsp") ;
		
		// 进行判断操作
		if(isAdmin){
			if (request.getSession().getAttribute("operator") == null || request.getSession().getAttribute("operator").equals("")) {
				request.getRequestDispatcher(
						"/admin/login.jsp").forward(
						request, response);
			} else 
				filterChain.doFilter(request, response);  
		} else if (isUser) {
			if (request.getSession().getAttribute("rbUser") == null || request.getSession().getAttribute("rbUser").equals("")) {
				request.getRequestDispatcher(
						"/user/login.jsp").forward(
						request, response);
			} else 
				filterChain.doFilter(request, response);  
		} else
			filterChain.doFilter(request, response);  
	} 
	/**
	 * @throws IOException 
	 * @title 根据处理需求跳转登录页面
	 */
	public void PageProcess(HttpServletRequest request, String userType, HttpServletResponse response) throws IOException {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
		
		// 使用response跳转
         StringBuilder builder = new StringBuilder();  
         builder.append("<script type=\"text/javascript\">");  
         builder.append("window.top.location.href='");  
         if (userType == "user") {
        	builder.append(basePath + "user/login.jsp");  
		} else {
			builder.append(basePath  + "admin/login.jsp");  
		}
         builder.append("';");  
         builder.append("</script>");  
         response.getWriter().print(builder.toString());  
	}
}
