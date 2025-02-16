package com.catering.catering_hub.services;

import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;

import java.util.List;

public interface CateringDetailsBulkFetchSevice {

    List<CateringOrdersJsonModel> getBulkSessionsInfo(String orderId);
    List<CateringOrdersJsonModel> getSessionsWithItemsFromJoin(String orderId);
    List<CateringOrdersJsonModel> getAllOrdersInfo();
}
