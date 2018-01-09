package com.xbss.service.rentalBikeHistory;

import javax.servlet.http.HttpServletRequest;

import com.xbss.entity.rentalBikeHistory.RentalBikeHistory;

/**
 * @author xbss
 * 车辆租借记录
 */
public interface IRentalBikeHistoryService {
	public String getById(String rentalId);
	
	public String add(RentalBikeHistory rentalBikeHistory);
	
	public String deleteById(String rentalId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(RentalBikeHistory rentalBikeHistory);
	
	
	public String getWithPage(int rows, int page, String sort, String userName);
	
	public String getRentalBikeInfo(String bikeId, HttpServletRequest request);
	
	public String rentalABike(String bikeId, String userId);
	
	public String getRecordNoBackIWithPage(int rows, int page, String userId);
	public String backABike(String rentalId, String bikeId, String userId);
	
	public String getRecordHaveBackIWithPage(int rows, int page, String userId);
	
	public String server_checkABike(String rentalId, int damage, HttpServletRequest request);
	public String server_getRecordNoCheckWithPage(int rows, int page, String userName);
}
