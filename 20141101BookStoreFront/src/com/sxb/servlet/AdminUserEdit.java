package com.sxb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.entity.User;
import com.sxb.service.UserService;
import com.sxb.tool.IDFactory;

public class AdminUserEdit extends HttpServlet {
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
		// 获取注册的信息
		String USERID = req.getParameter("USERID");
		String LOGINNAME = req.getParameter("LOGINNAME");
		String PASSWORD = req.getParameter("PASSWORD");
		int SEX = 3;
		if (req.getParameter("SEX") == null) {
		} else {
			SEX=Integer.parseInt(req.getParameter("SEX"));
		}

		String BIRTH = req.getParameter("BIRTH");
		String PHONE = req.getParameter("PHONE");
		String NAME = req.getParameter("NAME");
		String ADDRESS = req.getParameter("ADDRESS");
		String MAIL = req.getParameter("MAIL");
		// 验证信息
		boolean isLOGINNAME = existLoginName(LOGINNAME, req, resp);
		boolean isPASSWORD = isPasswordError(PASSWORD, req, resp);
		boolean isSEX = isSexError(SEX, req, resp);
		boolean isBIRTH = isBirthError(BIRTH, req, resp);
		boolean isPHONE = isPhoneError(PHONE, req, resp);
		boolean isNAME = existName(NAME, req, resp);
		boolean isADDRESS = isAddressError(ADDRESS, req, resp);
		boolean isMAIL = isMailError(MAIL, req, resp);
		// 验证信息的后的页面跳转
		if (!isLOGINNAME && !isPASSWORD && !isSEX && !isBIRTH && !isPHONE
				&& !isNAME && !isADDRESS && !isMAIL) {

			User user = new User();
			user.setUSERID(USERID);
			user.setLOGINNAME(LOGINNAME);
			user.setNAME(NAME);
			user.setPASSWORD(PASSWORD);
			user.setSEX(SEX);
			user.setBIRTH(new java.sql.Date(new Date(BIRTH).getTime()).toString());
			user.setPHONE(PHONE);
			user.setEMAIL(MAIL);
			user.setMAIL("");
			user.setADDRESS(ADDRESS);
			user.setTYPE(1);
			user.setPHOTO("modules/admin/image/head.jpg");
			// 调用service方法存入数据库
			int flag = -1;
			 try {
				flag = userService.EditUser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			if (flag > 0) {
				String url = req.getScheme() + "://" + req.getServerName()
						+ ":" + req.getServerPort() + "/" + "BookStore" +"/success.jsp";
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
									"<span id='time' style='background: #00BFFF'>4</span>秒钟后自动跳转，如果不跳转，请点击下面的链接<a href='AdminIndex?actionType=Column&ColumnId=0'>用户管理</a>" +
								"<script type='text/javascript'>" +
									"delayURL('AdminIndex?actionType=Column&ColumnId=0');" +
								"</script>";
				// 加入
				req.setAttribute("html", html);
				// 为了避免F5刷新重复提交页面数据，使用response对象进行跳转
				resp.sendRedirect(url);
			}

		} else {
			// 如果有错的话及回到注册页面
			req.getRequestDispatcher("modules/admin/jsp/AdminUserEdit.jsp").forward(
					req, resp);

		}
	}

	// 验证真实姓名是否存在
	public boolean existName(String NAME, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;

		ArrayList<User> users = userService.getAllUsers();
		for (User user1 : users) {
			if (user1.getNAME().equals(NAME))
				flag = true;
			else
				flag = false;
		}
		return flag;
	}

	// 验证密码格式
	public boolean isPasswordError(String PASSWORD, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (PASSWORD == null || PASSWORD.equals("")) {
			System.out.println("注册信息：密码格式错误");
			req.setAttribute("PasswordMessage", "密码格式错误");
			flag = true;
		}
		return flag;
	}

	// 验证性别格式
	public boolean isSexError(int SEX, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (SEX != 0 && SEX != 1) {
			System.out.println("注册信息：性别格式错误");
			req.setAttribute("SexMessage", "性别格式错误" + SEX);
			flag = true;
		}
		return flag;
	}

	// 验证生日格式
	public boolean isBirthError(String BIRTH, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (BIRTH == null || BIRTH.equals("")) {
			System.out.println("注册信息：生日格式错误");
			req.setAttribute("BirthMessage", "生日格式错误");
			flag = true;
		}
		return flag;
	}

	// 验证电话号码格式
	public boolean isPhoneError(String PHONE, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (PHONE == null || PHONE.equals("")) {
			System.out.println("注册信息：电话号码格式错误");
			req.setAttribute("PhoneMessage", "电话号码格式错误");
			flag = true;
		}
		return flag;
	}

	// 验证地址格式
	public boolean isAddressError(String ADDRESS, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (ADDRESS == null || ADDRESS.equals("")) {
			System.out.println("注册信息：地址格式错误");
			req.setAttribute("AddressMessage", "地址格式错误");
			flag = true;
		}
		return flag;
	}

	// 验证邮政编码格式
	public boolean isMailError(String MAIL, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;
		if (MAIL == null || MAIL.equals("")) {
			System.out.println("注册信息：邮政编码格式错误");
			req.setAttribute("MailMessage", "邮政编码格式错误");
			flag = true;
		}
		return flag;
	}

	// 验证真实姓名
	public boolean existLoginName(String LOGINNAME, HttpServletRequest req,
			HttpServletResponse resp) {
		boolean flag = false;

		ArrayList<User> users = userService.getAllUsers();
		for (User user1 : users) {
			if (user1.getLOGINNAME().equals(LOGINNAME))
				flag = true;
			else
				flag = false;
		}

		return flag;
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
