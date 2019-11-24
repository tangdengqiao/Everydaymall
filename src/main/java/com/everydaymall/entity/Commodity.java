package com.everydaymall.entity;

import java.io.Serializable;

public class Commodity implements Serializable {

	private static final long serialVersionUID = 4031211081756276206L;

	private Integer idIndex;

	private String idCommodity;

	private String commodityName;

	private String commodityCreateby;

	private String commodityCreatetime;

	private Float commodityPrice;

	private String commodityPicture;

	private String commodityDescribe;

	private String commodityType;

	private Integer commodityState;

	public Commodity(Integer idIndex, String idCommodity, String commodityName, String commodityCreateby,
			String commodityCreatetime, Float commodityPrice, String commodityPicture, String commodityDescribe,
			String commodityType, Integer commodityState) {
		this.idIndex = idIndex;
		this.idCommodity = idCommodity;
		this.commodityName = commodityName;
		this.commodityCreateby = commodityCreateby;
		this.commodityCreatetime = commodityCreatetime;
		this.commodityPrice = commodityPrice;
		this.commodityPicture = commodityPicture;
		this.commodityDescribe = commodityDescribe;
		this.commodityType = commodityType;
		this.commodityState = commodityState;
	}

	public Commodity() {
		super();
	}

	public Integer getIdIndex() {
		return idIndex;
	}

	public void setIdIndex(Integer idIndex) {
		this.idIndex = idIndex;
	}

	public String getIdCommodity() {
		return idCommodity;
	}

	public void setIdCommodity(String idCommodity) {
		this.idCommodity = idCommodity;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityCreateby() {
		return commodityCreateby;
	}

	public void setCommodityCreateby(String commodityCreateby) {
		this.commodityCreateby = commodityCreateby;
	}

	public String getCommodityCreatetime() {
		return commodityCreatetime;
	}

	public void setCommodityCreatetime(String commodityCreatetime) {
		this.commodityCreatetime = commodityCreatetime;
	}

	public Float getCommodityPrice() {
		return commodityPrice;
	}

	public void setCommodityPrice(Float commodityPrice) {
		this.commodityPrice = commodityPrice;
	}

	public String getCommodityPicture() {
		return commodityPicture;
	}

	public void setCommodityPicture(String commodityPicture) {
		this.commodityPicture = commodityPicture;
	}

	public String getCommodityDescribe() {
		return commodityDescribe;
	}

	public void setCommodityDescribe(String commodityDescribe) {
		this.commodityDescribe = commodityDescribe;
	}

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public Integer getCommodityState() {
		return commodityState;
	}

	public void setCommodityState(Integer commodityState) {
		this.commodityState = commodityState;
	}

	@Override
	public String toString() {
		return "Commodity [idIndex=" + idIndex + ", idCommodity=" + idCommodity + ", commodityName=" + commodityName
				+ ", commodityCreateby=" + commodityCreateby + ", commodityCreatetime=" + commodityCreatetime
				+ ", commodityPrice=" + commodityPrice + ", commodityPicture=" + commodityPicture
				+ ", commodityDescribe=" + commodityDescribe + ", commodityType=" + commodityType + ", commodityState="
				+ commodityState + "]";
	}

}