package com.everydaymall.mapper;

import com.everydaymall.entity.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}