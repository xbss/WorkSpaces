/*function submit1(){
	if(dataCheck == false){
		info("填写");
	}
}*/

// 封装基本库
var xbss = {
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
// 打印错误信息
function info(type){
	//console.info(title+""+message);
	var info = xbss.getById("info");
	if(info != null){
		info.parentNode.removeChild(info);
	}
	message="操作失败"
	if(type >= 1){
		message = "操作成功";
	} 
	var div = document.createElement("div");
	div.innerHTML = "<div id='info'>" + message + " </div>";
	document.body.appendChild(div);
	info = xbss.getById("info");
	fadeOut(info, "slow");
}

// 获取速度值
function getSpeed(s){
//速度值，可随意更改。
switch(s){
case "fast": return 200;
case "normal": return 500;
case "slow": return 1000;
default: return s;
}
}
// 设置透明度
function opacity(node, opc){
if(node.style.opacity != null) {  node.style.opacity = opc; }
else { //for IE
opc *= 100;
var alpha = node.style.filter.match(RegExp("alpha\\(opacity=\\S+\\);"));
node.style.filter = node.style.filter.replace(alpha, "");
node.style.filter += "alpha(opacity="+opc+");";
}
}
// 渐显
function fadeIn(node, speed){
if(speed==null) {  speed = "normal"; }
speed = getSpeed(speed);
var delay = speed / 100;
var opc = 0;
opacity(node, opc);
node.style.display = "";
window.setTimeout(function(){fadeInStep(node,opc,delay);},0);
}
// 渐显过程
function fadeInStep(node,opc,delay){
opc+=0.01;
opacity(node, opc);
if(opc>=1){
return true;
}
window.setTimeout(function(){fadeInStep(node,opc,delay);},delay);
}
// 渐隐
function fadeOut(node, speed){
if(speed==null) {  speed = "normal"; }
speed = getSpeed(speed);
var delay = speed / 100;
var opc = 1;
opacity(node, opc);
node.style.display = "";
window.setTimeout(function(){fadeOutStep(node,opc,delay);},0);
}
// 渐隐过程
function fadeOutStep(node,opc,delay){
opc-=0.01;
opacity(node, opc);
if(opc<=0){
node.style.display = "none";
return true;
}
window.setTimeout(function(){fadeOutStep(node,opc,delay);},delay);
}