<!--
作者：邵小镔
作者链接：http://blog.csdn.net/qq1360303452
版本：version 1.0
时间：2016-1
描述信息：基于bootstrap 3 ui界面
                加入flat ui 美化

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
<link href="Frame/bootstrap-3.3.5/css/buttons.css" rel="stylesheet" >
<!-- 字体 -->
<link href="Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 
<!-- sweet alert -->
<link href="Frame/sweetalert/sweetalert.css" rel="stylesheet" >
    
<!-- css -->
<link href="user/css/login.css" rel="stylesheet"  />
<link href="user/view/top/top.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="view/top/top.jsp" %>
 
<div id="login-page">
   <div id="login-logo">
    <img src="user/img/bike-blue.png" alt=""/>
  </div>
  <form id="login-form-container">
    <div class="input-box">
        <input type="text" name="userName" id="sign_in_name"  placeholder="手机号码/电子邮件">
        <img id="input-bottom-img" src="user/img/input-bottom.png"  />
   </div>
    <div class="input-box">
        <input type="password" name="password" id="sign_in_password"  placeholder="密码">
        <img id="input-bottom-img" src="user/img/input-bottom.png"  />
   </div>
    <div class="input-box">
        <a  class="login-button" id="loginBtn">
            <span>登 录</span>
        </a>
        <a class="login-button" id="loginByCard">
            <span>刷 卡</span>
        </a >
   </div>
   <div  class="input-box">
    <span id="login-server-info"></span>
   </div>
  </form>
   <div class="login-copy_layout">
      <p>Copyright &copy; 自行车租赁收费系统. All Rights Reserved | Design by <a href="http://blog.csdn.net/qq1360303452" target="_blank">小镔叔叔</a> </p>
   </div>
</div>
   
   
 <!-- 引用js -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="Frame/sweetalert/sweetalert.min.js"></script> 
<!-- js -->
<script src="user/js/login.js"></script>
</body>
</html>
