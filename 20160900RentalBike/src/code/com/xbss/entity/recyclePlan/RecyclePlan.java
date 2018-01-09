package com.xbss.entity.recyclePlan;


import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 回收计划表
 */
public class RecyclePlan{
	
	@ID
	private String  rPId;
	private String rPInfo;
	private String operatorId;
	private String operatorName;
	private String pPBikeBatchIds;
	private double evaluation;
	private double totalPrice;
	private int carryStatus;
	
	
	public String getRPId() {
		return rPId;
	}	
	
	public void setRPId(String rPId) {
		this.rPId = rPId;
	}
	public String getRPInfo() {
		return rPInfo;
	}	
	
	public void setRPInfo(String rPInfo) {
		this.rPInfo = rPInfo;
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
	public double getEvaluation() {
		return evaluation;
	}	
	
	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
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
		return   rPId  + "\t" +  rPInfo  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  pPBikeBatchIds  + "\t" +  evaluation  + "\t" +  totalPrice  + "\t" +  carryStatus  + "\t"  ;
	}
}
