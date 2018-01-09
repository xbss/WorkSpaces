package com.xbss.controller.yearFinancialSheet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xbss.service.yearFinancialSheet.IYearFinancialSheetService;

/**
 * @author xbss
 * 年财务
 */
@Controller
@RequestMapping("/yearFinancialSheetController")
public class YearFinancialSheetController{
	
	@Resource(name="yearFinancialSheetService")
	IYearFinancialSheetService service;
}
