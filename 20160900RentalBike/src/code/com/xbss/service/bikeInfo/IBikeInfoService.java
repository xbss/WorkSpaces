package com.xbss.service.bikeInfo;

import com.xbss.entity.bikeInfo.BikeInfo;

/**
 * @author xbss
 * 自行车信息
 */
public interface IBikeInfoService {
	public String getById(String bikeId);
	
	public String add(BikeInfo bikeInfo);
	
	public String deleteById(String bikeId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(BikeInfo bikeInfo);
	
	
	public String getWithPage(int rows, int page, String sort, String bikeId);
}
