$(document).ready(function() {
	
	// 1.对用户ID赋值
	$("#userId").val($("#hidden-userId").val());
	
	// 2.  加载表格 
	$('#table').bootstrapTable({
		url : 'suggestionController/client_getUserSuggestionWithPage.do',
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
			field : 'suggestionId',
			title : '流水号',
			visible : false
		}, {
			field : 'content',
			title : '',
			visible:false
		}, {
			field : 'state',
			title : '审查状态',
			formatter : getState
		}, {
			field : 'operatorName',
			title : '操作员',
		}, {
			field : 'submitTime',
			title : '提交时间',
			formatter:getHtmlTime
		},
		 {
			field : 'feedBackInfo',
			title : '反馈信息',
			visible:false
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
	
	
	// 2. 进行表单验证 
	$('#client_addASuggestion').validate({
		submitHandler: function(){ // 3.  验证成功后提交个人信息更新信息
			var data = {
					"userId":$("#userId").val(),
					"content":$("#content").val()
			};
			$.ajax({
				url:"suggestionController/client_addASuggestion.do" ,
				type:'post',
				dataType:'text',
				data: data,
				success:function(result){
					if(result === "1"){
						/*提示信息*/
		        		swal({
		        			title : "操作信息",
		        			text : "您的信息已提交，请耐心等待工作人员反馈，感谢您的参与！祝您骑行愉快！",
		        			showConfirmButton : true
		        		});
					} else {
						/*提示信息*/
		        		swal({
		        			title : "操作信息",
		        			text : "您的信息在提交过程中出错，可能是服务器压力过大，请稍后。",
		        			showConfirmButton : true
		        		});
		        	}
					// 清除原有数据
					$('#client_addASuggestion')[0].reset();
					// 关闭弹窗
					$('#modal_addNew').modal('hide');
				}
			});
		}
	});
});

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
		return "已审核";
	} else {
		return "未审核";
	}
}

/**
 * @title 新增条目
 */
function btn_add(){
	// 打开弹窗
	$('#modal_addNew').modal('show');
}

/**
 * @title 查看详情
 */
function btn_check(){
	// 清除原有数据
	$('#form_check')[0].reset();
	// 处理数据
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
	// 填充页面
	$('#form_check div').children('#operatorName').val(rows_check[0].operatorName);
	$('#form_check div').children('#submitTime').val(getHtmlTime(rows_check[0].submitTime));
	$('#form_check div').children('#state').val(getState(rows_check[0].state));
	$('#form_check div').children('#content1').val(rows_check[0].content);
	$('#form_check div').children('#feedBackInfo').val(rows_check[0].feedBackInfo);
	// 打开弹窗
	$('#modal_check').modal('show');
}
