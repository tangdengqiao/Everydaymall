package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;

public interface ICommodityTypeService {
	
	/**
	 * 首页获取3个商品类型
	 * @return
	 */
    List<CommodityType> listCommodityType();

}
