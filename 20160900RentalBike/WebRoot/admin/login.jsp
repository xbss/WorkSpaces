<!--
作者：邵小镔
作者链接：http://blog.csdn.net/qq1360303452
版本：version 1.0
时间：2016-1
描述信息：基于bootstrap 3 后台管理系统ui界面
                加入flat ui 美化
感谢：感谢魔客吧的支持
-->
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>"> 
<title>自行车租赁收费系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" />
 <!-- Bootstrap Core CSS -->
<link href="Frame/bootstrap-3.3.5/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<!-- <link href="../css/style.css" rel='stylesheet' type='text/css' /> -->
<link rel="stylesheet" href="admin/css/login/login.css" />
<!----webfonts--->
<link href='admin/css/roboto.css' rel='stylesheet' type='text/css'> 

</head>
<body id="login">
  <div class="login-logo">
  	<!-- <img src="bike.png" alt=""/> -->
    <span id="R">R</span>
    <span id="E">e</span>
    <span id="N">n</span>
    <span id="T">t</span>
    <span id="A">a</span>
    <span id="L">l</span>
    <span id="B">B</span>
    <span id="I">i</span>
    <span id="K">k</span>
    <span id="E">e</span>
  </div>
  <div class="app-cam">
	  <form id="fm">
		<input id="operatorName" name="operatorName"  type="text" placeholder="姓名" onfocus=";" onblur="" required data-msg-required="请输入姓名">
		<input id="password" name="password" type="password" placeholder="密码" onfocus="'';" onblur="" required data-msg-required="请输入密码">
		<div id="randomcode">
		  <input id="randomcodeInput" name="randomcode" type="text"  placeholder="验证码" onfocus=";" onblur="" required >
		  <img id="randomcodeImg" name="randomcodeImg" alt="Random Code"  title="Random Code" src="operatorController/getRandomCode.do?id="+ Math.random()">
		</div>
		<div id="login-server-info">
		  <span ></span>
		</div>
		
		<input id="loginBtn"  type="submit" value="登录"/>
	</form>
  </div>
   <div class="copy_layout login">
      <p>Copyright &copy; 自行车租赁收费系统. All Rights Reserved | Design by <a href="http://blog.csdn.net/qq1360303452" target="_blank">小镔叔叔</a> </p>
   </div>
   
   
 <!-- jQuery -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<!-- 表单验证 -->
<script  src="Frame/jquery.validate/jquery.validate.js"></script>
<!-- js -->
<script src="admin/js/login/login.js" type="text/javascript"></script>
<script>

</script>
</body>
</html>
