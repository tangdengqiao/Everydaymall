package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;
import com.everydaymall.mapper.CommodityTypeMapper;
import com.everydaymall.service.ICommodityTypeService;

@Service
public class CommodityTypeServiceImpl implements ICommodityTypeService{
	
	private Logger LOGGER = LoggerFactory.getLogger(CommodityTypeServiceImpl.class);
	
	@Autowired
	private CommodityTypeMapper commodityTypeMapper;
	
	/**
	 * 首页获取3个商品类型
	 * @return
	 */
	@Override
	public List<CommodityType> listCommodityType() {
		try {
			List<CommodityType> listCommodityType = commodityTypeMapper.listCommodityType();
			return listCommodityType;
		} catch (Exception e) {
			LOGGER.info("CommodityTypeServiceImpl    listCommodity  查询异常----" + e.toString());
			return null;
		}
	}

}
