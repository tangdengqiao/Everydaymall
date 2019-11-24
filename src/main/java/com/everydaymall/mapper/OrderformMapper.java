package com.everydaymall.mapper;

import com.everydaymall.entity.Orderform;

public interface OrderformMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Orderform record);

    int insertSelective(Orderform record);

    Orderform selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Orderform record);

    int updateByPrimaryKey(Orderform record);
}