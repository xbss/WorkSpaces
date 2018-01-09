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
<title>查看/更新用户基础资料</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" />
 <!-- Bootstrap Core CSS -->
<link href="Frame/bootstrap-3.3.5/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="Frame/sweetalert/sweetalert.css" rel="stylesheet" >
<link href="Frame/bootstrap-3.3.5/css/buttons.css" rel="stylesheet" >
<link href="Frame/bootstrap-table-1.9.1/bootstrap-table.min.css"  rel="stylesheet" />
<!-- 用于表单验证 -->
<!-- <link rel="stylesheet" type="text/css" href="Frame/jquery-easyui-theme/default/easyui.css">
    <link rel="stylesheet" type="text/css" href=" rame/jquery-easyui-theme/icon.css">  -->
<!-- 字体 -->
<link href="Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 
    
<!-- css -->
<link href="Frame/xbss-message/message.css" rel="stylesheet" >
<link href="user/view/top/top.css" rel="stylesheet"  />
<link href="user/view/person/person.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="../top/top.jsp" %>

<!-- 矩形块 -->
<div id="rental-page" class="container ">
    <form id="client_updateUserInfo" class="info-group form-horizontal">
        <span class="info-group-title">基本信息</span>
        <!-- 反馈信息 -->
        <div class="fp,r-group">
            <div class="col-sm-12">
                <span id="info-result-message"> </span>
             </div>
        </div>
        <div class="form-group ">
             <label for="userName" class="col-sm-1 control-label input-sm">用户名：</label>
             <div class="col-sm-5">
                   <input  id="userName"   class=" form-control input-sm"  type="text" disabled="disabled"/>
             </div>
              <label for="mobileNumber" class="col-sm-1 control-label input-sm" >手机号：</label>
             <div class="col-sm-5">
                   <input  id="mobileNumber" name="mobileNumber"  class=" form-control input-sm" type="text" required data-rule-mobile="true" data-msg-required="请输入手机号" data-msg-mobile="请输入正确格式"/>
             </div>
         </div>
         <div class="form-group ">
            <label for="email" class="col-sm-1 control-label input-sm">邮箱地址：</label>
            <div class="col-sm-5">
                  <input  id="email" name="email"  class=" form-control input-sm"  type="email" required data-rule-email="true" data-msg-required="请输入email地址" data-msg-email="请输入正确的email地址"/>
            </div>
             <label for="signTime" class="col-sm-1 control-label input-sm">注册时间：</label>
            <div class="col-sm-5">
                  <input  id="signTime"  class=" form-control input-sm" disabled="disabled" type="text"/>
            </div>
        </div>
        <div class="form-group ">
            <label for="sex" class="col-sm-1 control-label input-sm">性别：</label>
            <div class="col-sm-5">
                  <input  id="sex"  class=" form-control input-sm" disabled="disabled" type="text"/>
            </div>
             <label for="age" class="col-sm-1 control-label input-sm" >年龄：</label>
            <div class="col-sm-5">
                  <input  id="age" name="age"  class=" form-control input-sm"  type="text" required data-rule-age="true" data-msg-required="不能为空" data-msg-age="请输入数字"/>
            </div>
        </div>
        <div class="form-group ">
            <label for="userKind" class="col-sm-1 control-label input-sm">用户类型：</label>
            <div class="col-sm-5">
                  <input  id="userKind"   class=" form-control input-sm" type="text"disabled="disabled"/>
            </div>
            <div class="col-sm-6">
               <button  type="submit" class="btn button-primary">提交</button>
            </div>
        </div>
         <!-- 隐藏域 -->
        <input type="hidden"  id="userId" name="userId"/>
    </form>
</div>

<!-- 引用js -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<script src="Frame/sweetalert/sweetalert.min.js"></script> 
<script src="Frame/bootstrap-table-1.9.1/bootstrap-table.min.js"></script>
<script src="Frame/bootstrap-table-1.9.1/bootstrap-table-zh-CN.min.js"></script>
<!-- 表单验证 -->
<script  src="Frame/jquery.validate/jquery.validate.js"></script>

<!-- js -->
<script src="Frame/xbss-message/message.js"></script> 
<script src="user/view/top/top.js"></script>
<script src="user/view/person/person.js"></script>

</body>
</html>