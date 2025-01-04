package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders_table")
public class CateringOrdersModel {

    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "event_note")
    private String eventNote;
    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private String createdDate;

    public CateringOrdersModel(Integer orderId, String eventNote, Integer createdBy, String createdDate) {
        this.orderId = orderId;
        this.eventNote = eventNote;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
    }

    public CateringOrdersModel() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
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
}
