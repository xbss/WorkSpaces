jQuery(document).ready(function() {
	// 操作员表格初始化
	$('#table').bootstrapTable({
		url : '../../../rbUserController/getWithPage.do',
		pagination : true,
		queryParams :function (params) {
			// 返回的变量名必须和后台controller
			return {
				rows : params.limit, // 页面大小
				page : params.offset, // 页码
				userName : $("#userName").val().trim()
			// 查询参数
			};
		},
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		singleSelect : true,
		showRefresh : true,
		striped : true, // 隔行加亮
		idfield : "id",
		search : false, // 不显示 搜索框
		pageSize : 5,
		pageNumber : 1,
		columns : [ {
			checkbox : true
		}, {
			field : 'userId',
			title : 'ID',
			visible : false
		}, {
			field : 'userName',
			title : '姓名'
		}, {
			field : 'userKind',
			title : '用户类型',
			formatter:getUserKind
		}, {
			field : 'userState',
			title : '用户状态',
			formatter:getState
		}, {
			field : 'mobileNumber',
			title : '手机号'
		} ,{
			field:'email',
			title:'邮箱地址'
		},  {
			field : 'sex',
			title : '性别',
			formatter:getSex
		}, {
			field : 'age',
			title : '年龄'
		}, {
			field : 'lastLoginTime',
			title : '最后登录时间时间',
			formatter:getHtmlTime
		}]
	});
	
});
//绑定搜索事件
$("#userName").keyup(function(event) {
	if (event.keyCode == 13) {
		$.ajax({
			url : '../../../rbUserController/getWithPage.do',
			type : "post",
			data : {
				rows : 5,
				page : 0,
				userName : $("#userName").val().trim()
			},
			dataType : 'json',
			success : function(result) {
				console.info(result);
				$('#table').bootstrapTable('removeAll');
				$('#table').bootstrapTable('load', result);
			}
		});
	}
});

/**
 * 添加方法
 */
function f_add() {
	$.ajax({
		url : '../../../rbUserController/add.do',
		type : "post",
		data : $("#form_add").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result >= 0)
				info(1);
			else
				info(0);
			$('#modal_add').modal('hide');
			$('#form_add')[0].reset();
			window.location.reload();
		}
	});
}
/**
 * 删除
 */
