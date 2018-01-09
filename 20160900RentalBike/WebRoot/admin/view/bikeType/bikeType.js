jQuery(document).ready(function() {
	// 操作员表格初始化
	$('#table').bootstrapTable({
		url : '../../../bikeTypeController/getWithPage.do',
		pagination : true,
		queryParams :function (params) {
			// 返回的变量名必须和后台controller
			return {
				rows : params.limit, // 页面大小
				page : params.offset, // 页码
				bikeTypeName : $("#bikeTypeName").val().trim()
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
			field : 'bikeTypeId',
			title : 'ID',
			visible : false
		}, {
			field : 'supplierId',
			title : '供应商'
		}, {
			field : 'supplierName',
			title : '供应商名称',
		}, {
			field : 'bikeTypeName',
			title : '车型名称'
		}, {
			field : 'createTime',
			title : '创建时间',
			formatter:getHtmlTime
		} ,{
			field:'price',
			title:'购买价格'
		} ]
	});
	
});
//绑定搜索事件
$("#bikeTypeName").keyup(function(event) {
	if (event.keyCode == 13) {
		$.ajax({
			url : '../../../bikeTypeController/getWithPage.do',
			type : "post",
			data : {
				rows : 5,
				page : 0,
				bikeTypeName : $("#bikeTypeName").val().trim()
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
		url : '../../../bikeTypeController/add.do',
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
				url : '../../../bikeTypeController/deleteEntities.do',
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
	$('#form_edit div').children('#price').val(edit_rows[0].price);
	$('#form_edit').children('#bikeId').val(edit_rows[0].bikeId);
	$('#form_edit div').children('#state').val(edit_rows[0].state);
	$('#form_edit div').children('#rentalState').val(edit_rows[0].rentalState);
	$('#form_edit div').children('#storageId').val(edit_rows[0].storageId);
	$('#form_edit div').children('#bikeTypeId').val(edit_rows[0].bikeTypeId);
	$('#form_edit div').children('#bikeTypeName').val(edit_rows[0].bikeTypeName);
	$('#form_edit div').children('#appearanceInfo').val(edit_rows[0].appearanceInfo);
	// modal
	$('#modal_edit').modal('show');
	
}
function btn_editSubmit() {
	$.ajax({
		url : '../../../bikeTypeController/updatePropByID.do',
		type : "post",
		data : $("#form_edit").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result > 0)
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
 * @title 选择供应商
 */
// 点击按钮加载供应商数据
function btn_selectSupplierLoad(){
	
$('#table_selectSupplier').bootstrapTable({
	url : '../../../supplierController/server_getSelectWithPage.do',
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
		field : 'supplierId',
		title : '编码',
		visible : false
	}, {
		field : 'supplierName',
		title : '供应商'
	}, {
		field : 'introduction',
		title : '车型名称'
	}]
});
}
// 选择供应商页面确认按钮
function btn_selectSupplier(){
	// 清除原有数据
	$("#form_add div").children("#supplierName").val()
	$("#form_add div").children("#supplierId").val()
	
	$("#form_edit div").children("#supplierName").val()
	$("#form_edit div").children("#supplierId").val()
	// 处理数据
	var rows_storage = $('#table_selectSupplier').bootstrapTable('getSelections');
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
	$("#form_add div").children("#supplierName").val(rows_storage[0].address);
	$("#form_add div").children("#supplierId").val(rows_storage[0].storageId);
	$("#form_edit div").children("#supplierName").val(rows_storage[0].address);
	$("#form_edit div").children("#supplierId").val(rows_storage[0].storageId);
	// 关闭选择弹窗
	$('#modal_selectSupplier').modal('hide');
}


/************   转换器 *******************/
//转换时间
function getHtmlTime(value){
	if(value != null && value != '' && value != ''){
		var toDate = new Date(value.time);
		return toDate.toLocaleString();
	}
}