package com.catering.catering_hub.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customersMaster")
public class CustomerInfoModel {

    public CustomerInfoModel(Integer customerId, String customerMobile, String customerName, String customerEmail, Integer createdBy, String customerAddress, String createdDate) {
        this.customerId = customerId;
        this.customerMobile = customerMobile;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.createdBy = createdBy;
        this.customerAddress = customerAddress;
        this.createdDate = createdDate;
    }

    public CustomerInfoModel() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerMobile() {
        return customerMobile;
    }

    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Id
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Column(name = "CUST_NAME")
    private String customerName;
    @Column(name = "CUST_MOBILE")
    private String customerMobile;
    @Column(name = "CUST_EMAIL")
    private String customerEmail;
    @Column(name = "CUST_ADDRESS")
    private String customerAddress;
    @Column(name = "CREATED_BY")
    private Integer createdBy;
    @Column(name = "CREATE_DATE")
    private String createdDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerInfoModel that = (CustomerInfoModel) o;
        return Objects.equals(getCustomerId(), that.getCustomerId()) && Objects.equals(getCustomerName(), that.getCustomerName()) && Objects.equals(getCustomerMobile(), that.getCustomerMobile()) && Objects.equals(getCustomerEmail(), that.getCustomerEmail()) && Objects.equals(getCustomerAddress(), that.getCustomerAddress()) && Objects.equals(getCreatedBy(), that.getCreatedBy()) && Objects.equals(getCreatedDate(), that.getCreatedDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getCustomerName(), getCustomerMobile(), getCustomerEmail(), getCustomerAddress(), getCreatedBy(), getCreatedDate());
    }

    @Override
    public String toString() {
        return "CustomerInfoModel{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
