package com.everydaymall.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everydaymall.common.constants.Constants;
import com.everydaymall.entity.Comment;
import com.everydaymall.mapper.CommentMapper;
import com.everydaymall.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService{
	
	private Logger LOGGER = LoggerFactory.getLogger(CommentServiceImpl.class);
	
	@Autowired
	private CommentMapper commentMapper;

	/**
	 * 根据idCommodity查询评论
	 */
	@Override
	public List<Comment> listComment(String idCommodity) {
		try {
			List<Comment> listComment = commentMapper.listComment(idCommodity);
			return listComment;
		} catch (Exception e) {
			LOGGER.info("CommentServiceImpl    listComment  查询异常----" + e.toString());
			return null;
		}
	}

	/**
	 * 根据idCommodity查询评论数量
	 */
	@Override
	public int selectCommentNumber(String idCommodity) {
		try {
			return commentMapper.selectCommentNumber(idCommodity);
		} catch (Exception e) {
			LOGGER.info("CommentServiceImpl    selectCommentNumber  查询异常----" + e.toString());
		}
		return Constants.SAVEREGISTER_SUCESS;
	}
	
}
