package com.xbss.entity.purchasePlanBikeBatch;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 采购计划批次表
 */
public class PurchasePlanBikeBatch{
	
	@ID
	private String  pPBikeBatchId;
	private String pPId;
	private String bikeTypeId;
	private String bikeTypeName;
	private int amount;
	private int carryStatus;
	
	
	public String getPPBikeBatchId() {
		return pPBikeBatchId;
	}	
	
	public void setPPBikeBatchId(String pPBikeBatchId) {
		this.pPBikeBatchId = pPBikeBatchId;
	}
	public String getPPId() {
		return pPId;
	}	
	
	public void setPPId(String pPId) {
		this.pPId = pPId;
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
	public int getAmount() {
		return amount;
	}	
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCarryStatus() {
		return carryStatus;
	}	
	
	public void setCarryStatus(int carryStatus) {
		this.carryStatus = carryStatus;
	}
	
	@Override
	public String toString() {
		return   pPBikeBatchId  + "\t" +  pPId  + "\t" +  bikeTypeId  + "\t" +  bikeTypeName  + "\t" +  amount  + "\t" +  carryStatus  + "\t"  ;
	}
}
