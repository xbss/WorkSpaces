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
<title>反馈</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<meta name="keywords" content="" />
<link rel="shortcut icon" href="favicon.ico" />
 <!-- Bootstrap Core CSS -->
<link href="Frame/bootstrap-3.3.5/css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="Frame/bootstrap-3.3.5/css/buttons.css" rel="stylesheet" >
<link href="Frame/sweetalert/sweetalert.css" rel="stylesheet" >
<link href="Frame/bootstrap-table-1.9.1/bootstrap-table.min.css"  rel="stylesheet" />
<!-- 用于表单验证 -->
<!-- <link rel="stylesheet" type="text/css" href="Frame/jquery-easyui-theme/default/easyui.css">
    <link rel="stylesheet" type="text/css" href=" rame/jquery-easyui-theme/icon.css">  -->
<!-- 字体 -->
<link href="Frame/font-awesome/font-awesome.min.css" rel="stylesheet"> 
    
<!-- css -->
<link href="Frame/xbss-message/message.css" rel="stylesheet" >
<link href="user/view/top/top.css" rel="stylesheet"  />
<link href="user/view/suggestion/suggestion.css" rel="stylesheet"  />

</head>
<body>
<!-- 引用固定模块 -->
<%@include file="../top/top.jsp" %>

<!-- 矩形块 -->
<div id="rental-page" class="container ">

    <!-- toolbar -->
    <div id="toolbar" class="btn-group">
        <button id="btn_add" class="btn button-primary  button-small " onclick="btn_add()"><i class="fa fa-cloud-search"></i> 新增</button>
        <button id="btn_check" class="btn button-primary  button-small " onclick="btn_check()"><i class="fa fa-cloud-search"></i> 查看详细</button>
    </div>
    <table id="table" data-click-to-select="true"  data-toolbar="#toolbar"></table>
     <!-- 隐藏域 -->
     <input type="hidden"  id="userId" name="userId"/>
    
    
</div>

<!-- 摸态框-提交新条目 -->
<div class="modal fade" id="modal_addNew" tabindex="-1" role="dialog"
    aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel">新增</h4>
            </div>
            <div class="modal-body">
                <form id="client_addASuggestion" class=" form-horizontal">
			        <!-- 反馈信息 -->
			        <div class="fp,r-group">
			            <div class="col-sm-22">
			                <span id="info-result-message"> </span>
			             </div>
			        </div>
			        <div class="form-group ">
			             <label for="userName" class="col-sm-2 control-label input-sm">内容：</label>
			             <div class="col-sm-9">
			                   <textarea id="content"  class=" form-control input-sm"  rows="10" cols="" required data-msg-required="请输入内容" ></textarea>
			             </div>
			         </div>
			        <div class="form-group ">
			            <div class="col-sm-9"></div>
			            <div class="col-sm-3">
			               <button  type="submit" class="btn button-primary">提交</button>
			            </div>
			        </div>
			    </form>
            </div>
           <!--  <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
            </div> -->
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
</div>
<!-- 摸态框-查看详细 -->
<div class="modal fade" id="modal_check" tabindex="-1" role="dialog"
    aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalLabel">查看</h4>
            </div>
            <div class="modal-body">
                <form action="" id="form_check" class="form-horizontal">
                    <div class="form-group ">
                        <label for="operatorName" class="col-sm-2 control-label input-sm">工作人员：</label>
                        <div class="col-sm-4">
                              <input  id="operatorName"   class=" form-control input-sm" type="text" disabled="disabled"/>
                        </div>
                        <label for="submitTime" class="col-sm-2 control-label input-sm">提交时间：</label>
                        <div class="col-sm-4">
                              <input  id="submitTime"   class=" form-control input-sm" type="text" disabled="disabled"/>
                        </div>
                    </div>
                    <div class="form-group ">
                        <label for="state" class="col-sm-2 control-label input-sm">审查状态：</label>
                        <div class="col-sm-4">
                              <input  id="state"   class=" form-control input-sm" type="text" disabled="disabled"/>
                        </div>
                   </div>
                    <div class="form-group ">
                        <label for="content1" class="col-sm-2 control-label input-sm">意见/建议：</label>
                        <div class="col-sm-4">
                              <textarea  id="content1"   class=" form-control input-sm"  rows="5" cols=""   readonly="readonly" ></textarea>
                        </div>
                         <label for="feedBackInfo" class="col-sm-2 control-label input-sm">反馈信息：</label>
                        <div class="col-sm-4">
                              <textarea id="feedBackInfo"   class=" form-control input-sm"  rows="5" cols=""  readonly="readonly"></textarea>
                        </div>
                      </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn button-primary"
                    data-dismiss="modal">关闭</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal -->
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
<script src="user/view/suggestion/suggestion.js"></script>

</body>
</html>