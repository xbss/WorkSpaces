/*var seriesData = [ [], [], [], [], [] ];
var random = new Rickshaw.Fixtures.RandomData(50);

for (var i = 0; i < 75; i++) {
	random.addData(seriesData);
}

var graph = new Rickshaw.Graph( {
	element: document.getElementById("chart"),
	renderer: 'multi',
	
	dotSize: 5,
	series: [
		{
			name: 'temperature',
			data: seriesData.shift(),
			color: '#AFE9FF',
			renderer: 'stack'
		}, {
			name: 'heat index',
			data: seriesData.shift(),
			color: '#FFCAC0',
			renderer: 'stack'
		}, {
			name: 'dewpoint',
			data: seriesData.shift(),
			color: '#555',
			renderer: 'scatterplot'
		}, {
			name: 'pop',
			data: seriesData.shift().map(function(d) { return { x: d.x, y: d.y / 4 } }),
			color: '#555',
			renderer: 'bar'
		}, {
			name: 'humidity',
			data: seriesData.shift().map(function(d) { return { x: d.x, y: d.y * 1.5 } }),
			renderer: 'line',
			color: '#ef553a'
		}
	]
} );


graph.render();

var detail = new Rickshaw.Graph.HoverDetail({
	graph: graph
});*/


jQuery(document).ready(function() {
	/*jQuery('#vmap').vectorMap({
	    map: 'world_en',
	    backgroundColor: '#333333',
	    color: '#ffffff',
	    hoverOpacity: 0.7,
	    selectedColor: '#666666',
	    enableZoom: true,
	    showTooltip: true,
	    values: sample_data,
	    scaleColors: ['#C8EEFF', '#006491'],
	    normalizeFunction: 'polynomial'
	});*/
	
	/**
	 *  @title addtabs 使用可删除增加的tabs插件
	 */
	//$('#addtabs-pages').addtabs({monitor:'.addtabs-pages-bar'});
	$('#addtabs-pages').addtabs();
	
	/**
	 * @title 系统推出
	 */
	$("#exitSystem").click(function(){
		$.ajax({
			url : "operatorController/Exit.do",
			type:"post",
			success : function(result) {
				if (result === '1') {
	                window.location.href = "admin/login.jsp";
	            } 
			}
		})
	});
	
	
	
/**
 * @title 首页报表模型
 */
 var doughnutData = [
     {
         value: 30,
         color:"#ef553a",
         title:"维修"
     },
     {
         value : 50,
         color : "#9358ac"
     },
     {
         value : 100,
         color : "#3b5998"
     },
     {
         value : 40,
         color : "#00aced"
     },
     {
         value : 120,
         color : "#4D5360"
     }
 
 ];
 var lineChartData = {
     labels : ["","","","","","",""],
     datasets : [
         {
             fillColor : "#00aced",
             strokeColor : "#00aced",
             pointColor : "#00aced",
             pointStrokeColor : "#fff",
             data : [65,59,90,81,56,55,40]
         },
         {
             fillColor : "#3b5998",
             strokeColor : "#3b5998",
             pointColor : "#3b5998",
             pointStrokeColor : "#fff",
             data : [28,48,40,19,96,27,100]
         }
     ]
     
 };
 var pieData = [
         {
             value: 30,
             color:"#ef553a"
         },
         {
             value : 50,
             color : "#00aced"
         },
         {
             value : 100,
             color : "#69D2E7"
         }
     
     ];
 var barChartData = {
     labels : ["January","February","March","April","May","June","July"],
     datasets : [
         {
             fillColor : "#ef553a",
             strokeColor : "#ef553a",
             data : [65,59,90,81,56,55,40]
         },
         {
             fillColor : "#00aced",
             strokeColor : "#00aced",
             data : [28,48,40,19,96,27,100]
         }
     ]
     
 };
 var chartData = [
     {
         value : Math.random(),
         color: "#D97041"
     },
     {
         value : Math.random(),
         color: "#C7604C"
     },
     {
         value : Math.random(),
         color: "#21323D"
     },
     {
         value : Math.random(),
         color: "#9D9B7F"
     },
     {
         value : Math.random(),
         color: "#7D4F6D"
     },
     {
         value : Math.random(),
         color: "#9358ac"
     }
 ];
 var radarChartData = {
     labels : ["","","","","","",""],
     datasets : [
         {
             fillColor : "#3b5998",
             strokeColor : "#3b5998",
             pointColor : "#3b5998",
             pointStrokeColor : "#fff",
             data : [65,59,90,81,56,55,40]
         },
         {
             fillColor : "#ef553a",
             strokeColor : "#ef553a",
             pointColor : "#ef553a",
             pointStrokeColor : "#fff",
             data : [28,48,40,19,96,27,100]
         }
     ]
     
 };
 new Chart(document.getElementById("doughnut").getContext("2d")).Doughnut(doughnutData);
 new Chart(document.getElementById("line").getContext("2d")).Line(lineChartData);
/* new Chart(document.getElementById("radar").getContext("2d")).Radar(radarChartData);*/
/* new Chart(document.getElementById("polarArea").getContext("2d")).PolarArea(chartData);*/
 new Chart(document.getElementById("bar").getContext("2d")).Bar(barChartData);
 new Chart(document.getElementById("pie").getContext("2d")).Pie(pieData);
});