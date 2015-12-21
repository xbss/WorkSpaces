package com.sxb.entity;

import java.util.Date;



public class OrderForm {
	private String ORDERFORMID;
	private String USERID;
	private String GOODID;
	private double PRICE;
	private Date ORDERTIME;
	private Date PAYMENTTIME;
	private Date FINISHTIME;
	public OrderForm() {
	}
	public String getORDERFORMID() {
		return ORDERFORMID;
	}
	public void setORDERFORMID(String oRDERFORMID) {
		ORDERFORMID = oRDERFORMID;
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getGOODID() {
		return GOODID;
	}
	public void setGOODID(String gOODID) {
		GOODID = gOODID;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	public Date getORDERTIME() {
		return ORDERTIME;
	}
	public void setORDERTIME(Date oRDERTIME) {
		ORDERTIME = oRDERTIME;
	}
	public Date getPAYMENTTIME() {
		return PAYMENTTIME;
	}
	public void setPAYMENTTIME(Date pAYMENTTIME) {
		PAYMENTTIME = pAYMENTTIME;
	}
	public Date getFINISHTIME() {
		return FINISHTIME;
	}
	public void setFINISHTIME(Date fINISHTIME) {
		FINISHTIME = fINISHTIME;
	}
	@Override
	public String toString() {
		return "OrderForm [ORDERFORMID=" + ORDERFORMID + ", USERID=" + USERID
				+ ", GOODID=" + GOODID + ", PRICE=" + PRICE + ", ORDERTIME="
				+ ORDERTIME + ", PAYMENTTIME=" + PAYMENTTIME + ", FINISHTIME="
				+ FINISHTIME + "]";
	}
	
}
