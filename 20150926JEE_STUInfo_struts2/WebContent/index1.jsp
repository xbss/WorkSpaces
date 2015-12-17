<%@page import="com.sxb.entity.Student"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String dataString = "";
	String countString = "";
	List<Student> students = new ArrayList<Student>();
	Student student = new Student();
	
	if(request.getAttribute("data") != null){
		dataString =(String) request.getAttribute("data");
	}
	if(request.getAttribute("count") != null){
		countString = (String) request.getAttribute("count");
	}
	if(request.getAttribute("students") != null){
		students = (List)request.getAttribute("students");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>基于 Struts2 的学生信息查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="index.css">
	
  </head>
  
  <body>
  	<div id="title">JEE 学生信息查询</div>
  	<!-- 查询信息模块 -->
  	<div id="form">
  		<form action="getInfo" method="post">
  			<div id="attrLabel">属性：</div>
  			<select id="attr" name="attr" onchange="attrSelectOnChange()">
  				<option value="sno">学号</option>
  				<option value="sname" selected="selected" >姓名</option>
  				<option value="sage">年龄</option>
  			</select>
  			<select id="isHave" name="isHave">
  				<option value="" selected="selected">请选择属性</option>
  			</select>
  			<input type="text" id="content" name="content" placeholder="请输入需要查询的信息">
  			<input type="submit" id="submit"  value="查询">
  		</form>
  	</div>
  	<!-- 数据表格 -->
  	<div id="data">
  		<table id="datagrid" border="1">
  			<thead>
  				<tr><td>学号</td><td>姓名</td><td>年龄</td></tr>
  			</thead>
  			<tbody>
  				<!-- 打印数据 -->
  				<% 
  				Iterator iterator = students.iterator();
  				while(iterator.hasNext()) { 
  					student = (Student)iterator.next();
  				%>
  						<tr>
  							<td> <%=student.getSno()%></td>
  							<td> <%=student.getSname() %></td>
  							<td> <%=student.getSage() %></td>
  						</tr>
  				<%} %>
  				
  			</tbody>
  			<tfoot>
  				<!-- 打印统计量 -->
  				<tr><td colspan="3">共<%=countString %>人</td></tr>
  			</tfoot>
  		</table>
  	</div>
  	<script type="text/javascript" src="index.js"></script>
  </body>
</html>