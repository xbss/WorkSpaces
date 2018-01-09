<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 首页图表 -->
<div class="graphs">
      
      <!-- 报表模型 -->
      <div class="graph_box">
            <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>本月资金占比</h3>
                <canvas id="doughnut" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div>
            <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>当日营业情况</h3>
                <canvas id="line" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div>
            <!-- <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>PolarArea</h3>
                <canvas id="polarArea" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div> -->
            <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>本月分库维修情况</h3>
                <canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div>
            <div class="clearfix"> </div>
        </div>
        <div class="graph_box1">
            <!-- <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>本月分库维修情况</h3>
                <canvas id="bar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div> -->
            <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>人员职业分类占比</h3>
                <canvas id="pie" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div>
            <!-- <div class="col-md-4 grid_2"><div class="grid_1">
                <h3>Radar</h3><canvas id="radar" height="300" width="400" style="width: 400px; height: 300px;"></canvas>
            </div></div> -->
            <div class="clearfix"> </div>
        </div>
</div>