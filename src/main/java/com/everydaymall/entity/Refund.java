package com.everydaymall.entity;

import java.io.Serializable;

public class Refund implements Serializable {

	private static final long serialVersionUID = -8278091896046056985L;

	private Integer idIndex;

	private String idRefund;

	private String idOrder;

	private String idUser;

	private String idCommodity;

	private Float refundMoney;

	private String refundReason;

	private String refundLaunchtime;

	private String refundTime;

	private Integer refundState;

	public Refund(Integer idIndex, String idRefund, String idOrder, String idUser, String idCommodity,
			Float refundMoney, String refundReason, String refundLaunchtime, String refundTime, Integer refundState) {
		this.idIndex = idIndex;
		this.idRefund = idRefund;
		this.idOrder = idOrder;
		this.idUser = idUser;
		this.idCommodity = idCommodity;
		this.refundMoney = refundMoney;
		this.refundReason = refundReason;
		this.refundLaunchtime = refundLaunchtime;
		this.refundTime = refundTime;
		this.refundState = refundState;
	}

	public Refund() {
		super();
	}

	public Integer getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(Integer idIndex) {
		this.idIndex = idIndex;
	}

	public String getIdRefund() {
		return idRefund;
	}

	public void setIdRefund(String idRefund) {
		this.idRefund = idRefund;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public String getIdCommodity() {
		return idCommodity;
	}

	public void setIdCommodity(String idCommodity) {
		this.idCommodity = idCommodity;
	}

	public Float getRefundMoney() {
		return refundMoney;
	}

	public void setRefundMoney(Float refundMoney) {
		this.refundMoney = refundMoney;
	}

	public String getRefundReason() {
		return refundReason;
	}

	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

	public String getRefundLaunchtime() {
		return refundLaunchtime;
	}

	public void setRefundLaunchtime(String refundLaunchtime) {
		this.refundLaunchtime = refundLaunchtime;
	}

	public String getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(String refundTime) {
		this.refundTime = refundTime;
	}

	public Integer getRefundState() {
		return refundState;
	}

	public void setRefundState(Integer refundState) {
		this.refundState = refundState;
	}

	@Override
	public String toString() {
		return "Refund [idIndex=" + idIndex + ", idRefund=" + idRefund + ", idOrder=" + idOrder + ", idUser=" + idUser
				+ ", idCommodity=" + idCommodity + ", refundMoney=" + refundMoney + ", refundReason=" + refundReason
				+ ", refundLaunchtime=" + refundLaunchtime + ", refundTime=" + refundTime + ", refundState="
				+ refundState + "]";
	}

}