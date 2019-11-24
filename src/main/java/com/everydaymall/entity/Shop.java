package com.everydaymall.entity;

import java.io.Serializable;

public class Shop implements Serializable {

	private static final long serialVersionUID = 5327894341934512062L;

	private Integer idIndex;

	private String idShop;

	private String shopName;

	private String shopLog;

	private String shopCreateby;

	private String shopCreatetime;

	private String shopDescribe;

	private Integer shopState;

	public Shop(Integer idIndex, String idShop, String shopName, String shopLog, String shopCreateby,
			String shopCreatetime, String shopDescribe, Integer shopState) {
		this.idIndex = idIndex;
		this.idShop = idShop;
		this.shopName = shopName;
		this.shopLog = shopLog;
		this.shopCreateby = shopCreateby;
		this.shopCreatetime = shopCreatetime;
		this.shopDescribe = shopDescribe;
		this.shopState = shopState;
	}

	public Shop() {
		super();
	}

	public Integer getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(Integer idIndex) {
		this.idIndex = idIndex;
	}

	public String getIdShop() {
		return idShop;
	}

	public void setIdShop(String idShop) {
		this.idShop = idShop;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLog() {
		return shopLog;
	}

	public void setShopLog(String shopLog) {
		this.shopLog = shopLog;
	}

	public String getShopCreateby() {
		return shopCreateby;
	}

	public void setShopCreateby(String shopCreateby) {
		this.shopCreateby = shopCreateby;
	}

	public String getShopCreatetime() {
		return shopCreatetime;
	}

	public void setShopCreatetime(String shopCreatetime) {
		this.shopCreatetime = shopCreatetime;
	}

	public String getShopDescribe() {
		return shopDescribe;
	}

	public void setShopDescribe(String shopDescribe) {
		this.shopDescribe = shopDescribe;
	}

	public Integer getShopState() {
		return shopState;
	}

	public void setShopState(Integer shopState) {
		this.shopState = shopState;
	}

	@Override
	public String toString() {
		return "Shop [idIndex=" + idIndex + ", idShop=" + idShop + ", shopName=" + shopName + ", shopLog=" + shopLog
				+ ", shopCreateby=" + shopCreateby + ", shopCreatetime=" + shopCreatetime + ", shopDescribe="
				+ shopDescribe + ", shopState=" + shopState + "]";
	}

}