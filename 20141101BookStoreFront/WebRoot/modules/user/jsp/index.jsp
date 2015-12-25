<%@page import="org.apache.struts2.components.Else"%>
<%@page import="com.sxb.entity.Good"%>
<%@page import="com.sxb.entity.GoodType"%>
<%@page import="com.sxb.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	User user = (User) session.getAttribute("User");
	if(user == null){
		out.print("<script>alert(\"网页过期请重新登陆\"); window.location.href=\"modules/user/jsp/login.jsp\"; </script>");
	}
	/* User user = new User();
	user.setUSERID("5454");
	user.setNAME("xiaoxiao");
	user.setPHOTO("modules/admin/image/head.jpg"); */
	ArrayList<Good> goodList = (ArrayList<Good>) request
			.getAttribute("goodList");
	/* List<Good> goodList = new ArrayList<Good>();
	for(int i = 0; i< 25; i++){
		Good good1 = new Good();
	good1.setMAINPIC("modules/user/image/good/5.jpg");
	good1.setNAME("人性的弱点");
	good1.setPRICE(5.00);
	goodList.add(good1);
	} */
	ArrayList<GoodType> goodTypeList = (ArrayList<GoodType>) request
			.getAttribute("goodTypeList");
	/* List<GoodType> goodtypelist =new ArrayList<GoodType>();
	for(int i = 0; i< 5; i++){
	GoodType goodType = new GoodType();
	goodType.setGOODTYPEID("4564654");
	goodType.setNAME("人性的弱点");
	goodtypelist.add(goodType);
	} */
	ArrayList<Good> goodQueryList = (ArrayList<Good>) request
			.getAttribute("goodQueryList");
	/* List<Good> goodQueryList = new ArrayList<Good>();
	for (int i = 0; i < 5 ; i++){
	Good good1 = new Good();
	good1.setMAINPIC("modules/user/image/good/5.jpg");
	good1.setNAME("人性的弱点");
	good1.setPRICE(5.00);
	goodQueryList.add(good1);
	} */
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>小小镔实惠书店</title>

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
	href="modules/user/css/index.css">
