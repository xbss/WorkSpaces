jQuery(document).ready(function() {
	// 操作员表格初始化
	$('#table').bootstrapTable({
		url : '../../../rentalBikeHistoryController/server_getRecordNoCheckWithPage.do',
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
			field : 'rentalId',
			title : '',
			visible:false
		},  {
			field : 'userId',
			title : '',
			visible:false
		},{
			field : 'userId',
			title : '租借人姓名'
		}, {
			field : 'endTime',
			title : '结束时间',
			formatter:getHtmlTime
		}, {
			field : 'bikeId',
			title : '租借车辆编号',
		}, {
			field : 'rentalPrice',
			title : '出租消费'
		}, {
			field : 'rentalTime',
			title : '出租时间'
		}]
	});
	
});
//绑定搜索事件
$("#userName").keyup(function(event) {
	if (event.keyCode == 13) {
		$.ajax({
			url : '../../../rentalBikeHistoryController/server_getRecordNoCheckWithPage.do',
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
 * 车辆结算
 */
function btn_checkLoad() {
	var check_rows = $('#table').bootstrapTable('getSelections');
	if (check_rows.length == 0) {
		swal({
			title : "操作信息",
			text : "至少选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return ;
	} else if(check_rows.length > 1){
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
	$('#form_check div').children('#damage').val(check_rows[0].damage);
	$('#form_check').children('#rentalId').val(check_rows[0].rentalId);
	// modal
	$('#modal_check').modal('show');
	
}
function btn_checkSubmit() {
	$.ajax({
		url : '../../../rentalBikeHistoryController/server_checkABike.do',
		type : "post",
		data : $("#form_check").serialize(),
		dataType : 'json',
		success : function(result) {
			if (result > 0)
				info(1);
			else
				info(0);
			$('#modal_check').modal('hide');
			$('#form_check')[0].reset();
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
//转换状态
function getState(value){
	if(value == 1){
		return "启用";
	} else {
		return "禁用";
	}
}