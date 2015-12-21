<%@page import="org.apache.struts2.components.Else"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.sxb.entity.User"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	User user =null;
	if(session.getAttribute("User") != null){
		user =(User) session.getAttribute("User");
	} else {
		out.print("<script>alert(\"网页过期请重新登陆\"); window.location.href=\"modules/user/jsp/login.jsp\"; </script>");
	}
%>
<%
/* 读取的user的信息 ，如果修改不成功就使用这个填充*/
String USERID = user.getUSERID();
String LOGINNAME = user.getLOGINNAME();
String PASSWORD = user.getPASSWORD();
int SEX = user.getSEX();
String BIRTH = user.getBIRTH();
String PHONE = user.getPHONE();
String NAME = user.getNAME();
String ADDRESS =user.getADDRESS();
String MAIL = user.getMAIL();

/* 输入信息的提示信息 */
String LoginNameMessage = (String)request.getAttribute("LoginNameMessage");
String PasswordMessage = (String)request.getAttribute("PasswordMessage");
String SexMessage = (String)request.getAttribute("SexMessage");
String BirthMessage = (String)request.getAttribute("BirthMessage");
String PhoneMessage = (String)request.getAttribute("PhoneMessage");
String NameMessage = (String)request.getAttribute("NameMessage");
String AddressMessage = (String)request.getAttribute("AddressMessage");
String MailMessage = (String)request.getAttribute("MailMessage");

/*  */
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户信息</title>

<!-- 禁止用户缩放界面大小 -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!-- 加载CSS -->
<link rel="stylesheet" type="text/css"
	href="modules/user/css/userinfo.css">

</head>

<body>
	<div>
		<!-- 头部 -->
		<div id="head">
			<div id="head_content" class="center">
				<div id="head_logo">
					<a href=<%=basePath%>><img
						src="modules/user/image/frontlogo.png">
					</a>
				</div>
				<form id="head_search" method="post"  action="IndexQuery">
					<!-- <input name="actiontype" value="indexQuery" type="hidden"> -->
					<input id="search_info" type="text" name="goodquery"
						placeholder="书籍搜索">
				</form>
				<div id="head_user">
					<%
						if (user == null) {
					%>
					<a class="login-reigster" href="login">登陆</a> <a
						class="login-reigster" href="register">注册</a> <span><img
						id="user_head" alt="P" src="modules/user/image/demohead.png">
					</span>
					<%
						} else {
					%>
					<a id="user"
						href="/User?userid=<%=user.getUSERID()%>"><%=user.getLOGINNAME()%></a>
					<span><img id="user_head" alt="P" src=<%=user.getPHOTO()%>>
					</span> <span><a id="user" href="UserLogout">退出</a>
					</span>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<!-- 内容 -->
			<!-- 用户信息 -->
			<div align="left" style="width:600px;height:500px;z-index:500;
   	position: absolute;top: 50%;left: 50%;margin-left: -300px;margin-top: -250px;border-radius:60px 10px 60px 10px;box-shadow: 2px 2px 2px 2px rgba(0, 0, 0, .6);background: url('modules/user/image/goodbg.png');">
   		
   		<form style="margin-top:10px;width: 100%;height: auto;">
   			<div style="width:100px;height:100px;font-size: 3.0em;font-style: italic;font-weight: bold;color: #0593d3;margin-left: 20px;">
   				<img style="width:100px;height:100px;border-radius: 50%;" alt="注册" src="modules/user/image/demohead.png">
   			</div>
   			<div align=center style="
   										width:50px;height:20px;
   										float: right;right: 5px;position: absolute;top: 5px;border: none;
   										background:#fff;
   										color:black;
										border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;
										box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);"><a href=<%=basePath %>>首页</a></div>
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
				<input name="BIRTH" type="text"  value="<%if(BIRTH != null) out.println(BIRTH); %>" placeholder="example:1999/1/1" pattern="^((((1[6-9]|[2-9]\d)\d{2})/(0?[13578]|1[02])/(0?[1-9]|[12]\d|3[01]))|(((1[6-9]|[2-9]\d)\d{2})/(0?[13456789]|1[012])/(0?[1-9]|[12]\d|30))|(((1[6-9]|[2-9]\d)\d{2})/0?2/(0?[1-9]|1\d|2[0-8]))|(((1[6-9]|[2-9]\d)(0[48]|[2468][048]|[13579][26])|((16|[2468][048]|[3579][26])00))/0?2/29-))$" class="input">
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
   				<input name="USERID" type="hidden" value=<%if(USERID != null) out.println(USERID); %>> 

   			<input  type="submit" value="提交修改" style="width:49%;border:none;background: #0593d3;color: #fff;font-size: 1.5em;font-weight: bold;text-align: center;margin-top:30px">
   			<input  type="reset" value="重置信息" style="width:49%;border:none;background: #0593d3;color: #fff;font-size: 1.5em;font-weight: bold;text-align: center;margin-top:30px"><br>
   		</form>
   	</div>
		</div>
		<!-- 尾部 -->
		<div id="foot">
			<h1>ALL RIGHTS RECEIVED BY 小小镔</h1>
		</div>
	<!-- 联系我们 -->
	<div style="width: auto; position: fixed; left: 5%;z-index: 1200;top:50%">
		<a href="http://xiaobinshushu.lofter.com"
			style="display: block;
			width: 100px;
			height: 80px;
			/* background: url('http://img.ithome.com/images/v2.1/166x199_xzs.gif') no-repeatscroll 20% 0% transparent; */
			background: url('modules/user/image/noinfo.gif') no-repeat scroll 0% 0% transparent;">
		</a>
	</div>
	<!-- 分享 -->
	
<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"7","bdPos":"left","bdTop":"50"},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
	<!-- 加载JS脚本 -->
	<script type="text/javascript" src="modules/user/js/userinfo.js"></script>

</body>
</html>
