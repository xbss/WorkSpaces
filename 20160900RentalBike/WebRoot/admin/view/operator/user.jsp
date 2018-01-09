<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8" />
<link href="../../../Frame/icon/favicon.ico" rel="shortcut icon">
<title>user gesture</title>

<!-- bootstrap -->
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/bootstrap-theme.min.css" />
<link rel="stylesheet"
	href="../../../Frame/bootstrap-3.3.5/css/buttons.css">
<link rel="stylesheet"
	href="../../../Frame/bootstrap-table-1.9.1/bootstrap-table.min.css" />
<link rel="stylesheet"
	href="../../../Frame/xbss-message/message.css" />
	
<link rel="stylesheet" type="text/css" href="./userINFO.css">

</head>
<body>
	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a href="#" class="navbar-brand">USER INFO</a>
			</div>

			<div id="navbar" class="navbar-collapse collapse">
				<form action="" class="navbar-form navbar-right">
					<div class="form-group">
						<input type="text" name="username" placeholder="UserName"
							class="form-control">
					</div>
					<div class="form-group">
						<input type="password" name="password" placeholder="Password"
							class="form-control">
					</div>
					<button class="btn btn-success">Sign in</button>
				</form>
			</div>
		</div>
	</nav>
	<!-- /.navbar-collapse -->


	<!-- Example row of columns -->
	<div class="container">
		<div id="toolbar">
			<button id="add" class="btn button-primary  button-small " 
				data-toggle="modal"
				data-target="#addUserModal">+ ADD</button>
			<button id="delete" class="btn button-primary  button-small "
				data-toggle="modal"
				data-target="#deleteUserModal">- DELETE</button>
			<button id="delete" class="btn button-primary  button-small " data-toggle="modal"
				onclick="editLoadInfo()"
				data-toggle="modal"
				data-target="#editUserModal">* EDIT</button>
			<button id="delete" class="btn button-primary  button-small " 
				onclick="info('info demo')">* INFO</button>
		</div>

		<table id="table" data-click-to-select="true" data-toolbar="#toolbar">
			<h3>User DataGrid</h3>
			<thead>
				<tr>
					<th data-field="state" data-checkbox="true"></th>
					<th data-field="id">ID</th>
					<th data-field="username">username</th>
					<th data-field="password">password</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div><!-- /.container -->
	<!-- ***************************************************************************************************************************************** -->
	<!-- æ¨¡ææ¡ï¼Modalï¼ æ·»å USER -->
	<div class="modal fade" id="addUserModal" tabindex="-1" role="dialog"
		aria-labelledby="addUserModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="addUserModalLabel">ADD User</h4>
				</div>
				<div class="modal-body">
					<form action="" id="addUserFrom">
						<div class="form-group">
						<input type="text" id="addUserUserName" name="addUserUserName" placeholder="UserName"
							class="form-control">
					</div>
					<div class="form-group">
						<input type="text" id="addUserPassword" name="addUserPassword" placeholder="Password"
							class="form-control">
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn button-primary" data-dismiss="modal">ClOSE
					</button>
					<button type="button" onclick="addUser()" class="btn button-primary">ADD</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ************************************************************************************************************************************** -->
	<!-- æ¨¡ææ¡ï¼Modalï¼ deleteUSER -->
	<div class="modal fade" id="deleteUserModal" tabindex="-1" role="dialog"
		aria-labelledby="deleteUserModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="deleteUserModalLabel">ADD User</h4>
				</div>
				<div class="modal-body">
					<h4>Confirm Delete</h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn button-primary" data-dismiss="modal">ClOSE
					</button>
					<button type="button" onclick="deleteUser()" class="btn button-primary">DELETE</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	<!-- ***************************************************************************************************************************************** -->
	<!-- æ¨¡ææ¡ï¼Modalï¼ editUSER -->
	<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog"
		aria-labelledby="editUserModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="editUserModalLabel">ADD User</h4>
				</div>
				<div class="modal-body">
					
					<form action="" id="editUserFrom">
						<input type="hidden" id="editUserId" name="editUserId" placeholder="ID"
							class="form-control">
						<div class="form-group">
						<input type="text" id="editUserUserName" name="editUserUserName" placeholder="UserName"
							class="form-control">
					</div>
					<div class="form-group">
						<input type="text" id="editUserPassword"  name="editUserPassword" placeholder="Password"
							class="form-control">
					</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn button-primary" data-dismiss="modal">ClOSE
					</button>
					<button type="button" onclick="editUser()" class="btn button-primary">EDIT</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
	

	<script src="../../../Frame/jquery/jquery-2.1.1.min.js"></script>
	<script src="../../../Frame/bootstrap-3.3.5/js/bootstrap.min.js"></script>
	<script src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table.min.js"></script>
	<script
		src="../../../Frame/bootstrap-table-1.9.1/bootstrap-table-zh-CN.min.js"></script>
	<script
		src="../../../Frame/xbss-message/message.js"></script>
	<script src="./user.js"></script>
</body>
</html>