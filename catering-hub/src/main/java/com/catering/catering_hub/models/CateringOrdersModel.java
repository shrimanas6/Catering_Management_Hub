package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "orders_table")
public class CateringOrdersModel {

    @Id
    @Column(name = "order_id")
    private String orderId;
    @Column(name = "event_note")
    private String eventNote;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "customer_id")
    private Integer customerId;

    public CateringOrdersModel(String orderId, String eventNote, Integer createdBy, String createdDate, List<SessionsModel> sessionsModelList, Integer customerId) {
        this.orderId = orderId;
        this.eventNote = eventNote;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.customerId = customerId;
    }

    public CateringOrdersModel() {
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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
