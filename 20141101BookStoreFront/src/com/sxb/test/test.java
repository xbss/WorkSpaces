package com.sxb.test;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.sxb.entity.Good;
import com.sxb.entity.GoodType;
import com.sxb.entity.Operator;
import com.sxb.entity.User;
import com.sxb.service.GoodService;
import com.sxb.service.GoodTypeService;
import com.sxb.service.IService;
import com.sxb.service.OperatorService;
import com.sxb.service.UserService;
import com.sxb.tool.IDFactory;
import com.sxb.tool.SysConfig;
import com.sxb.tool.SysDateFormat;

public class test {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*for (int i = 0; i < 7; i++) {
			System.out.println(IDFactory.createId());
		}*/
		
		/*String file  = "http:localhost:8080/BookStore/user/jsp/index.jsp";
		int index = file.indexOf("BookStore");
		System.out.println(file.substring(index).replace("BookStore/", ""));*/
		
		/*IService iService;
		iService = new OperatorService();
		iService.uploadPhoto("", "");
		iService = new UserService();
		iService.uploadPhoto("", "");*/
		/*OperatorService operatorService = new OperatorService();
		Operator operator = new Operator();
		operator.setOPERATORID(IDFactory.createId());
		operator.setLOGINNAME("123");
		operator.setNAME("4564");
		operator.setPASSWORD("123");
		operator.setPERMISSION(0);
		operator.setPHOTO("1231321");*/
		/*System.out.println(operatorService.AddOperator(operator));*/
		/*System.out.println(operatorService.DeleteOperatorByCondition("operatorid", "20141229213734933"));*/
		
		// 商品测试
		/*GoodService goodService = new GoodService();
		Good object = new Good();
		object.setAUTHOR("author");
		object.setDESCRIPTION(("description"));
		object.setGOODTYPEID(("20141229162750158"));
		object.setGOOGID(("gdfoodisddssdsdssdsfd4s566"));
		object.setISBN(("isbn"));
		object.setMAINPIC(("modules/user/image/good/10.jpg"));
		object.setNAME(("name56dssdfdsssssf4dsd6"));
		object.setPRICE(5.00);
		object.setPUBLISHER(("publisher"));
		object.setSALES(500);
		object.setSTOCK(500);
		object.setUSERID(("20141229144845082"));
		System.out.println("GOODSERVICE getall " + object.toString());
		System.out.println(goodService.AddGood(object));*/
		
		// 商品测试 模糊查询
		/*GoodService goodService = new GoodService();
		List<Good> list = goodService.fuzzyQuery("author", "author");
		for (Good good : list) {
			System.out.println(good.toString());
		}*/
		
		// 商品测试 模糊查询
		GoodService goodService = new GoodService();
		List<Good> list = goodService.getGoodsByCondition("goodtypeid", "20141229162750161");
				for (Good good : list) {
					System.out.println(good.toString());
				}
		
		/*// 商品类型 测试
		GoodTypeService goodTypeService = new GoodTypeService();
		List<GoodType> list = goodTypeService.getAllGoodTypes();
		for (GoodType goodType : list) {
			System.out.println(goodType.getNAME());
		}*/
		
		/*String requestURL = "http://localhost/BookStore/modules/user/jsp";
		boolean isAdminPages = requestURL.contains("/modules/admin") || requestURL.contains("Admin");
		System.out.println(isAdminPages);*/
				
		// 测试用户注册
		Date date =new Date(new java.util.Date("1992/4/5").getTime());
		String string = "1994-5-6";
		System.out.println();
		User user = new User();
		user.setADDRESS("重庆理工大学");
		user.setBIRTH(new Date(new java.util.Date("1994/5/2").getTime()).toString());
		user.setEMAIL("1360303452@qq.com");
		user.setLOGINNAME("longhang");
		user.setMAIL("401254");
		user.setNAME("龙行");
		user.setPASSWORD("123");
		user.setPHONE("13452155441");
		user.setPHOTO("modules/user/image/head.jpg");
		user.setSEX(0);
		user.setTYPE(1);
		user.setUSERID(IDFactory.createId());
		UserService userService = new UserService();
		/*List<User> list2 = userService.getAllUsers();
		for (User user2 : list2) {
			System.out.println(user2.toString());
		}*/
		/*System.out.println(userService.getUsersByCondition("userid", "20150109212905998"));*/
		
		// 测试编辑信息
		user.setADDRESS("重庆理工大学");
		user.setBIRTH(new Date(new java.util.Date("1994/5/2").getTime()).toString());
		user.setEMAIL("1360303452@qq.com");
		user.setLOGINNAME("long4hang");
		user.setMAIL("401254");
		user.setNAME("上官清月");
		user.setPASSWORD("123");
		user.setPHONE("13452155441");
		user.setPHOTO("modules/user/image/head.jpg");
		user.setSEX(0);
		user.setTYPE(1);
		user.setUSERID("20150112005533564");
		UserService userService1 = new UserService();
		System.out.println("fanhui: "+ userService1.EditUser(user));
		
	}

}
