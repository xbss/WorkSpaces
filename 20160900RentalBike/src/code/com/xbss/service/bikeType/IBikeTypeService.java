package com.xbss.service.bikeType;

import com.xbss.entity.bikeType.BikeType;

/**
 * @author xbss
 * 自行车车型
 */
public interface IBikeTypeService {
	public String getById(String bikeTypeId);
	
	public String add(BikeType bikeType);
	
	public String deleteById(String bikeTypeId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(BikeType bikeType);
	
	
	public String getWithPage(int rows, int page, String sort, String bikeTypeName);
	
	public String server_getSelectWithPage(int rows, int page, String sort);
}
