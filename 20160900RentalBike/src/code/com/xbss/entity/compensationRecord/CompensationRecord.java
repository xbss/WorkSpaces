package com.xbss.entity.compensationRecord;

import java.util.Date;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 赔偿记录
 */
public class CompensationRecord{
	
	@ID
	private String  cRId;
	private String bikeId;
	private String userId;
	private String userName;
	private String rentalId;
	private double price;
	private String reason;
	private String operatorId;
	private String operatorName;
	private Date cRTime;
	
	
	public String getCRId() {
		return cRId;
	}	
	
	public void setCRId(String cRId) {
		this.cRId = cRId;
	}
	public String getBikeId() {
		return bikeId;
	}	
	
	public void setBikeId(String bikeId) {
		this.bikeId = bikeId;
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
	public String getRentalId() {
		return rentalId;
	}	
	
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
	}
	public double getPrice() {
		return price;
	}	
	
	public void setPrice(double price) {
		this.price = price;
	}
	public String getReason() {
		return reason;
	}	
	
	public void setReason(String reason) {
		this.reason = reason;
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
	public Date getCRTime() {
		return cRTime;
	}	
	
	public void setCRTime(Date cRTime) {
		this.cRTime = cRTime;
	}
	
	@Override
	public String toString() {
		return   cRId  + "\t" +  bikeId  + "\t" +  userId  + "\t" +  userName  + "\t" +  rentalId  + "\t" +  price  + "\t" +  reason  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  cRTime  + "\t"  ;
	}
}
