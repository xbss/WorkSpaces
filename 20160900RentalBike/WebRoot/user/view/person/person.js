// 全局变量
var result_message = $("#info-result-message");   // 对服务器反馈信息显示
var mobileNumber = $("#mobileNumber");
var email = $("#email");
var signTime = $("#signTime");
var sex = $("#sex");
var age = $("#age");
var userKind = $("#userKind");

$(document).ready(function() {
	// 1.对用户ID和用户名赋值
	$("#userId").val($("#hidden-userId").val());
	$("#userName").val($("#hidden-userName").val());
	
	//2. 加载个人信息到页面中
	$.ajax({
		url:'rbUserController/client_getUserById.do',
		type:'post',
		data:{"userId": $("#userId").val()},
		dataType:'text',
		success:function(result){
			if(result != null && result != ""){ // 判断返回结果不为空
				//解析json字符串，填充页面
				var data = JSON.parse(result);
				mobileNumber.val(data.mobileNumber);
				email.val(data.email);
				signTime.val(getHtmlTime( data.signTime)  );
				sex.val(data.sex > 0 ? "男" : "女");
				age.val(data.age);
				userKind.val(data.userKind > 0 ? "会员" : "普通用户");
			}
		}
	});
	
	
	
	// 3. 进行表单验证 
	$('#client_updateUserInfo').validate({
		submitHandler: function(){ // 4.  验证成功后提交个人信息更新信息
			var data = {
					"userId":$("#userId").val(),
					"mobileNumber":mobileNumber.val(),
					"email":email.val(),
					"age":age.val()
			};
			$.ajax({
				url:"rbUserController/client_updateUserInfo.do" ,
				type:'post',
				dataType:'text',
				data: data,
				success:function(result){
					if(result === "1"){
						info(1);
						/*$("#client_updateUserInfo")[0].reset();*/   // 重置表单 废弃
						result_message.css('display', 'none');
					} else {
						info(0);
						if(result === "2"){
							/*提示信息*/
			        		result_message.html("信息错误请核对后再提交");
			        		result_message.css('display', 'block');
						}
					}
				}
			});
		}
	});
	
	//转换时间
	function getHtmlTime(value){
		if(value != null && value != '' && value != ''){
			var toDate = new Date(value.time);
			return toDate.toLocaleString();
		}
	}
});