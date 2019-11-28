package com.everydaymall.mapper;

import com.everydaymall.entity.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}