package com.sxb.entity;

import java.util.ArrayList;
/**
 * 
 * @author 小小镔
 * @Title 服务器上的文件管理
 */
public class SystemFile {
	private String ID;
	private String NAME;
	private String OWERID;
	private String TYPE;
	private String FILESIZE;
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getOWERID() {
		return OWERID;
	}
	public void setOWERID(String oWERID) {
		OWERID = oWERID;
	}
	public String getTYPE() {
		return TYPE;
	}
	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}
	public String getFILESIZE() {
		return FILESIZE;
	}
	public void setFILESIZE(String fILESIZE) {
		FILESIZE = fILESIZE;
	}
	@Override
	public String toString() {
		return "SystemFile [ID=" + ID + ", NAME=" + NAME + ", OWERID=" + OWERID
				+ ", TYPE=" + TYPE + ", FILESIZE=" + FILESIZE + "]";
	}
	// 文件管理 method
	public int DeleteFileByCondition(String name, String value) {
		return 0;
	}

	public ArrayList<SystemFile> getAllGoods() {
		return null;
	}

	public ArrayList<SystemFile> getGoodsByCondition(String name, String value) {
		return null;
	}
	public int EditFile(SystemFile systemFile){
		return 0;
	}
}
