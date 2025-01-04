package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "session_items_table")
public class SessionItemsModel {

    @Id
    @Column(name = "session_item_id")
    private Integer sessionItemId;
    @Column(name = "session_id")
    private Integer sessionId;
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "item_description")
    private String itemDesc;
    @Column(name = "sub_item_id")
    private Integer subItemId;

    @Column(name = "created_by")
    private Integer createdBy;
    @Column(name = "created_date")
    private String createdDate;
    @Column(name = "modified_date")
    private String modifiedDate;
    @Column(name = "modified_by")
    private Integer modifiedBy;

    public SessionItemsModel(Integer sessionItemId, Integer sessionId, Integer itemId, String itemDesc, Integer subItemId, Integer createdBy, String createdDate, String modifiedDate, Integer modifiedBy) {
        this.sessionItemId = sessionItemId;
        this.sessionId = sessionId;
        this.itemId = itemId;
        this.itemDesc = itemDesc;
        this.subItemId = subItemId;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public SessionItemsModel() {
    }

    public Integer getSessionItemId() {
        return sessionItemId;
    }

    public void setSessionItemId(Integer sessionItemId) {
        this.sessionItemId = sessionItemId;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public Integer getSubItemId() {
        return subItemId;
    }

    public void setSubItemId(Integer subItemId) {
        this.subItemId = subItemId;
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
