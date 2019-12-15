package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.CommodityType;

public interface ICommodityTypeService {

	/**
	 * 首页获取3个商品类型
	 * 
	 * @return
	 */
	List<CommodityType> listCommodityTypeLimit();
	
	/**
	 * 获取所有类别
	 * @return
	 */
    List<CommodityType> listCommodityType();
    
    /**
     * 根据类别IdType查询类别名称
     * @param IdType
     * @return
     */
    String selectTypeNameIdType(String IdType);

}
