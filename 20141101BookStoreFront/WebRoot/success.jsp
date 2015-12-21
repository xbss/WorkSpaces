<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String html = (String)request.getAttribute("html");
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
  </head>
  
  <body>
  <div style="width:150px;height:150px;position:absolute;top:50%;left:50%;margin-top:-75px;margin-left:-75px;">
  	<img width="150px;" height="150px" src="success.jpg">
  	<h1 align="center">²Ù×÷³É¹¦</h1>
  	<%
  	if(html != null){
  		out.print(html);
  	}
  	 %>
  </div>
  
  </body>
</html>
