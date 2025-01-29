package com.catering.catering_hub.models.order_models;

import org.springframework.stereotype.Component;

@Component
public class SessionItemsJsonModel {

    private Integer sessionItemId;
    private Integer sessionId;
    private Integer itemId;
    private String itemDesc;
    private Integer subItemId;

    private Integer createdBy;
    private String createdDate;
    private String modifiedDate;
    private Integer modifiedBy;

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

    @Override
    public String toString() {
        return "SessionItemsJsonModel{" +
                "sessionItemId=" + sessionItemId +
                ", sessionId=" + sessionId +
                ", itemId=" + itemId +
                ", itemDesc='" + itemDesc + '\'' +
                ", subItemId=" + subItemId +
                ", createdBy=" + createdBy +
                ", createdDate='" + createdDate + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                ", modifiedBy=" + modifiedBy +
                '}';
    }
}
