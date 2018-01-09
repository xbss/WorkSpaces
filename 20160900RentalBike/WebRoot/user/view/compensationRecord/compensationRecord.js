var datetime = null;
$(document).ready(function() {
	$('#table').bootstrapTable({
		url : 'compensationRecordController/client_getUserComRecordWithPage.do',
		pagination : true,
		search : true,
		queryParams : queryParams,
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
			field : 'cRId',
			title : '流水号',
			visible : false
		}, {
			field : 'bikeId',
			title : '车辆'
		}, {
			field : 'price',
			title : '金额',
		}, {
			field : 'operatorName',
			title : '操作员',
		}, {
			field : 'cRTime',
			title : '制定时间',
			/*formatter:getHtmlTime*/
		}]
	});

	// 查询方法
	function queryParams(params) {
		// 返回的变量名必须和后台controller
		return {
			rows : params.limit, // 页面大小
			page : params.offset, // 页码
		// 查询参数
		};
	}
});

/**
 * @title 查看详细情况
 */
function btn_check(){
	var rows_check = $('#table').bootstrapTable('getSelections');
	if (rows_check.length == 0) {
		swal({
			title : "操作信息",
			text : "选择一条数据",
			timer : 1000,
			showConfirmButton : false
		});
		return ;
	} else if(rows_check.length > 1){
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
	$.ajax({
		url:'compensationRecordController/client_getUserComRecordById.do',
		type:'post',
		data:{"cRId": rows_check[0].cRId},
		dataType:'text',
		success:function(result){
			if(result != null && result != ""){ // 判断返回结果不为空
				//解析json字符串，
				var data = JSON.parse(result);
				// 清除原有信息
				$('#form_check')[0].reset();
				// 填充页面
				$('#form_check div').children('#bikeId').val(data.bikeId);
				$('#form_check div').children('#rentalId').val(data.rentalId);
				$('#form_check div').children('#price').val(data.price);
				$('#form_check div').children('#reason').val(data.reason);
				$('#form_check div').children('#operatorName').val(data.operatorName);
				$('#form_check div').children('#cRTime').val(getHtmlTime(data.CRTime));
			}
		}
	});
	// 显示modal
	$('#modal_check').modal('show');
}

/**
 * @title 转换时间
 */
//转换时间
function getHtmlTime(value){
	if(value != null && value != '' && value != ''){
		var toDate = new Date(value.time);
		return toDate.toLocaleString();
	}
}