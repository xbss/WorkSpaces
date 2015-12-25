<%@page import="com.sxb.entity.Operator"%>
<%@page import="org.apache.struts2.components.Else"%>
<%@page import="com.sxb.entity.Good"%>
<%@page import="com.sxb.entity.GoodType"%>
<%@page import="com.sxb.entity.User"%>
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
	out.print("<script>alert(\"网页过期请重新登陆\"); window.location.href=\"AdminLogin.jsp\"; </script>");
	}
	/* request.getRequestDispatcher("AdminLogin.jsp").forward(request, response); */
%>
<%
	/* Operator operator = new Operator();
	operator.setLOGINNAME("xiaobin");
	operator.setOPERATORID("454565");
	operator.setPHOTO("modules/admin/image/head.jpg"); */
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
	href="modules/admin/css/AdminIndex.css">
<script type="text/javascript"  src="framework/JQuery/jquery-2.1.1.js"></script>
</head>

<body>
	<div>
		<!-- 头部 -->
		<div id="head">
			<div id="head_content" class="center">
				<div id="head_logo">
					<a href=<%=basePath %>><img src="modules/admin/image/BookStoreLogo.png">
					<font style="vertical-align: middle;line-height: 1.3em;position: relative;top: -15px;">Book Store 前台首页</font></a>
				</div>
				<form id="head_search" action="Index" method="post" >
					<input name ="actiontype" value="indexQuery" type="hidden">
					<input id="search_info" type="text" name="goodquery"placeholder="书籍检索" >
				</form>
				<div id="head_user">
					<%
						if (operator == null) {
					%>
					<a class="login-reigster" href="AdminLogin">登陆</a>
					<span><img id="user_head"
						src="modules/admin/image/head.jpg"> </span>
					<%
						} else {
					%>
					<a id="user" href="#"><%=operator.getNAME() %></a>
					<span><img id="user_head" src=<%=operator.getPHOTO() %>>
					</span>
					<span><a id="user" href="AdminLogout">退出</a>
					</span>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<!-- 内容 -->
		<div id="main" class="center">
			<!-- 导航窗格 -->
			<div id="navigationBar">
				<%if(operator.getPERMISSION() == 0){ %>
				<a class="column" href="AdminIndex?actionType=Column&ColumnId=0&ColumnName=<%out.print("用户管理");%>" target="innerFrame"><%out.print("用户管理");%></a>
				<a class="column" href="AdminIndex?actionType=Column&ColumnId=1&ColumnName=<%out.print("商品管理");%>" target="innerFrame"><%out.print("商品管理");%></a>
				<a class="column" href="AdminIndex?actionType=Column&ColumnId=3&ColumnName=<%out.print("模块管理");%>" target="innerFrame"><%out.print("模块管理");%></a>
				<%}else if(operator.getPERMISSION() == 1){ %>
				<a class="column" href="AdminIndex?actionType=Column&ColumnId=1&ColumnName=<%out.print("商品管理");%>" target="innerFrame"><%out.print("商品管理");%></a>
				<a class="column" href="AdminIndex?actionType=Column&ColumnId=3&ColumnName=<%out.print("模块管理");%>" target="innerFrame"><%out.print("模块管理");%></a>
				<% }%>
			</div>
			<!-- 信息显示窗格 把商品信息全部显示出来 -->
			<!-- <div id="content"> -->
			<div id="content">
			<iframe class="innerFrame" name="innerFrame" frameborder="0" scrolling="auto" style="margin: 0px auto; height: 100%; -ms-overflow-x: hidden;"src="modules/admin/jsp/MyHtml.html">
				<!-- 加载的html -->
			</iframe>
			</div>
		</div>
		<!-- 尾部 -->
		<div id="foot">
			<h1>ALL RIGHTS RECEIVED BY 小小镔</h1>
		</div>
	</div>
	<!-- 加载JS脚本 -->
	<script type="text/javascript" src="modules/admin/js/AdminIndex.js"></script>

</body>
</html>
