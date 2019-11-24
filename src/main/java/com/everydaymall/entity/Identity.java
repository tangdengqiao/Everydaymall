package com.everydaymall.entity;

import java.io.Serializable;

public class Identity implements Serializable{
	
	private static final long serialVersionUID = -521609705491578941L;

	private Integer idIndex;

    private String idIdentity;

    private String identityName;

    private String identityDescribe;

    public Identity(Integer idIndex, String idIdentity, String identityName, String identityDescribe) {
        this.idIndex = idIndex;
        this.idIdentity = idIdentity;
        this.identityName = identityName;
        this.identityDescribe = identityDescribe;
    }

    public Identity() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdIdentity() {
        return idIdentity;
    }

    public void setIdIdentity(String idIdentity) {
        this.idIdentity = idIdentity;
    }

    public String getIdentityName() {
        return identityName;
    }

    public void setIdentityName(String identityName) {
        this.identityName = identityName;
    }

    public String getIdentityDescribe() {
        return identityDescribe;
    }

    public void setIdentityDescribe(String identityDescribe) {
        this.identityDescribe = identityDescribe;
    }

	@Override
	public String toString() {
		return "Identity [idIndex=" + idIndex + ", idIdentity=" + idIdentity + ", identityName=" + identityName
				+ ", identityDescribe=" + identityDescribe + "]";
	}
    
    
}