package com.xbss.entity.rentalBikeHistory;

import java.util.Date;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 车辆租借记录
 */
public class RentalBikeHistory{
	
	@ID
	private String  rentalId;
	private String bikeId;
	private String userId;
	private String userName;
	private String operatorId;
	private String operatorName;
	private Date startTime;
	private Date endTime;
	private String rentalTime;
	private double rentalPrice;
	private int state;
	private int damage;
	
	
	public String getRentalId() {
		return rentalId;
	}	
	
	public void setRentalId(String rentalId) {
		this.rentalId = rentalId;
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
	public Date getStartTime() {
		return startTime;
	}	
	
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}	
	
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getRentalTime() {
		return rentalTime;
	}	
	
	public void setRentalTime(String rentalTime) {
		this.rentalTime = rentalTime;
	}
	public double getRentalPrice() {
		return rentalPrice;
	}	
	
	public void setRentalPrice(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public int getDamage() {
		return damage;
	}	
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	@Override
	public String toString() {
		return   rentalId  + "\t" +  bikeId  + "\t" +  userId  + "\t" +  userName  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  startTime  + "\t" +  endTime  + "\t" +  rentalTime  + "\t" +  rentalPrice  + "\t" +  state  + "\t" +  damage  + "\t"  ;
	}
}
