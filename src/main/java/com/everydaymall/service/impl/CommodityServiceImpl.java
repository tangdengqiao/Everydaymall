package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.entity.Commodity;
import com.everydaymall.mapper.CommodityMapper;
import com.everydaymall.service.ICommodityService;

@Service
public class CommodityServiceImpl implements ICommodityService {

	private Logger LOGGER = LoggerFactory.getLogger(CommodityServiceImpl.class);

	@Autowired
	private CommodityMapper commodityMapper;

	/**
	 * 首页展示商品
	 */
	@Override
	public List<Commodity> listCommodity(String commodityName) {
		try {
			return commodityMapper.listCommodity(commodityName);
		} catch (Exception e) {
			LOGGER.info("CommodityServiceImpl    listCommodity  查询异常----" + e.toString());
			return null;
		}
	}

}
