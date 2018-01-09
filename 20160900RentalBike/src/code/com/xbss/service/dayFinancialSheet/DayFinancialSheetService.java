package com.xbss.service.dayFinancialSheet;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import  com.xbss.dao.dayFinancialSheet.DayFinancialSheetDao;
import  com.xbss.entity.dayFinancialSheet.DayFinancialSheet;

/**
 * @author xbss
 * 日财务表
 */
@Service
public class DayFinancialSheetService extends SearchService implements IDayFinancialSheetService{
	
	@Resource(name="dayFinancialSheetDao")
	DayFinancialSheetDao dao ;

	@Override
	public String getBaseEntityName() {
		return "dayFinancialSheet";
	}

	@Override
	public String getBasePrimaryKey() {
		return "dayFinancialSheet.dFSId";
	}
	
}
