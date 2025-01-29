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
    private List<SessionsJsonModel> sessionsJsonModel;

    @Override
    public String toString() {
        return "CateringOrdersJsonModel{" +
                "customerId='" + customerId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", eventNote='" + eventNote + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", sessionsModel=" + sessionsJsonModel +
                '}';
    }

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
}
