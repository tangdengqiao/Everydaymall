package com.everydaymall.entity;

public class Users {
    private Integer idIndex;

    private String idUser;

    private String userName;

    private String userPwd;

    private String salt;

    private Integer locked;

    private Float userMoney;

    private String userHeadportrait;

    private String userPhonenumber;

    private String userCreatetime;

    private String idIdentity;

    private Integer userState;

    public Users(Integer idIndex, String idUser, String userName, String userPwd, String salt, Integer locked, Float userMoney, String userHeadportrait, String userPhonenumber, String userCreatetime, String idIdentity, Integer userState) {
        this.idIndex = idIndex;
        this.idUser = idUser;
        this.userName = userName;
        this.userPwd = userPwd;
        this.salt = salt;
        this.locked = locked;
        this.userMoney = userMoney;
        this.userHeadportrait = userHeadportrait;
        this.userPhonenumber = userPhonenumber;
        this.userCreatetime = userCreatetime;
        this.idIdentity = idIdentity;
        this.userState = userState;
    }

    public Users() {
        super();
    }

    public Integer getIdIndex() {
        return idIndex;
    }

    public void setIdIndex(Integer idIndex) {
        this.idIndex = idIndex;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    public Float getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(Float userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserHeadportrait() {
        return userHeadportrait;
    }

    public void setUserHeadportrait(String userHeadportrait) {
        this.userHeadportrait = userHeadportrait;
    }

    public String getUserPhonenumber() {
        return userPhonenumber;
    }

    public void setUserPhonenumber(String userPhonenumber) {
        this.userPhonenumber = userPhonenumber;
    }

    public String getUserCreatetime() {
        return userCreatetime;
    }

    public void setUserCreatetime(String userCreatetime) {
        this.userCreatetime = userCreatetime;
    }

    public String getIdIdentity() {
        return idIdentity;
    }

    public void setIdIdentity(String idIdentity) {
        this.idIdentity = idIdentity;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

	@Override
	public String toString() {
		return "Users [idIndex=" + idIndex + ", idUser=" + idUser + ", userName=" + userName + ", userPwd=" + userPwd
				+ ", salt=" + salt + ", locked=" + locked + ", userMoney=" + userMoney + ", userHeadportrait="
				+ userHeadportrait + ", userPhonenumber=" + userPhonenumber + ", userCreatetime=" + userCreatetime
				+ ", idIdentity=" + idIdentity + ", userState=" + userState + "]";
	}
    
    
    
}