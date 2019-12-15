package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.entity.Comment;
import com.everydaymall.mapper.CommentMapper;
import com.everydaymall.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	
	private Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<Comment> listComment(String idCommodity) {
		try {
			List<Comment> listComment = commentMapper.listComment(idCommodity);
			return listComment;
		} catch (Exception e) {
			LOGGER.info("ShoppingcartServiceImpl    selectShoppingcart  查询异常----" + e.toString());
			return null;
		}
	}
	
}
