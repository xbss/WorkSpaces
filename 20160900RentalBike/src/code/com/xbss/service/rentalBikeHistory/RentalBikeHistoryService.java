package com.xbss.service.rentalBikeHistory;


import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.xbss.service.operator.OperatorService;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import com.xbss.dao.bikeInfo.BikeInfoDao;
import com.xbss.dao.rbUser.RbUserDao;
import  com.xbss.dao.rentalBikeHistory.RentalBikeHistoryDao;
import com.xbss.entity.bikeInfo.BikeInfo;
import com.xbss.entity.operator.Operator;
import com.xbss.entity.rbUser.RbUser;
import  com.xbss.entity.rentalBikeHistory.RentalBikeHistory;

/**
 * @author xbss
 * 车辆租借记录
 */
@Service
public class RentalBikeHistoryService extends SearchService implements IRentalBikeHistoryService{
	
	@Resource(name="rentalBikeHistoryDao")
	RentalBikeHistoryDao dao ;
	@Resource(name="rbUserDao")
	RbUserDao rbUserDao ;
	@Resource(name="bikeInfoDao")
	BikeInfoDao bikeInfoDao ;
	
	@Resource(name="operatorService")
	OperatorService operatorService ;

	@Override
	public String getBaseEntityName() {
		return "rentalBikeHistory";
	}

	@Override
	public String getBasePrimaryKey() {
		return "rentalBikeHistory.rentalId";
	}

	@Override
	public String getById(String rentalId) {
		return dao.getByID(rentalId).toString();
	}

