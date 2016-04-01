/**
 * @title 生成最长公共子序列的页面动画以及算法
 * @author XBSS
 * 
 * 
 * lcs-table-data-th  头部
 * lcs-table-data-rh 侧部
 * lcs-result-max-text  
 * lcs-result-minresult-text
*/

// 处理用的数据
var MAX;
var m;
var n;
var L = [];
var L1 = [];
var result = "";
// 页面对象
var string1 = "zxyxyz";
var string2 = "xyyzx";
var table = getID("lcs-table-data");
var tableTH = getID("lcs-table-data-th");
var tableRH = getCLASS("lcs-table-data-rh");
var lcsresult = getID("lcs-result");
var maxText = getID("lcs-result-max-text");
var maxresultText = getID("lcs-result-maxresult-text");
// 动画使用
var runLCS;
var delayLCS = 500;

function run(){
	// 数据准备
	/*if(getID("string1").val() != null && getID("string1").val() != "" && getID("string2").val() != null && getID("string2").val() != ""){
		string1 = getID("string1").val();
		string2 = getID("string2").val();
		
	} else {
		info("输入数据格式错误");
		return ;
	}*/
	// 初始化数组
	m = string1.length;
	n = string2.length;
	//console.info(m + n);
	for (var i = 0; i < m+1; i++) {
		if(!L[i]){
          L[i] = [];
       }
		for (var j = 0; j < n+1; j++) {
			//console.info(i +" "+ j);
			if(!L[i][j]){
               L[i][j] = [];
           }
			L[i][j] = 0;
		}
	}
	// 清除已有数据
	stop();
	// 生成表格
	CreateLCSTable();
	// 计算最小需要的计算次数
	LCS();
	// 开始动画
	StartFlash();
	// 打印结果
	PrintResult();
	
}

	
/**
 * @title 计算值
 * @param a
 * @param m
 * @param s
 */
function LCS(){
	var max = 0;
	for (var i = 1; i <= m; i++) {
		for (var j = 1; j <= n; j++) {
			if(string1[i-1] === string2[j-1]){
				//console.info(i + ":" + j );
				L[i][j] = L[i-1][j-1] + 1;
				L1.push([i,j,L[i][j]]);
				//getID(i+""+j).css("opacity","1");
				//getID(i+""+j).html(L[i][j]);
				//result += string1[i-1];
				getID(i+""+j).css("color","red");
				getID(i+""+j).css("opacity","1");
			} else {
				//console.info(i + ":" + j );
				L[i][j] = Math.max(L[i][j-1],L[i-1][j]);
				L1.push([i,j,L[i][j]]);
				//getID(i+""+j).css("opacity","1");
				//getID(i+""+j).html(L[i][j]);
			}
			// 存储最大
			if(L[i][j] > max){
				console.info("max:" + max);
				setTimeout(null, 500);
				max = L[i][j];
				
				//getID(i+""+j).html(L[i][j]);
			}
		}
	}
	MAX = max;
}
function stop(){
	//clearInterval(run);
	table.empty();
	lcsresult.css("opacity","0");
	maxText.html("");
	maxresultText.html("");
	getID("lcs-process").html("");
	result = "";
	MAX = 0;
}
function PrintResult(){
	lcsresult.css("opacity","1");
	maxText.append(MAX);
	maxresultText.append(result + "<br>");
}

/**
 * @title 创建table
 */
function CreateLCSTable(){
	var tableTHString = "";
	var tableBODYString = "";
	// TH 
	tableTHString +="<th>"  + "</th>" // 占位使用
	tableTHString +="<th>"  + "</th>" // 占位使用
	for(var i = 0; i < n; i++){
		tableTHString += "<th>" + string2[i]  + "</th>";
	}
	
	tableTHString = "<tr id='lcs-table-data-th'>" + tableTHString +"</tr>"
	table.append(tableTHString);
	// TBODY
	for(var i = 0; i < m+1; i++){
		console.info("i m:" + i + "" + m);
		if(i == 0){
			tableBODYString += "<td class='lcs-table-data-rh'>"  + "</td>";
		} else {
			tableBODYString += "<td class='lcs-table-data-rh'>" + string1[i-1] + "</td>";
		}
		for(var j = 0; j < n+1; j++){
			console.info("i j :" + i + "" + j);
			tableBODYString += "<td id='"+i+j+"' class='hiddenTd'>" +L[i][j]+"</td>";
		}
		
		tableBODYString = "<tr>" + tableBODYString + "</tr>";
	}
	table.append(tableBODYString);
}

/**
 * @title 开始动画
 */
function StartFlash(){
	var xy = 0;
	runLCS = setInterval(function(){
		
		if(xy == L1.length){
			clearInterval(runLCS);
		} else{
			getID(L1[xy][0]+""+L1[xy][1]).css("opacity","1");
			getID(L1[xy][0]+""+L1[xy][1]).html(L1[xy][2]);
		}
		xy ++;
	}, delayLCS)
	
	for (var i = 0; i < m+1; i++) {
		getID(i+""+0).css("opacity","1");
		getID(i+""+0).css("color","#bbb");
	}
	for (var j = 0; j < n+1; j++) {
		getID(0+""+j).css("opacity","1");
		getID(0+""+j).css("color","#bbb");
	}
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