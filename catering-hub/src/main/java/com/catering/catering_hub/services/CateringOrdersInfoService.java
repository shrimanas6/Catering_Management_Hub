package com.catering.catering_hub.services;

import com.catering.catering_hub.models.CateringOrdersModel;
import com.catering.catering_hub.models.order_models.CateringOrdersJsonModel;

public interface CateringOrdersInfoService {
    CateringOrdersModel saveCateringOrderInfo(CateringOrdersModel cateringOrder);
    void saveCateringOrderObjectInfo(CateringOrdersJsonModel cateringOrder);
}
