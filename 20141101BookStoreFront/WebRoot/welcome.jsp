<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>welocme</title>
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
  <h1>登陆成功</h1>
  <input id="search_info" placeholder="输入信息查询"> <span><input
						type="button" value="GO">
						
						<a id="user" href="#">嗯嗯喔喔</a> <span><img id="user_head"
						src="head.jpg">
  <script language="JavaScript" type="text/javascript">
function delayURL(url) {
var delay = document.getElementById("time").innerHTML;
if(delay > 0) {
delay--;
document.getElementById("time").innerHTML = delay;
} else {
window.top.location.href = url;
}
setTimeout("delayURL('" + url + "')", 1000);
}
</script>
<span id="time" style="background: #00BFFF">3</span>秒钟后自动跳转，如果不跳转，请点击下面的链接<a href="http://www.baidu.com">我的百度</a>
<script type="text/javascript">
delayURL("http://www.baidu.com");
</script>
  </body>
</html>
