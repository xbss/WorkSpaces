<%@page import="com.sxb.entity.User"%>
<%@page import="com.sxb.service.UserService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
/* 保留的表单信息 */
String LOGINNAME = (String)request.getParameter("LOGINNAME");
String PASSWORD = (String)request.getParameter("PASSWORD");
int SEX = 3;
if(request.getParameter("SEX") != null){
	SEX = Integer.parseInt(request.getParameter("SEX"));
	}
String BIRTH = (String)request.getParameter("BIRTH");
String PHONE = (String)request.getParameter("PHONE");
String NAME = (String)request.getParameter("NAME");
String ADDRESS = (String)request.getParameter("ADDRESS");
String MAIL = (String)request.getParameter("MAIL");
if(request.getParameter("userId") != null){
UserService userService = new UserService();
User object = userService.getUsersByCondition("userid", request.getParameter("userId")).get(0);
 LOGINNAME = object.getLOGINNAME();
 PASSWORD = object.getPASSWORD();
 SEX = object.getSEX();
 BIRTH = object.getBIRTH();
 PHONE = object.getPHONE();
 NAME = object.getNAME();
 ADDRESS = object.getADDRESS();
 MAIL = object.getMAIL();
}
/* 输入信息的提示信息 */
String LoginNameMessage = (String)request.getAttribute("LoginNameMessage");
String PasswordMessage = (String)request.getAttribute("PasswordMessage");
String SexMessage = (String)request.getAttribute("SexMessage");
String BirthMessage = (String)request.getAttribute("BirthMessage");
String PhoneMessage = (String)request.getAttribute("PhoneMessage");
String NameMessage = (String)request.getAttribute("NameMessage");
String AddressMessage = (String)request.getAttribute("AddressMessage");
String MailMessage = (String)request.getAttribute("MailMessage");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>增加商品</title>

<!-- 禁止用户缩放界面大小 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 加载CSS -->
<!-- <link rel="stylesheet" type="text/css"
	href="modules/admin/css/AdminIndex.css"> -->
<script type="text/javascript"  src="framework/JQuery/jquery-2.1.1.js"></script>
</head>
<style type="text/css">
	body{
		/* background: url("modules/user/image/bg.png") repeat; */
	}
	a{
		color: black;
		text-decoration: none;
	}
	a:hover {
		color: red;
	}
	a:visited{
    	 
	}
	.labeltitle{
		width: 20%;
		height: 30px;
		font-size: 1.3em;
		font-weight:bold;
		color: black;
	/* 	line-height: 15px; */
		text-align: left;
		text-indent: 2px;
		margin-top: 0px;
		margin-left:20px;
		display: inline-block;
	}
	.input{
		width: 30%;
		height: 30px;
		font-size: 1.3em;
		color: black;
		line-height: 15px;
		text-align: left;
		text-indent: 2px;
		margin-top: 5px;
		display: inline-block;
	}
	</style>
  </head>
  
  <body >
   	<div align="left" style="width:600px;;height:100%;">
   		<form action="AdminUserEdit" method="post" style="margin-top:10px;width: 100%;height: auto;">
   			<div style="width:100px;height:100px;font-size: 3.0em;font-style: italic;font-weight: bold;color: #0593d3;margin-left: 20px;">
   				<img style="width:100px;height:100px;border-radius: 50%;" alt="上传头像" src="modules/user/image/demohead.png">
   			</div>
   			<div align=center onclick="userEditBack()" style="
   										width:50px;height:20px;
   										float: right;right: 5px;position: absolute;top: 5px;border: none;
   										background:#fff;
										border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;
										box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);">返回</div>
				<div class="labeltitle" >用户名：</div>
				<input name="LOGINNAME" type="text"   class="input" maxlength="18" value="<%if(LOGINNAME != null) out.println(LOGINNAME); %>">
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(LoginNameMessage != null) out.println(LoginNameMessage); %></font><br>
				<div class="labeltitle" >密码：</div>
				<input name="PASSWORD" type="password" class="input" maxlength="6"  value="<%if(PASSWORD != null) out.println(PASSWORD); %>">
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(PasswordMessage != null) out.println(PasswordMessage); %></font><br>
				
				<div class="labeltitle" >性别：</div>
				<input name="SEX" value="0" type="radio"  width="10px" height="30px">男<span><input name="SEX" value="1" type="radio" width="10px" height="30px">女</span>
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(SexMessage != null) out.println(SexMessage); %></font><br>
				
				<div class="labeltitle" >生日：</div>
				<input name="BIRTH" type="text"  value="<%if(BIRTH != null) out.println(BIRTH); %>" placeholder="example:1998-5-6" pattern="^((((1[6-9]|[2-9]\d)\d{2})-(0?[13578]|1[02])-(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})-(0?[13456789]|1[012])-(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})-0?2-(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))-0?2-29-))$" class="input">
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(BirthMessage != null) out.println(BirthMessage); %></font><br>
				<div class="labeltitle" >电话：</div>
				<input name="PHONE" type="text" class="input"  value="<%if(PHONE != null) out.println(PHONE); %>">
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(PhoneMessage != null) out.println(PhoneMessage); %></font><br>
				<div class="labeltitle" >真实姓名：</div>
				<input name="NAME" type="text"  class="input" value="<%if(NAME != null) out.println(NAME); %>">
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(NameMessage != null) out.println(NameMessage); %></font><br>
				<div class="labeltitle" >住址：</div>
				<input name="ADDRESS" type="text" class="input" value='<%if(ADDRESS != null) out.println(ADDRESS); %>'>
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(AddressMessage != null) out.println(AddressMessage); %></font><br>
				<div class="labeltitle" >邮政编码：</div>
				<input name="MAIL" type="text" class="input" value='<%if(MAIL != null) out.println(MAIL); %>'>
   				<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(MailMessage != null) out.println(MailMessage); %></font><br>

   			<input  type="submit" value="提交信息" style="width:49%;border:none;background: #0593d3;color: #fff;font-size: 1.5em;font-weight: bold;text-align: center;margin-top:30px">
   			<input  type="reset" value="重置信息" style="width:49%;border:none;background: #0593d3;color: #fff;font-size: 1.5em;font-weight: bold;text-align: center;margin-top:30px"><br>
   		</form>
   	</div>
  </body>
	
	<!-- <!-- 加载JS脚本 -->
	<script type="text/javascript" src="modules/admin/js/AdminUserManage.js"></script> -->
</html>
