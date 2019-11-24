package com.everydaymall.entity;

import java.io.Serializable;

public class Orderform implements Serializable {

	private static final long serialVersionUID = -6268917271775138610L;

	private Integer idIndex;

	private String idOrder;

	private String orderNumbers;

	private String idShoppingcart;

	private String idUser;

	private String idCommodity;

	private String orderCreatetime;

	private Float orderPrice;

	private String orderAddress;

	private Integer orderState;

	public Orderform(Integer idIndex, String idOrder, String orderNumbers, String idShoppingcart, String idUser,
			String idCommodity, String orderCreatetime, Float orderPrice, String orderAddress, Integer orderState) {
		this.idIndex = idIndex;
		this.idOrder = idOrder;
		this.orderNumbers = orderNumbers;
		this.idShoppingcart = idShoppingcart;
		this.idUser = idUser;
		this.idCommodity = idCommodity;
		this.orderCreatetime = orderCreatetime;
		this.orderPrice = orderPrice;
		this.orderAddress = orderAddress;
		this.orderState = orderState;
	}

	public Orderform() {
		super();
	}

	public Integer getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(Integer idIndex) {
		this.idIndex = idIndex;
	}

	public String getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(String idOrder) {
		this.idOrder = idOrder;
	}

	public String getOrderNumbers() {
		return orderNumbers;
	}

	public void setOrderNumbers(String orderNumbers) {
		this.orderNumbers = orderNumbers;
	}

	public String getIdShoppingcart() {
		return idShoppingcart;
	}

	public void setIdShoppingcart(String idShoppingcart) {
		this.idShoppingcart = idShoppingcart;
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

	public String getOrderCreatetime() {
		return orderCreatetime;
	}

	public void setOrderCreatetime(String orderCreatetime) {
		this.orderCreatetime = orderCreatetime;
	}

	public Float getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Float orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public Integer getOrderState() {
		return orderState;
	}

	public void setOrderState(Integer orderState) {
		this.orderState = orderState;
	}

	@Override
	public String toString() {
		return "Orderform [idIndex=" + idIndex + ", idOrder=" + idOrder + ", orderNumbers=" + orderNumbers
				+ ", idShoppingcart=" + idShoppingcart + ", idUser=" + idUser + ", idCommodity=" + idCommodity
				+ ", orderCreatetime=" + orderCreatetime + ", orderPrice=" + orderPrice + ", orderAddress="
				+ orderAddress + ", orderState=" + orderState + "]";
	}

}