package com.everydaymall.entity;

import java.io.Serializable;

public class CommodityType implements Serializable{
	
	private static final long serialVersionUID = 4801180609148646902L;

	private Integer idIndex;

    private String idType;

    private String typeName;

    private String typeCreateby;

    private String typeCreatetime;

    private String typeDescribe;

    private String typePicture;

    public CommodityType(Integer idIndex, String idType, String typeName, String typeCreateby, String typeCreatetime, String typeDescribe, String typePicture) {
        this.idIndex = idIndex;
        this.idType = idType;
        this.typeName = typeName;
        this.typeCreateby = typeCreateby;
        this.typeCreatetime = typeCreatetime;
        this.typeDescribe = typeDescribe;
        this.typePicture = typePicture;
    }

    public CommodityType() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeCreateby() {
        return typeCreateby;
    }

    public void setTypeCreateby(String typeCreateby) {
        this.typeCreateby = typeCreateby;
    }

    public String getTypeCreatetime() {
        return typeCreatetime;
    }

    public void setTypeCreatetime(String typeCreatetime) {
        this.typeCreatetime = typeCreatetime;
    }

    public String getTypeDescribe() {
        return typeDescribe;
    }

    public void setTypeDescribe(String typeDescribe) {
        this.typeDescribe = typeDescribe;
    }

    public String getTypePicture() {
        return typePicture;
    }

    public void setTypePicture(String typePicture) {
        this.typePicture = typePicture;
    }

	@Override
	public String toString() {
		return "CommodityType [idIndex=" + idIndex + ", idType=" + idType + ", typeName=" + typeName + ", typeCreateby="
				+ typeCreateby + ", typeCreatetime=" + typeCreatetime + ", typeDescribe=" + typeDescribe
				+ ", typePicture=" + typePicture + "]";
	}
    
    
}