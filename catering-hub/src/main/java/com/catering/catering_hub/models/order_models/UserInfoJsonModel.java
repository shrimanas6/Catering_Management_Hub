package com.catering.catering_hub.models.order_models;

import org.springframework.stereotype.Component;

@Component
public class UserInfoJsonModel {

    private Integer userId;
    private String userName;
    private String userMobile;
    private String userMail;
    private String userAddress;
    private String userPassword;
    private String createdBy;
    private String createdDate;
    private Integer userRole;
    private Integer userProductType;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public Integer getUserProductType() {
        return userProductType;
    }

    public void setUserProductType(Integer userProductType) {
        this.userProductType = userProductType;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserInfoJsonModel{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPassword='"+ userPassword + '\''+
                ", createdBy='" + createdBy + '\'' +
                ", createdDate='" + createdDate + '\'' +
                ", userRole=" + userRole +
                ", userProductType=" + userProductType +
                '}';
    }
}
