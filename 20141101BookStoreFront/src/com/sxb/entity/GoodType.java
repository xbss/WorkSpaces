package com.sxb.entity;

public class GoodType {
	private String GOODTYPEID;
	private String NAME;
	public GoodType() {
		
	}
	public String getGOODTYPEID() {
		return GOODTYPEID;
	}
	public void setGOODTYPEID(String gOODTYPEID) {
		GOODTYPEID = gOODTYPEID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@Override
	public String toString() {
		return "GoodType [GOODTYPEID=" + GOODTYPEID + ", NAME=" + NAME + "]";
	}
	
}
