package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.entity.CommodityType;
import com.everydaymall.mapper.CommodityTypeMapper;
import com.everydaymall.service.ICommodityTypeService;

@Service
public class CommodityTypeServiceImpl implements ICommodityTypeService {

	private Logger LOGGER = LoggerFactory.getLogger(CommodityTypeServiceImpl.class);

	@Autowired
	private CommodityTypeMapper commodityTypeMapper;

	/**
	 * 首页获取3个商品类型
	 * 
	 * @return
	 */
	@Override
	public List<CommodityType> listCommodityTypeLimit() {
		try {
			List<CommodityType> listCommodityTypeLimit = commodityTypeMapper.listCommodityTypeLimit();
			return listCommodityTypeLimit;
		} catch (Exception e) {
			LOGGER.info("CommodityTypeServiceImpl    listCommodityTypeLimit  查询异常----" + e.toString());
			return null;
		}
	}

	/**
	 * 获取所有类别
	 */
	@Override
	public List<CommodityType> listCommodityType() {
		try {
			List<CommodityType> listCommodityTypeLimit = commodityTypeMapper.listCommodityType();
			return listCommodityTypeLimit;
		} catch (Exception e) {
			LOGGER.info("CommodityTypeServiceImpl    listCommodityType  查询异常----" + e.toString());
			return null;
		}
	}

	/**
	 * 根据类别IdType查询类别名称
	 */
	@Override
	public CommodityType selectTypeNameIdType(String IdType) {
		try {
			return commodityTypeMapper.selectTypeNameIdType(IdType);
		} catch (Exception e) {
			LOGGER.info("CommodityTypeServiceImpl    selectTypeNameIdType  查询异常----" + e.toString());
			return null;
		}
	}

}