<link rel="stylesheet" type="text/css" href="index.css">

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
				<form id="head_search" action="IndexQuery" method="post" >
					<!-- <input name="actiontype" value="indexQuery" type="hidden"> -->
					<input id="search_info" type="text" name="goodquery"
						placeholder="书籍搜索">
				</form>
				<div id="head_user">
					<%
						if (user == null) {
					%>
					<a class="login-reigster" href="modules/user/jsp/login.jsp">登陆</a> <a
						class="login-reigster" href="modules/user/jsp/register.jsp">注册</a> <span><img
						id="user_head" alt="P" src="modules/user/image/demohead.png">
					</span>
					<%
						} else {
					%>
					<a id="user"
						href="<%=basePath %>User?userid=<%=user.getUSERID()%>"><%=user.getLOGINNAME()%></a>
					<span><img id="user_head" alt="P" src=FileDownload?type=user&photoPath=<%=user.getPHOTO()%>>
					</span> <span><a id="user" href="UserLogout">退出</a>
					</span>
					<%
						}
					%>
				</div>
			</div>
		</div>
		<!-- 内容 -->
		<div id="main" class="wrap center">
			<!-- 导航窗格 -->
			<div id="navigationBar">
				<div id="">
					<h3>全部分类</h3>
				</div>
				<%
					if (goodTypeList == null || goodTypeList.isEmpty()) {
				%>
				<%
					} else {
						for (int i = 0; i < goodTypeList.size(); i++) {
							GoodType goodType = (GoodType) goodTypeList.get(i);
				%>
				<a id=<%=goodType.getGOODTYPEID()%> class="goodtype"
					href="<%=basePath %>?actionType=goodTypeQuery&goodtypeid=<%=goodType.getGOODTYPEID()%>"><%=goodType.getNAME()%></a>
				<%
					}
					}
				%>
			</div>
			<!-- 信息显示窗格 把商品信息全部显示出来 -->
			<div id="content">
				<table id="goodtable" class="center">
					<%
						if (goodList == null) {
							if (goodQueryList == null)
								out.println("<div align=center><font align=center style="
										+ "\"font-size: 2.3em;font-weight: bold;color: white;width: auto;height:auto;\""
										+ ">没有书书哦~</font><br>"
										+ "<img src=modules/user/image/noinfo.gif  style="
										+ "\"width: 200px;height:200px;\" ></div>");
							else
								//打印查询结果
								for (int i = 0; i < goodQueryList.size(); i++) {
									Good good = goodQueryList.get(i);
									String USERID = "";
									if (user != null)
										USERID = user.getUSERID();
					%>
					<!-- 打印查询结果 -->
					<tr>
						<td>
							<div id="goodQuery" align="left"
								style=" color:black;padding:5px;border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;">
								<div id="goodQuerypicdiv"
									style="width: 200px;height: 200px;overflow: hidden;display: inline-block;">
									<img id="goodQuerypic" alt="小小镔图书" src=FileDownload?type=good&photoPath=<%=good.getMAINPIC()%>
										style="width: auto;height: 200px;">
								</div>
								<div id="goodQuerycontent" style="display: inline-block;">
									<label id="goodQueryname"
										style="color: #0593d3;font-weight: bold;font-size: 2.3em;"><%=good.getNAME()%></label><br>
									<label id="goodQueryAuthor"><%=good.getAUTHOR()%></label><br>
									<label id="goodQueryprice"
										style="color: red;font-weight: bold;font-size: 1.2em;">￥<%=good.getPRICE()%></label><br>
									<form action="GoodBuy" method="post">
										<!-- 购买书时需要的其他信息 -->
										<input type="hidden" name="USERID" value=<%=USERID%>>
										<!-- 判断是否登陆 -->
										<%
											String warring = "";
											if(request.getAttribute("warring") != null){
												warring = (String)request.getAttribute("warring");
												out.print("<script>alert(\"查看商品信息和购买需要用户信息\n" + warring + "\n\"); window.location.href=\"modules/user/jsp/login.jsp\"; </script>");
												}
											if(user == null){
												out.print("<script>alert(\"网页过期请重新登陆\"); window.location.href=\"modules/user/jsp/login.jsp\"; </script>");
											}
										 %>
										<input type="hidden" name="GOODID"
											value=<%=good.getGOODID()%>> <input type="hidden"
											name="PRICE" value=<%=good.getPRICE()%>> <input
											type="hidden" name="STOCK" value=<%=good.getSTOCK()%>>
										<label>购买数量： </label><input type="text" name="goodBuyNumber"
											placeholder="输入你的购书数量"
											onkeyup="this.value=this.value.replace(/\D/g,'')"
											onafterpaste="this.value=this.value.replace(/\D/g,'')">
										<span><label>库存 <%=good.getSTOCK()%></label>
										</span><br>
										<br> <input type="submit"
											value="&nbsp;&nbsp;立即购买&nbsp;&nbsp;"
											style="width:200px;height:auto;color: white;font-weight: bold;font-size: 1.2em;background-color: #0593d3;border:none;">
									</form>
								</div>
								<div class="goodQueryDetail">
									<label>图书简介</label>
									<HR style="FILTER: alpha(opacity=100,finishopacity=0,style=2)"
										width="100%" color=#0593d3 SIZE=10>
									<label>ISBN: <%=good.getISBN()%></label><br> <label>书名:
										<%=good.getNAME()%></label><br> <label>作者: <%=good.getAUTHOR()%></label><br>
									<label>价格: <%=good.getPRICE()%></label><br> <label>类型:
										<%=good.getGOODTYPEID()%></label><br> <label>库存: <%=good.getSTOCK()%></label><br>
									<label>出版社: <%=good.getPUBLISHER()%></label><br> <label
										for="">描述: <textarea readonly="readonly"
											placeholder="没有简介"
											style="
										width: 200px;height: auto;resize:none;text-indent: 15px;border: none;
										border-top-left-radius:0.5em;
										border-bottom-left-radius:0.5em;
										border-top-right-radius:0.5em;
										border-bottom-right-radius:0.5em;
										box-shadow: 0 0 10px rgba(0, 0, 0, 0.4);"><%=good.getDESCRIPTION()%></textarea>
									</label>
								</div>
							</div></td>
					</tr>

					<%
						}
					%>
					<%
						} else {
							int amount = goodList.size();
							int flag = 1;
							for (int i = 0; i < amount; i++) {
								Good good = (Good) goodList.get(i);
								if (flag == 1) {
									out.println("<tr>");
									flag++;
					%>
					<td><a id="good"
						href="GoodDetail?goodid=<%=good.getGOODID()%>">
							<div id="goodpicdiv">
								<img id="goodpic" alt="" src=FileDownload?type=good&photoPath=<%=good.getMAINPIC()%>>
							</div>
							<div id="goodcontent">
								<label id="goodprice">￥<%=good.getPRICE()%></label>
								<div id="goodtitle"><%=good.getNAME()%></div>
							</div> </a></td>
					<%
						} else if (flag == 4) {
					%>
					<td><a id="good"
						href="GoodDetail?goodid=<%=good.getGOODID()%>">
							<div id="goodpicdiv">
								<img id="goodpic" alt="" src=FileDownload?type=good&photoPath=<%=good.getMAINPIC()%>>
							</div>
							<div id="goodcontent">
								<label id="goodprice">￥<%=good.getPRICE()%></label>
								<div id="goodtitle"><%=good.getNAME()%></div>
							</div> </a></td>
					<%
						out.println("</tr>");
									flag = 1;
								} else {
									flag++;
					%>
					<td><a id="good"
						href="GoodDetail?goodid=<%=good.getGOODID()%>">
							<div id="goodpicdiv">
								<%-- <img id="goodpic" alt="" src=<%=good.getMAINPIC()%>> --%>
								<img id="goodpic" alt="" src="FileDownload?type=good&photoPath=<%=good.getMAINPIC()%>">
							</div>
							<div id="goodcontent">
								<label id="goodprice">￥<%=good.getPRICE()%></label>
								<div id="goodtitle"><%=good.getNAME()%></div>
							</div> </a></td>
					<%
						}
					%>
					<%
						}
						}
					%>
				</table>
				<!-- 分页代码 -->
				<!-- <div id="pages">分页</div> -->
			</div>
		</div>
		<!-- 尾部 -->
		<div id="foot">
			<h1>ALL RIGHTS RECEIVED BY 小小镔</h1>
		</div>
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
	<script type="text/javascript" src="modules/user/js/index.js"></script>
	<script type="text/javascript" src="index.js"></script>

</body>
</html>
