package com.xbss.controller.baseControllers;
import java.util.Date;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * 项目名称：RentalBike 自行车租赁收费系统
 * 类名称：BaseController
 * 创建人：xbss
 * 创建时间：2015-12-15 下午9:00:10
 * 备注：  更新和完善转换器类
 * @version 1.0
 * 
 */
public abstract class BaseController {
	@InitBinder    
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(double.class, new DoubleEditor());
		binder.registerCustomEditor(float.class, new FloatEditor());
		binder.registerCustomEditor(int.class, new IntegerEditor());
		binder.registerCustomEditor(long.class, new LongEditor());
	}   
}
