<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="com.xbss.entity.rbUser.RbUser"%>
<%
/* 用户信息获取 */
String info_userName = "";
String info_userId = "";
if(request.getSession().getAttribute("rbUser") != null){
    info_userName = ((RbUser)request.getSession().getAttribute("rbUser")).getUserName();
    info_userId =  ((RbUser)request.getSession().getAttribute("rbUser")).getUserId();
}
%>
<!-- 针对顶部导航固定化 -->


<!-- 用户登录 -->
<div class="navbar-user">
    <%
    if(request.getSession().getAttribute("rbUser") != null){
    %>
        <a class="login"  href="user/view/person/person.jsp"> <i class="fa fa-user"></i> <%=info_userName %></a>
        <a class="login" onclick="eixtSystem()"> <i class="fa fa-power-off"></i>退出</a>
        <input id="hidden-userName"  type="hidden" value="<%=info_userName%>"/>
         <input id="hidden-userId"  type="hidden" value="<%=info_userId%>"/>
    <%
    } else {
    %>
        <a class="login"  href="admin/login.jsp"> <i class="fa fa-signal"></i> 管理员入口</a>
    <%
    }
    %>
	
</div>

<!-- 导航栏 -->
<div class="navbar navbar-jianshu expanded">
	<div class="navbar-home">
		<a class="active logo" href="user/user.jsp"> 
		  <i class="fa fa-home"></i>
		  <span class="title">首页</span>
		</a>
		<a href="user/view/person/person.jsp">
			<i class="fa fa-user"></i>
			<span class="title">个人信息</span>
		</a>
		<a href="user/view/rental/rental.jsp">
		  <i class="fa fa-bicycle"></i>
			<span class="title">租车</span>
		</a>
	</div>
</div>
