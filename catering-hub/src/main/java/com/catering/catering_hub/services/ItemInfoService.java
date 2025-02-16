package com.catering.catering_hub.services;

import com.catering.catering_hub.models.CustomerInfoModel;
import com.catering.catering_hub.models.ItemMasterModel;

import java.util.List;

public interface ItemInfoService {

    ItemMasterModel saveItemInfo(ItemMasterModel item);
    List<ItemMasterModel> getAllItems();
    String deleteItemsById(Integer itemId);
    String deleteAllItems();
}
