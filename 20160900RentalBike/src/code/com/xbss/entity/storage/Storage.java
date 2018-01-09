package com.xbss.entity.storage;

import java.util.Date;
import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 仓库
 */
public class Storage{
	
	@ID
	private String  storageId;
	private String address;
	private int state;
	private Date createTime;
	private String operatorId;
	private String operatorName;
	private String information;
	
	
	public String getStorageId() {
		return storageId;
	}	
	
	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}
	public String getAddress() {
		return address;
	}	
	
	public void setAddress(String address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
	public String getInformation() {
		return information;
	}	
	
	public void setInformation(String information) {
		this.information = information;
	}
	
	@Override
	public String toString() {
		return   storageId  + "\t" +  address  + "\t" +  state  + "\t" +  createTime  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  information  + "\t"  ;
	}
}
