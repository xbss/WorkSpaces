package com.xbss.service.monthFinancialSheet;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.xbss.service.search.SearchService;
import  com.xbss.dao.monthFinancialSheet.MonthFinancialSheetDao;

/**
 * @author xbss
 * 月财务
 */
@Service
public class MonthFinancialSheetService extends SearchService implements IMonthFinancialSheetService{
	
	@Resource(name="monthFinancialSheetDao")
	MonthFinancialSheetDao dao ;

	@Override
	public String getBaseEntityName() {
		return "monthFinancialSheet";
	}

	@Override
	public String getBasePrimaryKey() {
		return "monthFinancialSheet.mFSId";
	}
	
}
