package com.sxb.service;

import java.util.ArrayList;

import com.sxb.dao.Dao;

/**
 * 
 * @author 小小镔
 * @Title 只要是需要上传文件的entity，就实现这个接口
 */
public interface IService {
	public Dao dao = new Dao();
	// 图片
	public boolean uploadPhoto(String ID, String photoPath);
	public boolean downloadPhoto(String ID, String photoPath);
	// 文件
	public boolean uploadFile(String ID, String filePath);
	public boolean downloadFile(String ID, String filePath);
	// 增···删···查···改 方法
	/*public int Add(Object object);
	public int DeleteByCondition(String name, String value);
	public ArrayList<Object> getAll();
	public ArrayList<Object> getByCondition(String name, String value);*/
}
