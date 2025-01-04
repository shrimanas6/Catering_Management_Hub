package com.catering.catering_hub.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items_master")
public class ItemMasterModel {

    @Id
    @Column(name = "item_id")
    private Integer itemId;
    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_desc")
    private String itemDesc;
    @Column(name = "item_status")
    private String itemStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemMasterModel that = (ItemMasterModel) o;
        return Objects.equals(getItemId(), that.getItemId()) && Objects.equals(getItemName(), that.getItemName()) && Objects.equals(getItemDesc(), that.getItemDesc()) && Objects.equals(getItemStatus(), that.getItemStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemId(), getItemName(), getItemDesc(), getItemStatus());
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
    }

    public String getItemStatus() {
        return itemStatus;
    }

    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }
}
