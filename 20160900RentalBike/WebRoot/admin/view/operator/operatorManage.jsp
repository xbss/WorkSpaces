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
<link rel="stylesheet"  href="./operatorManage.css">
</head>
<body>
<div class="col-md-12 ">
	<div id="toolbar" class="btn-group">
		<button id="btn_add" class="btn button-primary  button-small " data-toggle="modal" data-target="#modal_add" ><i class="icon-plus"></i> 增加</button>
		<button id="btn_delete" class="btn button-primary  button-small " onclick="btn_delete()"><i class="icon-minus nav_icon"></i> 删除</button>
		<button id="btn_edit" class="btn button-primary  button-small " onclick="btn_editLoad()"><i class="icon-edit "></i> 编辑</button>
		<button id="" class="btn button-primary  button-small "   onclick="btn_editPasswordLoad()"><i class="icon-key "></i> 修改密码</button>
        <div class="search-form">
        <input id="operatorName" type="text" class="search-text" placeholder="输入操作员姓名查询">
        </div>
        
	</div>

	<table id="table" data-click-to-select="true" data-toolbar="#toolbar"></table>
</div><!-- /.container -->
	
<!-- 摸态框弹窗代码 -->
<%@include file="operatorProcess.jsp" %>
<!-- 引用js -->
<script src="../../../Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="../../../Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table.min.js"></script>
<script src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table-zh-CN.min.js"></script>
<!-- 表单验证 -->
<script  src="../../../Frame/jquery.validate/jquery.validate.js"></script>
<script src="../../../Frame/sweetalert/sweetalert.min.js"></script> 
<script src="../../../Frame/xbss-message/message.js"></script> 
<script src="./operatorManage.js"></script>
</body>
</html>