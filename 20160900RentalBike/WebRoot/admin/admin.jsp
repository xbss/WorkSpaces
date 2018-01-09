<!--
作者：邵小镔
作者链接：http://blog.csdn.net/qq1360303452
版本：version 1.0
时间：2016-1
描述信息：基于bootstrap 3 后台管理系统ui界面
                加入flat ui 美化
感谢：感谢魔客吧的支持
-->
<%@page import="com.xbss.entity.operator.Operator"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String title_operatorName = "";
if(request.getSession().getAttribute("operator") != null){
	title_operatorName = ((Operator)request.getSession().getAttribute("operator")).getOperatorName();
}
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
<link rel="stylesheet" href="Frame/bootstrap-3.3.5/css/buttons.css">
<!-- Graph CSS -->
<link href="admin/css/lines.css" rel='stylesheet' type='text/css' />
<!-- 字体 -->
<link href="admin/css/font-awesome.css" rel="stylesheet"> 
<!--  Calender -->
<link href="admin/css/clndr.css" rel="stylesheet"  type="text/css" />
<!-- Map -->
<link href="admin/css/jqvmap.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href='admin/css/roboto.css' rel='stylesheet' type='text/css'> 
<!-- Custom CSS -->
<link href="admin/css/custom.css" rel="stylesheet">

<link href="admin/css/style.css" rel='stylesheet' type='text/css' />

<!-- AddTabs 用于支持bootstrap的创建和关闭操作 -->
<link href="Frame/bootstrap-tabs/bootstrap-addtabs.css" rel="stylesheet"  type="text/css"  />
<!-- table支持 -->
<link href="Frame/bootstrap-table-1.9.1/bootstrap-table.min.css" rel="stylesheet" />
<!-- Admin CSS -->
<link href="admin/css/Admin/Admin.css" rel='stylesheet' type='text/css' />


