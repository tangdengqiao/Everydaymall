package com.everydaymall.mapper;

import java.util.List;

import com.everydaymall.entity.Commodity;
import com.everydaymall.entity.CommodityType;

public interface CommodityTypeMapper {
    
   /**
    * 首页获取3个商品类
    * @return
    */
    List<CommodityType> listCommodityType();
}