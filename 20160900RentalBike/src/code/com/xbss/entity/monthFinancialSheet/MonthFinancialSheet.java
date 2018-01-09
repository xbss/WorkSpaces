package com.xbss.entity.monthFinancialSheet;

import java.util.Date;
import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 月财务
 */
public class MonthFinancialSheet{
	
	@ID
	private String  mFSId;
	private Date createTime;
	private double income;
	private double purchaseCosts;
	private double maintenanceCosts;
	private double compensation;
	private double recycleIncomes;
	private double totalIncome;
	private String remarks;
	
	
	public String getMFSId() {
		return mFSId;
	}	
	
	public void setMFSId(String mFSId) {
		this.mFSId = mFSId;
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
		return   mFSId  + "\t" +  createTime  + "\t" +  income  + "\t" +  purchaseCosts  + "\t" +  maintenanceCosts  + "\t" +  compensation  + "\t" +  recycleIncomes  + "\t" +  totalIncome  + "\t" +  remarks  + "\t"  ;
	}
}
