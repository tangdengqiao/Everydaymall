package com.everydaymall.entity;

public class Collection {
    private Integer idIndex;

    private String idCollection;

    private String idUser;

    private String idCommodity;

    private String collectionCreatetime;

    public Collection(Integer idIndex, String idCollection, String idUser, String idCommodity, String collectionCreatetime) {
        this.idIndex = idIndex;
        this.idCollection = idCollection;
        this.idUser = idUser;
        this.idCommodity = idCommodity;
        this.collectionCreatetime = collectionCreatetime;
    }

    public Collection() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdCollection() {
        return idCollection;
    }

    public void setIdCollection(String idCollection) {
        this.idCollection = idCollection;
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

    public String getCollectionCreatetime() {
        return collectionCreatetime;
    }

    public void setCollectionCreatetime(String collectionCreatetime) {
        this.collectionCreatetime = collectionCreatetime;
    }

	@Override
	public String toString() {
		return "Collection [idIndex=" + idIndex + ", idCollection=" + idCollection + ", idUser=" + idUser
				+ ", idCommodity=" + idCommodity + ", collectionCreatetime=" + collectionCreatetime + "]";
	}
    
    
    
}