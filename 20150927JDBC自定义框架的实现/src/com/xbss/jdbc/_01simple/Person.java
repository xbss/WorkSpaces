package com.xbss.jdbc._01simple;

public class Person {
	public String pid;
	public String pname;
	public int psex;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPsex() {
		return psex;
	}
	public void setPsex(int psex) {
		this.psex = psex;
	}
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", psex=" + psex
				+ "]";
	}
	
}