</head>
<body>
<div id="wrapper">
     <!-- Navigation -->
        <nav class="top1 navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" >RentalBike</a>
            </div>
            <!-- /.navbar-header -->
            <ul class="nav navbar-nav navbar-right">
			    <li class="dropdown">
	        		<a href="#" class="dropdown-toggle avatar" data-toggle="dropdown"><span><%=title_operatorName %></span><i class="fa fa-wrench fa-fw nav_icon"></i><span class="badge"></span></a>
	        		<ul class="dropdown-menu">
						<li class="dropdown-menu-header text-center">
							<strong>通知</strong>
						</li>
						<li class="m_2"><a data-addtab="信息" url="admin/view/suggestion/suggestionManage.jsp"><i class="fa fa-envelope-o"></i> 信息 <span class="label label-success">1</span></a></li>
						<li class="m_2"><a data-addtab="系统配置" url="admin/view/home/systemConfiguration.jsp"><i class="fa fa-wrench"></i> 系统配置</a></li>
						<li class="m_2"><a id="exitSystem"><i class="fa fa-power-off"></i> 退出</a></li>	
	        		</ul>
	      		</li>
			</ul>
            <!-- 搜索框 -->
			<form id="form_wholeSearch" class="navbar-form navbar-right">
              <input id="input_wholeSearch" type="text" class="form-control" value="搜索..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '搜索...';}">
            </form>

            <div class="navbar-default sidebar addtabs-pages-bar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a data-addtab="操作员管理" url="admin/view/operator/operatorManage.jsp"><i class="fa fa-hdd-o fa-fw nav_icon"></i>操作员管理</a>
                        </li>
                        <li>
                            <a data-addtab="用户管理" url="admin/view/rbUser/rbUser.jsp"><i class="fa fa-male fa-fw nav_icon"></i>用户管理</a>
                        </li>
                        <li>
                            <a data-addtab="一卡通/会员管理" url="admin/view/rbCard/rbCard.jsp"><i class="fa fa-credit-card fa-fw nav_icon"></i>*一卡通/会员管理</a>
                        </li>
                        <li>
                            <a data-addtab="仓库管理" url="admin/view/storage/storage.jsp"><i class="fa fa-database fa-fw nav_icon"></i>仓库管理</a>
                        </li>
                        <li>
                            <!--  二级栏目必须加上 href="#" 否则加载首页会出现全部一级项class="active" -->
                            <a href="#"><i class="fa fa-bicycle nav_icon"></i>自行车管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a data-addtab="自行车信息" url="admin/view/bikeInfo/bikeInfo.jsp" href="#">自行车信息</a>
                                </li>
                                <li>
                                    <a data-addtab="自行车类型" url="admin/view/bikeType/bikeType.jsp" href="#">自行车类型</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                        <li>
                            <a ><i class="fa fa-tasks fa-fw nav_icon"></i>采购管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a data-addtab="采购计划" url="admin/view/purchasePlan/purchasePlan.jsp" href="#">*采购计划</a>
                                </li>
                                <li>
                                    <a data-addtab="采购计划批次" url="admin/view/purchasePlanBikeBatch/purchasePlanBikeBatch.jsp" href="#">*采购计划批次</a>
                                </li>
                                <li>
                                    <a data-addtab="供应商" url="admin/view/supplier/supplier.jsp" href="#">*供应商</a>
                                </li>
                            </ul>
                           <!--  /.nav-second-level -->
                        </li>
                        <li>
                            <a ><i class="fa fa-wrench fa-fw nav_icon"></i>维修管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a data-addtab="维修计划" url="admin/view/maintenancePlan/maintenancePlan.jsp" href="#">*维修计划</a>
                                </li>
                                <li>
                                    <a data-addtab="维修记录" url="admin/view/maintenancePlan/maintenancePlan.jsp" href="#">*维修记录</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a ><i class="fa fa-cny fa-fw nav_icon"></i>*资金统计<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a data-addtab="日财务" url="admin/view/dayFinancialSheet/dayFinancialSheet.jsp" href="#">*日财务</a>
                                </li>
                                <li>
                                    <a data-addtab="月财务" url="admin/view/monthFinancialSheet/monthFinancialSheet.jsp" href="#">*月财务</a>
                                </li>
                                <li>
                                    <a data-addtab="年财务" url="admin/view/yearFinancialSheet/yearFinancialSheet.jsp" href="#">*年财务</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a data-addtab="回收管理" url="admin/view/recyclePlan/recyclePlan.jsp"><i class="fa fa-truck fa-fw nav_icon"></i>*回收管理</a>
                        </li>
                        <li>
                            <a data-addtab="赔偿记录" url="admin/view/compensationRecord/compensationRecord.jsp"><i class="fa fa-calculator fa-fw nav_icon"></i>*赔偿记录</a>
                        </li>
                         <li>
                             <a data-addtab="租借记录" url="admin/view/rentalBikeHistory/rentalBikeHistory.jsp" ><i class="fa fa-file fa-fw nav_icon"></i>租借记录</a>
                         </li>
                         <li>
                            <a data-addtab="快捷验车" url="admin/view/fastAcceptanceChecking/fastAcceptanceChecking.jsp"><i class="fa fa-exchange fa-fw nav_icon"></i>快捷验车</a>
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
        <!-- 页面主视图 -->
        <div id="page-wrapper">
        <div class="col-md-12">

            <!-- 可关闭标签页 addtabs:tabs -->
            <div id="addtabs-pages">
                <!-- nav tabs -->
                <ul class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-home fa-fw nav_icon"></i>主页</a></li>
                    <li role="presentation" class=""><a href="#graphPage" aria-controls="home" role="tab" data-toggle="tab"><i class="fa fa-tasks fa-fw nav_icon"></i>报表</a></li>  
                </ul>
                <!-- tab panes -->
                <div class="tab-content" class="scrollbar" >
                    <div role="tabpanel" class="tab-pane active" id="home">
                        <%@include file="view/home/home.jsp" %>
                    </div>
                    <div role="tabpanel" class="tab-pane " id="graphPage">
                        <%@include file="view/graphPage/graphPage.jsp" %>
                    </div>    
                </div>
            </div>

        </div>
       </div>
      <!-- /#page-wrapper -->
   </div>

<!-- /#wrapper -->

<!-- jQuery -->
<script src="Frame/jquery/jquery-2.1.1.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="admin/js/metisMenu.min.js"></script>
<script src="admin/js/custom.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
<!-- AddTabs -->
<script src="Frame/bootstrap-tabs/bootstrap-addtabs.js"></script>

<!----Calender -------->
<script src="admin/js/underscore-min.js" type="text/javascript"></script>
<script src= "admin/js/moment-2.2.1.js" type="text/javascript"></script>
<script src="admin/js/clndr.js" type="text/javascript"></script>
<script src="admin/js/site.js" type="text/javascript"></script>

<!-- graph -->
<script src="admin/js/Chart.js" type="text/javascript"></script>

<!-- develop js -->
<script src="admin/js/Admin/Admin.js"></script>
</body>
</html>
