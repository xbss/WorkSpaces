jQuery(document).ready(function() {
	// 操作员表格初始化
	$('#table').bootstrapTable({
		url : '../../../supplierController/getWithPage.do',
		pagination : true,
		queryParams :function (params) {
			// 返回的变量名必须和后台controller
			return {
				rows : params.limit, // 页面大小
				page : params.offset, // 页码
				supplierName : $("#supplierName").val().trim()
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
			field : 'supplierId',
			title : '供应商'
		}, {
			field : 'supplierName',
			title : '供应商名称',
		}, {
			field : 'introduction',
			title : '供应商简介'
		} ]
	});
	
});
//绑定搜索事件
$("#supplierName").keyup(function(event) {
	if (event.keyCode == 13) {
		$.ajax({
			url : '../../../supplierController/getWithPage.do',
			type : "post",
			data : {
				rows : 5,
				page : 0,
				supplierName : $("#supplierName").val().trim()
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
		url : '../../../supplierController/add.do',
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
				url : '../../../supplierController/deleteEntities.do',
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
	$('#form_edit div').children('#supplierName').val(edit_rows[0].supplierName);
	$('#form_edit').children('#supplierId').val(edit_rows[0].supplierId);
	$('#form_edit div').children('#introduction').val(edit_rows[0].introduction);
	// modal
	$('#modal_edit').modal('show');
	
}
function btn_editSubmit() {
	$.ajax({
		url : '../../../supplierController/updatePropByID.do',
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


/************   转换器 *******************/
//转换时间
function getHtmlTime(value){
	if(value != null && value != '' && value != ''){
		var toDate = new Date(value.time);
		return toDate.toLocaleString();
	}
}