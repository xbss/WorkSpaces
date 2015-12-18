// 封装基本库
var sxb = {
	getById : function(id) {
		return document.getElementById(id);
	},
	getByName : function(name) {
		return document.getElementsByName(name);
	},
	getByTagName : function(tag) {
		return document.getElementsByTagName(tag);
	}
};

// 选中学生信息属性框事件
function attrSelectOnChange(){
	var attr = sxb.getById("attr");
	var isHave = sxb.getById("isHave");
	
	if(attr.value == "sage"){
		// 清空内容
		for(var i = 0; i < isHave.options.length; i++){
			isHave.remove(i);
			isHave.innerHtml = "";
		}
		// 增加相应内容
		var option1 = document.createElement("option");
		option1.text= "大于";
		option1.value="more";
		isHave.appendChild(option1);
		var option2 = document.createElement("option");
		option2.text= "小于";
		option2.value="less";
		isHave.appendChild(option2);
		var option3 = document.createElement("option");
		option3.text= "等于";
		option3.value="equal";
		isHave.appendChild(option3);
		
	} else{
		// 清空内容
		for(var i = 0; i < isHave.options.length; i++){
			isHave.remove(i);
			isHave.innerHtml = "";
		}
		// 增加相应内容
		var option1 = document.createElement("option");
		option1.text= "包含";
		option1.value="is";
		isHave.appendChild(option1);
		var option2 = document.createElement("option");
		option2.text= "不包含";
		option2.value="no";
		isHave.appendChild(option2);
		
	}
}

//打印错误信息
function info(message){
	/*var html  = "<div id='info'>" + 格式错误 + "<\/div>";*/
	/*var infoarea = sxb.getById("infoarea");
	infoarea.appendChild(html);*/
	/*var info = sxb.getById("info").style.display = "block";*/
	var info = sxb.getById("info");
	if(info != null){
		info.parentNode.removeChild(info);
	}
	var div = document.createElement("div");
	div.innerHTML = "<div id='info'>" + message + "格式错误 </div>";
	document.body.appendChild(div);
	info = sxb.getById("info");
	/*fadeIn(info, "slow");*/
	fadeOut(info, "slow");
}