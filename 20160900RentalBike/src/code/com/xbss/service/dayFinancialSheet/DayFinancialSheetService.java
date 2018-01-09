package com.xbss.service.dayFinancialSheet;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import  com.xbss.dao.dayFinancialSheet.DayFinancialSheetDao;

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
