function eixtSystem(){
	 $.ajax({
	        url : "rbUserController/Exit.do",
	        type:"post",
	        dataType: 'text',
	        success : function(result) {
	            if (result === '1') {
	                window.location.href = "user/login.jsp";
	            }
	        }
	    });
}