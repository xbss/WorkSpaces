package com.sxb.dto;

import java.util.List;
import java.util.Map;

import com.sxb.entity.GoodType;

public class GoodTypeGood {
	private GoodType goodType;
	private List<Map<String, Object>> goods;
	public GoodType getGoodType() {
		return goodType;
	}
	public void setGoodType(GoodType goodType) {
		this.goodType = goodType;
	}
	public List<Map<String, Object>> getGoods() {
		return goods;
	}
	public void setGoods(List<Map<String, Object>> goods) {
		this.goods = goods;
	}
	@Override
	public String toString() {
		return "GoodTypeGood [goodType=" + goodType + ", goods=" + goods + "]";
	}
	
}
