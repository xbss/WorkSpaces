package com.sxb.entity;

public class Permission {
	private String PERMISSIONID;
	private String NAME;
	public Permission() {
	}
	public String getPERMISSIONID() {
		return PERMISSIONID;
	}
	public void setPERMISSIONID(String pERMISSIONID) {
		PERMISSIONID = pERMISSIONID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@Override
	public String toString() {
		return "Permission [PERMISSIONID=" + PERMISSIONID + ", NAME=" + NAME
				+ "]";
	}
	
	
}
