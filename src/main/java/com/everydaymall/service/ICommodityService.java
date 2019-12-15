package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.Commodity;

public interface ICommodityService {
	/**
	 * 首页展示商品
	 * @param commodityName
	 * @return
	 */
	List<Commodity> listCommodity(String commodityName);
	
	/**
	 * 根据idIndex查询商品的详情
	 * @param idIndex
	 * @return
	 */
	Commodity selectCommodityIdIndex(Integer idIndex);
	
	/**
	 * 根据商品idCommodity查询商品
	 * @param idCommodity
	 * @return
	 */
	Commodity selectCommodityIdCommodity(String idCommodity);
}
