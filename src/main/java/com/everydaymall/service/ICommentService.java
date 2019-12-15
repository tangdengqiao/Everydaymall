package com.everydaymall.service;

import java.util.List;

import com.everydaymall.entity.Comment;

public interface ICommentService {
	
	 /**
     * 根据商品ID查询评论
     * @param idComment
     * @return
     */
    List<Comment> listComment(String idCommodity);

}
