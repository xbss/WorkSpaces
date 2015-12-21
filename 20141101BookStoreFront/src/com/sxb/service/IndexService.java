package com.sxb.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.dao.Dao;
import com.sxb.dto.GoodTypeGood;
import com.sxb.entity.Good;
import com.sxb.entity.GoodType;

/**
 * 
 * @author 小小镔
 * @Title 处理数据查询
 */
public class IndexService {
	public Dao dao = new Dao();
	GoodService goodService = new GoodService();
	GoodTypeService goodTypeService = new GoodTypeService();

	// 首页初始化
	public int indexInit(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		ArrayList<Good> goodList = new ArrayList<Good>();
		// 查询所有的商品类型
		goodTypeList = goodTypeService.getAllGoodTypes();
		// 查询所有的商品
		goodList = goodService.getAllGoods();
		// 将结果集放入request中
		request.removeAttribute("goodList");
		request.setAttribute("goodList", goodList);
		request.removeAttribute("goodTypeList");
		request.setAttribute("goodTypeList", goodTypeList);
		return 0;
	}

	// 处理首页分类商品的加载
	public int indexGoodTypeQuery(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<Good> goodList = new ArrayList<Good>();
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		goodList = goodService.getGoodsByCondition("goodtypeid",
				(String) request.getParameter("goodtypeid"));
		System.out.println("类型信息：" + (String) request.getParameter("goodtypeid"));
		goodTypeList = goodTypeService.getAllGoodTypes();
		
		
		request.removeAttribute("goodList");
		request.setAttribute("goodList", goodList);
		request.removeAttribute("goodTypeList");
		request.setAttribute("goodTypeList", goodTypeList);
		return 0;
	}

	// 处理首页的信息查询
	public int indexGoodQuery(HttpServletRequest request,
			HttpServletResponse response) {
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		ArrayList<Good> goodList = new ArrayList<Good>();
		goodTypeList = goodTypeService.getAllGoodTypes();
		// 得到查询的关键字
		String goodquery = request.getParameter("goodquery");
		System.out.println("查询的关键字： " + goodquery);
		// 执行查询
		goodList = goodService.fuzzyQuery("name", goodquery);
		goodList.addAll(goodService.fuzzyQuery("goodtypeid", goodquery));
		goodList.addAll(goodService.fuzzyQuery("author", goodquery));
		
		// 清除以前的数据
		request.removeAttribute("goodTypeList");
		request.removeAttribute("goodQueryList");
		// 加入查询的信息数据
		request.setAttribute("goodTypeList", goodTypeList);
		request.setAttribute("goodList", goodList);
		return 0;
	}
}
