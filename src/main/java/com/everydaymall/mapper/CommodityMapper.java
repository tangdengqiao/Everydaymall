package com.everydaymall.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.everydaymall.entity.Commodity;

public interface CommodityMapper {
	int deleteByPrimaryKey(Integer idIndex);

	int insert(Commodity record);

	int insertSelective(Commodity record);

	Commodity selectByPrimaryKey(Integer idIndex);

	int updateByPrimaryKeySelective(Commodity record);

	int updateByPrimaryKey(Commodity record);

	/**
	 * 首页展示商品
	 * 
	 * @param commodityName
	 * @return
	 */
	List<Commodity> listCommodity(@Param(value = "commodityName") String commodityName);
	
	/**
	 * 根据商品ID查询商品
	 * @param idCommodity
	 * @return
	 */
	Commodity selectCommodityIdCommodity(String idCommodity);
}