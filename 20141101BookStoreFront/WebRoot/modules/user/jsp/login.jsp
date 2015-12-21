<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String loginNameMessage = (String)request.getAttribute("loginNameMessage");
String loginPasswordMessage = (String)request.getAttribute("loginPasswordMessage");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
	body{
		background: url("modules/user/image/bg.png") repeat;
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
	input{
		width: 100%;
		height: 40px;
		font-size: 1.3em;
		color: black;
		line-height: 15px;
		text-align: center;
		text-indent: 2px;
	}
	</style>
  </head>
  
  <body >
   	<div align="center" style="width:400px;height:300px;
   	position: absolute;top: 50%;left: 50%;margin-left: -150px;margin-top: -200px;border-radius:60px 10px 60px 10px;box-shadow: 2px 2px 2px 2px rgba(0, 0, 0, .6);background: url('modules/user/image/goodbg.png');">
   		
   		<form action="UserLogin" method="post"  style="margin-top:20px;width: 250px;height: auto;">
   			<div style="width:100px;height:100px;font-size: 3.0em;font-style: italic;font-weight: bold;color: #0593d3;">
   				<img style="width:100px;height:100px;border-radius: 50%;" alt="登陆" src="modules/user/image/demohead.png">
   			</div>
   			<div style="
   										width:50px;height:20px;
   										float: right;right: 5px;position: absolute;top: 5px;border: none;
   										background:#fff;
										border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;
										box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);"><a href=<%=basePath %>>首页</a></div>
   			<input name="LOGINNAME" type="text" placeholder="用户名" ><br>
   			<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(loginNameMessage != null) out.println(loginNameMessage); %></font><br>
   			<input name="PASSWORD" type="password" placeholder="密码" ><br>
   			<font style="width:auto;height:auto;color:red;font-weight: bold;font-size: 1.2em;"><%if(loginPasswordMessage != null) out.println(loginPasswordMessage); %></font><br>
   			<input  type="submit" value="登陆" style="border:none;background: #0593d3;color: #fff;font-size: 1.5em;font-weight: bold;"><br>
   		</form>
   	</div>
  </body>
</html>
