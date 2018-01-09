package com.xbss.entity.bikeInfo;

import java.util.Date;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 自行车信息
 */
public class BikeInfo{
	
	@ID
	private String  bikeId;
	private String purchasePlanId;
	private String pPBikeBatchId;
	private String recyclePlanId;
	private String bikeTypeId;
	private String bikeTypeName;
	private String appearanceInfo;
	private String storageId;
	private Date inStorageTime;
	private Date outStorageTime;
	private double price;
	private int state;
	private int rentalState;
	private String barCode;
	
	
	public String getBikeId() {
		return bikeId;
	}	
	
	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
	}
	public String getPurchasePlanId() {
		return purchasePlanId;
	}	
	
	public void setPurchasePlanId(String purchasePlanId) {
		this.purchasePlanId = purchasePlanId;
	}
	public String getPPBikeBatchId() {
		return pPBikeBatchId;
	}	
	
	public void setPPBikeBatchId(String pPBikeBatchId) {
		this.pPBikeBatchId = pPBikeBatchId;
	}
	public String getRecyclePlanId() {
		return recyclePlanId;
	}	
	
	public void setRecyclePlanId(String recyclePlanId) {
		this.recyclePlanId = recyclePlanId;
	}
	public String getBikeTypeId() {
		return bikeTypeId;
	}	
	
	public void setBikeTypeId(String bikeTypeId) {
		this.bikeTypeId = bikeTypeId;
	}
	public String getBikeTypeName() {
		return bikeTypeName;
	}	
	
	public void setBikeTypeName(String bikeTypeName) {
		this.bikeTypeName = bikeTypeName;
	}
	public String getAppearanceInfo() {
		return appearanceInfo;
	}	
	
	public void setAppearanceInfo(String appearanceInfo) {
		this.appearanceInfo = appearanceInfo;
	}
	public String getStorageId() {
		return storageId;
	}	
	
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public Date getInStorageTime() {
		return inStorageTime;
	}	
	
	public void setInStorageTime(Date inStorageTime) {
		this.inStorageTime = inStorageTime;
	}
	public Date getOutStorageTime() {
		return outStorageTime;
	}	
	
	public void setOutStorageTime(Date outStorageTime) {
		this.outStorageTime = outStorageTime;
	}
	public double getPrice() {
		return price;
	}	
	
	public void setPrice(double price) {
		this.price = price;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public int getRentalState() {
		return rentalState;
	}	
	
	public void setRentalState(int rentalState) {
		this.rentalState = rentalState;
	}
	public String getBarCode() {
		return barCode;
	}	
	
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}
	
	@Override
	public String toString() {
		return   bikeId  + "\t" +  purchasePlanId  + "\t" +  pPBikeBatchId  + "\t" +  recyclePlanId  + "\t" +  bikeTypeId  + "\t" +  bikeTypeName  + "\t" +  appearanceInfo  + "\t" +  storageId  + "\t" +  inStorageTime  + "\t" +  outStorageTime  + "\t" +  price  + "\t" +  state  + "\t" +  rentalState  + "\t" +  barCode  + "\t"  ;
	}
}
