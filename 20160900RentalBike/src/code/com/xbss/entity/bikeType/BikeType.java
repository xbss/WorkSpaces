package com.xbss.entity.bikeType;

import java.util.Date;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 自行车车型
 */
public class BikeType{
	
	@ID
	private String  bikeTypeId;
	private String supplierId;
	private String supplierName;
	private String bikeTypeName;
	private Date createTime;
	private double price;
	
	
	public String getBikeTypeId() {
		return bikeTypeId;
	}	
	
	public void setBikeTypeId(String bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}
	public String getSupplierId() {
		return supplierId;
	}	
	
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}	
	
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getBikeTypeName() {
		return bikeTypeName;
	}	
	
	public void setBikeTypeName(String bikeTypeName) {
		this.bikeTypeName = bikeTypeName;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getPrice() {
		return price;
	}	
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return   bikeTypeId  + "\t" +  supplierId  + "\t" +  supplierName  + "\t" +  bikeTypeName  + "\t" +  createTime  + "\t" +  price  + "\t"  ;
	}
}
