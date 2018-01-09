package com.xbss.controller.supplier;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xbss.entity.bikeInfo.BikeInfo;
import com.xbss.entity.supplier.Supplier;
import com.xbss.service.supplier.ISupplierService;

/**
 * @author xbss
 * 供应商
 */
@Controller
@RequestMapping("/supplierController")
public class SupplierController{
	
	@Resource(name="supplierService")
	ISupplierService service;
	
	@RequestMapping("/getById")
	@ResponseBody
	public String getById(String supplierId){
		return service.getById(supplierId);
	}
	
	@RequestMapping("/add")
	@ResponseBody
	public String add(Supplier supplier){
		return service.add(supplier);
	}
	
	@RequestMapping("/deleteById")
	@ResponseBody
	public String deleteById(String supplierId){
		return service.deleteById(supplierId);
	}
	
	@RequestMapping("/deleteEntities")
	@ResponseBody
	public String deleteEntities(String[] ids){
		return service.deleteEntities(ids);
	}
	
	@RequestMapping("/updatePropByID")
	@ResponseBody
	public String updatePropByID(Supplier supplier){
		return service.updatePropByID(supplier);
	}
	
	@RequestMapping("/getWithPage")
	@ResponseBody
	public String getWithPage(int rows, int page, String sort, String supplierName){
		return service.getWithPage(rows, page, sort, supplierName);
	}
	
	@RequestMapping("/server_getSelectWithPage")
	@ResponseBody
	public String server_getSelectWithPage(int rows, int page, String sort){
		return service.server_getSelectWithPage(rows, page, sort);
	}
}
