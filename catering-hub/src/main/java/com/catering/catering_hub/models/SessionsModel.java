package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "sessions_table")
public class SessionsModel {

    @Id
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_begin_time")
    private String sessionBeginTime;
    @Column(name = "session_end_time")
    private String sessionEndTime;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_quantity")
    private Integer sessionQuantity;

    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "event_date")
    private String eventDate;
    @Column(name = "event_location")
    private String eventLocation;
    @Column(name = "event_address")
    private String eventAddress;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "modified_date")
    private String modifiedDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;

    public SessionsModel(Integer sessionId, Integer orderId, String sessionName, String sessionBeginTime, String sessionEndTime, String sessionDescription, Integer sessionQuantity, Integer customerId, String eventDate, String eventLocation, String eventAddress, Integer createdBy, String createdDate, String modifiedDate, Integer modifiedBy) {
        this.sessionId = sessionId;
        this.orderId = orderId;
        this.sessionName = sessionName;
        this.sessionBeginTime = sessionBeginTime;
        this.sessionEndTime = sessionEndTime;
        this.sessionDescription = sessionDescription;
        this.sessionQuantity = sessionQuantity;
        this.customerId = customerId;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventAddress = eventAddress;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public SessionsModel() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
}
