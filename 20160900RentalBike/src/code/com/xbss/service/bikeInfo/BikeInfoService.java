package com.xbss.service.bikeInfo;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import net.sf.json.JSONObject;

import  com.xbss.dao.bikeInfo.BikeInfoDao;
import  com.xbss.entity.bikeInfo.BikeInfo;

/**
 * @author xbss
 * 自行车信息
 */
@Service
public class BikeInfoService extends SearchService implements IBikeInfoService{
	
	@Resource(name="bikeInfoDao")
	BikeInfoDao dao ;

	@Override
	public String getBaseEntityName() {
		return "bikeInfo";
	}

	@Override
	public String getBasePrimaryKey() {
		return "bikeInfo.bikeId";
	}

	@Override
	public String getById(String bikeId) {
		return JSONObject.fromObject(dao.getByID(bikeId)).toString();
	}

	@Override
	public String add(BikeInfo bikeInfo) {
		bikeInfo.setBikeId(EntityIDFactory.createId());
		bikeInfo.setBarCode("000");
		bikeInfo.setInStorageTime(new Date());
		
		return dao.save(bikeInfo) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteById(String bikeId) {
		return dao.deleteByID(bikeId) >0 ? "1" : "-1" ;
	}

	@Override
	public String deleteEntities(String[] ids) {
		return dao.deleteEntities(ids) > 0 ? "1" : "-1";
	}

	@Override
	public String updatePropByID(BikeInfo bikeInfo) {
		Map<String, Object> temp = new HashMap<>();
		temp.put("price", bikeInfo.getPrice());
		temp.put("state", bikeInfo.getState());
		temp.put("rentalState", bikeInfo.getRentalState());
		temp.put("storageId", bikeInfo.getStorageId());
		temp.put("bikeTypeId", bikeInfo.getBikeTypeId());
		temp.put("bikeTypeName", bikeInfo.getBikeTypeName());
		temp.put("appearanceInfo", bikeInfo.getAppearanceInfo());
		
		return dao.updatePropByID(temp.entrySet(), bikeInfo.getBikeId()) > 0 ? "1" : "-1";
	}

	@Override
	public String getWithPage(int rows, int page, String sort, String bikeId) {
		String condition = "";
		if (bikeId != null && !bikeId.equals("")) {
			condition = " bikeId like '%" + bikeId + "%'";
		}
		
		List<Map<String, Object>> ens = originalSearchWithpaging(
				new String[]{"bikeId","storageId","inStorageTime", "outStorageTime","bikeTypeId","bikeTypeName","state","rentalState", "price", "appearanceInfo"},
				this.getBaseEntityName(), null, null, condition, false, null, this.getBasePrimaryKey(), null, rows,  page);
		int total = dao.getCountByCondition(condition);
		Map<String, Object> objects = new HashMap<>();
		objects.put("total", total);
		objects.put("rows", ens);
		
		return JSONObject.fromObject(objects).toString();
	}
}
