package com.everydaymall.service;

import java.util.List;


import com.everydaymall.entity.Commodity;

public interface ICommodityService {
	/**
     * 首页展示商品
     * @param currentPage
     * @param pageSize
     * @param commodity
     * @return
     */
    List<Commodity> listCommodity(String commodityName);
}
