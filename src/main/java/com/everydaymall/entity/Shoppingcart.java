package com.everydaymall.entity;

import java.io.Serializable;

public class Shoppingcart implements Serializable{
	
	private static final long serialVersionUID = 1869112051196416263L;

	private Integer idIndex;

    private String idShoppingcart;

    private String shoppingcartCreateby;

    private String shoppingcartCreatetime;

    private String idCommodity;

    private Float shoppingcartPrice;

    private Integer shoppingcartNumber;

    public Shoppingcart(Integer idIndex, String idShoppingcart, String shoppingcartCreateby, String shoppingcartCreatetime, String idCommodity, Float shoppingcartPrice, Integer shoppingcartNumber) {
        this.idIndex = idIndex;
        this.idShoppingcart = idShoppingcart;
        this.shoppingcartCreateby = shoppingcartCreateby;
        this.shoppingcartCreatetime = shoppingcartCreatetime;
        this.idCommodity = idCommodity;
        this.shoppingcartPrice = shoppingcartPrice;
        this.shoppingcartNumber = shoppingcartNumber;
    }

    public Shoppingcart() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdShoppingcart() {
        return idShoppingcart;
    }

    public void setIdShoppingcart(String idShoppingcart) {
        this.idShoppingcart = idShoppingcart;
    }

    public String getShoppingcartCreateby() {
        return shoppingcartCreateby;
    }

    public void setShoppingcartCreateby(String shoppingcartCreateby) {
        this.shoppingcartCreateby = shoppingcartCreateby;
    }

    public String getShoppingcartCreatetime() {
        return shoppingcartCreatetime;
    }

    public void setShoppingcartCreatetime(String shoppingcartCreatetime) {
        this.shoppingcartCreatetime = shoppingcartCreatetime;
    }

    public String getIdCommodity() {
        return idCommodity;
    }

    public void setIdCommodity(String idCommodity) {
        this.idCommodity = idCommodity;
    }

    public Float getShoppingcartPrice() {
        return shoppingcartPrice;
    }

    public void setShoppingcartPrice(Float shoppingcartPrice) {
        this.shoppingcartPrice = shoppingcartPrice;
    }

    public Integer getShoppingcartNumber() {
        return shoppingcartNumber;
    }

    public void setShoppingcartNumber(Integer shoppingcartNumber) {
        this.shoppingcartNumber = shoppingcartNumber;
    }

	@Override
	public String toString() {
		return "Shoppingcart [idIndex=" + idIndex + ", idShoppingcart=" + idShoppingcart + ", shoppingcartCreateby="
				+ shoppingcartCreateby + ", shoppingcartCreatetime=" + shoppingcartCreatetime + ", idCommodity="
				+ idCommodity + ", shoppingcartPrice=" + shoppingcartPrice + ", shoppingcartNumber="
				+ shoppingcartNumber + "]";
	}
    
    
}