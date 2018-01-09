package com.xbss.controller.dayFinancialSheet;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xbss.service.dayFinancialSheet.IDayFinancialSheetService;

/**
 * @author xbss
 * 日财务表
 */
@Controller
@RequestMapping("/dayFinancialSheetController")
public class DayFinancialSheetController{
	
	@Resource(name="dayFinancialSheetService")
	IDayFinancialSheetService service;
}
