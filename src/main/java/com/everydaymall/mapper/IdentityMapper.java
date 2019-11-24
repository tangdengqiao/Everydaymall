package com.everydaymall.mapper;

import com.everydaymall.entity.Identity;

public interface IdentityMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Identity record);

    int insertSelective(Identity record);

    Identity selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Identity record);

    int updateByPrimaryKey(Identity record);
}