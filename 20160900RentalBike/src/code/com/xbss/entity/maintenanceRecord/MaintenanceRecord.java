package com.xbss.entity.maintenanceRecord;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 维修记录
 */
public class MaintenanceRecord{
	
	@ID
	private String  mRId;
	private String mRInfo;
	private String operatorId;
	private String operatorName;
	private String mPId;
	private String pPBikeBatchIds;
	private int mRtype;
	private String userId;
	private String userName;
	private double totalPrice;
	
	
	public String getMRId() {
		return mRId;
	}	
	
	public void setMRId(String mRId) {
		this.mRId = mRId;
	}
	public String getMRInfo() {
		return mRInfo;
	}	
	
	public void setMRInfo(String mRInfo) {
		this.mRInfo = mRInfo;
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
	public String getMPId() {
		return mPId;
	}	
	
	public void setMPId(String mPId) {
		this.mPId = mPId;
	}
	public String getPPBikeBatchIds() {
		return pPBikeBatchIds;
	}	
	
	public void setPPBikeBatchIds(String pPBikeBatchIds) {
		this.pPBikeBatchIds = pPBikeBatchIds;
	}
	public int getMRtype() {
		return mRtype;
	}	
	
	public void setMRtype(int mRtype) {
		this.mRtype = mRtype;
	}
	public String getUserId() {
		return userId;
	}	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}	
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public double getTotalPrice() {
		return totalPrice;
	}	
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return   mRId  + "\t" +  mRInfo  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  mPId  + "\t" +  pPBikeBatchIds  + "\t" +  mRtype  + "\t" +  userId  + "\t" +  userName  + "\t" +  totalPrice  + "\t"  ;
	}
}
