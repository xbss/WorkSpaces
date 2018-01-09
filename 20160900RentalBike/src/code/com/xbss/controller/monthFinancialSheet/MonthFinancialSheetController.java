package com.xbss.controller.monthFinancialSheet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xbss.service.monthFinancialSheet.IMonthFinancialSheetService;

/**
 * @author xbss
 * 月财务
 */
@Controller
@RequestMapping("/monthFinancialSheetController")
public class MonthFinancialSheetController{
	
	@Resource(name="monthFinancialSheetService")
	IMonthFinancialSheetService service;
}
