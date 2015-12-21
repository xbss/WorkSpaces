
function userEdit(userId){
	$("#content").empty();
	$("#content").append("<div id=useredit style=\"background:red;width:100%;height:100%;position:relative;border:none;z-index:2000;;\"><iframe src=modules/admin/jsp/AdminUserEdit.jsp?userId=" + userId +" style=\"width:100%;height:100%;border:none;margin:0;\"></iframe></div>");
	
};
function userEditBack(){
	alert("4");
	$("#useredit").fadeOut();
	$("#useredit").remove();
	location.reload();
};