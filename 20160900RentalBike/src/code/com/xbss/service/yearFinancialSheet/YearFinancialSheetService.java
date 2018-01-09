package com.xbss.service.yearFinancialSheet;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import com.xbss.system.tool.EntityIDFactory;

import  com.xbss.dao.yearFinancialSheet.YearFinancialSheetDao;
import  com.xbss.entity.yearFinancialSheet.YearFinancialSheet;

/**
 * @author xbss
 * 年财务
 */
@Service
public class YearFinancialSheetService extends SearchService implements IYearFinancialSheetService{
	
	@Resource(name="yearFinancialSheetDao")
	YearFinancialSheetDao dao ;

	@Override
	public String getBaseEntityName() {
		return "yearFinancialSheet";
	}

	@Override
	public String getBasePrimaryKey() {
		return "yearFinancialSheet.yFSId";
	}
	
}
