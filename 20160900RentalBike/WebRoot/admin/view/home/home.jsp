<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 首页图表 -->
<div class="graphs">
	<div class="col_3">
		<div class="col-md-3 widget ">
			<div class="r3_counter_box">
				<i class="pull-left fa fa-database  icon-rounded"></i>
				<div class="stats">
					<h5>
						<strong id="admin_data_bikeAmount">45</strong>
					</h5>
					<span>车辆库存</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 widget ">
			<div class="r3_counter_box">
				<i class="pull-left fa fa-users user1 icon-rounded"></i>
				<div class="stats">
					<h5>
						<strong id="admin_data_users">1019</strong>
					</h5>
					<span>用户总数</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 widget ">
			<div class="r3_counter_box">
				<i class="pull-left fa fa-comment user2 icon-rounded"></i>
				<div class="stats">
					<h5>
						<strong id="admin_data_suggestion">1012</strong>
					</h5>
					<span>用户反馈</span>
				</div>
			</div>
		</div>
		<div class="col-md-3 widget">
			<div class="r3_counter_box">
				<i class="pull-left fa fa-dollar dollar1 icon-rounded"></i>
				<div class="stats">
					<h5>
						<strong id="admin_data_dayIncount">$450</strong>
					</h5>
					<span>当日营收</span>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
    <div class="col_1">
            <div class="col-md-4 span_7">   
              <div class="cal1 cal_2"><div class="clndr"><div class="clndr-controls"><div class="clndr-control-button"><p class="clndr-previous-button">previous</p></div><div class="month">July 2015</div><div class="clndr-control-button rightalign"><p class="clndr-next-button">next</p></div></div><table class="clndr-table" border="0" cellspacing="0" cellpadding="0"><thead><tr class="header-days"><td class="header-day">S</td><td class="header-day">M</td><td class="header-day">T</td><td class="header-day">W</td><td class="header-day">T</td><td class="header-day">F</td><td class="header-day">S</td></tr></thead><tbody><tr><td class="day adjacent-month last-month calendar-day-2015-06-28"><div class="day-contents">28</div></td><td class="day adjacent-month last-month calendar-day-2015-06-29"><div class="day-contents">29</div></td><td class="day adjacent-month last-month calendar-day-2015-06-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-01"><div class="day-contents">1</div></td><td class="day calendar-day-2015-07-02"><div class="day-contents">2</div></td><td class="day calendar-day-2015-07-03"><div class="day-contents">3</div></td><td class="day calendar-day-2015-07-04"><div class="day-contents">4</div></td></tr><tr><td class="day calendar-day-2015-07-05"><div class="day-contents">5</div></td><td class="day calendar-day-2015-07-06"><div class="day-contents">6</div></td><td class="day calendar-day-2015-07-07"><div class="day-contents">7</div></td><td class="day calendar-day-2015-07-08"><div class="day-contents">8</div></td><td class="day calendar-day-2015-07-09"><div class="day-contents">9</div></td><td class="day calendar-day-2015-07-10"><div class="day-contents">10</div></td><td class="day calendar-day-2015-07-11"><div class="day-contents">11</div></td></tr><tr><td class="day calendar-day-2015-07-12"><div class="day-contents">12</div></td><td class="day calendar-day-2015-07-13"><div class="day-contents">13</div></td><td class="day calendar-day-2015-07-14"><div class="day-contents">14</div></td><td class="day calendar-day-2015-07-15"><div class="day-contents">15</div></td><td class="day calendar-day-2015-07-16"><div class="day-contents">16</div></td><td class="day calendar-day-2015-07-17"><div class="day-contents">17</div></td><td class="day calendar-day-2015-07-18"><div class="day-contents">18</div></td></tr><tr><td class="day calendar-day-2015-07-19"><div class="day-contents">19</div></td><td class="day calendar-day-2015-07-20"><div class="day-contents">20</div></td><td class="day calendar-day-2015-07-21"><div class="day-contents">21</div></td><td class="day calendar-day-2015-07-22"><div class="day-contents">22</div></td><td class="day calendar-day-2015-07-23"><div class="day-contents">23</div></td><td class="day calendar-day-2015-07-24"><div class="day-contents">24</div></td><td class="day calendar-day-2015-07-25"><div class="day-contents">25</div></td></tr><tr><td class="day calendar-day-2015-07-26"><div class="day-contents">26</div></td><td class="day calendar-day-2015-07-27"><div class="day-contents">27</div></td><td class="day calendar-day-2015-07-28"><div class="day-contents">28</div></td><td class="day calendar-day-2015-07-29"><div class="day-contents">29</div></td><td class="day calendar-day-2015-07-30"><div class="day-contents">30</div></td><td class="day calendar-day-2015-07-31"><div class="day-contents">31</div></td><td class="day adjacent-month next-month calendar-day-2015-08-01"><div class="day-contents">1</div></td></tr></tbody></table></div></div>
            </div>
            <!-- 用户信息滚动 -->
            <div id="user_message_scroll" class="col-md-4 span_8">
               <div class="activity_box">
                <div class="scrollbar" id="style-2">
                   <div class="activity-row">
                     <div class="col-xs-4 activity-img">
                        <!-- <img src='admin/img/5.png' class="img-responsive" alt=""/> -->
                        <i class="pull-left fa fa-user fa-3x "></i>
                     </div>
                     <div class="col-xs-8 activity-desc">
                        <h5>小陈</h5>
                        <p>希望做的更好</p>
                        <h6>8:03</h6>
                     </div>
                    </div>
                    <div class="activity-row">
                     <div class="col-xs-4 activity-img">
                        <!-- <img src='admin/img/5.png' class="img-responsive" alt=""/> -->
                        <i class="pull-left fa fa-user fa-3x "></i>
                     </div>
                     <div class="col-xs-8 activity-desc">
                        <h5>小陈</h5>
                        <p>希望做的更好</p>
                        <h6>8:03</h6>
                     </div>
                    </div>
                    <div class="activity-row">
                     <div class="col-xs-4 activity-img">
                        <!-- <img src='admin/img/5.png' class="img-responsive" alt=""/> -->
                        <i class="pull-left fa fa-user fa-3x "></i>
                     </div>
                     <div class="col-xs-8 activity-desc">
                        <h5>小陈</h5>
                        <p>希望做的更好</p>
                        <h6>8:03</h6>
                     </div>
                    </div>
                   </div>
                </div>
            </div>
            <div class="col-md-4 stats-info">
                <div class="panel-heading">
                    <h4 class="panel-title">快捷导航</h4>
                </div>
                <div class="panel-body">
                    <ul class="list-unstyled">
                        <li>车辆信息<div class="text-success pull-right">12%<i class="fa fa-level-up"></i></div></li>
                        <li>供应商管理<div class="text-success pull-right">15%<i class="fa fa-level-up"></i></div></li>
                        <li>用户端配置<div class="text-success pull-right">18%<i class="fa fa-level-up"></i></div></li>
                        <li>财务结算<div class="text-danger pull-right">17%<i class="fa fa-level-down"></i></div></li>
                    </ul>
                </div>
            </div>
            <div class="clearfix"> </div>
      </div>
      
      
      
</div>