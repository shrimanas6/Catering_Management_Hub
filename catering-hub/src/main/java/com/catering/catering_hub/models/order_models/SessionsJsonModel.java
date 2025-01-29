package com.catering.catering_hub.models.order_models;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionsJsonModel {


    private Integer sessionId;
    private String orderId;
    private String sessionName;
    private String sessionBeginTime;
    private String sessionEndTime;
    private String sessionDescription;
    private Integer sessionQuantity;

    private String eventDate;
    private String eventLocation;
    private String eventAddress;

    private Integer createdBy;
    private String createdDate;
    private String modifiedDate;
    private Integer modifiedBy;

    private List<SessionItemsJsonModel> sessionItemsJsonModels;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getSessionBeginTime() {
        return sessionBeginTime;
    }

    public void setSessionBeginTime(String sessionBeginTime) {
        this.sessionBeginTime = sessionBeginTime;
    }

    public String getSessionEndTime() {
        return sessionEndTime;
    }

    public void setSessionEndTime(String sessionEndTime) {
        this.sessionEndTime = sessionEndTime;
    }

    public String getSessionDescription() {
        return sessionDescription;
    }

    public void setSessionDescription(String sessionDescription) {
        this.sessionDescription = sessionDescription;
    }

    public Integer getSessionQuantity() {
        return sessionQuantity;
    }

    public void setSessionQuantity(Integer sessionQuantity) {
        this.sessionQuantity = sessionQuantity;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
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

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public List<SessionItemsJsonModel> getSessionItemsJsonModels() {
        return sessionItemsJsonModels;
    }

    public void setSessionItemsJsonModels(List<SessionItemsJsonModel> sessionItemsJsonModels) {
        this.sessionItemsJsonModels = sessionItemsJsonModels;
    }

    @Override
    public String toString() {
        return "sessionsJsonModel{" +
                "sessionId=" + sessionId +
                ", orderId='" + orderId + '\'' +
                ", sessionName='" + sessionName + '\'' +
                ", sessionBeginTime='" + sessionBeginTime + '\'' +
                ", sessionEndTime='" + sessionEndTime + '\'' +
                ", sessionDescription='" + sessionDescription + '\'' +
                ", sessionQuantity=" + sessionQuantity +
                ", eventDate='" + eventDate + '\'' +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventAddress='" + eventAddress + '\'' +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", modifiedBy=" + modifiedBy +
                ", sessionItemsModelList=" + sessionItemsJsonModels +
                '}';
    }
}
