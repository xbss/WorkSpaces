package com.sxb.entity;

public class User {
	private String USERID;
	private String NAME;  // 真实名字
	private String LOGINNAME;
	private String PASSWORD;
	private int SEX;
	private String BIRTH;
	private String PHONE;
	private String EMAIL;
	private String ADDRESS;
	private String MAIL;
	private int TYPE;  // 1：普通用户， 0：VIP用户
	private String PHOTO;
	private double money; // 用户余额
	public User() {
	}
	public String getUSERID() {
		return USERID;
	}
	public void setUSERID(String uSERID) {
		USERID = uSERID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getLOGINNAME() {
		return LOGINNAME;
	}
	public void setLOGINNAME(String lOGINNAME) {
		LOGINNAME = lOGINNAME;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getSEX() {
		return SEX;
	}
	public void setSEX(int sEX) {
		SEX = sEX;
	}
	public String getBIRTH() {
		return BIRTH;
	}
	public void setBIRTH(String bIRTH) {
		BIRTH = bIRTH;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	public String getADDRESS() {
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}
	public String getMAIL() {
		return MAIL;
	}
	public void setMAIL(String mAIL) {
		MAIL = mAIL;
	}
	public int getTYPE() {
		return TYPE;
	}
	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}
	public String getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(String pHOTO) {
		PHOTO = pHOTO;
	}
	
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "User [USERID=" + USERID + ", NAME=" + NAME + ", LOGINNAME="
				+ LOGINNAME + ", PASSWORD=" + PASSWORD + ", SEX=" + SEX
				+ ", BIRTH=" + BIRTH + ", PHONE=" + PHONE + ", EMAIL=" + EMAIL
				+ ", ADDRESS=" + ADDRESS + ", MAIL=" + MAIL + ", TYPE=" + TYPE
				+ ", PHOTO=" + PHOTO + ", money=" + money + "]";
	}
	
	
}
