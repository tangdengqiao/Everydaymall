package com.everydaymall.mapper;

import com.everydaymall.entity.Shop;

public interface ShopMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}