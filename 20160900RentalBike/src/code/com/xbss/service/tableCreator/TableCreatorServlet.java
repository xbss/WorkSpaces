package com.xbss.service.tableCreator;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Service;

import com.xbss.dao.tableCreator.TableCreatorDao;
import com.xbss.system.classLoader.IClassLoaderTool;
import com.xbss.system.tool.SystemConfig;

@Service
public class TableCreatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		String isCreate = SystemConfig.getSystemPram("createTalbe");
		if (!"true".equals(isCreate)) {
			return;
		}
		
		System.out.println("Create Table!!!");
		IClassLoaderTool classLoader = (IClassLoaderTool) SpringContextHolder
				.getBean("classLoader");
		TableCreatorDao dao = (TableCreatorDao) SpringContextHolder
				.getBean("tableCreatorDao");

		

		String entityPackage = SystemConfig.getSystemPram("entityPath");
		if (entityPackage == null) {
			System.err.println("读取entity所在路径出错,默认使用com.xbss.entity");
			entityPackage = "com.xbss.entity";
		}
		List<Class<?>> classes = classLoader
				.loaderClassInPackage(entityPackage);

		for (Class<?> clazz : classes) {

			String className = clazz.getSimpleName();
//			String i = dao.existsTable(className.toUpperCase());
			String i = dao.existsTable(className);

			if (i == null) {
				Set<String> fieldSqls = new HashSet<String>();
				Field[] fs = clazz.getDeclaredFields();

				/*
				 * //orcal建 表 for(Field f : fs) { Object o =
				 * f.getAnnotation(ID.class); if(o != null) { //该字段为id String
				 * fieldSql = f.getName() +
				 * " varchar(255) NOT NULL PRIMARY KEY ";
				 * fieldSqls.add(fieldSql); } else { String typeName =
				 * f.getType().getName();
				 * if(typeName.equals("java.lang.String")) {
				 * fieldSqls.add(f.getName() + " varchar(255) "); } else
				 * if(typeName.equals("int")) { fieldSqls.add(f.getName() +
				 * " Integer "); } else if(typeName.equals("java.util.Date")) {
				 * fieldSqls.add(f.getName() + " Date "); } else
				 * if(typeName.equals("boolean")) { fieldSqls.add(f.getName() +
				 * " short "); } else if(typeName.equals("double")) {
				 * fieldSqls.add(f.getName() + " double "); } else
				 * if(typeName.equals("float")) { fieldSqls.add(f.getName() +
				 * " float "); }else if(typeName.equals("long")) {
				 * fieldSqls.add(f.getName() + " long "); } else {
				 * System.out.println(f.getName() + "类型无法识别，默认使用字符串");
				 * fieldSqls.add(f.getName() + "  varchar(255)  "); } } }
				 */

				for (Field f : fs) {
					Object o = f.getAnnotation(ID.class);
					if (o != null) { // 该字段为id
						String fieldSql = f.getName()
								+ " varchar(255) NOT NULL PRIMARY KEY ";
						fieldSqls.add(fieldSql);
					} else {
						String typeName = f.getType().getName();
						if (typeName.equals("java.lang.String")) {
							fieldSqls.add(f.getName() + " varchar(255) ");
						} else if (typeName.equals("int")
								|| typeName.equals("java.lang.Integer")) {
							fieldSqls.add(f.getName() + " Integer ");
						} else if (typeName.equals("java.util.Date")) {
							fieldSqls.add(f.getName() + " datetime ");
						} else if (typeName.equals("boolean")) {
							fieldSqls.add(f.getName() + " bit ");
						} else if (typeName.equals("double")
								|| typeName.equals("java.lang.Double")) {
							fieldSqls.add(f.getName() + " double ");
						} else if (typeName.equals("float")
								|| typeName.equals("java.lang.Float")) {
							fieldSqls.add(f.getName() + " float ");
						} else if (typeName.equals("long")
								|| typeName.equals("java.lang.long")) {
							fieldSqls.add(f.getName() + " bigint ");
						} else {
							System.out.println(f.getName() + "类型无法识别，默认使用字符串");
							fieldSqls.add(f.getName() + "  varchar(255)  ");
						}
					}
				}

				dao.createTable(className, fieldSqls);
			}
		}
	}
}
