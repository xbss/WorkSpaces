<%@page import="com.sxb.entity.Operator"%>
<%@page import="org.apache.struts2.components.Else"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	// 获取管理员
	Operator operator = (Operator) request.getSession().getAttribute("Operator");
	if(operator == null){
	operator = new Operator();
	operator.setPERMISSION(0);
	/* out.print("<script>alert(\"网页过期请重新登陆\"); window.location.href=\"modules/admin/jsp/AdminLogin.jsp\"; </script>"); */
	out.print("<script   language=javascript>parent.location.replace(parent.location.href);  </script>");
	}
	/* request.getRequestDispatcher("AdminLogin.jsp").forward(request, response); */
%>
<%
	// 获取传入的html字符串
	String html = "";
	if(request.getAttribute("html") != null)
		html = (String)request.getAttribute("html");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>小小镔实惠书店后台管理</title>

<!-- 禁止用户缩放界面大小 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 加载CSS -->
<link rel="stylesheet" type="text/css"
	href="modules/admin/css/AdminUserManage.css">
<script type="text/javascript"  src="framework/JQuery/jquery-2.1.1.js"></script>
</head>

<body>
	<%if(html.equals("") || html == null)
			request.getRequestDispatcher("failed.jsp").forward(request, response);
		else
			out.print(html);
	 %>
	<!-- 加载JS脚本 -->
	<!-- <script type="text/javascript" src="modules/admin/js/AdminIndex.js"></script> -->

</body>
</html>
