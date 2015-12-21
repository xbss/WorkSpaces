package com.sxb.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.entity.Good;
import com.sxb.entity.GoodType;
import com.sxb.service.GoodService;
import com.sxb.service.GoodTypeService;
/**
 *  
 * @author 小小镔
 * @Title 点击查看商品的详情
 */
public class GoodDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GoodService goodService = new GoodService();
	GoodTypeService goodTypeService = new  GoodTypeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("商品详细信息：" + req.getParameter("goodid"));
		ArrayList<Good> goodQueryList = new ArrayList<Good>();
		ArrayList<GoodType> goodTypeList = new ArrayList<GoodType>();
		goodQueryList = goodService.getGoodsByCondition("goodid",
				(String) req.getParameter("goodid"));
		goodTypeList = goodTypeService.getAllGoodTypes();
		
		req.removeAttribute("goodList");
		req.setAttribute("goodQueryList", goodQueryList);
		req.removeAttribute("goodTypeList");
		req.setAttribute("goodTypeList", goodTypeList);
		req.getRequestDispatcher("/modules/user/jsp/index.jsp").forward(req, resp);
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
