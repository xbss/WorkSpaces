package com.sxb.entity;

public class Good {
	private String GOODID;
	private String USERID;
	private String NAME;
	private String AUTHOR;
	private String ISBN;
	private double PRICE;
	private String PUBLISHER;
	private String GOODTYPEID;
	private String DESCRIPTION;
	private String MAINPIC;
	private long STOCK; // 库存
	private long SALES; // 销量
	public Good() {
	}
	public String getGOODID() {
		return GOODID;
	}
	public void setGOOGID(String gOODID) {
		GOODID = gOODID;
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
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public double getPRICE() {
		return PRICE;
	}
	public void setPRICE(double pRICE) {
		PRICE = pRICE;
	}
	public String getPUBLISHER() {
		return PUBLISHER;
	}
	public void setPUBLISHER(String pUBLISHER) {
		PUBLISHER = pUBLISHER;
	}
	public String getGOODTYPEID() {
		return GOODTYPEID;
	}
	public void setGOODTYPEID(String gOODTYPEID) {
		GOODTYPEID = gOODTYPEID;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getMAINPIC() {
		return MAINPIC;
	}
	public void setMAINPIC(String mAINPIC) {
		MAINPIC = mAINPIC;
	}
	public long getSTOCK() {
		return STOCK;
	}
	public void setSTOCK(long sTOCK) {
		STOCK = sTOCK;
	}
	public long getSALES() {
		return SALES;
	}
	public void setSALES(long sALES) {
		SALES = sALES;
	}
	@Override
	public String toString() {
		return "Good [GOOGID=" + GOODID + ", USERID=" + USERID + ", NAME="
				+ NAME + ", AUTHOR=" + AUTHOR + ", ISBN=" + ISBN + ", PRICE="
				+ PRICE + ", PUBLISHER=" + PUBLISHER + ", GOODTYPEID=" + GOODTYPEID
				+ ", DESCRIPTION=" + DESCRIPTION + ", MAINPIC=" + MAINPIC
				+ ", STOCK=" + STOCK + ", SALES=" + SALES + "]";
	}
	
	
}
