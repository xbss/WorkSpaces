<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>index</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a {
	color: black;
	text-decoration: none;
	outline:0 none;
}

a:hover {
	color: red;
}

a:visited {
	
}
a:AFTER{
border: none;
}

body {
	width: 100%;
	height: 100%;
}

#box {
	width: 500px;
	height: 300px;
	top: 50%;
	left: 50%;
	margin-left: -250px;
	margin-top: -200px;
	border-color: black;
	position: absolute;
}
</style>
</head>

<body>

	<div align="center" id="box">
		<div
			style="
   										width:50px;height:20px;
   										float: right;right: 5px;position: absolute;top: 5px;border: none;
   										background:#fff;
										border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;
										box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);">
			<a href=<%=basePath%>>首页</a>
		</div>
		<h1>Sorry~小小镔书店没有呢~</h1>
		<img alt="Error" src="modules/user/image/error.png" align="middle" style="margin: 20px;">  
		<div style="width: 60px;height: 60px;border-radius:50%;background: #000;box-shadow: 0 0 40px rgba(0,0,0,0.5);margin-top: 50px">
			<a href="<%=basePath%>" style="width: 100%;height: 100%;border-radius:50%;background: #000;">
				<font
				style="width:100;height:100;line-height:30px;vertical-align:middle;margin-top:30px;
				position: relative;top: 16px;
				font-size: 3em;font-family: serif;font-style: normal;font-weight: bolder;color: white;">
					＜
				</font>
			</a>
		</div>
	</div>

</body>
</html>
