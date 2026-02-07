package com.catering.catering_hub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.relational.core.mapping.Column;

@Entity
@Table(name = "userMaster")
public class UserInfoModel {

    @Id
    @Column(value = "USER_ID")
    private Integer userId;
    @Column(value = "USER_NAME")
    private String userName;
    @Column(value = "USER_MOBILE")
    private String userMobile;
    @Column(value = "USER_EMAIL")
    private String userMail;
    @Column(value = "USER_ADDRESS")
    private String userAddress;
    @Column(value = "CREATED_BY")
    private String createdBy;
    @Column(value = "CREATED_DATE")
    private String createdDate;
    @Column(value = "USER_ROLE")
    private Integer userRole;
    @Column(value = "USER_PRODUCT_TYPE")
    private Integer userProductType;
    @Column(value = "USER_PASSWORD")
    private String userPassword;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserProductType() {
        return userProductType;
    }

    public void setUserProductType(Integer userProductType) {
        this.userProductType = userProductType;
    }

    public UserInfoModel() {
    }

    public UserInfoModel(Integer userId, String userName, String userMobile, String userMail, String userAddress, String createdBy, String createdDate, Integer userRole, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userMobile = userMobile;
        this.userMail = userMail;
        this.userAddress = userAddress;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.userRole = userRole;
        this.userPassword = userPassword;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