var $ids = [];
function btn_delete() {
	var rows = $('#table').bootstrapTable('getSelections');
	if (rows.length == 0) {
		swal({
			title : "操作信息",
			text : "至少选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
	} else {
		for (var i = 0; i < rows.length; i++) {
			$ids.push(rows[i].operatorCode);
		}
		swal({
			title : "确定删除吗？",
			text : "你将会删除选中的条目",
			type : "warning",
			showCancelButton : true,
			confirmButtonColor : "#DD6B55",
			confirmButtonText : "Ok",
			closeOnConfirm : false
		},
		function() {
			setTimeout(function(){     swal("操作完成");   }, 1000);
			jQuery.ajaxSettings.traditional = true;
			$.ajax({
				url : '../../../rbUserController/deleteEntities.do',
				type : "post",
				data : {ids : $ids},
				dataType : 'json',
				success : function(result) {
					if (result >= 0) info(1); else info(0);
					window.location.reload();
				}
			});
		});
	}
}

/**
 * 修改
 */
function btn_editLoad() {
	var edit_rows = $('#table').bootstrapTable('getSelections');
	if (edit_rows.length == 0) {
		swal({
			title : "操作信息",
			text : "至少选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return ;
	} else if(edit_rows.length > 1){
		swal({
			title : "操作信息",
			text : "只能选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return;
	}
	// modal 装载数据
	//   =v= 柑橘就应该弄个独立的方法来读取，就像easyui中的form.('load', data);
	$('#form_edit div').children('#userName').val(edit_rows[0].userName);
	$('#form_edit').children('#userId').val(edit_rows[0].userId);
	$('#form_edit div').children('#sex').val(edit_rows[0].sex);
	$('#form_edit div').children('#age').val(edit_rows[0].age);
	$('#form_edit div').children('userState').val(edit_rows[0].userState);
	$('#form_edit div').children('mobileNumber').val(edit_rows[0].mobileNumber);
	$('#form_edit div').children('email').val(edit_rows[0].email);
	// modal
	$('#modal_edit').modal('show');
	
}
function btn_editSubmit() {
	$.ajax({
		url : '../../../rbUserController/updatePropByID.do',
		type : "post",
		data : $("#form_edit").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result >= 0)
				info(1);
			else
				info(0);
			$('#modal_edit').modal('hide');
			$('#form_edit')[0].reset();
			window.location.reload();
		}
	});
}


/**
 * @title获得选择的仓库
 */
// 点击按钮加载仓库数据
function btn_selectStorageLoad(){
	
$('#table_selectStorage').bootstrapTable({
	url : '../../../storageController/server_getSelectWithPage.do',
	pagination : true,
	queryParams :function (params) {
		// 返回的变量名必须和后台controller
		return {
			rows : params.limit, // 页面大小
			page : params.offset, // 页码
		};
	},
	sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
	singleSelect : true,
	showRefresh : true,
	striped : true, // 隔行加亮
	idfield : "id",
	search : false, // 不显示 搜索框
	pageSize : 5,
	pageNumber : 1,
	columns : [ {
		checkbox : true
	}, {
		field : 'storageId',
		title : '编码',
		visible : false
	}, {
		field : 'address',
		title : '地址'
	}, {
		field : 'createTime',
		title : '创建时间',
		formatter:getHtmlTime
	}, {
		field : 'operatorName',
		title : '创建人'
	}, {
		field : 'information',
		title : '详情'
	}]
});
}
// 选择仓库页面确认按钮
function btn_selectStorage(){
	// 清除原有数据
	$("#form_add div").children("#storageName").val()
	$("#form_add div").children("#storageId").val()
	$("#form_edit div").children("#storageName").val()
	$("#form_edit div").children("#storageId").val()
	// 处理数据
	var rows_storage = $('#table_selectStorage').bootstrapTable('getSelections');
	if (rows_storage.length == 0) {
		swal({
			title : "操作信息",
			text : "选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return ;
	} else if(rows_storage.length > 1){
		swal({
			title : "操作信息",
			text : "只能选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return;
	}
	// 填充数据
	$("#form_add div").children("#storageName").val(rows_storage[0].address);
	$("#form_add div").children("#storageId").val(rows_storage[0].storageId);
	$("#form_edit div").children("#storageName").val(rows_storage[0].address);
	$("#form_edit div").children("#storageId").val(rows_storage[0].storageId);
	// 关闭选择弹窗
	$('#modal_selectStorage').modal('hide');
}

/**
 * @title 修改密码
 */
function btn_editPasswordLoad(){
	// 清除原有数据
	$("#form_editPassword div").children("#new_password").val();
	$("#form_editPassword div").children("#comPassword").val();
	$("#form_editPassword div").children("#userId").val();
	// 处理数据
	var rows_editPassword = $('#table').bootstrapTable('getSelections');
	if (rows_editPassword.length == 0) {
		swal({
			title : "操作信息",
			text : "选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return ;
	} else if(rows_editPassword.length > 1){
		swal({
			title : "操作信息",
			text : "只能选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return;
	}
	// 填充数据
	$("#form_editPassword div").children("#userId").val(rows_editPassword[0].userId);
	// 打开选择弹窗
	$('#modal_editPassword').modal('show');
}
function btn_editPasswordSubmit(){
	$('#form_editPassword').validate({
		submitHandler: function(){
			$.ajax({
				url : '../../../bikeInfoController/modifyPassword.do',
				type : "post",
				data : $("#form_editPassword").serialize(),
				dataType : 'json',
				success : function(result) {
					if (result >= 0)
						info(1);
					else
						info(0);
					$('#form_editPassword')[0].reset();
					window.location.reload();
					// 关闭选择弹窗
					$('#modal_editPassword').modal('hide');
				}
			});
		}
	});
	
}
/************   转换器 *******************/
//转换时间
function getHtmlTime(value){
	if(value != null && value != '' && value != ''){
		var toDate = new Date(value.time);
		return toDate.toLocaleString();
	}
}
// 转换状态
function getState(value){
	if(value == 1){
		return "启用";
	} else {
		return "禁用";
	}
}
//转换用户类型
function getUserKind(value){
	if(value == 1){
		return "vip";
	} else {
		return "普通";
	}
}
//转换性别
function getSex(value){
	if(value == 1){
		return "女";
	} else {
		return "男";
	}
}