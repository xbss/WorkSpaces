package com.sxb.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.INEG;
import com.sxb.entity.Good;
import com.sxb.entity.GoodType;
import com.sxb.entity.User;
import com.sxb.service.GoodService;
import com.sxb.service.IndexService;
import com.sxb.tool.SysConfig;
/**
 * 
 * @author 小小镔
 * 默认的首页处理 servlet
 * 处理来自首页的搜索和其他请求 
 */
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 处理业务的 service
	IndexService indexService = new IndexService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String actionType = req.getParameter("actionType");
		System.out.println("首页请求类型：" + actionType);
		if (actionType == null||actionType.equals(""))
			indexInit(req, resp);
		else if(actionType.equals("goodTypeQuery")){
			indexGoodTypeQuery(req, resp);
		};
	}
	
	//处理无action的页面请求
	public void indexInit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		/*User user = new User();
		user.setLOGINNAME("564");
		user.setPASSWORD("sdfsadf");
		user.setNAME("我不是金牛座");
		user.setPHOTO("modules/admin/image/head.jpg");
		System.out.println("首页" + user.toString());
		req.getSession().setAttribute("User", user);*/
		/* List<Good> goodList = new ArrayList<Good>();
			for(int i = 0; i< 25; i++){
				Good good1 = new Good();
			good1.setMAINPIC("modules/user/image/good/5.jpg");
			good1.setNAME("人性的弱点");
			good1.setPRICE(5.00);
			goodList.add(good1);
			}
		System.out.println("首页" + goodList.toString());
		req.setAttribute("goodQueryList", goodList);*/
		
		// 调用相应的业务层处理事务
		indexService.indexInit(req, resp);
		req.getRequestDispatcher("/modules/user/jsp/index.jsp").forward(req, resp);
		/*System.out.println(SysConfig.getRelativeUrl(req, resp));
		req.getRequestDispatcher(SysConfig.getRelativeUrl(req, resp)).forward(req, resp);*/
	}
	// 处理分类加载请求
	public void indexGoodTypeQuery(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		 indexService.indexGoodTypeQuery(req, resp);
		 req.getRequestDispatcher("/modules/user/jsp/index.jsp").forward(req, resp);
	}
	@Override
	public void destroy() {
	}

	@Override
	public void init() throws ServletException {
	}

}
