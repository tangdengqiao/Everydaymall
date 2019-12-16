package com.everydaymall.mapper;

import java.util.List;

import com.everydaymall.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer idIndex);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer idIndex);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    /**
     * 根据idCommodity查询评论
     * @param idComment
     * @return
     */
    List<Comment> listComment(String idCommodity);
    
    /**
     * 根据idCommodity查询评论数量
     * @param idCommodity
     * @return
     */
    int selectCommentNumber(String idCommodity);
} 