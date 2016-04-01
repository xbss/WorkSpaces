/**
 * @title 生成矩阵链相乘的页面动画以及算法
 * @author XBSS
 * C[i][j] = C[i][k] + C[k+1][j] +r[i]*r[k+1]*r[j+1]
 * 1 <= i <= j <= n
 * i <= k <= j-1
 * C[i][j] = min{C[i][k-1] + C[k][j] + r[i]*r[k]*r[j]}    (i<j)
 * 
 * mc-table-data-th  头部
 * mc-table-data-rh 侧部
 * mc-result-min-text  
 * mc-result-multi-text
*/

// 处理用的数据
var LEN = 0;
var MIN;
var M = [];  
var S = [];
var NAME;
var result = "";
var resultStrings = [];
//记录轨迹
var L1 =Array();
var L2 =Array();
// 页面对象
var firstString = "1,2,5,2,6";
//var firstString = getID("firstString");
var table = getID("mc-table-data");
var tableTH = getID("mc-table-data-th");
var tableRH = getCLASS("mc-table-data-rh");
var mcresult = getID("mc-result");
var minText = getID("mc-result-min-text");
var multiText = getID("mc-result-multi-text ");
// 动画使用
var sladeTime = 500;
var runInteral;
var stopInteral;


function run(){
	// 数据准备
	if(getID("slideTime").val() < 0){
		info("延迟时间格式错误");
		return ;
	} else {
		sladeTime = getID("slideTime").val();
	}
	if(getID("firstString").val() != null && getID("firstString").val() != ""){
		firstString = getID("firstString").val();
		
	} else {
		info("输入数据格式错误");
		return ;
	}
	
	MIN = 0;
	var firStrings = Array();
	firStrings = firstString.split(",");
	var squer=""; 
	for (var i = 0; i < firStrings.length; i++) {
		console.info(firStrings[i]);
	}
	LEN = firStrings.length - 1;
	// 
	for (var i = 0; i < LEN; i++) {
		squer += "A" + i + ":" + firStrings[i]  + "*" + firStrings[i+1] + " ";
		resultStrings[i] = firStrings[i]  + "*" + firStrings[i+1];
	}
	// 初始化数组
	
	for (var i = 0; i < LEN; i++) {
		if(!M[i]){
          M[i] = [];
       }
       if(!S[i]){
          S[i] = [];
       }
		for (var j = 0; j < LEN; j++) {
			if(!M[i][j]){
               M[i][j] = [];
           }
           if(!S[i][j]){
               S[i][j] = [];
           }
			M[i][j] = 0;
			S[i][j] = 0;
		}
	}
	
	for (var i = 0; i < LEN; i++) {
		L1.push([i,i]);
		L2.push([i,i]);
	}
	// 清除已有数据
	stop();
	// 计算最小需要的计算次数
	MtrixChain(firStrings);
	// 矩阵相乘的顺序为：
	GetResultString(0,LEN-1);
	// 输出结果
	PrintResult();
	// 生成表格
	CreateMCTable();
	// 开始动画
	StartFlash();
	
}
function stop(){
	clearInterval(run);
	table.empty();
	mcresult.css("opacity","0");
	minText.html("");
	multiText.html("");
	getID("mc-process").html("");
}
	
/**
 * @title 计算值
 * @param a
 * @param m
 * @param s
 */
function MtrixChain(a){
	var t = 0;
	var min = 0;
	var temp = 0;
	for (var i = 2; i < a.length; i++) {
		for (var j = 0; j < a.length-i; j++) {
			t = j + i -1;
			M[j][t] = Number.MAX_VALUE;
			for (var k = j; k < t; k++) {
				/*
				 * 利用的算法
				 * C[i][j] = C[i][k] + C[k+1][j] +r[i]*r[k+1]*r[j+1]
				 * 1 <= i <= j <= n
				 * i <= k <= j-1
				 * C[i][j] = min{C[i][k-1] + C[k][j] + r[i]*r[k]*r[j]}    (i<j)
				 */
				temp = M[j][k] + M[k+1][t] + a[j]*a[k+1]*a[t+1];
				L1.push([j, k]);
				L2.push([k+1,t]);
				if (temp < M[j][t]) {
					min = temp;
					// 保留最小耗费
					M[j][t] = temp;
					// 保留最小耗费的k
					S[j][t] = k;
				}
			}
		}
	}
	MIN = min;
}

