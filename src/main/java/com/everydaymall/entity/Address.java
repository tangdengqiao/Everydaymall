package com.everydaymall.entity;

import java.io.Serializable;

public class Address implements Serializable{
	
	private static final long serialVersionUID = 8925282920413309002L;

	private Integer idIndex;

    private String idAddress;

    private String addressCreateby;

    private String addressCratetime;

    private String addressName;

    private String addressDetailed;

    public Address(Integer idIndex, String idAddress, String addressCreateby, String addressCratetime, String addressName, String addressDetailed) {
        this.idIndex = idIndex;
        this.idAddress = idAddress;
        this.addressCreateby = addressCreateby;
        this.addressCratetime = addressCratetime;
        this.addressName = addressName;
        this.addressDetailed = addressDetailed;
    }

    public Address() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getAddressCreateby() {
        return addressCreateby;
    }

    public void setAddressCreateby(String addressCreateby) {
        this.addressCreateby = addressCreateby;
    }

    public String getAddressCratetime() {
        return addressCratetime;
    }

    public void setAddressCratetime(String addressCratetime) {
        this.addressCratetime = addressCratetime;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressDetailed() {
        return addressDetailed;
    }

    public void setAddressDetailed(String addressDetailed) {
        this.addressDetailed = addressDetailed;
    }

	@Override
	public String toString() {
		return "Address [idIndex=" + idIndex + ", idAddress=" + idAddress + ", addressCreateby=" + addressCreateby
				+ ", addressCratetime=" + addressCratetime + ", addressName=" + addressName + ", addressDetailed="
				+ addressDetailed + "]";
	}
    
}