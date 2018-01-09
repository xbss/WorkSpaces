package com.xbss.entity.purchasePlan;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 采购计划
 */
public class PurchasePlan{
	
	@ID
	private String  pPId;
	private String pPInfo;
	private String operatorId;
	private String operatorName;
	private double totalPrice;
	
	
	public String getPPId() {
		return pPId;
	}	
	
	public void setPPId(String pPId) {
		this.pPId = pPId;
	}
	public String getPPInfo() {
		return pPInfo;
	}	
	
	public void setPPInfo(String pPInfo) {
		this.pPInfo = pPInfo;
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
	public double getTotalPrice() {
		return totalPrice;
	}	
	
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return   pPId  + "\t" +  pPInfo  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  totalPrice  + "\t"  ;
	}
}
