package com.everydaymall.mapper;

import java.util.List;

import com.everydaymall.entity.CommodityType;

public interface CommodityTypeMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(CommodityType record);

    int insertSelective(CommodityType record);

    CommodityType selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(CommodityType record);

    int updateByPrimaryKey(CommodityType record);
    
    /**
     * 首页获取3个商品类
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