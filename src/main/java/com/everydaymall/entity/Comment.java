package com.everydaymall.entity;

import java.io.Serializable;

public class Comment implements Serializable {

	private static final long serialVersionUID = 6008580980379774401L;

	private Integer idIndex;

	private String idComment;

	private String commentCreateby;

	private String commentCreatetime;

	private String idCommodity;

	private String commentContent;

	private String commentPicture;

	public Comment(Integer idIndex, String idComment, String commentCreateby, String commentCreatetime,
			String idCommodity, String commentContent, String commentPicture) {
		this.idIndex = idIndex;
		this.idComment = idComment;
		this.commentCreateby = commentCreateby;
		this.commentCreatetime = commentCreatetime;
		this.idCommodity = idCommodity;
		this.commentContent = commentContent;
		this.commentPicture = commentPicture;
	}

	public Comment() {
		super();
	}

	public Integer getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(Integer idIndex) {
		this.idIndex = idIndex;
	}

	public String getIdComment() {
		return idComment;
	}

	public void setIdComment(String idComment) {
		this.idComment = idComment;
	}

	public String getCommentCreateby() {
		return commentCreateby;
	}

	public void setCommentCreateby(String commentCreateby) {
		this.commentCreateby = commentCreateby;
	}

	public String getCommentCreatetime() {
		return commentCreatetime;
	}

	public void setCommentCreatetime(String commentCreatetime) {
		this.commentCreatetime = commentCreatetime;
	}

	public String getIdCommodity() {
		return idCommodity;
	}

	public void setIdCommodity(String idCommodity) {
		this.idCommodity = idCommodity;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentPicture() {
		return commentPicture;
	}

	public void setCommentPicture(String commentPicture) {
		this.commentPicture = commentPicture;
	}

	@Override
	public String toString() {
		return "Comment [idIndex=" + idIndex + ", idComment=" + idComment + ", commentCreateby=" + commentCreateby
				+ ", commentCreatetime=" + commentCreatetime + ", idCommodity=" + idCommodity + ", commentContent="
				+ commentContent + ", commentPicture=" + commentPicture + "]";
	}

}