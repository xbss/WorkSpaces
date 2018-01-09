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
<title>租车流程</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" />
 <!-- Bootstrap Core CSS -->
<link href="Frame/bootstrap-3.3.5/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="Frame/bootstrap-3.3.5/css/buttons.css" rel="stylesheet" >
<link href="Frame/sweetalert/sweetalert.css" rel="stylesheet" >
<link href="Frame/bootstrap-table-1.9.1/bootstrap-table.min.css"  rel="stylesheet" />
<!-- 字体 -->
<link href="Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 
    
<!-- css -->
<link rel="stylesheet" 
    href="Frame/xbss-message/message.css">
<link href="user/view/top/top.css" rel="stylesheet"  />
<link href="user/view/rental/rental.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="../top/top.jsp" %>

<!-- 矩形块 -->
<div id="rental-page" class="container ">
    <form class="info-group form-horizontal">
        <span class="info-group-title">1 基本信息</span>
        <div class="form-group ">
             <label for="info-userName" class="col-sm-1 control-label input-sm">用户：</label>
             <div class="col-sm-5">
                   <input  id="info-userName"  class=" form-control input-sm" readonly="readonly" type="text"/>
             </div>
             
             <div class="col-sm-6">
                <span id="info-result-message">44444</span>
             </div>
         </div>
         <div class="form-group ">
             <label for="info-bikeId" class="col-sm-1 control-label input-sm">自行车编号：</label>
             <div class="col-sm-5">
                   <input  id="info-bikeId"   class=" form-control input-sm" type="text"/>
             </div>
             <div class="col-sm-6">
                <button onclick="form_baseInfo_submit()" type="button" class="btn button-primary">提交</button>
             </div>
         </div>
    </form>
    
    <form id="form-rental" class="info-group form-horizontal">
        <span class="info-group-title">2 租赁信息</span>
        <!-- <input id="price" name="price" type="text" /> -->
        <div class="form-group ">
             <label for="rental-date" class="col-sm-1 control-label input-sm">出租日期：</label>
             <div class="col-sm-5">
                   <input type="text" id="rental-date" name="rental-date" class=" form-control input-sm" readonly="readonly">
             </div>
              
         </div>
         <div class="form-group">
            <label for="rental-time" class="col-sm-1 control-label input-sm">出租时间：</label>
             <div class="col-sm-5">
                   <input type="text" id="rental-time" name="rental-time" readonly="readonly" class=" form-control input-sm">
             </div>
         </div>
         <div class="form-group">
            <label for="rental-price" class="col-sm-1  control-label input-sm" >车价：</label>
            <div class="col-sm-5">
                <input type="text" id="rental-price" name="rental-price"  readonly="readonly" class=" form-control input-sm">
            </div>
            
        </div>
         <div class="form-group">
            <label for="rental-type" class="col-sm-1 control-label input-sm">车辆类型：</label>
             <div class="col-sm-5">
                   <input type="text" id="rental-type" name="rental-type" readonly="readonly" class=" form-control input-sm">
             </div>
            <div class="col-sm-6">
                <button  id="form_rentalInfo_btn" onclick="form_rentalInfo_submit()" type="button" disabled="disabled" class="btn button-primary">提交</button>
             </div>
        </div>
        <!-- 隐藏域 -->
        <input type="hidden" id="bikeId" name="bikeId" />
        <input type="hidden"  id="userId" name="userId"/>
    </form>
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
<script src="user/view/rental/rental.js"></script>


</body>
</html>