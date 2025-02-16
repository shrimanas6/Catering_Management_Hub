package com.catering.catering_hub.models.order_models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CateringOrdersJsonModel {

    private String customerId;
    private String orderId;
    private String eventNote;
    private Integer createdBy;
    private String createdDate;

    private String customerName;
    private String customerMobile;
    private String customerAddress;
    private String customerEmail;
    private String customerCreateDate;
    private Integer customerCreatedBy;

    private List<SessionsJsonModel> sessionsJsonModel;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEventNote() {
        return eventNote;
    }

    public void setEventNote(String eventNote) {
        this.eventNote = eventNote;
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

    public List<SessionsJsonModel> getSessionsJsonModel() {
        return sessionsJsonModel;
    }

    public void setSessionsJsonModel(List<SessionsJsonModel> sessionsJsonModel) {
        this.sessionsJsonModel = sessionsJsonModel;
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

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerCreateDate() {
        return customerCreateDate;
    }

    public void setCustomerCreateDate(String customerCreateDate) {
        this.customerCreateDate = customerCreateDate;
    }

    public Integer getCustomerCreatedBy() {
        return customerCreatedBy;
    }

    public void setCustomerCreatedBy(Integer customerCreatedBy) {
        this.customerCreatedBy = customerCreatedBy;
    }

    @Override
    public String toString() {
        return "CateringOrdersJsonModel{" +
                "customerId='" + customerId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", eventNote='" + eventNote + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", sessionsJsonModel=" + sessionsJsonModel +
                ", customerName='" + customerName + '\'' +
                ", customerMobile='" + customerMobile + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerCreateDate='" + customerCreateDate + '\'' +
                ", customerCreatedBy=" + customerCreatedBy +
                '}';
    }
}
