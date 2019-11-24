package com.everydaymall.mapper;

import com.everydaymall.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}