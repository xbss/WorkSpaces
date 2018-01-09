package com.xbss.entity.maintenancePlan;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 维修计划
 */
public class MaintenancePlan{
	
	@ID
	private String  mPId;
	private String mPInfo;
	private String operatorId;
	private String operatorName;
	private String pPBikeBatchIds;
	private double totalPrice;
	private int carryStatus;
	
	
	public String getMPId() {
		return mPId;
	}	
	
	public void setMPId(String mPId) {
		this.mPId = mPId;
	}
	public String getMPInfo() {
		return mPInfo;
	}	
	
	public void setMPInfo(String mPInfo) {
		this.mPInfo = mPInfo;
	}
	public String getOperatorId() {
		return operatorId;
	}	
	
	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorName() {
		return operatorName;
	}	
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
	public String getPPBikeBatchIds() {
		return pPBikeBatchIds;
	}	
	
	public void setPPBikeBatchIds(String pPBikeBatchIds) {
		this.pPBikeBatchIds = pPBikeBatchIds;
	}
	public double getTotalPrice() {
		return totalPrice;
	}	
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getCarryStatus() {
		return carryStatus;
	}	
	
	public void setCarryStatus(int carryStatus) {
		this.carryStatus = carryStatus;
	}
	
	@Override
	public String toString() {
		return   mPId  + "\t" +  mPInfo  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  pPBikeBatchIds  + "\t" +  totalPrice  + "\t" +  carryStatus  + "\t"  ;
	}
}