function PrintResult(){
	mcresult.css("opacity","1");
	minText.append(MIN);
	multiText.append(result);
}
/**
 * @title 显示最终结果
 * @param s
 * @param name
 * @param i
 * @param j
 */
function GetResultString(i, j){
	if (i == j) {
		result += resultStrings[i];
		
	}else {
		result += "(";
		GetResultString(i, S[i][j]);
		result += "*";
		GetResultString(S[i][j]+1, j);
		result += ")";
	}
}

/**
 * @title 创建table
 */
function CreateMCTable(){
	var tableTHString = "";
	var tableBODYString = "";
	// TH 
	for(var i = 0; i < LEN; i++){
		tableTHString += "<th>" + resultStrings[i]  + "</th>";
	}
	tableTHString +="<th>"  + "</th>" // 占位使用
	tableTHString = "<tr id='mc-table-data-th'>" + tableTHString +"</tr>"
	table.append(tableTHString);
	// TBODY
	for(var i = 0; i < LEN; i++){
		for(var j = 0; j < LEN; j++){
			tableBODYString += "<td id='"+i+j+"' class='hiddenTd'>" +M[i][j]+"</td>";
		}
		tableBODYString += "<td class='mc-table-data-rh'>" + resultStrings[i] + "</td>";
		tableBODYString = "<tr>" + tableBODYString + "</tr>";
	}
	table.append(tableBODYString);
}

/**
 * @title 开始动画
 */
function StartFlash(){
	var weizhi = 0; // 记录位置
	// 记录坐标
	var x1,y1,x2,y2,x3,y3;
	runInteral = setInterval(function(){
		// 当当前坐标不一致时修改颜色
		if(weizhi > LEN){
			getID(L1[weizhi-1][0]+""+L2[weizhi-1][1]).css("opacity","1").css("color", "#ffd400");
		}
		if(weizhi < LEN){
			getID(L1[weizhi][0]+""+L2[weizhi][1]).css("color","#33a3dc");
			getID(L1[weizhi][0]+""+L1[weizhi][1]).css("color","#000");
			getID(L2[weizhi][0]+""+L2[weizhi][1]).css("color","#000");
			getID(L2[weizhi][0]+""+L2[weizhi][1]).css("opacity","1");
		} else{
			getID(L1[weizhi][0]+""+L2[weizhi][1]).css("color","#33a3dc").css("opacity","0.5");
			getID(L1[weizhi][0]+""+L1[weizhi][1]).css("color","#1d953f");
			getID(L2[weizhi][0]+""+L2[weizhi][1]).css("color","#1d953f");
			getID("mc-process").append("<br>(" + (L1[weizhi][0]+1)+""+(L2[weizhi][1]+1) + ") 结果由： (" + (L1[weizhi][0]+1)+""+ (L1[weizhi][1]+1)  + ") ， (" + (L2[weizhi][0]+1)+""+(L2[weizhi][1]+1) +") 得出");
			if (weizhi>LEN) {
                if (weizhi>(LEN+LEN-2)) {
                	getID(x3+""+y3).css("color","#000");
                }
                getID(x2+""+y2).css("color","#000");
             }
		}
		
		// 第一个依赖值 坐标
		x2= L1[weizhi][0];
        y2= L1[weizhi][1];

        // 第二个依赖值 坐标
        x3= L2[weizhi][0];
        y3= L2[weizhi][1];
		weizhi++;
		if (weizhi==L1.length) {
	        clearInterval(runInteral);
	        getID(L1[weizhi-1][0]+""+L2[weizhi-1][1]).css("color","#000");
	        getID(L1[weizhi-1][0]+""+L2[weizhi-1][1]).css("opacity","1");
	        getID(x2+""+y2).css("color","#000");
	        getID(x3+""+y3).css("color","#000");
	    }
	}, sladeTime);
}




















/***
 * @title 将常用函数封装
 * @param id
 * @returns
 */
function getID(id){
	return $("#"+id );
}
function getCLASS(clazz){
	return $("." +clazz);
}
function getTAG(tag){
	return $(tag);
}