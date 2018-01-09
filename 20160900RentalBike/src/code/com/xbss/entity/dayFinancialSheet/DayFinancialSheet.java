package com.xbss.entity.dayFinancialSheet;

import java.util.Date;
import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 日财务表
 */
public class DayFinancialSheet{
	
	@ID
	private String  dFSId;
	private Date createTime;
	private double income;
	private double purchaseCosts;
	private double maintenanceCosts;
	private double compensation;
	private double recycleIncomes;
	private double totalIncome;
	private String remarks;
	
	
	public String getDFSId() {
		return dFSId;
	}	
	
	public void setDFSId(String dFSId) {
		this.dFSId = dFSId;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public double getIncome() {
		return income;
	}	
	
	public void setIncome(double income) {
		this.income = income;
	}
	public double getPurchaseCosts() {
		return purchaseCosts;
	}	
	
	public void setPurchaseCosts(double purchaseCosts) {
		this.purchaseCosts = purchaseCosts;
	}
	public double getMaintenanceCosts() {
		return maintenanceCosts;
	}	
	
	public void setMaintenanceCosts(double maintenanceCosts) {
		this.maintenanceCosts = maintenanceCosts;
	}
	public double getCompensation() {
		return compensation;
	}	
	
	public void setCompensation(double compensation) {
		this.compensation = compensation;
	}
	public double getRecycleIncomes() {
		return recycleIncomes;
	}	
	
	public void setRecycleIncomes(double recycleIncomes) {
		this.recycleIncomes = recycleIncomes;
	}
	public double getTotalIncome() {
		return totalIncome;
	}	
	
	public void setTotalIncome(double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public String getRemarks() {
		return remarks;
	}	
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	@Override
	public String toString() {
		return   dFSId  + "\t" +  createTime  + "\t" +  income  + "\t" +  purchaseCosts  + "\t" +  maintenanceCosts  + "\t" +  compensation  + "\t" +  recycleIncomes  + "\t" +  totalIncome  + "\t" +  remarks  + "\t"  ;
	}
}
