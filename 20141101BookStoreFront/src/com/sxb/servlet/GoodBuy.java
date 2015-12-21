package com.sxb.servlet;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxb.entity.Good;
import com.sxb.service.GoodService;
import com.sxb.service.GoodTypeService;
import com.sxb.service.UserService;

public class GoodBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserService();
	GoodService goodService = new GoodService();
	GoodTypeService goodTypeService = new GoodTypeService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("DEBUG--->进入购买商品流程");
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("DEBUG--->进入购买商品流程");
		// 检测参数是否满足条件
		processArgs(req);
		// 执行购物流程
					System.out.println("执行购物流程");
					com.sxb.entity.User user = userService.getUsersByCondition("userid", req.getParameter("USERID")).get(0);
					Good good = goodService.getGoodsByCondition("goodid", req.getParameter("GOODID")).get(0);
		if (!req.getAttribute("warring").equals("")) {
			
			System.out.println("数据库操作");
			user.setMoney(user.getMoney() - Double.parseDouble(req.getParameter("PRICE")));
			good.setSTOCK(good.getSTOCK() - Long.parseLong(req.getParameter("STOCK")));
		} else{
			
		}
		//
		int flag1 = -1;
		int flag2 = -1;
		//
		try {
			flag1= userService.EditUser(user);
			flag2 =goodService.EditGood(good);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 
		if (flag1 > 0 && flag2 > 0) {
			addWarring(req, req.getParameter("GOODID"), "购买成功");
			req.getRequestDispatcher("GoodDetail?goodid=" + req.getParameter("GOODID")).forward(req, resp);
		} else {
			req.getRequestDispatcher("GoodDetail?goodid=" + req.getParameter("GOODID")).forward(req, resp);
		}
	}
	// 检测参数
	public void processArgs(HttpServletRequest request) throws ServletException, IOException{
		try {
			// 
			String USERID = request.getParameter("USERID");
			String GOODID = request.getParameter("GOODID");
			double PRICE = Double.parseDouble(request.getParameter("PRICE"));
			System.out.println("余额：" + PRICE);
			long STOCK = Long.parseLong(request.getParameter("STOCK"));
			String goodBuyNumber1 = request.getParameter("goodBuyNumber");
			if (goodBuyNumber1 != null) {
				long goodBuyNumber = Long.parseLong(goodBuyNumber1);
				if (goodBuyNumber <= 0) {
					addWarring(request, GOODID, "你还没有输入购书的数量");
				}
			} else {
				addWarring(request, GOODID, "你还没有输入购书的数量");
			}
			// 
			com.sxb.entity.User user = userService.getUsersByCondition("userid", USERID).get(0);
			
			if (USERID == null ) {
				addWarring(request, GOODID, "用户没有登陆");
			}
			if (PRICE >= user.getMoney()) {
				addWarring(request, GOODID, "你的余额不足");
			}
			if (STOCK <= 0) {
				addWarring(request, GOODID, "库存不足");
			}
		} catch (Exception e) {
			addWarring(request, request.getParameter("GOODID"), "信息出错");
			e.printStackTrace();
		}
	}
	// 信息
	public void addWarring(HttpServletRequest request, String GOODID, String warring) throws ServletException, IOException{
		request.setAttribute("warring", warring);
		System.out.println("warring : " + warring);
		/*request.getRequestDispatcher("GoodDetail?goodid=" + GOODID).forward(request, response);*/
		/*response.sendRedirect("GoodDetail?goodid=" + GOODID );*/
	}
	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}
}
