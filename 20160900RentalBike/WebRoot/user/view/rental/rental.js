// 全局变量
var result_message = $("#login-server-message");
var userId = $("#hidden-userId").val();
var userName = $("#hidden-userName").val();
var rental_bikeId = $("#bikeId");
var rental_date = $("#rental-date");
var rental_time = $("#rental-time");
var rental_price = $("#rental-price");
var rental_type = $("#rental-type");
var form_rentalInfo_btn = $("#form_rentalInfo_btn");


$(function() {
	/*对用户ID赋值*/
	$("#userId").val($("#hidden-userId").val());
	$("#info-userName").val($("#hidden-userName").val());
});
// 提交车辆查询信息
function form_baseInfo_submit(){
	console.info($("#info-bikeId").val());
	 $.ajax({
	        url:"rentalBikeHistoryController/getRentalBikeInfo.do",
	        type:"post",
	        data: {"bikeId": $("#info-bikeId").val()},
	        dataType: 'text',
	        success : function(result) {
	        	console.info(result);
	        	var data = JSON.parse(result);
	        	
	        	if(data.resultInfo == "1"){
	        		
	        		/*设置基本信息*/
	        		rental_price.val(data.bikeInfo.price);
	        		rental_type.val(data.bikeInfo.bikeTypeName);
	        		var now_date = new Date();
	        		rental_date.val(now_date.getFullYear() + "/" + (now_date.getMonth()+1) + "/" + now_date.getDate() );
	        		rental_time.val( (now_date.getHours()+1) + ":" + now_date.getMinutes() );
	        		rental_bikeId.val($("#info-bikeId").val());
	        		/*按钮启用*/
	        		form_rentalInfo_btn.removeAttr('disabled', "");
	        		/*提示信息*/
	        		result_message.css('display', 'none');
	        	} else {
	        		/*按钮启用*/
	        		form_rentalInfo_btn.attr('disabled', 'disabled');
	        		/*提示信息*/
	        		result_message.html("车辆信息错误，请检查");
	        		result_message.css('display', 'block');
	        	}
	        }
	 });
}

// 提交租车信息
function form_rentalInfo_submit(){
	var data = {
			"userId":userId,
			"bikeId":rental_bikeId.val()
	};
	$.ajax({
		url:"rentalBikeHistoryController/rentalABike.do" ,
		type:'post',
		dataType:'text',
		data: data,
		success:function(result){
			if(result === "1"){
				info(1);
				$("#form-rental")[0].reset();
			} else {
				info(0);
			}
		}
	});
}