package com.sxb.dto;

import java.util.List;
import java.util.Map;

import com.sxb.entity.User;


// 用于封装用户权限
public class UserPermission {
	private User user;
	private List<Map<String, Object>> permissionsList;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Map<String, Object>> getPermissionsList() {
		return permissionsList;
	}
	public void setPermissionsList(List<Map<String, Object>> permissionsList) {
		this.permissionsList = permissionsList;
	}
	@Override
	public String toString() {
		return "UserPermission [user=" + user + ", permissionsList="
				+ permissionsList + "]";
	}
	
}
