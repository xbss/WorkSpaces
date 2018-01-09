package com.xbss.entity.rbCard;

import java.util.Date;

import com.xbss.service.tableCreator.ID;

/**
 * @author xbss
 * 一卡通/会员卡
 */
public class RbCard{
	
	@ID
	private String  cardId;
	private Date signTime;
	private String signUserId;
	private String signUserName;
	private int level;
	private double discount;
	private String operatorId;
	private String operatorName;
	private int state;
	
	
	public String getCardId() {
		return cardId;
	}	
	
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public Date getSignTime() {
		return signTime;
	}	
	
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	public String getSignUserId() {
		return signUserId;
	}	
	
	public void setSignUserId(String signUserId) {
		this.signUserId = signUserId;
	}
	public String getSignUserName() {
		return signUserName;
	}	
	
	public void setSignUserName(String signUserName) {
		this.signUserName = signUserName;
	}
	public int getLevel() {
		return level;
	}	
	
	public void setLevel(int level) {
		this.level = level;
	}
	public double getDiscount() {
		return discount;
	}	
	
	public void setDiscount(double discount) {
		this.discount = discount;
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
	public int getState() {
		return state;
	}	
	
	public void setState(int state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return   cardId  + "\t" +  signTime  + "\t" +  signUserId  + "\t" +  signUserName  + "\t" +  level  + "\t" +  discount  + "\t" +  operatorId  + "\t" +  operatorName  + "\t" +  state  + "\t"  ;
	}
}
