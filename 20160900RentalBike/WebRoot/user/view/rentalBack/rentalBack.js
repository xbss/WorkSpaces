jQuery(document).ready(function() {
	$('#table').bootstrapTable({
		url : 'rentalBikeHistoryController/getRecordNoBackIWithPage.do',
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
			field : 'rentalId',
			title : '',
			visible : false
		}, {
			field : 'bikeId',
			title : '车辆'
		}, {
			field : 'startTime',
			title : '开始时间',
			formatter:getHtmlTime
		}, {
			field : 'endTime',
			title : '结束时间',
			formatter:getHtmlTime
		}, {
			field : 'rentalTime',
			title : '租借时间'
		} ,{
			field : 'rentalPrice',
			title : "费用"
		}, {
			field:'damage',
			title:'损坏',
			formatter:getHtmlDamage
		}]
	});

// 查询方法
function queryParams(params) {
	// 返回的变量名必须和后台controller
	return {
		rows : params.limit, // 页面大小
		page : params.offset, // 页码
		userId : $("#hidden-userId").val()
	// 查询参数
	};
}
// 转换时间
function getHtmlTime(value){
	if(value != null && value != '' && value != ''){
		var toDate = new Date(value.time);
		return toDate.toLocaleString();
	}
}
// 转换损坏
function getHtmlDamage(value, row, index){
	if(value != null && value == 0 && value != ''){
		return "否";
	} else if(value != null && value == 1){
		return "是";
	} else {
		return "";
	}
}
});

//申请归还按钮事件
function btn_apply(){
	var data = $('#table').bootstrapTable('getSelections');
	var bikeId = "";
	var rentalId = "";
	if(data != null && data.length != 0){
		bikeId = data[0].bikeId;
		rentalId = data[0].rentalId;
		$.ajax({
			url: 'rentalBikeHistoryController/backABike.do',
			type:'post',
			dataType:'text',
			data:{'bikeId':bikeId, 'rentalId':rentalId ,'userId':$("#hidden-userId").val()},
			success:function(result){
				if (result >= 0)
					info(1);
				else
					info(0);
				// 完成后刷新当前页
				window.location.reload();
			}
		});
	} else {
		info(0);
		return false;
	}
}