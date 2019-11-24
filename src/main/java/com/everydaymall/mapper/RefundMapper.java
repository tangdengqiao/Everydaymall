package com.everydaymall.mapper;

import com.everydaymall.entity.Refund;

public interface RefundMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Refund record);

    int insertSelective(Refund record);

    Refund selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Refund record);

    int updateByPrimaryKey(Refund record);
}