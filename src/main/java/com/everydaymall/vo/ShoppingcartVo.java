package com.everydaymall.vo;

import java.io.Serializable;

import com.everydaymall.entity.Shoppingcart;

public class ShoppingcartVo extends Shoppingcart implements Serializable{

	private static final long serialVersionUID = -5899229875055000597L;
	
	private String commodityName;
	
	private String commodityPicture;
	
	private String commodityDescribe;

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
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
	
	public ShoppingcartVo() {
	}

	public ShoppingcartVo(Integer idIndex, String idShoppingcart, String shoppingcartCreateby,
			String shoppingcartCreatetime, String idCommodity, Float shoppingcartPrice, Integer shoppingcartNumber) {
		super(idIndex, idShoppingcart, shoppingcartCreateby, shoppingcartCreatetime, idCommodity, shoppingcartPrice,
				shoppingcartNumber);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ShoppingcartVo [commodityName=" + commodityName + ", commodityPicture=" + commodityPicture
				+ ", commodityDescribe=" + commodityDescribe + "]";
	}
	
	

}
