package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.Comment;

public interface ICommentService {
	
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
