package com.xbss.controller.storage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.storage.Storage;
import com.xbss.service.storage.IStorageService;
import com.xbss.system.tool.EntityIDFactory;

/**
 * @author xbss
 * 仓库
 */
@Controller
@RequestMapping("/storageController")
public class StorageController{
	
	@Resource(name="storageService")
	IStorageService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String storageId) {
		return service.getById(storageId);
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add(Storage storage, HttpServletRequest request) {
		storage.setStorageId(EntityIDFactory.createId());
		return service.add(storage, request);
	}

	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String storageId) {
		return service.deleteById(storageId);
	}

	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids) {
		return service.deleteEntities(ids);
	}

	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(Storage storage, HttpServletRequest request) {
		return service.updatePropByID(storage, request);
	}

	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String address) {
		
		return service.getWithPage(rows, page, sort, address);
	}
	
	@RequestMapping("/server_getSelectWithPage")
	@ResponseBody
	public String server_getSelectWithPage(int rows, int page, String sort){
		return service.server_getSelectWithPage(rows, page, sort);
	}
}
