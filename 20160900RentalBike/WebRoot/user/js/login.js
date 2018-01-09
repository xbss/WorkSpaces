// 预处理只需要执行一次
$(function() {
    // 提交按钮
    $("#loginBtn").click(function(){
        login();
    });
    // 刷卡按钮
    $("#loginByCard").click(function(){
    	/*提示信息*/
        swal({
            title : "操作信息",
            text : "暂未实现刷卡登录功能",
            showConfirmButton : true
        });
    });
});
// 用于登陆
function login(){
	var info = $("#login-server-info");
    $.ajax({
        url : "rbUserController/Login.do",
        type:"post",
        data: $("#login-form-container").serialize(),
        dataType: 'text',
        success : function(result) {
        	$("#login-server-info").css('display', 'block');
            if (result === '1') {
                window.location.href = "user/user.jsp";
            } else if (result === '3') {
                info.html("账号不存在或者密码错误");
            } else if(result === "4"){
            	info.html("帐号禁用");
            } else if (result === '-5') {
                info.html("帐号未分配使用用户");
            } else if (result === '-6') {
                info.html("密码错误");
            }
        }
    });
}