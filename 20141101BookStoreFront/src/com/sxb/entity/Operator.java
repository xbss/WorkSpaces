package com.sxb.entity;

public class Operator {
	private String OPERATORID;
	private String NAME;
	private String LOGINNAME;
	private String PASSWORD;
	private int PERMISSION;
	private String PHOTO;
	public Operator() {
	}
	public String getOPERATORID() {
		return OPERATORID;
	}
	public void setOPERATORID(String oPERATORID) {
		OPERATORID = oPERATORID;
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
	public int getPERMISSION() {
		return PERMISSION;
	}
	public void setPERMISSION(int pERMISSION) {
		PERMISSION = pERMISSION;
	}
	public String getPHOTO() {
		return PHOTO;
	}
	public void setPHOTO(String pHOTO) {
		PHOTO = pHOTO;
	}
	@Override
	public String toString() {
		return "Operator [OPERATORID=" + OPERATORID + ", NAME=" + NAME
				+ ", LOGINNAME=" + LOGINNAME + ", PASSWORD=" + PASSWORD
				+ ", PERMISSION=" + PERMISSION + ", PHOTO=" + PHOTO + "]";
	}
	
	
	
}
