<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<!-- bootstrap -->
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/bootstrap-theme.min.css" />
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/buttons.css">
<link rel="stylesheet"
	href="../../../Frame/bootstrap-table-1.9.1/bootstrap-table.min.css" />
<link rel="stylesheet" 
	href="../../../Frame/sweetalert/sweetalert.css">
<!-- 字体 -->
<link href="../../../Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 

<link rel="stylesheet" 
    href="../../../Frame/xbss-message/message.css">
<link rel="stylesheet"  href="./fastAcceptanceChecking.css">
</head>
<body>
<div class="col-md-12 ">
	<div id="toolbar" class="btn-group">
		<button id="btn_check" class="btn button-primary  button-small " onclick="btn_checkLoad()"><i class="icon-edit "></i> 结算</button>
        <div class="search-form">
        <input id="userName" type="text" class="search-text" placeholder="输入地址查询">
        </div>
        
	</div>

	<table id="table" data-click-to-select="true" data-toolbar="#toolbar"></table>
</div><!-- /.container -->
	
<!-- 摸态框弹窗代码 -->
<%@include file="fastAcceptanceCheckingProcess.jsp" %>
<!-- 引用js -->
<script src="../../../Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="../../../Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table.min.js"></script>
<script src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table-zh-CN.min.js"></script>
<!-- 表单验证 -->
<script  src="../../../Frame/jquery.validate/jquery.validate.js"></script>
<script src="../../../Frame/sweetalert/sweetalert.min.js"></script> 
<script src="../../../Frame/xbss-message/message.js"></script> 
<script src="./fastAcceptanceChecking.js"></script>
</body>
</html>