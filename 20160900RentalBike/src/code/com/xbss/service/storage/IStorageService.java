package com.xbss.service.storage;

import javax.servlet.http.HttpServletRequest;

import com.xbss.entity.storage.Storage;

/**
 * @author xbss
 * 仓库
 */
public interface IStorageService {
	
	public String getById(String storageId);
	
	public String add(Storage storage, HttpServletRequest request);
	
	public String deleteById(String storageId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(Storage storage, HttpServletRequest request);
	
	
	public String getWithPage(int rows, int page, String sort, String address);
	
	public String server_getSelectWithPage(int rows, int page, String sort);
}
