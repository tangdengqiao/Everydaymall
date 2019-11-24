package com.everydaymall.mapper;

import com.everydaymall.entity.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}