// 预处理只需要执行一次
$(function() {
	// 验证码点击切换
	$("#randomcodeImg").click(function(){
		$(this).attr("src","operatorController/getRandomCode.do?id="+ Math.random());
	});
	
	// 表单验证
	$('#fm').validate({
		submitHandler: function(){ //   验证成功后提交个人信息更新信息
			var data = {
					"operatorName":$("#operatorName").val(),
					"password":$("#password").val(),
					"randomCode":$("#randomcodeInput").val()
			};
			var info = $("#login-server-info span");
			console.info(data);
			$.ajax({
				url:"operatorController/Login.do" ,
				type:'post',
				dataType:'text',
				data: data,
				success:function(result){
		            if (result === '1') {
		                window.location.href = "admin/admin.jsp";
		            } else if (result === '3') {
		                info.html("帐号不存在或密码错误");
		            } else if (result === '4') {
		                info.html("帐号禁用");
		            } else if (result === '-3') {
		                info.html("非本系统账号");
		            } else if (result === '2') {
		                info.html("验证码出错");
		                $("#randomCode").attr(
		                            "src",
		                            "operatorController/getRandomCode.do?id="
		                                    + Math.random());
		            } else if (result === '-5') {
		                info.html("帐号未分配使用用户");
		            }
		            else if (result === '-6') {
		                info.html("密码错误");
		            } 
		            else {
		            	info.html("信息出错");
		            }
		        }
			});
		}
	});
});



// 用于登陆
function login(){
	console.info($("#fm").serialize());
	var info = $("#login-server-info span");
	$.ajax({
		url : "operatorController/Login.do",
		type:"post",
		data: $("#fm").serialize(),
		dataType: 'text',
		success : function(result) {
            if (result === '1') {
                window.location.href = "admin/admin.jsp";
            } else if (result === '-1') {
                info.html("帐号不存在");
            } else if (result === '-2') {
                info.html("帐号禁用");
            } else if (result === '-3') {
                info.html("非本系统账号");
            } else if (result === '-4') {
                    
                info.html("验证码出错");
                $("#randomCode").attr(
                            "src",
                            "operatorController/getRandomCode.do?id="
                                    + Math.random());
                
            } else if (result === '-5') {
                info.html("帐号未分配使用用户");
            }
            else if (result === '-6') {
                info.html("密码错误");
            }
        }
	});
	
}