	@Override
	public String add(RentalBikeHistory rentalBikeHistory) {
		rentalBikeHistory.setRentalId(EntityIDFactory.createId());
		return dao.save(rentalBikeHistory) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String rentalId) {
		return dao.deleteByID(rentalId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(RentalBikeHistory rentalBikeHistory) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("userName", rentalBikeHistory.getUserName());
		
		return dao.updatePropByID(temp.entrySet(), rentalBikeHistory.getRentalId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String userName) {
		String condition = "";
		if (userName != null && !userName.equals("")) {
			condition = " userName like '%" + userName + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"rentalId","bikeId","userId","userName", "operatorId", "operatorName","startTime","endTime","rentalTime", "rentalPrice", "state", "damage"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	/**
	 * @author XBSS
	 * @title 客户端检索车辆信息
	 */
	@Override
	public String getRentalBikeInfo(String bikeId, HttpServletRequest request) {
		
		// 1 根据信息查看车辆是否能符合租借标准
		String resultInfo= "1";
		BikeInfo bikeInfo = null;
		if (bikeInfoDao.getByID(bikeId)  == null) {
			/*resultInfo = "车辆不存在";*/
			resultInfo = "2";
		} else {
			bikeInfo = bikeInfoDao.getByID(bikeId);
			if (bikeInfo.getRentalState() == 1) {
				/*resultInfo = "正在使用中";*/
				resultInfo = "3";
			}
			if (bikeInfo.getState() == 0) {
				/*resultInfo = "车辆不可用";*/
				resultInfo = "4";
			}
		}
		
		// 2 组织信息
		Map< String, Object> results = new HashMap<>();
		results.put("resultInfo", resultInfo);
		results.put("bikeInfo", bikeInfo);
		
		return JSONObject.fromObject(results).toString();
	}

	/**
	 * @author XBSS
	 * @title 客户端租一辆车
	 */
	@Override
	public String rentalABike(String bikeId, String userId) {
		BikeInfo bikeInfo = bikeInfoDao.getByID(bikeId);
		RbUser rbUser = rbUserDao.getByID(userId);
		RentalBikeHistory rentalBikeHistory = new RentalBikeHistory();
		// 存入租赁记录
		rentalBikeHistory.setRentalId(EntityIDFactory.createId());
		rentalBikeHistory.setBikeId(bikeId);
		rentalBikeHistory.setUserId(userId);
		rentalBikeHistory.setUserName(rbUser.getUserName());
		rentalBikeHistory.setState(0);
		rentalBikeHistory.setStartTime(new Date());
		int flag = dao.save(rentalBikeHistory);
		
		if (flag > 0) {
			// 更新车辆租赁状态
			bikeInfo.setRentalState(1);
			bikeInfoDao.updateByID(bikeInfo, bikeId);
		}
		
		return flag > 0 ? "1" : "-1";
	}
	
	

	/**
	 * @title 客户端查询该用户未结算的租车记录
	 * @param rows
	 * @param page
	 * @param userId
	 * @return
	 */
	@Override
	public String getRecordNoBackIWithPage(int rows, int page, String userId) {
		String condition = " userId = '" + userId + "' and state = 0" ;
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"rentalId","bikeId","rentalPrice","startTime","endTime","rentalTime", "damage"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	/**
	 * 
	 * @param bikeId
	 * @param userId
	 * @return 
	 * @title 客户端归还车辆申, 申请后工作人员进行验收，并计算租车消费
	 */
	@Override
	public String backABike(String rentalId, String bikeId, String userId) {
		if (rentalId != null && userId != null) {
			// 获得实体
			RentalBikeHistory rentalBikeHistory = dao.getByID(rentalId);
			BikeInfo bikeInfo = bikeInfoDao.getByID(bikeId);
			// 进行业务操作: 计算租借时间和价格
			int flag = 0; // 成功标志
			rentalBikeHistory.setEndTime(new Date());
			long rentalTime = rentalBikeHistory.getEndTime().getTime() - rentalBikeHistory.getStartTime().getTime();
			// 计算价格
			double totalPrice =( rentalTime / 1000 / 60) * bikeInfo.getPrice()  / 60;  // 得到总的消费，取两位小数
			rentalBikeHistory.setRentalPrice( Double.valueOf(new DecimalFormat("#.00").format(totalPrice)) );
			// 设置租赁时间（单位：分）
			rentalBikeHistory.setRentalTime(String.valueOf(rentalTime / 1000 / 60));
			// 存入数据库
			flag = dao.updateByID(rentalBikeHistory, rentalBikeHistory.getRentalId());
			if (flag > 0) {
				// 更改车辆状态
				return bikeInfoDao.updateByID(bikeInfo, bikeInfo.getBikeId()) > 0 ? "1" : "0";
			} else {
				return "0";
			}
		} else  {
			return "0";
		}
		
	}
	/**
	 * @title 客户端查询该用户已结算的租车记录
	 * @param rows
	 * @param page
	 * @param userId
	 * @return
	 */
	@Override
	public String getRecordHaveBackIWithPage(int rows, int page, String userId) {
		String condition = " userId = '" + userId + "' and state = 1" ;
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"rentalId","bikeId","rentalPrice","startTime","endTime","rentalTime", "damage"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
	
	
	/**
	 * @title 服务器端快速验收车
	 */
	public String server_checkABike(String rentalId, int damage, HttpServletRequest request){
		// 获取实体
		Operator operator = operatorService.getCurrentOperator(request);
		RentalBikeHistory rentalBikeHistory = dao.getByID(rentalId);
		
		// 结算车辆，设置损坏
		System.out.println("" + operator.getOperatorName());
		Map<String, Object> temp = new HashMap<>();
		temp.put("operatorId", operator.getOperatorCode());
		temp.put("operatorName", operator.getOperatorName());
		temp.put("state", 1);
		temp.put("damage", damage);
		
		return dao.updatePropByID(temp.entrySet(), rentalBikeHistory.getRentalId()) > 0 ? "1" : "-1";
	}
	/**
	 * @title 服务器端快速验收车获取已归还但是未结算的车辆
	 */
	public String server_getRecordNoCheckWithPage(int rows, int page, String userName){
		String condition = " state = 0" ;
		if(userName != null){
			condition += "  and userName like '%" + userName + "%'";
		}
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"rentalId","bikeId","rentalPrice","userId","userName", "endTime","rentalTime", "damage"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
}
