package com.xbss.service.rbCard;

import com.xbss.entity.rbCard.RbCard;

/**
 * @author xbss
 * 一卡通/会员卡
 */
public interface IRbCardService {
	
	public String getById(String cardId);
	
	public String add(RbCard rbCard);
	
	public String deleteById(String cardId);
	
	public String deleteEntities(String[] ids);
	
	public String updatePropByID(RbCard rbCard);
	
	
	public String getWithPage(int rows, int page, String sort, String signUserName);
}
