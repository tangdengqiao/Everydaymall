package com.everydaymall.mapper;

import com.everydaymall.entity.Shoppingcart;

public interface ShoppingcartMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Shoppingcart record);

    int insertSelective(Shoppingcart record);

    Shoppingcart selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Shoppingcart record);

    int updateByPrimaryKey(Shoppingcart record);
}