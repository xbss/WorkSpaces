<!--
作者：邵小镔
作者链接：http://blog.csdn.net/qq1360303452
版本：version 1.0
时间：2016-1
描述信息：基于bootstrap 3 ui界面
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
<title>还车流程</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" />
 <!-- Bootstrap Core CSS -->
<link href="Frame/bootstrap-3.3.5/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="Frame/bootstrap-3.3.5/css/buttons.css" rel="stylesheet" >
<link href="Frame/bootstrap-table-1.9.1/bootstrap-table.min.css"  rel="stylesheet" />
<!-- 字体 -->
<link href="Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 
    
<!-- css -->
<link rel="stylesheet" 
    href="Frame/xbss-message/message.css">
<link href="user/view/top/top.css" rel="stylesheet"  />
<link href="user/view/rentalBack/rentalBack.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="../top/top.jsp" %>

<!-- 矩形块 -->
<div id="rental-page" class="container ">

    <div id="toolbar" class="btn-group">
        <button id="btn_add" class="btn button-primary  button-small " onclick="btn_apply()"><i class="fa fa-cloud-upload"></i> 申请归还</button>
    </div>
    <table id="table" data-click-to-select="true" data-toolbar="#toolbar"></table>
</div>

<!-- 引用js -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="Frame/sweetalert/sweetalert.min.js"></script> 
<script src="Frame/bootstrap-table-1.9.1/bootstrap-table.min.js"></script>
<script
    src="Frame/bootstrap-table-1.9.1/bootstrap-table-zh-CN.min.js"></script>
<!-- js -->
<script src="Frame/xbss-message/message.js"></script> 
<script src="user/view/top/top.js"></script>
<script src="user/view/rentalBack/rentalBack.js"></script>


</body>
</html>