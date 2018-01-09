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
<link href="user/css/user.css" rel="stylesheet"  />
<link href="user/view/top/top.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="view/top/top.jsp" %>

<!-- 矩形导航块 -->
<div id="navar-flag">
    <ul>
    	<li>
    	   <a id="nav-rental" href="user/view/rental/rental.jsp"><i  class="fa fa-bicycle fa-3x"></i><span>租车</span></a>
    	</li>
    	<li>
    	   <a id="nav-reantalHistory" href="user/view/rentalRecord/rentalRecord.jsp"><i  class="fa fa-area-chart fa-3x"></i><span>租借记录</span></a>
    	</li>
    	<li>
    	   <a id="nav-compensationRecord" href="user/view/rentalBack/rentalBack.jsp"><i  class="fa fa-clock-o fa-3x"></i><span>申请还车</span></a>
    	</li>
    	<li>
           <a id="nav-personInfo" href="user/view/person/person.jsp"><i  class="fa fa-user fa-3x"></i><span>个人信息</span></a>
        </li>
        <li>
           <a id="nav-fit" href="user/view/compensationRecord/compensationRecord.jsp"><i  class="fa fa-credit-card fa-2x"></i><span>赔款记录</span></a>
        </li>
        <li>
           <a id="nav-suggestion" href="user/view/suggestion/suggestion.jsp"><i  class="fa fa-thumbs-up fa-3x"></i><span>反馈信息</span></a>
        </li>
    </ul>
</div>

<!-- 引用js -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="Frame/sweetalert/sweetalert.min.js"></script> 
<!-- js -->
<script src="user/view/top/top.js"></script>
<script src="user/js/user.js"></script>


</body>
</html>